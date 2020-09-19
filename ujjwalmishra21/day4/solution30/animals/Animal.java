package org.animals;
/*
 * Abstract class for animals 
 */
public abstract class Animal {
	String color;
	int age;
	int weight;
	
	public Animal() {
		super();
	}
	public Animal(String color, int age, int weight) {
		super();
		this.color = color;
		this.age = age;
		this.weight = weight;
	}
	public abstract void isVegetarian();
	public abstract void canClimb();
	public abstract void sound();
}
