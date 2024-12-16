package template;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class Controller {
	@FXML
    private HBox h1, h2, h3, h4, h5, h6;

    @FXML
    private Button submit;

    @FXML
    private TextField tf11, tf12, tf13, tf14, tf15;
    
    @FXML
    private VBox v1;
	
	Random rand = new Random();
	int[] digits;
	int count = 0;
	int check = 0;
	int within = 0;
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
           	submission[0] = Integer.parseInt(tf11.getText());
       		submission[1] = Integer.parseInt(tf12.getText());
		submission[2] = Integer.parseInt(tf13.getText());
		submission[3] = Integer.parseInt(tf14.getText());
		submission[4] = Integer.parseInt(tf15.getText());
		check = 0;
		HBox h = new HBox(); 
		for (int i = 0; i < digits.length; i++) {
			labels[count][i] = new Label();
		        labels[count][i].setText("" + submission[i]);
			labels[count][i].setAlignment(Pos.CENTER);
	
		        if (digits[i] == submission[i]) {
		            labels[count][i].setStyle("-fx-background-color: green");
		            check++;
		        }
			else if (anywhere(submission[i]) && digits[i] != submission[i]) {
		            labels[count][i].setStyle("-fx-background-color: yellow");
			check = 0;
		        }
			else {
		            labels[count][i].setStyle("-fx-background-color: grey");
				check = 0;
		        }
		
		        h.getChildren().add(labels[count][i]); 
		    }
		
		    v1.getChildren().add(h);
		    count++;
		
		   
		    if (check == 5) {
		        Label finish = new Label("You got the number!");
			Button reset = new Button("Reset");
		        v1.getChildren().addAll(finish, reset); 
			v1.getChildren().remove(submit);
		    }
		
		    if (count == 6 && check != 5) {
		        Label finish = new Label("You didn't get the number...");
			Button reset = new Button("Reset");
		        v1.getChildren().add(finish);
			v1.getChildren().addAll(finish, reset); 
		    }
		}
		
	
	
	
   
}

