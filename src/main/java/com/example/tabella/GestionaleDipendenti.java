package com.example.tabella;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Random;



public class GestionaleDipendenti extends Application {

    private static final ObservableList<Dipendente> dipendenti = FXCollections.observableArrayList();

    private static Stage popupStage;
    private static ModificaDipendenteController popupController;

    public GestionaleDipendenti(){

        Random random = new Random(new Date().getTime());
        dipendenti.add(new Dipendente(random.nextInt(), "Donald", "Duck", "DNDCK123456789","1"));
        dipendenti.add(new Dipendente(random.nextInt(), "Mickey", "Mouse", "MKMS123456789","2"));
        dipendenti.add(new Dipendente(random.nextInt(), "Uncle", "Scrooge", "NCLSC123456789","3"));
        dipendenti.add(new Dipendente(random.nextInt(), "Gyro", "Gearloose", "GRGRS123456789","3"));
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("tabellaDipendenti.fxml"));
        primaryStage.setTitle("Gestionale dipendenti");
        primaryStage.setScene(new Scene(root));


        popupStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modificaDipendente.fxml" +
                ""));
        Parent popupRoot = fxmlLoader.load();
        popupController = fxmlLoader.getController();
        popupStage.setScene(new Scene(popupRoot));
        popupStage.setTitle("Modifica dipendente");
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(primaryStage);
        primaryStage.show();
    }

    public static void mostraPopupModifica(Dipendente dipendente) {
        popupController.setDipendente(dipendente);
        popupStage.showAndWait();
    }

    public static ObservableList<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public static void aggiungiDipendente(Dipendente dip) {
        dipendenti.add(dip);
    }

    public static void rimuoviDipendente(Dipendente dipendente) {
        dipendenti.remove(dipendente);
    }

    public static void modificaDipendente(Dipendente dipendenteAggiornato) {
        for (Dipendente dipendente : dipendenti) {
            if (dipendente.getId() == dipendenteAggiornato.getId()) {
                dipendente = dipendenteAggiornato;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
