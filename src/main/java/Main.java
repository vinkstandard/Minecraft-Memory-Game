import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stagePrimario) {
        ControllerGioco controller = new ControllerGioco();
        Scene scene = new Scene(controller.getView(), 600, 600);
        stagePrimario.setScene(scene);
        stagePrimario.setTitle("Minecraft Memory Game");
        stagePrimario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}