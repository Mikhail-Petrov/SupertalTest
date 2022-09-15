package test.java.supertal.indexing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class IndexingArgumentsProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext arg0) {
		String[]
				indexes1 = {"1,3-5", "2", "3-4"},
				indexes2 = {"1-5,7,9-11"};
		Integer[][]
				arrays1 = {{1,3,4,5}, {2}, {3,4}},
				arrays2 = {{1,2,3,4,5,7,9,10,11}};
		return Stream.of(
				Arguments.of(new ArrayList<String>(Arrays.asList(indexes1)), TestIndexing.arrayToList(arrays1)),
				Arguments.of(new ArrayList<String>(Arrays.asList(indexes2)), TestIndexing.arrayToList(arrays2))
			);
	}
}
