/*
 * @author Rick van den Berg
 */
package bagtrack;

import javafx.beans.property.SimpleStringProperty;

public class Tabeldata {

    final SimpleStringProperty naam;
    final SimpleStringProperty merk;
    final SimpleStringProperty kleur;
    final SimpleStringProperty luchthaven;
    final SimpleStringProperty gewicht;
    final SimpleStringProperty soort;
    final SimpleStringProperty opdruk;

    public Tabeldata(String Naam, String Merk, String Kleur, String Luchthaven, String Gewicht, String Soort, String Opdruk) {

        this.naam = new SimpleStringProperty(Naam);
        this.merk = new SimpleStringProperty(Merk);
        this.kleur = new SimpleStringProperty(Kleur);
        this.luchthaven = new SimpleStringProperty(Luchthaven);
        this.gewicht = new SimpleStringProperty(Gewicht);
        this.soort = new SimpleStringProperty(Soort);
        this.opdruk = new SimpleStringProperty(Opdruk);
    }

    public String getNaam() {
        return naam.get();
    }

    public void setNaam(String Naam) {
        naam.set(Naam);
    }

    public String getMerk() {
        return merk.get();
    }

    public void setMerk(String Merk) {
        merk.set(Merk);
    }

    public String getKleur() {
        return kleur.get();
    }

    public void setKleur(String Kleur) {
        kleur.set(Kleur);
    }

    public String getLuchthaven() {
        return luchthaven.get();
    }

    public void setLuchthaven(String Luchthaven) {
        kleur.set(Luchthaven);
    }

    public String getGewicht() {
        return gewicht.get();
    }

    public void setGewicht(String Gewicht) {
        gewicht.set(Gewicht);
    }

    public String getSoort() {
        return soort.get();
    }

    public void setSoort(String Soort) {
        gewicht.set(Soort);
    }

    public String getOpdruk() {
        return opdruk.get();
    }

    public void setOpdruk(String Opdruk) {
        gewicht.set(Opdruk);
    }
}
