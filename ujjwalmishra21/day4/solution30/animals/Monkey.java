package org.animals;
/*
 * Monkey implementation of Animal class
 */
public final class Monkey extends Animal {
	
	public Monkey(String color, int age, int weight) {
		super(color, age, weight);
	}

	@Override
	public void isVegetarian() {
		System.out.println("Monkeys are not vegetarian");

	}

	@Override
	public void canClimb() {
		System.out.println("Monkeys can climb trees");
	}

	@Override
	public void sound() {
		System.out.println("Monkey scream, chatters");

	}

	@Override
	public String toString() {
		return "Monkey [color=" + color + ", age=" + age + ", weight=" + weight + "kg]";
	}
	
}
