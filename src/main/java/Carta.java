import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.image.*;
import javafx.scene.image.Image;



public class Carta extends StackPane {

    private int valore;
    private boolean scoperta = false;
    private boolean abbinata = false;
    private Rectangle bordo = new Rectangle(180, 200);
    private ImageView immagine;

    public Carta(int valore) {
        this.valore = valore;
        bordo.setFill(Color.LIGHTGRAY);
        bordo.setStroke(Color.DARKGREY);

        immagine = new ImageView();
        immagine.setFitHeight(160);
        immagine.setFitWidth(160);

        getChildren().addAll(bordo, immagine);

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
            Image image = new Image(getClass().getResourceAsStream("/images/" + valore + ".png"));
            immagine.setImage(image);
            immagine.setVisible(true);
            scoperta = true;
        }
    }

    public void copriCarta() {
        if (!abbinata) {
            immagine.setVisible(false);
            scoperta = false;
        }
    }

    public void setAbbinata(boolean abbinata) {
        this.abbinata = abbinata;
        bordo.setFill(Color.LIGHTGREEN);
    }

}
