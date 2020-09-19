package org.animals;
/*
 * Deer implementation of Animal class
 */
public final class Deer extends Animal {
	
	public Deer(String color, int age, int weight) {
		super(color, age, weight);
	}

	@Override
	public void isVegetarian() {
		System.out.println("Deers are not vegetarians");

	}

	@Override
	public void canClimb() {
		System.out.println("Deers can climb trees");

	}

	@Override
	public void sound() {
		System.out.println("Deer bellows, bleats");

	}

	@Override
	public String toString() {
		return "Deer [color=" + color + ", age=" + age + ", weight=" + weight + "kg]";
	}

}
