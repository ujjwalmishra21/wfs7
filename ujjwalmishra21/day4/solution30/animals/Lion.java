package org.animals;
/*
 * Lion implementation of Animal class
 */
public final class Lion extends Animal {
	
	public Lion(String color, int age, int weight) {
		super(color, age, weight);
	}

	@Override
	public void isVegetarian() {
		System.out.println("Lions are not vegetarians");
	}

	@Override
	public void canClimb() {
		System.out.println("Lions can climb trees");

	}

	@Override
	public void sound() {
		System.out.println("Lion roars, growls, snarls");
	}

	@Override
	public String toString() {
		return "Lion [color=" + color + ", age=" + age + ", weight=" + weight + "kg]";
	}

}
