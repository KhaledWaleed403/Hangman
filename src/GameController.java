import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GameController implements ActionListener{
    GamePlay play;
    GameFrame frame;
    GameButtons buttons;
    LevelSelector level;

    GameController(GameFrame frame, GamePlay play, GameButtons buttons, LevelSelector level){
        this.frame = frame;
        this.play = play;
        this.buttons = buttons;
        this.level = level;
        startGame();
    }

    void startGame(){
        frame.setGameFrame();
        frame.setMainMenu();
        buttons.addLevelButtons(this);
        buttons.addRandomButton(this);
    }

    void startLevel(){
        frame.setGamePanel(level.selectedLevel.length());
        buttons.addAlphabetButtons(this);
        buttons.addExitButton(this);
        buttons.addMainMenuButton(this);
        frame.setAnswerSpace();
        play.setLevel(level.getSelectedLevel());
        frame.mainMenu.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!play.gameOver() && !play.levelCleared()) {
            checkLevelButtons(e);
        }
        checkMenuButtons(e);
        checkRandomButton(e);
        checkExitButton(e);
        checkMainMenuButton(e);
    }

    private void checkMenuButtons(ActionEvent e){
        for (int i = 0; i <= 99; i++){
            if (e.getSource() == buttons.getLevelButton(i)){
                level.selectLevel(i);
                startLevel();
            }
        }
    }

    private void checkLevelButtons(ActionEvent e){
        for (int i = 0; i < 26; i++) {
            if (e.getSource() == buttons.getButton(i)) {
                play.updateCheck(buttons.alphabet.charAt(i));
                play.checkAnswer(buttons.alphabet.charAt(i));
                buttons.letterButtons[i].setEnabled(false);
            }
        }
    }
    private void checkRandomButton(ActionEvent e){
        if (e.getSource() == buttons.getRandomButton()){
            buttons.randomButton.setEnabled(false);
            level.selectLevel(level.selectRandomLevel());
            startLevel();
        }
    }

    private void checkExitButton(ActionEvent e){
        if (e.getSource() == buttons.getExitButton()){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void checkMainMenuButton(ActionEvent e){
        if (e.getSource() == buttons.getMainMenuButton()){
            buttons.resetGameButtons(this);
            frame.resetGameFrame();
            play.resetGamePlay();
            level.resetLevelSelector();
            startGame();
        }
    }
}
