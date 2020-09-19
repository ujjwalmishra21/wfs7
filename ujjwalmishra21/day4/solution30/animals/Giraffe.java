package org.animals;
/*
 * Giraffe implementation of Animal class
 */
public final class Giraffe extends Animal {
	
	public Giraffe(String color, int age, int weight) {
		super(color, age, weight);
	}

	@Override
	public void isVegetarian() {
		System.out.println("Giraffes are vegetarians");

	}

	@Override
	public void canClimb() {
		System.out.println("Giraffes can not climb trees");

	}

	@Override
	public void sound() {
		System.out.println("Giraffes bleat");

	}

	@Override
	public String toString() {
		return "Giraffe [color=" + color + ", age=" + age + ", weight=" + weight + "kg]";
	}

}
