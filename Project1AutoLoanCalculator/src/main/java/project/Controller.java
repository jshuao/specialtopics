package project;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.lang.Math;

/**
 * Name: Joshua Yi
 * Username: jyi
 */

public class Controller {
    
	@FXML
	private RadioButton lb1, lb2, lb3, lb4;
	
	@FXML
	private CheckBox e1, e2, e3;
	
	@FXML
	private TextField f1, f2, f3;
	
	@FXML
	private Label pi1, pi2, pi3;
	
	@FXML
	private Button calculate, reset;
	

	public void calculate() {
		
		//initial values
		int basePrice = Integer.parseInt(f1.getText());
		int downPayment = Integer.parseInt(f2.getText());
		double taxRate = (Double.parseDouble(f3.getText()))/100.0;
		int optionCosts = 0;
		int months = 0;
		double annualinterest = 0.0;
		
		//checking selections
		if(e1.isSelected()) {
			optionCosts += 1510;
		}
		if(e2.isSelected()) {
			optionCosts += 470;
		}
		if(e3.isSelected()) {
			optionCosts += 340;
		}
		
		if(lb1.isSelected()) {
			months = 24;
			annualinterest = 0.07;
		}
		else if(lb2.isSelected()){
			months = 36;
			annualinterest = 0.06;
		}
		else if(lb3.isSelected()) {
			months = 48;
			annualinterest = 0.055;
		}
		else {
			months = 60;
			annualinterest = 0.05;
		}
		
		//value calculations
		double subtotal = basePrice + optionCosts;
		double tax = subtotal * taxRate;
		double totalLoan = subtotal + tax - downPayment;
		double monthlyInterest = annualinterest / 12.0;
		double monthScale = Math.pow((1+monthlyInterest), months);
		double monthlyPayment = totalLoan * ((monthlyInterest * monthScale)/(monthScale - 1));
		double totalPayment = monthlyPayment * months;
		
		//gui update
		pi1.setText(String.format("%.2f", totalLoan));
		pi2.setText(String.format("%.2f", monthlyPayment));
		pi3.setText(String.format("%.2f", totalPayment));
	}
	
	public void reset() {
		pi1.setText("0.0");
		pi2.setText("0.0");
		pi3.setText("0.0");
		lb1.setSelected(true);
		lb2.setSelected(false);
		lb3.setSelected(false);
		lb4.setSelected(false);
		e1.setSelected(false);
		e2.setSelected(false);
		e3.setSelected(true);
		f1.setText("0.0");
		f2.setText("0.0");
		f3.setText("7.0");
	}
}
