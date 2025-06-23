import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;

public class ControllerGioco {
    private GridPane gridPrincipale = new GridPane();
    private Carta primaCarta = null;
    private Carta secondaCarta = null;


    public ControllerGioco() {


        gridPrincipale.setPadding(new Insets(10));
        gridPrincipale.setHgap(10);
        gridPrincipale.setVgap(10);

        ArrayList<Integer> valori = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
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
            }
        }
    }

    public StackPane getView() {
        return new StackPane(gridPrincipale);
    }

    private void gestistiClick(Carta cliccata) {
        if (cliccata.isScoperta() || cliccata.isAbbinata()) return;

        cliccata.scopriCarta();
        if (primaCarta == null) {
            primaCarta = cliccata;
        } else {
            secondaCarta = cliccata;
            if (primaCarta.getValore() == secondaCarta.getValore()) {
                primaCarta.setAbbinata(true);
                secondaCarta.setAbbinata(true);
                resettaTurno();
            } else {
                PauseTransition pausa = new PauseTransition(Duration.seconds(1));
                pausa.setOnFinished(e -> {
                    primaCarta.copriCarta();
                    secondaCarta.copriCarta();
                    resettaTurno();
                });
                pausa.play();
            }
        }
    }

    private void resettaTurno() {
        primaCarta = null;
        secondaCarta = null;
    }
}
