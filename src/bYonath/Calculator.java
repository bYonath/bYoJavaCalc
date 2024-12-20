package bYonath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.*;

// The child must be silenced : )
@SuppressWarnings("serial")
public class Calculator extends JPanel implements ActionListener{
	
	// Create Buttons (NumButtons, Operation Buttons)
	// Also create their respective panels
	
	// NumButtons
	private JButton[] NumButtons;
	private JPanel NumPanel;
	// Operations
	private JButton[] Operations;
	private JPanel OpPanel;
	
	// Create misc buttons (reset/clear button)
	private JButton clearButton;
	// Decimal Button
	private JButton decimalButton;
	
	// Create TextBox
	private JTextField Output = new JTextField();
	private JPanel OutPanel = new JPanel();
	// Use Later?
	//public ArrayList<Integer> Numbers;
	private String operation;
	
	private double num1; 
	private double num2;
	private double result;
	
	Calculator(){
		this.setLayout(new BorderLayout(10,10));
		//this.setBackground(Color.gray);
		
		// Add output text field to the Pad panel
		Output.setEditable(true);
		Output.setPreferredSize(new Dimension(300,50));
		//OutPanel.setPreferredSize(new Dimension(100,50));
		OutPanel.add(Output);
		
		// Create Number Buttons
		NumButtons = new JButton[10];
		NumPanel = new JPanel();
		NumPanel.setLayout(new GridLayout(3,3));
		for(int i = 0; i < NumButtons.length; i++) {
			String num = Integer.toString(i);
			NumButtons[i] = new JButton();
			NumButtons[i].setText(num);
			NumPanel.add(NumButtons[i]);
			NumButtons[i].addActionListener(this);
		}
		
		decimalButton = new JButton(".");
		decimalButton.addActionListener(this);
		NumPanel.add(decimalButton);
		//NumPanel.setPreferredSize(new Dimension(250,250));
		//this.add(NumPanel, BorderLayout.EAST);
		
		// Create clear button
		clearButton = new JButton("clear");
		clearButton.addActionListener(this);
		
		/*
		==========================
		 Create Button Operations
		==========================
		*/
		
		// Create Operations Buttons (List)
		Operations = new JButton[5];
		OpPanel = new JPanel();
		OpPanel.setLayout(new GridLayout(5,1));
		// Addition Button
		Operations[0] = new JButton();
		Operations[0].setText("+");
		Operations[0].addActionListener(this);
		OpPanel.add(Operations[0]);
		
		// Subtraction Button
		Operations[1] = new JButton();
		Operations[1].setText("-");
		Operations[1].addActionListener(this);
		OpPanel.add(Operations[1]);
		
		// Multiplication Button
		Operations[2] = new JButton();
		Operations[2].setText("*");
		Operations[2].addActionListener(this);
		OpPanel.add(Operations[2]);
		
		// Division Button
		Operations[3] = new JButton();
		Operations[3].setText("/");
		Operations[3].addActionListener(this);
		OpPanel.add(Operations[3]);
		
		// Equality Button (Gives an output)
		Operations[4] = new JButton();
		Operations[4].setText("=");
		Operations[4].addActionListener(this);
		OpPanel.add(Operations[4]);
		
		this.add(OpPanel, BorderLayout.EAST);
		this.add(NumPanel, BorderLayout.CENTER);
		this.add(OutPanel, BorderLayout.NORTH);
		this.add(clearButton, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Check for the Number
		for(int i = 0; i<NumButtons.length; i++) {
			if(e.getSource() == NumButtons[i]) {
				Output.setText(Output.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decimalButton) {
			Output.setText(Output.getText() + ".");
		}
		// Check for operation type
		for(int i = 0; i<Operations.length; i++) {
			if(e.getSource() == Operations[i]) {
				// Compare the operation type, if it is = do the calculation
				// If not skip it
				if(Operations[i].getText().equals("=")) {
					num2 = Double.parseDouble(Output.getText());
					switch(operation) {
					case "+":
						result = num1+num2;
						System.out.println(result);
						Output.setText("" + result);
						break;
					case "-":
						result = num1-num2;
						System.out.println(result);
						Output.setText("" + result);
						break;
					case "*":
						result = num1*num2;
						System.out.println(result);
						Output.setText("" + result);
						break;
					case "/":
						result = num1/num2;
						System.out.println(result);
						Output.setText("" + result);
						break;
					}
					
				}
				else {
					// Set operation type to the operation button that was pressed
					operation = Operations[i].getText();
					num1 = Double.parseDouble(Output.getText());
					Output.setText("");
				}
			}
		}
		
		// Misc Buttons
		if(e.getSource() == clearButton) {
			Output.setText("");
		}
	}
}
