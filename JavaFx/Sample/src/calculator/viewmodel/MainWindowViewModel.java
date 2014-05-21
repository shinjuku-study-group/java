package calculator.viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import calculator.model.CalculateType;
import calculator.model.Calculator;

public class MainWindowViewModel implements Initializable{

	@FXML
	private TextField txtFileld;

	@FXML
	private Button btn1;

	@FXML
	private Button btn2;

	@FXML
	private Button btn3;

	@FXML
	private Button btn4;

	@FXML
	private Button btn5;

	@FXML
	private Button btn6;

	@FXML
	private Button btn7;

	@FXML
	private Button btn8;

	@FXML
	private Button btn9;

	@FXML
	private Button btn0;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnSub;

	@FXML
	private Button btnMul;

	@FXML
	private Button btnDiv;

	@FXML
	private Button btnEqual;

	@FXML
	private Button btnClear;

	private CalculateType selectedCalType = CalculateType.None;

	private String preValue = "";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn0.setOnAction(new EventHandler<ActionEvent>()  {
		    @Override public void handle(ActionEvent e) {
		    	setTextFieldValue("0");
		    }
		});
		btn1.setOnAction(new EventHandler<ActionEvent>()  {
			@Override public void handle(ActionEvent e){
				setTextFieldValue("1");
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>()  {
		    @Override public void handle(ActionEvent e) {
		    	setTextFieldValue("2");
		    }
		});
		btnClear.setOnAction(new EventHandler<ActionEvent>()  {
		    @Override public void handle(ActionEvent e) {
		    	txtFileld.setText("");
		    	selectedCalType = CalculateType.None;
		    	preValue = "";
		    }
		});
		btnAdd.setOnAction(new EventHandler<ActionEvent>()  {
		    @Override public void handle(ActionEvent e) {
		    	selectedCalType = CalculateType.Add;
		    	preValue = txtFileld.getText();
		    	txtFileld.setText("0");
		    }
		});
		btnEqual.setOnAction(new EventHandler<ActionEvent>()  {
		    @Override public void handle(ActionEvent e) {
			    if(selectedCalType != CalculateType.None){
			    	double arg1 = Double.parseDouble(preValue);
			    	double arg2 = Double.parseDouble(txtFileld.getText());
			    	double result = new Calculator().Calculate(arg1, arg2, selectedCalType);
			    	txtFileld.setText(Double.toString(result));
			    	selectedCalType = CalculateType.None;
			    	preValue = "";
		    	}
		    }
		});
	}

	private void setTextFieldValue(String val){
		String text = txtFileld.getText();
		if(text.equals("0")){
			text = "";
		}
    	txtFileld.setText(text + val);
	}
}
