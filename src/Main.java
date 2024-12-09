public class Main {

    public static void main (String[] args){

        GameFrame frame = new GameFrame();
        LevelSelector level = new LevelSelector();
        GameButtons buttons = new GameButtons(frame);
        GamePlay play = new GamePlay(frame);
        new GameController(frame,play,buttons,level);
    }
}
