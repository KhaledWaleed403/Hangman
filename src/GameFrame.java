import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameFrame extends JFrame {
    private int levelSize = 50;
    private final ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png")));
    private final ImageIcon gameIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Game.png")));
    private final ImageIcon menuIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("mainmenu.png")));
    public JLabel hangman = new JLabel();
    public JLabel hanger = new JLabel();
    public JLabel[] answer = new JLabel[levelSize];
    public JLabel over = new JLabel();
    public JPanel level = new JPanel();
    public JPanel mainMenu = new JPanel();

    GameFrame(){
    }

    public void setGameFrame(){
        hangman.setIcon(gameIcon);
        hangman.setVisible(true);
        hangman.setBounds(0,50,200,200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Hangman");
        this.setSize(1000,600);
        this.setVisible(true);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(222,184,135));
        this.repaint();
    }

    public void setMainMenu(){
        JLabel hangertext = new JLabel();
        hangertext.setText("Choose a level:");
        hangertext.setVisible(true);
        hangertext.setFont(new Font("Monospaced",Font.BOLD,40));
        hangertext.setForeground(new Color(64,64,181));
        hangertext.setBounds(50,200,500,100);

        hanger.setIcon(menuIcon);
        hanger.setVisible(true);
        hanger.setBounds(250,0,500,250);
        hanger.setText("Hangman");
        hanger.setHorizontalTextPosition(JLabel.CENTER);
        hanger.setVerticalTextPosition(JLabel.TOP);
        hanger.setIconTextGap(20);
        hanger.setForeground(new Color(235,28,21));
        hanger.setFont(new Font("Monospaced",Font.BOLD,40));

        mainMenu.setVisible(true);
        mainMenu.setBounds(0,0,1000,600);
        mainMenu.setBackground(new Color(222,184,135));
        mainMenu.setLayout(null);
        mainMenu.add(hanger);
        mainMenu.add(hangertext);

        this.add(mainMenu);
        this.repaint();
    }

    public void setGamePanel(int word){
        this.levelSize = word;
        hangman.setIcon(gameIcon);
        hangman.setVisible(true);
        hangman.setBounds(0,50,200,200);

        level.setBounds(0,0,1000,600);
        level.setVisible(true);
        level.setBackground(new Color(222,184,135));
        level.setLayout(null);
        level.add(hangman);


        this.add(level);
        this.repaint();
    }

    public void setAnswerSpace(){
        int x = 250, y = 200;
        for (int i = 0; i < levelSize; i++){
            this.answer[i] = new JLabel();
            this.answer[i].setText("_");
            this.answer[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.answer[i].setFont(new Font("Arial",Font.BOLD,40));
            this.answer[i].setBounds(x,y,75,50);
            level.add(answer[i]);
            x+=45;
            level.repaint();
        }
    }

    public void swapAnswerSpace(int index, char txt){
        for (int i = 0; i < levelSize; i++){
            if (i == index){
                answer[i].setText(String.valueOf(txt));
                level.repaint();
            }
        }
    }

    public void gameOverText(){
        over.setText("Game Over!");
        over.setBounds(450,50,500,50);
        over.setFont(new Font("Arial",Font.BOLD,40));
        over.setForeground(Color.RED);
        over.setVisible(true);
        level.add(over);
        level.repaint();
    }

    public void levelClearedText(){
        over.setText("Level Cleared!");
        over.setBounds(450,50,500,50);
        over.setFont(new Font("Arial",Font.BOLD,40));
        over.setForeground(Color.blue);
        over.setVisible(true);
        level.add(over);
        level.repaint();
    }

    public void resetGameFrame(){
        mainMenu.removeAll();
        level.removeAll();

        this.remove(mainMenu);
        this.remove(level);
        this.validate();
        this.repaint();
    }
}
