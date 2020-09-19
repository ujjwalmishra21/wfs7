package org.animals;
/*
 * Elephant implementation of Animal class
 */
public final class Elephant extends Animal {
	
	public Elephant(String color, int age, int weight) {
		super(color, age, weight);
	}

	@Override
	public void isVegetarian() {
		System.out.println("Elephants are vegetarians");

	}

	@Override
	public void canClimb() {
		System.out.println("Elephants can not climb trees");
	}

	@Override
	public void sound() {
		System.out.println("Elephant trumpets");
	}

	@Override
	public String toString() {
		return "Elephant [color=" + color + ", age=" + age + ", weight=" + weight + "kg]";
	}

}
