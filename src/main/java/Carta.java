import javafx.scene.layout.StackPane;

import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Carta extends StackPane {

    private int valore;
    private boolean scoperta = false;
    private boolean abbinata = false;

    private ImageView iconaCentrale;
    private ImageView immagineFronteView;
    private Rectangle bordo;

    private final Image immagineFronte;
    private final Image immagineRetroIcona = new Image(getClass().getResource("/images/chest.png").toExternalForm());
    private final Image retroTexture = new Image(getClass().getResource("/images/stone1.jpeg").toExternalForm());

    public Carta(int valore) {
        this.valore = valore;
        this.immagineFronte = new Image(getClass().getResource("/images/" + valore + ".png").toExternalForm());

        // bordo carta
        bordo = new Rectangle(200, 200);
        bordo.setArcWidth(20);
        bordo.setArcHeight(20);
        bordo.setFill(new javafx.scene.paint.ImagePattern(retroTexture));
        bordo.setStroke(Color.DARKGOLDENROD);
        bordo.setStrokeWidth(2);

        // icona al centro del back della carta
        iconaCentrale = new ImageView(immagineRetroIcona);
        iconaCentrale.setFitWidth(150);
        iconaCentrale.setFitHeight(150);

        // l'immagine della carta, ovviamente nascosta finchè non è scoperta
        immagineFronteView = new ImageView(immagineFronte);
        immagineFronteView.setFitWidth(150);
        immagineFronteView.setFitHeight(150);
        immagineFronteView.setVisible(false);

        getChildren().addAll(bordo, iconaCentrale, immagineFronteView);
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
            immagineFronteView.setVisible(true);
            iconaCentrale.setVisible(false);
            scoperta = true;
        }
    }

    public void copriCarta() {
        if (!abbinata) {
            immagineFronteView.setVisible(false);
            iconaCentrale.setVisible(true);
            scoperta = false;
        }
    }

    public void setAbbinata(boolean abbinata) {
        this.abbinata = abbinata;
        bordo.setStroke(Color.LIGHTGREEN); // colore in caso di abbinamento
    }
}
