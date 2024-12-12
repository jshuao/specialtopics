package template;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class Controller {
	@FXML
    private HBox h1, h2, h3, h4, h5, h6;

    @FXML
    private Button submit;

    @FXML
    private TextField tf11, tf12, tf13, tf14, tf15;
	
	Random rand = new Random();
	int[] digits;
	int count = 0;
	int check = 0;
	Label[][] labels;
	
	@FXML
	void initialize() {
		digits = new int[5];
		labels = new Label[6][5];
		for(int i = 0; i < digits.length; i++) {
			digits[i] = rand.nextInt(10);
			System.out.print(digits[i]); // getting the number, remove before submitting
		}
	}
	
	public Boolean anywhere(int current) {
		for (int x : digits) {
		    if (x == current) {
		        return true;
		    }
		}return false;
	}
	
	public void check() {
		int[] submission = new int[5];

		// just if statements only ?
		
		for(int i = 0; i < submission.length; i++) {
			if(i==0) {
				submission[i] = Integer.parseInt(tf11.getText());
			}
			else if(i==1) {
				submission[i] = Integer.parseInt(tf12.getText());
			}
			else if(i==2) {
				submission[i] = Integer.parseInt(tf13.getText());
			}
			else if(i==3) {
				submission[i] = Integer.parseInt(tf14.getText());
			}
			else if(i==4) {
				submission[i] = Integer.parseInt(tf15.getText());
			}
		}
		
		
		
		for(int i = 0; i < labels.length; i++) {
			for(int j = 0; j < labels[0].length; j++) {
				labels[i][j] = new Label();
			}
		}

		for(int i = 0; i < digits.length; i++) {
			// figure out how to make the font size bigger and get the margins
			if(digits[i] == submission[i]) {
				h1.getChildren().add(labels[count][i]);
				labels[count][i].setText("" + digits[i]);
				labels[count][i].setStyle("-fx-background-color: green");
				labels[count][i].setAlignment(Pos.CENTER);
				h1.setAlignment(Pos.CENTER);
				check++;
			}
			else if(anywhere(submission[i]) && digits[i] != submission[i]){
				h1.getChildren().add(labels[count][i]);
				labels[count][i].setText("" + submission[i]);
				labels[count][i].setStyle("-fx-background-color: yellow");
				labels[count][i].setAlignment(Pos.CENTER);
				h1.setAlignment(Pos.CENTER);
				check = 0;
			}
			else{
				h1.getChildren().add(labels[count][i]);
				labels[count][i].setText("" + submission[i]);
				labels[count][i].setStyle("-fx-background-color: grey");
				labels[count][i].setAlignment(Pos.CENTER);
				h1.setAlignment(Pos.CENTER);
				check = 0;
			}
			}
		if(check == 5){
			Label finish = new Label("You got the number!");
		}

		if(count ==6 && check !=5){
			Label finish = new Label("You didn't get the number...");
			// code to remove button
		}

		// code to add finish label
		
		count++;
		}
		
	
	
	
   
}


