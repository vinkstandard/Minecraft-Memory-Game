import javafx.scene.media.AudioClip;

public class GestoreSuoni {
    private final AudioClip suonoCorretto = new AudioClip(getClass().getResource("/sounds/orb.wav").toExternalForm());
    private final AudioClip suonoSbagliato = new AudioClip(getClass().getResource("/sounds/deny.wav").toExternalForm());
    private final AudioClip suonoVittoria = new AudioClip(getClass().getResource("/sounds/vittoria.wav").toExternalForm());

    public void playSuonoCorretto(){
        suonoCorretto.setVolume(0.3);
        suonoCorretto.play();
    }
    public void playSuonoSbagliato(){
        suonoSbagliato.setVolume(0.1);
        suonoSbagliato.play();
    }
    public void playSuonoVittoria(){
        suonoVittoria.setVolume(0.1);
        suonoVittoria.play();
    }

}
