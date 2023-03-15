package me.jeongseok.cote.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student {
	String name;
	int korean;
	int english;
	int math;

	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}


	@Override
	public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			", korean=" + korean +
			", english=" + english +
			", math=" + math +
			'}';
	}
}

public class BOJ_10825 {

	static ArrayList<Student> students = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	static void solution(ArrayList<Student> list) {

		// 국어 점수
		Collections.sort(list, (o1, o2) -> {
			if (o1.korean == o2.korean) {
				if (o1.english == o2.english) {
					if (o1.math == o2.math) {
						return o1.name.compareTo(o2.name);
					}
					return o2.math - o1.math;
				}
				return o1.english - o2.english;
			}
			return o2.korean - o1.korean;
		});
	}

	public static void main(String[] args) throws IOException {
		input();

		solution(students);

		for (int i = 0; i < students.size(); i++) {
			sb.append(students.get(i).name).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Student student = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			students.add(student);
		}
	}
}
