package Calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class Calculator {
	
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JLabel textField = new JLabel("");
	JLabel textFieldTwo = new JLabel("");
	JButton btnAdd = new JButton("+");
	JButton btnSubstract = new JButton("-");
	JButton btnMultiply = new JButton("*");
	JButton btnDivide = new JButton("/");
	JButton btnPoint = new JButton(".");
	JButton btnEqual = new JButton("=");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		initialize();
	}
	

	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton input = (JButton) e.getSource();
			
			if (input.getText() == "C") {
				textField.setText("");
				textFieldTwo.setText("");
				btnAdd.setEnabled(true);
				btnSubstract.setEnabled(true);
				btnMultiply.setEnabled(true);
				btnDivide.setEnabled(true);
				btnPoint.setEnabled(true);
				btnEqual.setEnabled(false);
			} else if (input.getText() == "←") {
				if(!textField.getText().contains(".")) {
					btnPoint.setEnabled(true);
				}
				textField.setText(backspaceButton(textField.getText()));
			} else if (textField.getText().contains(".")) { 
				btnPoint.setEnabled(false);
				textField.setText(textField.getText() + input.getText());
			} else {
				textField.setText(textField.getText() + input.getText());
			}
		}
	}
	
	public class ArithmeticActions implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton operationSelected = (JButton) e.getSource();
			
			if (operationSelected.getText() == "+") {
				textFieldTwo.setText(textField.getText() + operationSelected.getText());
				textField.setText("");
				btnAdd.setEnabled(false);
				btnSubstract.setEnabled(false);
				btnMultiply.setEnabled(false);
				btnDivide.setEnabled(false);
				btnPoint.setEnabled(true);
				btnEqual.setEnabled(true);
			} else if (operationSelected.getText() == "-") {
				textFieldTwo.setText(textField.getText() + operationSelected.getText());
				textField.setText("");
				btnAdd.setEnabled(false);
				btnSubstract.setEnabled(false);
				btnMultiply.setEnabled(false);
				btnDivide.setEnabled(false);
				btnPoint.setEnabled(true);
				btnEqual.setEnabled(true);
			} else if (operationSelected.getText() == "*") {
				textFieldTwo.setText(textField.getText() + operationSelected.getText());
				textField.setText("");
				btnAdd.setEnabled(false);
				btnSubstract.setEnabled(false);
				btnMultiply.setEnabled(false);
				btnDivide.setEnabled(false);
				btnPoint.setEnabled(true);
				btnEqual.setEnabled(true);
			} else if (operationSelected.getText() == "/") {
				textFieldTwo.setText(textField.getText() + operationSelected.getText());
				textField.setText("");
				btnAdd.setEnabled(false);
				btnSubstract.setEnabled(false);
				btnMultiply.setEnabled(false);
				btnDivide.setEnabled(false);
				btnPoint.setEnabled(true);
				btnEqual.setEnabled(true);
			} else if (operationSelected.getText() == "=") {
				if (textFieldTwo.getText().length() == 0 || textField.getText() == "") {
					textField.setText("ERROR!");
				} else {
					double result = ArithmeticOperations.getResult(textFieldTwo.getText(), textField.getText());
					textField.setText(Double.toString(result));
					textFieldTwo.setText("");
				}
			}
		}
	}
	
	public static String backspaceButton(String fieldValues) {
		StringBuilder fieldValuesModified = new StringBuilder(fieldValues);
		if (fieldValues.length() > 0) {
			fieldValuesModified.deleteCharAt((fieldValues.length() - 1));
		}
		return fieldValuesModified.toString();
	}
		
	private void initialize() {
		
		ButtonListener actionListener = new ButtonListener();
		ArithmeticActions arithmeticListener = new ArithmeticActions();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textField.setVerticalAlignment(SwingConstants.TOP);
		
		textField.setFont(new Font("Arial", Font.PLAIN, 22));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 42, 214, 39);
		frame.getContentPane().add(textField);
		
		textFieldTwo.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldTwo.setBounds(118, 11, 98, 14);
		frame.getContentPane().add(textFieldTwo);
		
		JButton btnDelete = new JButton("←");
		buttonGroup.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnDelete.setBounds(118, 108, 44, 39);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(actionListener);
		
		JButton btnClear = new JButton("C");
		buttonGroup.add(btnClear);
		btnClear.setBounds(10, 107, 98, 39);
		frame.getContentPane().add(btnClear);
		btnClear.addActionListener(actionListener);
		
		buttonGroup.add(btnAdd);
		btnAdd.setBounds(172, 108, 44, 39);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(arithmeticListener);
		
		JButton btnOne = new JButton("1");
		buttonGroup.add(btnOne);
		btnOne.setBounds(10, 158, 44, 39);
		frame.getContentPane().add(btnOne);
		btnOne.addActionListener(actionListener);
		
		JButton btnTwo = new JButton("2");
		buttonGroup.add(btnTwo);
		btnTwo.setBounds(64, 158, 44, 39);
		frame.getContentPane().add(btnTwo);
		btnTwo.addActionListener(actionListener);
		
		JButton btnThree = new JButton("3");
		buttonGroup.add(btnThree);
		btnThree.setBounds(118, 158, 44, 39);
		frame.getContentPane().add(btnThree);
		btnThree.addActionListener(actionListener);
		
		buttonGroup.add(btnSubstract);
		btnSubstract.setBounds(172, 158, 44, 39);
		frame.getContentPane().add(btnSubstract);
		btnSubstract.addActionListener(arithmeticListener);
		
		JButton btnFour = new JButton("4");
		buttonGroup.add(btnFour);
		btnFour.setBounds(10, 208, 44, 39);
		frame.getContentPane().add(btnFour);
		btnFour.addActionListener(actionListener);
		
		JButton btnFive = new JButton("5");
		buttonGroup.add(btnFive);
		btnFive.setBounds(64, 208, 44, 39);
		frame.getContentPane().add(btnFive);
		btnFive.addActionListener(actionListener);
		
		JButton btnSix = new JButton("6");
		buttonGroup.add(btnSix);
		btnSix.setBounds(118, 208, 44, 39);
		frame.getContentPane().add(btnSix);
		btnSix.addActionListener(actionListener);
		
		buttonGroup.add(btnMultiply);
		btnMultiply.setBounds(172, 208, 44, 39);
		frame.getContentPane().add(btnMultiply);
		btnMultiply.addActionListener(arithmeticListener);
		
		JButton btnSeven = new JButton("7");
		buttonGroup.add(btnSeven);
		btnSeven.setBounds(10, 258, 44, 39);
		frame.getContentPane().add(btnSeven);
		btnSeven.addActionListener(actionListener);
		
		JButton btnEight = new JButton("8");
		buttonGroup.add(btnEight);
		btnEight.setBounds(64, 258, 44, 39);
		frame.getContentPane().add(btnEight);
		btnEight.addActionListener(actionListener);
		
		JButton btnNine = new JButton("9");
		buttonGroup.add(btnNine);
		btnNine.setBounds(118, 258, 44, 39);
		frame.getContentPane().add(btnNine);
		btnNine.addActionListener(actionListener);
		
		buttonGroup.add(btnDivide);
		btnDivide.setBounds(172, 258, 44, 39);
		frame.getContentPane().add(btnDivide);
		btnDivide.addActionListener(arithmeticListener);
		
		buttonGroup.add(btnPoint);
		btnPoint.setBounds(10, 308, 44, 39);
		frame.getContentPane().add(btnPoint);
		btnPoint.addActionListener(actionListener);
		
		JButton btnZero = new JButton("0");
		buttonGroup.add(btnZero);
		btnZero.setBounds(64, 308, 44, 39);
		frame.getContentPane().add(btnZero);
		btnZero.addActionListener(actionListener);
		
		buttonGroup.add(btnEqual);
		btnEqual.setBounds(118, 308, 98, 39);
		frame.getContentPane().add(btnEqual);
		btnEqual.addActionListener(arithmeticListener);
		btnEqual.setEnabled(false);
	}
}
