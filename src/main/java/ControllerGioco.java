import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.image.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerGioco {
    private GridPane gridPrincipale = new GridPane();
    private Carta primaCarta = null;
    private Carta secondaCarta = null;
    private List<Carta> listaCarte = new ArrayList<>();
    private int numeroTentativi;

    public ControllerGioco() {

        // TODO:
        //  Selezione difficoltà{x caselle e y tentativi max}
        //  Aggiungere suono vittoria nel metodo controllaVittoria()
        //  Far sparire le caselle in caso di match corretto

        gridPrincipale.setPadding(new Insets(10));
        gridPrincipale.setHgap(10);
        gridPrincipale.setVgap(10);
        gridPrincipale.setAlignment(Pos.CENTER);

        ArrayList<Integer> valori = new ArrayList<>();
        for (int i = 1; i <= 8; i++) { // per ora solo 8 immagini, basterà modificare le condizioni di loop
            valori.add(i);
            valori.add(i); // da modificare dopo
        }
        Collections.shuffle(valori);

        int indice = 0;
        for (int riga = 0; riga < 4; riga++) {
            for (int colonna = 0; colonna < 4; colonna++) {
                int valore = valori.get(indice++);
                Carta carta = new Carta(valore);
                carta.setOnMouseClicked(e -> gestistiClick(carta));
                gridPrincipale.add(carta, riga, colonna);
                listaCarte.add(carta);
            }
        }
    }

    public StackPane getView() {

        ImageView immagineBackGround = new ImageView();
        immagineBackGround.setImage(new Image(getClass().getResource("/images/sfondo.png").toExternalForm()));
        immagineBackGround.setFitWidth(1920);
        immagineBackGround.setFitHeight(1080);
        immagineBackGround.setPreserveRatio(false);

        StackPane root = new StackPane();
        root.getChildren().addAll(immagineBackGround, gridPrincipale);
        return root;
    }

    private void gestistiClick(Carta cliccata) {
        if (cliccata.isScoperta() || cliccata.isAbbinata()) return;
        GestoreSuoni gestoreSuoni = new GestoreSuoni();

        cliccata.scopriCarta();
        if (primaCarta == null) {
            primaCarta = cliccata;
        } else {
            secondaCarta = cliccata;
            // stoppare i click dopo che l'utente ha cliccato su due carte
            gridPrincipale.setDisable(true);

            if (primaCarta.getValore() == secondaCarta.getValore()) {
                primaCarta.setAbbinata(true);
                secondaCarta.setAbbinata(true);
                gestoreSuoni.playSuonoCorretto();
                numeroTentativi++;
                resettaTurno();
                controllaVittora();


            } else {
                gestoreSuoni.playSuonoSbagliato();
                PauseTransition pausa = new PauseTransition(Duration.seconds(0.5));
                pausa.setOnFinished(e -> {
                    primaCarta.copriCarta();
                    secondaCarta.copriCarta();
                    numeroTentativi++;
                    resettaTurno();
                });
                pausa.play();
            }
        }
    }

    private void resettaTurno() {
        primaCarta = null;
        secondaCarta = null;
        gridPrincipale.setDisable(false);
    }

    private void controllaVittora() {
        for (Carta carta : listaCarte) {
            if (!carta.isAbbinata()) {
                return;
            }
        }
        GestoreSuoni gestoreSuoni = new GestoreSuoni();
        gestoreSuoni.playSuonoVittoria();
        // altrimenti abbiamo vinto
        Alert allerta = new Alert(Alert.AlertType.INFORMATION);
        allerta.setTitle("Hai vinto!");
        allerta.setHeaderText(null);
        allerta.setContentText("Ci sei riuscito in " + numeroTentativi + " tentativi");
        allerta.showAndWait();
    }
}
