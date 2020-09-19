package org.animals;
/*
 * Tiger implementation of Animal class
 */
public final class Tiger extends Animal {
	
	public Tiger(String color, int age, int weight) {
		super(color, age, weight);
	}

	@Override
	public void isVegetarian() {
		System.out.println("Tigers are not vegetarians");

	}

	@Override
	public void canClimb() {
		System.out.println("Tigers can climb trees");

	}

	@Override
	public void sound() {
		System.out.println("Tiger roars, growls, snarls");
	}

	@Override
	public String toString() {
		return "Tiger [color=" + color + ", age=" + age + ", weight=" + weight + "kg]";
	}

}
