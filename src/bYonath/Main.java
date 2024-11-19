package bYonath;

import java.awt.Dimension;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Calculator");
		Calculator calc = new Calculator();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400,400));
		frame.add(calc);
		frame.setVisible(true);
		
	}
}
