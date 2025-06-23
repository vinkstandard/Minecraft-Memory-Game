import javafx.scene.layout.StackPane;

import javafx.scene.image.*;
import javafx.scene.image.Image;

public class Carta extends StackPane {

    private int valore;
    private boolean scoperta = false;
    private boolean abbinata = false;
    private ImageView immagineDaVisualizzare;
    private final Image retroCarta = new Image(getClass().getResource("/images/chest.png").toExternalForm());
    private final Image immagineFronte;

    public Carta(int valore) {
        this.valore = valore;
        this.immagineFronte = new Image(getClass().getResource("/images/" + valore + ".png").toExternalForm());

        immagineDaVisualizzare = new ImageView(retroCarta);
        immagineDaVisualizzare.setFitWidth(100);
        immagineDaVisualizzare.setFitHeight(100);
        immagineDaVisualizzare.fitWidthProperty().bind(this.widthProperty());
        immagineDaVisualizzare.fitWidthProperty().bind(this.heightProperty());

        getChildren().add(immagineDaVisualizzare);
    }

    public int getValore() {
        return valore;
    }

    public boolean isScoperta() {
        return scoperta;
    }

    public boolean isAbbinata() {
        return abbinata;
    }

    public void scopriCarta() {
        if (!abbinata) {
            immagineDaVisualizzare.setImage(immagineFronte);
            scoperta = true;
        }
    }

    public void copriCarta() {
        if (!abbinata) {
            immagineDaVisualizzare.setImage(retroCarta);
            scoperta = false;
        }
    }

    public void setAbbinata(boolean abbinata) {
        this.abbinata = abbinata;
        // puoi aggiungere un effetto visivo se vuoi
    }
}
