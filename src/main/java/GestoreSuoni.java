import javafx.scene.media.AudioClip;

public class GestoreSuoni {
    private final AudioClip suonoCorretto = new AudioClip(getClass().getResource("/sounds/orb.wav").toExternalForm());
    private final AudioClip suonoSbagliato = new AudioClip(getClass().getResource("/sounds/deny.wav").toExternalForm());

    public void playSuonoCorretto(){
        suonoCorretto.setVolume(0.3);
        suonoCorretto.play();
    }
    public void playSuonoSbagliato(){
        suonoSbagliato.setVolume(0.1);
        suonoSbagliato.play();
    }

}
