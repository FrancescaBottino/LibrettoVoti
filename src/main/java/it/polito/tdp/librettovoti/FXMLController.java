package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovotiModel.Libretto;
import it.polito.tdp.librettovotiModel.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private TextField txtData;

    @FXML
    private TextArea txtResult;

    @FXML
    void HandleInserisci(ActionEvent event) {
    	
    	//diviso in tre parti
    	
    	//1) leggi e controlla i dati
    	
    	String nomeEsame= txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("Errore: nome esame vuoto");
    		return ;
    	}
    	
    	
    	String votoEsame= txtVoto.getText();
    	int votoInt=0;
    	try {
    		votoInt= Integer.parseInt(votoEsame);
    	}catch(NumberFormatException ex) {
    		txtResult.setText("Errore: il voto deve essere numerico");
    		return; 
    	}
    	
    	if(votoInt <18 || votoInt>30) {
    		txtResult.setText("Errore: il voto deve essere compreso tra 18 e 30");
    		return;
    		
    	}
    	
    	//ANCHE DATA PICKER IN SCENE BUILDER --> NO CONTROLLI
    	//solo LocalDate dataa= pickereEsame.getValue(); e vedere se non è null
    	
    	String dataEsame= txtData.getText();
    	LocalDate date;
    	try {
    		date= LocalDate.parse(dataEsame);
    	}catch(DateTimeParseException ex) {
    		txtResult.setText("Errore: la data non è nel formato corretto ");
    		return ;
    		
    	}
    	
    	
    	//2) esegui l'azione + controlli di logica (se esame gà dato)
    	
    	Voto voto=new Voto(nomeEsame, votoInt, date);
    	
    	model.add(voto);
    	
    	//3) aggiorna i risultati nella view
    	
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	txtData.clear();
    	
    	

    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }
}

