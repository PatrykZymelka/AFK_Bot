import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    public JPanel MainPanel;
    private JButton StartButton;
    private JProgressBar Progress;
    private JComboBox TimeMode ;
    private JComboBox AFKMode;
    private JLabel timeLabel;
    private JButton button1;
    boolean started = false;
    int elapsedTime = 0;
    int minutes = 0;
    int seconds = 0;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    GUIActionPerformer GAP = new GUIActionPerformer();


    public GUI() {
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(started ==false){
                    started = true;
                    StartButton.setText("Stop Process");
                    start();
                }
                else{
                    started=false;
                    StartButton.setText("Start Process");
                    stop();
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(started == true){
                    started = false;
                    StartButton.setText("Start Process");
                    stop();
                    reset();
                }
                else{
                    reset();
                }
            }
        });
    }

    public void Initialize() {
        setContentPane(MainPanel);
        setTitle("AFK bot");
        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] TimeModes = {"2 minutes", "1 minute","15 seconds","1 second"};
        for(int i = 0; i <TimeModes.length; i++) {
            TimeMode.addItem(TimeModes[i]);
        }

        String[] AFKmodes = {"Jump", "Left Click", "WASD", "Random"};
        for(int i = 0; i <AFKmodes.length; i++) {
            AFKMode.addItem(AFKmodes[i]);
        }
        timeLabel.setText(minutes_string+":"+seconds_string);
    }
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime+1000;
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            timeLabel.setText(minutes_string+":"+seconds_string);
            try {
                AFK(elapsedTime);
            } catch (AWTException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    void AFK (int ElapsedTime) throws AWTException, InterruptedException {
        int T = GAP.TimeConversion((String) TimeMode.getSelectedItem());
        if(ElapsedTime%T == 0){
            switch((String) AFKMode.getSelectedItem()){
                case "Jump":
                    GAP.jump();
                    break;

                case "Left Click":
                    GAP.left();
                    break;

                case "WASD":
                    GAP.wsad();
                    break;

                case "Random":
                    GAP.rand();
                    break;

            }
        }


    }
    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        timer.stop();
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        timeLabel.setText(minutes_string+":"+seconds_string);
    }
}
