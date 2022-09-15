package main.java.supertal.indexing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public class Indexing {

	public static List<List<Integer>> indexesToArrays(List<String> indexes) {
		List<List<Integer>> res = new ArrayList<>();
		if (indexes == null)
			return res;
		
		for (String index : indexes) {
			List<Integer> array = new ArrayList<>();
			if (index == null) {
				res.add(array);
				continue;
			}
			
			// get every element or row
			String[] elements = index.split(",");
			for (String element : elements) {
				String[] numbers = element.split("-");
				// get and add number or the first element of the row
				int number;
				try {
					number = Integer.parseInt(numbers[0]);
				} catch (NumberFormatException e) {
					System.out.println(String.format("Invalid element %s in index:\n%s", numbers[0], index));
					e.printStackTrace();
					continue;
				}
				array.add(number);
				if (numbers.length > 1) {
					// if row then get the last element
					int number2;
					try {
						number2 = Integer.parseInt(numbers[1]);
						// add all numbers in between
						for (int el = ++number; el <= number2; el++)
							array.add(el);
					} catch (NumberFormatException e) {
						System.out.println(String.format("Invalid element %s in index:\n%s", numbers[1], index));
						e.printStackTrace();
						continue;
					}
				}
			}
			res.add(array);
		}
		
		return res;
	}
	
	public static List<List<Integer>> arraysToGroup(List<List<Integer>> arrays) {
		List<List<Integer>> res = new ArrayList<>();
		if (arrays == null)
			return res;
		
		// create tree to contain all groups
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		List<DefaultMutableTreeNode> nodes = new ArrayList<>();
		nodes.add(root);	// current level of the tree
		
		// fill the tree
		arrays.forEach(array -> {
			// each array is a level in the tree
			final List<DefaultMutableTreeNode> newNodes = new ArrayList<>();	// next level
			nodes.forEach(node -> {
				// add elements of array as children for each node on the current level
				array.forEach(el -> {
					DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(el);
					node.add(newNode);
					// these children will be new current level
					newNodes.add(newNode);
				});
			});
			// change current level to the next one
			nodes.clear();
			nodes.addAll(newNodes);
		});
		
		// each leaf is the end of a group
		nodes.forEach(node -> {
			LinkedList<Integer> group = new LinkedList<>();
			// go up to the root
			while (!node.isRoot()) {
				group.addFirst((int) node.getUserObject());
				node = (DefaultMutableTreeNode) node.getParent();
			}
			res.add(group);
		});
		
		return res;
	}
}
