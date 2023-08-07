package me.jeongseok.cote.pt_practice;

public class Tree implements Comparable<Tree>{

	int x;
	int y;
	int age;

	public Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o) {
		if(this.age < o.age) {
			return -1;
		} else if(this.age == o.age) {
			return 0;
		} else {
			return 1;
		}
	}
}
