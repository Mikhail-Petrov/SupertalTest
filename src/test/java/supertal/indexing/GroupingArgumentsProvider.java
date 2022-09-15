package test.java.supertal.indexing;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class GroupingArgumentsProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext arg0) {
		Integer[][]
				arrays1 = {{1,3,4,5}, {2}, {3,4}},
				arrays2 = {{1,2,3,4,5,7,9,10,11}};
		Integer[][]
				groups1 = {{1, 2, 3}, {1, 2, 4}, {3, 2, 3}, {3, 2, 4}, {4, 2, 3}, {4, 2, 4}, {5, 2, 3}, {5, 2, 4}},
				groups2 = {{1},{2},{3},{4},{5},{7},{9},{10},{11}};
		return Stream.of(
				Arguments.of(TestIndexing.arrayToList(arrays1), TestIndexing.arrayToList(groups1)),
				Arguments.of(TestIndexing.arrayToList(arrays2), TestIndexing.arrayToList(groups2))
			);
	}
}
