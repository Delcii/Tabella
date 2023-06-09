package com.example.tabella;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dipendente {

    private final int id;
    private final StringProperty nome;
    private final StringProperty cognome;
    private final StringProperty codiceFiscale;
    private final StringProperty età;

    public Dipendente(int id, String nome, String cognome, String codiceFiscale, String età) {
        this.id = id;
        this.nome = new SimpleStringProperty(nome);
        this.cognome = new SimpleStringProperty(cognome);
        this.codiceFiscale = new SimpleStringProperty(codiceFiscale);
        this.età = new SimpleStringProperty(età);
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome.get();
    }
    public StringProperty nomeProperty() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCognome() {
        return cognome.get();
    }
    public StringProperty cognomeProperty() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome.set(cognome);
    }

    public String getCodiceFiscale() {
        return codiceFiscale.get();
    }
    public StringProperty codiceFiscaleProperty() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale.set(codiceFiscale);
    }

    public String getEtà() {
        return età.get();
    }

    public StringProperty etàProperty() {
        return età;
    }

    public void setEtà(String età) {
        this.età.set(età);
    }

    @Override
    public boolean equals(Object altro) {
        if (altro == null) return false;
        if (altro == this) return true;
        if (!(altro instanceof Dipendente)) return false;
        Dipendente altroDipendente = (Dipendente) altro;
        return altroDipendente.getCodiceFiscale()
                .equalsIgnoreCase(this.getCodiceFiscale());
    }
}