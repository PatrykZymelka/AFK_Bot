import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GUIActionPerformer {
    Random rand = new Random();

    public void jump() throws AWTException, InterruptedException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(50);
        r.keyRelease(KeyEvent.VK_SPACE);
    }
    public void left() throws AWTException, InterruptedException {
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public void wsad() throws AWTException, InterruptedException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_W);
        Thread.sleep(50);
        r.keyRelease(KeyEvent.VK_W);

        r.keyPress(KeyEvent.VK_A);
        Thread.sleep(50);
        r.keyRelease(KeyEvent.VK_A);

        r.keyPress(KeyEvent.VK_S);
        Thread.sleep(50);
        r.keyRelease(KeyEvent.VK_S);

        r.keyPress(KeyEvent.VK_D);
        Thread.sleep(50);
        r.keyRelease(KeyEvent.VK_D);
    }
    public void rand() throws AWTException, InterruptedException {
        Robot r = new Robot();
        int n = rand.nextInt(3);
        switch(n){
            case 0:
                jump();
                break;
            case 1:
                left();
                break;
            case 2:
                wsad();
                break;
        }
    }
    public int TimeConversion(String Time){
        switch (Time) {
            case "2 minutes":
                return (2 * 60 * 1000);
            case "1 minute":
                return (60 * 1000);
            case "15 seconds":
                return (15 * 1000);
            case "1 second":
                return (1000);
            default:
                return (30 * 1000);
        }
    }
    public String MethodConversion(String Method){
        switch (Method) {
            case "Jump":
                return "J";
            case "Left Click":
                return "L";
            case "WASD":
                return "W";
            case "Random":
                return "R";
            default:
                return "J";
        }
    }

}
