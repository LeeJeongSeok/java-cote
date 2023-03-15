package me.jeongseok.cote.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	int age;
	String name;
	int order;

	public Person(int age, String name, int order) {
		this.age = age;
		this.name = name;
		this.order = order;
	}

	@Override
	public int compareTo(Person o) {
		if (this.order > o.order) {
			return 1;
		} else if (this.order == o.order) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Person{" +
			"age=" + age +
			", name='" + name + '\'' +
			", order=" + order +
			'}';
	}
}
public class BOJ_10814 {

	static ArrayList<Person> persons = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	static void solution(ArrayList<Person> list) {

		Collections.sort(list, (o1, o2) -> {
			if (o1.age > o2.age) {
				return 1;
			} else if (o1.age == o2.age) {
				return o1.compareTo(o2);
			} else {
				return -1;
			}
		});



		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}

		System.out.println(sb.toString());
	}
	public static void main(String[] args) throws IOException {
		input();

		solution(persons);

	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Person person = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
			persons.add(person);
		}
	}

}
