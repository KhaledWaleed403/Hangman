import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class GameButtons extends GameFrame {
    public final JButton[] letterButtons = new JButton[26];
    public final JButton[] levelButtons = new JButton[100];
    public JButton randomButton = new JButton();
    public JButton mainMenu = new JButton();
    public JButton exitGame = new JButton();
    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final GameFrame game;

    GameButtons(GameFrame game){
        this.game = game;
    }

    public void addAlphabetButtons(ActionListener actionListener){
        int x = 100, y = 350;
        for (int i = 0; i <= 25; i++){
            letterButtons[i] = new JButton();
            letterButtons[i].setBounds(x,y,75,50);
            letterButtons[i].addActionListener(actionListener);
            letterButtons[i].setOpaque(false);
            letterButtons[i].setContentAreaFilled(false);
            letterButtons[i].setFocusable(false);
            letterButtons[i].setBorderPainted(false);
            letterButtons[i].setText(String.valueOf(alphabet.charAt(i)));
            letterButtons[i].setFont(new Font("Arial",Font.BOLD,40));
            game.level.add(letterButtons[i]);
            if (x > 750){
                x = 200;
                y = 450;
            }
            else {
                x+=50;
            }
        }
        game.repaint();
    }

    public void addExitButton(ActionListener actionListener){
        exitGame.setBounds(820,500,150,50);
        exitGame.setVisible(true);
        exitGame.addActionListener(actionListener);
        exitGame.setFocusable(false);
        exitGame.setText("Exit");
        exitGame.setFont(new Font("Arial",Font.BOLD,20));
        game.level.add(exitGame);
    }

    public void addMainMenuButton(ActionListener actionListener){
        mainMenu.setBounds(10,500,150,50);
        mainMenu.setVisible(true);
        mainMenu.addActionListener(actionListener);
        mainMenu.setFocusable(false);
        mainMenu.setText("Main Menu");
        mainMenu.setFont(new Font("Arial",Font.BOLD,20));
        mainMenu.setEnabled(true);
        game.level.add(mainMenu);
    }

    public void addRandomButton(ActionListener actionListener){
        randomButton.setBounds(795,500,150,50);
        randomButton.addActionListener(actionListener);
        randomButton.setFocusable(false);
        randomButton.setText("Randomize");
        randomButton.setFont(new Font("Arial",Font.BOLD,20));
        randomButton.setVisible(true);
        randomButton.setEnabled(true);
        game.mainMenu.add(randomButton);
    }

    public void addLevelButtons(ActionListener actionListener){
        int x = 15, y = 300;
        for (int i = 0; i <= 99; i++) {
            levelButtons[i] = new JButton();
            levelButtons[i].setBounds(x, y, 70, 50);
            levelButtons[i].addActionListener(actionListener);
            levelButtons[i].setOpaque(false);
            levelButtons[i].setContentAreaFilled(false);
            levelButtons[i].setFocusable(false);
            levelButtons[i].setBorderPainted(false);
            levelButtons[i].setText(String.valueOf(i+1));
            levelButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            game.mainMenu.add(levelButtons[i]);
            x+=40;
            if (x >= 920){
                x = 15;
                y += 50;
            }
        }
        game.mainMenu.repaint();
    }

    public JButton getButton(int index){
        return letterButtons[index];
    }

    public JButton getLevelButton(int index){
        return levelButtons[index];
    }

    public JButton getRandomButton(){
        return randomButton;
    }

    public JButton getExitButton(){
        return exitGame;
    }

    public JButton getMainMenuButton(){
        return mainMenu;
    }

    public void resetGameButtons(ActionListener actionListener){
        randomButton.removeActionListener(actionListener);
        mainMenu.removeActionListener(actionListener);
    }
}
