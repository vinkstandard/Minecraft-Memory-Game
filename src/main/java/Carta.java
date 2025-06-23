import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Carta extends StackPane {

    private int valore;
    private boolean scoperta = false;
    private boolean abbinata = false;
    Label label = new Label();

    private Rectangle bordo = new Rectangle(100, 100);

    public Carta(int valore){
        this.valore = valore;
        bordo.setFill(Color.LIGHTGRAY);
        bordo.setStroke(Color.DARKGREY);

        label.setText("");
        label.setStyle("-fx-font-size: 24px;");

        getChildren().addAll(bordo,label);
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
    public void scopriCarta(){
        if(!abbinata){
            label.setText(String.valueOf(valore));
            scoperta = true;
        }
    }
    public void copriCarta(){
        if(!abbinata){
            label.setText("");
            scoperta = false;
        }
    }
    public void setAbbinata(boolean abbinata){
        this.abbinata = abbinata;
        bordo.setFill(Color.LIGHTGREEN);
    }

}
