
//importing packages
package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	//initializing

	@FXML
	public Label wel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField input;
	@FXML
	public Button convert;

	private static final String c_to_f = "celsius to fahrenheit";
	private static final String f_to_c = " fahrenheit to celsius";

	private boolean isC_to_f= true;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		//adding choices

		choiceBox.getItems().add(c_to_f);
		choiceBox.getItems().add(f_to_c);

		// setting default choice

		choiceBox.setValue(c_to_f);

		// events of choiceBox
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, newValue) ->
		{
			if (newValue.equals(c_to_f)) {
				isC_to_f = true; // if user selected celsius to fahrenheit
			} else {
				isC_to_f = false;// if vice versa
			}
		});

		//events for button
		convert.setOnAction(actionEvent ->
				{
					convert();
				}
				);
	}

	private void convert() {
		String user = input.getText(); // get value from text feild

		float tempEntered =0.0f; //for value to be accessible to other methods
		//exception handling
		try {

			tempEntered = Float.parseFloat(user);

		} catch (Exception a) {
			warning();
			return;
		}
		float newTemp = 0.0f;
		if (isC_to_f) {
			newTemp = (tempEntered * 9 / 5) + 32;

		} else {
			newTemp = (tempEntered - 32) * 5 / 9;
		}
		display(newTemp);
	}

	private void warning() {
		Alert display  = new Alert(Alert.AlertType.ERROR);
		display.setTitle("invalid!");
		display.setHeaderText("entered value is invalid");
		display.setContentText("kindly enter a valid value( a numeric value) " );
		display.show();
	}

	private void display(float newTemp) {
		String unit = isC_to_f?"f":"c";
		System.out.println("the new temperature is " + newTemp + unit);

		// display result through alert
		Alert display  = new Alert(Alert.AlertType.INFORMATION);
		display.setTitle("result");
		display.setContentText("the new temperature is " + newTemp + unit);
		display.show();
	}
}