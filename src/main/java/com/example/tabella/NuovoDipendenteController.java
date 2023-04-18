package com.example.tabella;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Date;
import java.util.Random;

public class NuovoDipendenteController {
    @FXML private TextField campoNome;
    @FXML private TextField campoCognome;
    @FXML private TextField campoCodiceFiscale;
    @FXML private TextField campoEtà;
    @FXML private Button Aggiungi;

    public void handleSalvaModifiche(MouseEvent mouseEvent) {
        String nome = campoNome.textProperty().get();
        String cognome = campoCognome.textProperty().get();
        String codiceFiscale = campoCodiceFiscale.textProperty().get();
        String età = campoEtà.textProperty().get();
        Random random = new Random(new Date().getTime());
        int idNuovoDipendente = random.nextInt();
        GestionaleDipendenti.aggiungiDipendente(new Dipendente(idNuovoDipendente, nome, cognome, codiceFiscale, età));
        Stage stage = (Stage) Aggiungi.getScene().getWindow();
        stage.close();
        }

    public void initialize() {
        Aggiungi.disableProperty().bind(campoNome.textProperty().isEmpty()
                .or(campoCognome.textProperty().isEmpty())
                .or(campoCodiceFiscale.textProperty().isEmpty())
                .or(campoEtà.textProperty().isEmpty()));
    }
}
