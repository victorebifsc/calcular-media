package com.ifsc.tds.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

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
	} catch (NumberFormatException e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String textError = sw.toString();
		
		//show error
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Aconteceu um erro de corversão numérica.");
		
		Label label = new Label("Segue a pilha de exceção");
		
		TextArea textArea = new TextArea(textError);
		textArea.setEditable(false);
		textArea.setWrapText(true);
		
		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);
		alert.getDialogPane().setExpandableContent(expContent);
		alert.showAndWait();
	}
    	
    	
    }

    @FXML
    void clickLimpar(ActionEvent event) {
    	txtNota1.setText("");
    	txtNota2.setText("");
    	txtNota3.setText("");
    	txtNota4.setText("");
    }
    
    public boolean onCloseQuery() {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Pergunta");
    	ButtonType btnNo = ButtonType.NO;
    	ButtonType btnYes = ButtonType.YES;
    	
    	alert.getButtonTypes().setAll(btnYes, btnNo);
    	Optional<ButtonType> optionSelected = alert.showAndWait();
    	
    	return optionSelected.get() == btnYes ? true : false;
    }

}
