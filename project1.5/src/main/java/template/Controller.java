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
    
    @FXML
    private Label l11, l12, l13, l14,l15, l21, l22, l23, l24,l25, l31, l32,l33,l34,l35,l41,l42,l43,l44,l45,l51,l52,l53,l54,l55,l61,l62,l63,l64,l65;
	
	Random rand = new Random();
	int[] digits;
	int submissioncount = 0;
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
		
		if(submissioncount == 0) {
			for(int i = 0; i < digits.length; i++) {
				if(digits[i] == submission[i]) {
					h1.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + digits[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: green");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h1.setAlignment(Pos.CENTER);
				}
				else if(anywhere(submission[i])){
					h1.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + submission[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: yellow");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h1.setAlignment(Pos.CENTER);
				}
			}
			submissioncount++;
		}
		else if(submissioncount == 1) {
			for(int i = 0; i < digits.length; i++) {
				if(digits[i] == submission[i]) {
					h2.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + digits[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: green");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h2.setAlignment(Pos.CENTER);
				}
			}
			submissioncount++;
		}
		else if(submissioncount == 2) {
			for(int i = 0; i < digits.length; i++) {
				if(digits[i] == submission[i]) {
					h3.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + digits[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: green");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h3.setAlignment(Pos.CENTER);
				}
			}
			submissioncount++;
		}
		else if(submissioncount == 3) {
			for(int i = 0; i < digits.length; i++) {
				if(digits[i] == submission[i]) {
					h4.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + digits[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: green");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h4.setAlignment(Pos.CENTER);
				}
			}submissioncount++;
		}
		else if(submissioncount == 4) {
			for(int i = 0; i < digits.length; i++) {
				if(digits[i] == submission[i]) {
					h5.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + digits[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: green");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h5.setAlignment(Pos.CENTER);
				}
			}
			submissioncount++;
		}
		else if(submissioncount == 5) {
			for(int i = 0; i < digits.length; i++) {
				if(digits[i] == submission[i]) {
					h6.getChildren().add(labels[submissioncount][i]);
					labels[submissioncount][i].setText("" + digits[i]);
					labels[submissioncount][i].setStyle("-fx-background-color: green");
					labels[submissioncount][i].setAlignment(Pos.CENTER);
					h6.setAlignment(Pos.CENTER);
				}
			}
			submissioncount++;
		}
		
	}
	
	
	
   
}


