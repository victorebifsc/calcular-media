package com.ifsc.tds.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

    @FXML
    private TextField txtNota4;

    @FXML
    private Label lblMedia;

    @FXML
    private Label lblResultado;

    @FXML
    void clickCalcular(ActionEvent event) {
    try {
    	double media = Double.parseDouble(txtNota1.getText())+Double.parseDouble(txtNota2.getText())+Double.parseDouble(txtNota3.getText())+Double.parseDouble(txtNota4.getText());
    	media /= 4;
    	
    	lblMedia.setText(""+media);

    	if (media >= 7) {
    		lblResultado.setText("Aprovado");
    		lblResultado.setId("green-text");
    	}
    	else if(media >= 5) {
    		lblResultado.setText("Exame");
    		lblResultado.setId("yellow-text");
    	}
    	else {
    		lblResultado.setText("Reprovado");
    		lblResultado.setId("red-text");
    	}
	} catch (Exception e) {
		
	}
    	
    	
    }

    @FXML
    void clickLimpar(ActionEvent event) {
    	txtNota1.setText("");
    	txtNota2.setText("");
    	txtNota3.setText("");
    	txtNota4.setText("");
    }

}
