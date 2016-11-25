package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Arrays;

public class Controller implements Initializable {

    @FXML
    javafx.scene.control.TextField tb_EingabeBuchstabe;
    @FXML
    private Label lbl_GesuchtesWort;
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Circle header;
    @FXML
    private Line line5;
    @FXML
    private Line line6;
    @FXML
    private Line line7;
    @FXML
    private Line line8;
    @FXML
    private Label lbl_BuchstEingabe;
    @FXML
    private Button btn_Go;
    @FXML
    private Label lbl_Ende;
    @FXML
    private Button btn_Start;

    char[] HangmanCharArray;
    char[] HangmanCodeCharArray;
    int fails = 0;

    public void ActionButtonStart(ActionEvent actionEvent) {

        //Hangman Wort generieren
        String HangmanWort = WortListe.GetZufallsWort();
        //System.out.println(HangmanWort); //Für Debug Zwecke

        //Arrays Vorberieten mit *** Array und dem Char-Array des gesuchten Wortes
        HangmanCharArray = HangmanWort.toCharArray();
        HangmanCodeCharArray = HangmanWort.toCharArray();

        //Stern-Array generieren
        for (int i = 0; i < HangmanCodeCharArray.length; i++) {
            HangmanCodeCharArray[i] = '*';
        }

        String GesuchtesWort = new String(HangmanCodeCharArray);
        lbl_GesuchtesWort.setText(GesuchtesWort);

        //"Go" Elemente Einblenden:
        btn_Go.setVisible(true);
        tb_EingabeBuchstabe.setVisible(true);
        lbl_BuchstEingabe.setVisible(true);
    }

    public void ActionButtonGo(ActionEvent actionEvent) {
        //Wenn Eingabe mind. 1 Zeichen hat
        if (tb_EingabeBuchstabe.getCharacters().toString().length() != 0) {
            //Wenn Eingabe in WortArray vorhanden ist
            if (new String(HangmanCharArray).toUpperCase().contains(tb_EingabeBuchstabe.getCharacters().toString().toUpperCase())) {
                //Suche Stelle für * mit Buchstaben zu erstzen
                for (int i = 0; i < HangmanCharArray.length; i++) {

                    Character Codiert = tb_EingabeBuchstabe.getCharacters().charAt(0);
                    Character Uncodiert = HangmanCharArray[i];
                    //Ersetze * mit Buchsteben
                    if (Codiert.toString().toUpperCase().contains(Uncodiert.toString().toUpperCase())) {
                        HangmanCodeCharArray[i] = HangmanCharArray[i];
                    }
                }
            } else {
                //Hangman Elemente nacheinander einblenden
                fails++;
                switch (fails) {
                    case 1:
                        line1.setVisible(true);
                        break;
                    case 2:
                        line2.setVisible(true);
                        break;
                    case 3:
                        line3.setVisible(true);
                        break;
                    case 4:
                        line4.setVisible(true);
                        break;
                    case 5:
                        header.setVisible(true);
                        break;
                    case 6:
                        line5.setVisible(true);
                        break;
                    case 7:
                        line6.setVisible(true);
                        break;
                    case 8:
                        line7.setVisible(true);
                        break;
                    case 9:
                        line8.setVisible(true);
                        break;
                    case 10:
                        //Spiel verloren
                        System.out.println("EXIT");
                        lbl_Ende.setText("! VERLOREN !");
                        lbl_Ende.setVisible(true);
                        btn_Start.setVisible(false);
                        break;
                }
            }
            //Aktualisiertes *** Wort aufschalten
            String NeuesGesuchtesWort = String.valueOf(HangmanCodeCharArray);
            lbl_GesuchtesWort.setText(NeuesGesuchtesWort);
            tb_EingabeBuchstabe.setText("");

            //Spiel Gewonnen
            if (Arrays.equals(HangmanCharArray,HangmanCodeCharArray)){
                lbl_Ende.setText("! GEWONNEN !");
                lbl_Ende.setVisible(true);
                btn_Start.setVisible(false);
            }
        }
    }

    public void ActionButtonClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    //"Schnittstelle" zu FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void btn_Go_Pressed(KeyEvent keyEvent) {
        //Mehrfacheingabe abfangen, nur einen Buchstaben zulassen
        if (tb_EingabeBuchstabe.getCharacters().length() > 1){
            tb_EingabeBuchstabe.setText(tb_EingabeBuchstabe.getCharacters().toString().substring(0,1));
        }
    }
}
