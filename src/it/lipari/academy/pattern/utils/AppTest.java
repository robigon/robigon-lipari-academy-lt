package it.lipari.academy.pattern.utils;

public class AppTest {

	public static void main(String[] args) {
		

		bar(new BaseClass());
		bar(new Subclass1());
		bar(new Subclass2());
		
	}
	
	
	public static void bar(BaseClass param) {
		
		param.foo();
		
	}

}
