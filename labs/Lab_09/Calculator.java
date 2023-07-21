
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
 public class Calculator implements ActionListener{

 	

 	JButton[] numberButtons = new JButton[10];
 	JTextArea answerField = new JTextArea();
 	JButton equBtn,decBtn;
 	JButton clearBtn,sinhBtn ,sqrtBtn,addBtn;
 	JButton sinBtn  ,tanhBtn ,sqrBtn ,subBtn;
 	JButton cosBtn  ,coshBtn ,cubeBtn,multiBtn;
 	JButton xpwyBtn ,absBtn  ,invBtn ,divBtn;
 	
 	String operator;
 	double num1,num2,result;

 	Calculator(){



 		JFrame calculatorWindow = new JFrame();
 		calculatorWindow.setLayout(new BorderLayout(20,20));

		calculatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		calculatorWindow.setTitle("Calculator");
		calculatorWindow.setSize(600, 200);
		
		//answer field
		JPanel answer = new JPanel(); 
		answer.setLayout(new BorderLayout(30,30));
		answerField.setEditable(false);
		answerField.setFont(answerField.getFont().deriveFont(30f));
		answer.add(answerField, BorderLayout.CENTER);
		calculatorWindow.add(answer, BorderLayout.PAGE_START);


		//number buttons
		
		JPanel numbers = new JPanel();
		numbers.setLayout(new GridLayout(4,3,5,5));
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
		}

		for(int i = 1; i < 10;i++){
			numbers.add(numberButtons[i]);
		}
		equBtn = buttonMaker("=");

		decBtn = buttonMaker(".");
		//numbers.add(new JLabel(""));
		
		numbers.add(equBtn);
		numbers.add(numberButtons[0]);
		numbers.add(decBtn);

		//basic arithmatic buttons
		JPanel arithmatic = new JPanel();
		arithmatic.setLayout(new GridLayout(4,4,5,5));

		clearBtn = buttonMaker("Clear");
		sinhBtn = buttonMaker("sinh()");
		sqrtBtn = buttonMaker("sqrt()");
		addBtn = buttonMaker("+");
 		sinBtn = buttonMaker("sin()");
 		tanhBtn = buttonMaker("tanh()");
 		sqrBtn = buttonMaker("x^2");
 		subBtn = buttonMaker("-");
 		cosBtn = buttonMaker("cos()");
 		coshBtn = buttonMaker("cosh()");
 		cubeBtn = buttonMaker("x^3");
 		multiBtn = buttonMaker("*");
 		xpwyBtn = buttonMaker("x^y");
 		absBtn = buttonMaker("|x|");
 		invBtn = buttonMaker("+/-");
 		divBtn = buttonMaker("/");


		arithmatic.add(clearBtn);
		arithmatic.add(sinhBtn);
		arithmatic.add(sqrtBtn);
		arithmatic.add(addBtn);
 		arithmatic.add(sinBtn);
 		arithmatic.add(tanhBtn);
 		arithmatic.add(sqrBtn);
 		arithmatic.add(subBtn);
 		arithmatic.add(cosBtn);
 		arithmatic.add(coshBtn);
 		arithmatic.add(cubeBtn);
 		arithmatic.add(multiBtn);
 		arithmatic.add(xpwyBtn);
 		arithmatic.add(absBtn);
 		arithmatic.add(invBtn);
 		arithmatic.add(divBtn);
		
		
		JPanel center = new JPanel(); 
		center.setLayout(new GridLayout(1,2,5,5));
		center.add(arithmatic);
		center.add(numbers);
		
		//calculatorWindow.add(arithmatic, BorderLayout.LINE_START);
		
		//calculatorWindow.add(numbers, BorderLayout.LINE_END);
		calculatorWindow.add(center,BorderLayout.CENTER);

		calculatorWindow.setVisible(true);

 	}

 	public JButton buttonMaker(String title){
 		JButton temp = new JButton(title);
 		temp.addActionListener(this);
 		temp.setFocusable(false);
 		return temp;


 	}

 	public static void main(String[] args){

 		
 		Calculator calc = new Calculator();



 	}

 	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				answerField.setText(answerField.getText().concat(String.valueOf(i)));
			}
		}

		if(e.getSource() == clearBtn) {
			num1 = 0;	
			num2 = 0;		
			operator = "";
			answerField.setText("");
		}
		if(e.getSource() == addBtn) {
			num1 = Double.parseDouble(answerField.getText());
			operator ="+";
			answerField.setText("");
		}
		if(e.getSource() == subBtn) {
			num1 = Double.parseDouble(answerField.getText());
			operator ="-";
			answerField.setText("");
		}
		if(e.getSource() == multiBtn) {
			num1 = Double.parseDouble(answerField.getText());
			operator ="*";
			answerField.setText("");
		}
		if(e.getSource() == divBtn) {
			num1 = Double.parseDouble(answerField.getText());
			operator ="/";
			answerField.setText("");
		}
		if(e.getSource()==xpwyBtn){
			num1 = Double.parseDouble(answerField.getText());
			operator ="xpwy";
			answerField.setText("");
		}
		if(e.getSource()==decBtn) {
			answerField.setText(answerField.getText().concat("."));
		}
		if(e.getSource()==equBtn) {
			num2=Double.parseDouble(answerField.getText());
			
			switch(operator) {
			case "+":
				result=num1+num2;
				break;
			case "-":
				result=num1-num2;
				break;
			case  "*":
				result=num1*num2;
				break;
			case "/":
				result=num1/num2;
				break;
			case "xpwy":
				
				result= Math.pow(num1,num2);
				break;
			}
			
			
			answerField.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==sinhBtn) {
			num1 = Double.parseDouble(answerField.getText());
			result = Math.sinh(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}

		if(e.getSource()==sqrtBtn){
			num1 = Double.parseDouble(answerField.getText());
			result = Math.sqrt(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==sinBtn){
 			num1 = Double.parseDouble(answerField.getText());
			result = Math.sin(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==tanhBtn){
 			num1 = Double.parseDouble(answerField.getText());
			result = Math.tanh(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==sqrBtn){
 			num1 = Double.parseDouble(answerField.getText());
			result = num1 * num1;
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==cosBtn){
 			num1 = Double.parseDouble(answerField.getText());
			result = Math.cos(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==coshBtn){
 			num1 = Double.parseDouble(answerField.getText());
			result = Math.cosh(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==cubeBtn){
 			num1 = Double.parseDouble(answerField.getText());
			result = num1 * num1 * num1;
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==absBtn){
			num1 = Double.parseDouble(answerField.getText());
			result = Math.abs(num1);
			answerField.setText(String.valueOf(result));
			num1 = result;
		}
 		if(e.getSource()==invBtn){
 			answerField.setText(String.valueOf(-1 * Double.parseDouble(answerField.getText())));
			
		
		}

 	}

 }