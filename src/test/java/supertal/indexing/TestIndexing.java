package test.java.supertal.indexing;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import main.java.supertal.indexing.Indexing;

public class TestIndexing {

	@ParameterizedTest
	@ArgumentsSource(IndexingArgumentsProvider.class)
	public void indexesToArrays(List<String> indexes, List<List<Integer>> expectedArray) {
		assertThat(Indexing.indexesToArrays(indexes)).isEqualTo(expectedArray);
	}

	@ParameterizedTest
	@ArgumentsSource(GroupingArgumentsProvider.class)
	public void arraysToGroup(List<List<Integer>> arrays, List<List<Integer>> expectedGroups) {
		assertThat(Indexing.arraysToGroup(arrays)).isEqualTo(expectedGroups);
	}

	static List<List<Integer>> arrayToList(Integer[][] array) {
		List<List<Integer>> res = new ArrayList<>();
		for (Integer[] line : array)
			res.add(Arrays.asList(line));
		return res;
	}
}
