package me.jeongseok.cote.java_factory;


class Test {
	static int staticNumber = 0;
	int nonStaticNumber = 0;

}
public class StaticTest {

	static int staticNum = 0;
	int nonStaticNum = 0;

	public static void test() {

		System.out.println("정적 메소드");
	}

	public static void main(String[] args) {
		test();
	}
}
