package com.hsbc.day4.shapes;

public class TestShapes {
	public static void main(String args[]) {
		Circle circle = new Circle();
		Triangle triangle = new Triangle();
		Rectangle rectangle = new Rectangle();
		Square square = new Square();
		
		circle.run();
		square.run();
		rectangle.run();
		triangle.run();
	}
}
