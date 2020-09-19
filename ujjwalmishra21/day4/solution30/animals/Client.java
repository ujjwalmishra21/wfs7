package org.animals;
/*
 * Program adds deer, elephant, tiger, lion, monkey, giraffe and 
 * access their own implementation of methods
 */
public class Client {

	public static void main(String[] args) {
	
		Animal animal = new Deer("Red",11,190);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Elephant("Grey",30,4100);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Tiger("Black-striped Orange",9,260);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Lion("Reddish Brown",12,170);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();

		animal = new Monkey("Brown",4,25);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Giraffe("Chestnut",4,1990);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
	}
	

}
