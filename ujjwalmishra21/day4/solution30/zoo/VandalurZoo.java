package org.zoo;

import org.animals.Animal;
import org.animals.Deer;
import org.animals.Elephant;
import org.animals.Giraffe;
import org.animals.Lion;
import org.animals.Monkey;
import org.animals.Tiger;
/*
 	Program uses Animal jar and creates object out it and access associated methods
 */
public class VandalurZoo {
	
	public static void main(String args[]) {
		
		Animal animal = new Deer("Brown",1,30);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Elephant("Grey",3,230);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Tiger("Black-striped Orange",2,100);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();
		
		animal = new Lion("Reddish Brown",2,90);
		System.out.println(animal);
		animal.isVegetarian();
		animal.canClimb();
		animal.sound();
		System.out.println();

		animal = new Monkey("Brown",4,69);
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
