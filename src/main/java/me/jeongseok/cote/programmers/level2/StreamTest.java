package me.jeongseok.cote.programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		String[] board = new String[]{"O.X", ".O.", "..X"};

//		Map<Character, Long> counts = Arrays.stream(board)
//			.flatMap(row -> row.chars()
//				.mapToObj(word -> (char) word))
//			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		String test = "test";
//		IntStream chars = test.chars();
//		chars.forEach(System.out::println);

		Stream<Character> characterStream = test.chars().mapToObj(word -> (char) word);
		Map<Character, Long> list = characterStream.collect(
			Collectors.groupingBy(Function.identity(), Collectors.counting()));

		list.forEach((k, v) -> System.out.println((k + ":" + v)));

		String[] wow = new String[]{"test", "test2"};
		List<Character> list1 = Arrays.stream(wow)
			.flatMap(row -> row.chars()
				.mapToObj(word -> (char) word))
			.collect(Collectors.toList());


		list1.forEach(System.out::println);


	}


}
