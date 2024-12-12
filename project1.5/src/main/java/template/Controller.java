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
    private HBox h1;

    @FXML
    private HBox h2;

    @FXML
    private HBox h3;

    @FXML
    private HBox h4;

    @FXML
    private HBox h5;

    @FXML
    private HBox h6;

    @FXML
    private Button submit;

    @FXML
    private TextField tf11;

    @FXML
    private TextField tf12;

    @FXML
    private TextField tf13;

    @FXML
    private TextField tf14;

    @FXML
    private TextField tf15;
	
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
			System.out.println(digits[i]);
		}
	}
	
	public Boolean anywhere(int current) {
		for (int element : digits) {
		    if (element == current) {
		        return true;
		    }
		}return false;
	}
	
	public void check() {
		int[] submission = new int[5];
		
		
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
			if(digits[i] == submission[i]) {
				h1.getChildren().add(labels[count][i]);
				labels[count][i].setText("" + digits[i]);
				labels[count][i].setStyle("-fx-background-color: green");
				labels[count][i].setAlignment(Pos.CENTER);
				h1.setAlignment(Pos.CENTER);
				check++;
			}
			else if(anywhere(submission[i]) && digits[i] != sumission[i]){
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
		}
		
		count++;
		}
		
	
	
	
   
}


