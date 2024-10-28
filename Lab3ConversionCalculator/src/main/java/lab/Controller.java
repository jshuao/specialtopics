package lab;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Name: Joshua Yi
 * Username: joshuayi
 */

public class Controller {
	
	public String round(double input) {
		return String.format("%.2f", input);
	}
	
	@FXML
	private TextField inT, yT, mT, cmT;
	@FXML
	private Label errorL;
	@FXML
	private Button convert, clear, exit;
	
	
	
	public void convert() {
		boolean inches = inT.getText().isEmpty();
		boolean yards = yT.getText().isEmpty();
		boolean meters = mT.getText().isEmpty();
		boolean centimeters = cmT.getText().isEmpty();
		if ((!inches) && (yards) && (meters) && (centimeters)) {
			inConvert();
		}
		else if((inches) && (!yards) && (meters) && (centimeters)) {
			yConvert();
		}
		else if((inches) && (yards) && (!meters) && (centimeters)) {
			mConvert();
		}else if ((inches) && (yards) && (meters) && (!centimeters)){
			cmConvert();
		}
		else {
			errorL.setVisible(true);
		}
	}
	
	public void clear() {
		inT.setText("");
		yT.setText("");
		mT.setText("");
		cmT.setText("");
	}
	
	public void exit() {
		System.exit(0);
	}
	public void cmConvert() {
		double cm = Double.parseDouble(cmT.getText()); 
		double cmin = cm2in(cm);
		double cmm = cm2m(cm);
		double cmy = cm2y(cm);
		inT.setText(round(cmin));
		mT.setText(round(cmm));
		yT.setText(round(cmy));
	}
	
	public void inConvert() {
		double in = Double.parseDouble(inT.getText()); 
		double incm = in2cm(in);
		double inm = in2m(in);
		double iny = in2y(in);
		cmT.setText(round(incm));
		mT.setText(round(inm));
		yT.setText(round(iny));
	}
	
	public void yConvert() {
		double y = Double.parseDouble(yT.getText()); 
		double ycm = y2cm(y);
		double ym = y2m(y);
		double yin = y2in(y);
		inT.setText(round(yin));
		mT.setText(round(ym));
		cmT.setText(round(ycm));
	}
	
	public void mConvert() {
		double m = Double.parseDouble(mT.getText()); 
		double mcm = m2cm(m);
		double my = m2y(m);
		double min = m2in(m);
		inT.setText(round(min));
		yT.setText(round(my));
		cmT.setText(round(mcm));
	}
	
	public static double cm2in(double cm) {
		return cm/2.54;
	}
	
	public  static double cm2m(double cm) {
		return cm/100.0;
	}
	
	public static double cm2y(double cm) {
		return cm/91.44;
	}
	
	public static double in2cm(double in) {
		return in*2.54;
	}
	
	public static double in2y(double in) {
		return in/36.0;
	}
    
	public static double in2m(double in) {
		return in/39.37;
	}
	
	public static double y2m(double y) {
		return y/1.094;
	}
	
	public static double y2in(double y) {
		return y*36.0;
	}
	
	public static double y2cm(double y) {
		return y*91.44;
	}
	
	public static double m2y(double m) {
		return m*1.094;
	}
	
	public static double m2in(double m) {
		return m*39.37;
	}
	
	public static double m2cm(double m) {
		return m*100.0;
	}
}
