package it.lipari.academy.model.vo;

public class Dog extends Animal {

	@Override
	public String faiIlVerso() {
		return "Bau!";
	}
	
	public void run() {
		System.out.println("Running!");
	}

	@Override
	public void foo() {
		// TODO Auto-generated method stub
		
	}

}
