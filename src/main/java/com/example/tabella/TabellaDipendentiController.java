package com.example.tabella;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TabellaDipendentiController {


    private StringProperty messaggioValidazione = new SimpleStringProperty();


    @FXML private TableView<Dipendente> tabellaDipendenti;
    @FXML private TableColumn<Dipendente, String> colonnaNome;
    @FXML private TableColumn<Dipendente, String> colonnaCognome;
    @FXML private TableColumn<Dipendente, String> colonnaCodiceFiscale;
    @FXML private TableColumn<Dipendente, String> colonnaEtà;




    @FXML
    private void initialize() {
        tabellaDipendenti.setItems(GestionaleDipendenti.getDipendenti());
        colonnaNome.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("nome"));
        colonnaCognome.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("cognome"));
        colonnaCodiceFiscale.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("codiceFiscale"));
        colonnaEtà.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("età"));
    }

    public void handleNuovoDipendente(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("nuovoDipendente.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuovo Dipendente");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleModificaDipendente(MouseEvent mouseEvent) {
        Dipendente dipendenteSelezionato = tabellaDipendenti.getSelectionModel().getSelectedItem();
        if (dipendenteSelezionato == null) return;
        GestionaleDipendenti.mostraPopupModifica(dipendenteSelezionato);
    }

    public void handleEliminaDipendente(MouseEvent mouseEvent) {
        Dipendente dipendenteSelezionato = tabellaDipendenti.getSelectionModel().getSelectedItem();
        if (dipendenteSelezionato == null) return;
        GestionaleDipendenti.rimuoviDipendente(dipendenteSelezionato);
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

    public String getMessaggioValidazione() { return messaggioValidazione.get(); }

    public void setMessaggioValidazione(String msg) { this.messaggioValidazione.set(msg); }
}
