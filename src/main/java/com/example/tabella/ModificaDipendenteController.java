package com.example.tabella;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModificaDipendenteController {

    private Dipendente dipendente;
    private StringProperty messaggioValidazione =
            new SimpleStringProperty();

    @FXML private TextField campoNome;
    @FXML private TextField campoCognome;
    @FXML private TextField campoCodiceFiscale;
    @FXML private TextField campoEtà;

    public void handleSalvaModifiche(MouseEvent mouseEvent) {
        String nome = campoNome.textProperty().get();
        String cognome = campoCognome.textProperty().get();
        String codiceFiscale = campoCodiceFiscale.textProperty().get();
        String età = campoEtà.textProperty().get();
        if (validaForm(nome, cognome, codiceFiscale, età)) {
            dipendente.setNome(nome);
            dipendente.setCognome(cognome);
            dipendente.setCodiceFiscale(codiceFiscale);
            dipendente.setEtà(età);
            GestionaleDipendenti.modificaDipendente(dipendente);
            setMessaggioValidazione("Modifiche salvate con successo");
        }
    }


    private boolean validaForm(String nome, String cognome, String codiceFiscale, String età) {
        boolean valido = true;
        String msg = "";
        if (nome == null || nome.isEmpty()) {
            msg += "Inserisci nome\n";
            valido = false;
        }
        if (cognome == null || cognome.isEmpty()) {
            msg += "Inserisci cognome\n";
            valido = false;
        }
        if (codiceFiscale == null || codiceFiscale.isEmpty()) {
            msg += "Inserisci codice fiscale\n";
            valido = false;
        }
        if (età == null || età.isEmpty()) {
            msg += "Inserisci età\n";
            valido = false;
        }
        setMessaggioValidazione(msg);
        return valido;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
        campoNome.textProperty().setValue(dipendente.getNome());
        campoCognome.textProperty().set(dipendente.getCognome());
        campoCodiceFiscale.textProperty().set(dipendente.getCodiceFiscale());
        campoEtà.textProperty().set(dipendente.getEtà());
    }

    public String getMessaggioValidazione() {
        return messaggioValidazione.get();
    }

    public void setMessaggioValidazione(String messaggioValidazione) {
        this.messaggioValidazione.set(messaggioValidazione);
    }
}
