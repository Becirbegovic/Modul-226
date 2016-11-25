package sample;
import java.util.ArrayList;

/**
 * Created by Edin on 22.11.2016.
 * Erstellen der Wort Datenbank
 */
public class WortListe {

    public static String GetZufallsWort(){

        ArrayList<String> Wortliste = new ArrayList<String>();

        Wortliste.add("Auto");
        Wortliste.add("Girrafe");
        Wortliste.add("Esel");
        Wortliste.add("Igel");
        Wortliste.add("Panzer");
        Wortliste.add("Baum");
        Wortliste.add("Haus");
        Wortliste.add("Tastatur");
        Wortliste.add("Computer");
        Wortliste.add("Tisch");
        Wortliste.add("Fenster");
        Wortliste.add("Schlagzeug");
        Wortliste.add("Pauke");
        Wortliste.add("Marimbaphon");
        Wortliste.add("Saxophone");
        Wortliste.add("Maus");
        Wortliste.add("Motor");
        Wortliste.add("Taschenrechner");
        Wortliste.add("Wolke");
        Wortliste.add("Foto");
        Wortliste.add("Infomatik");
        Wortliste.add("Schuhe");

        int zufallszahl = (int) ((Math.random()*Wortliste.size()));

        //Zufällig Wort auswählen
        String GewaehltesWort = Wortliste.get(zufallszahl);

        return GewaehltesWort;

    }

}
