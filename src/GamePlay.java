public class GamePlay {
    public String levelWord = "                       ";
    public char[] wordCheck= new char[levelWord.length()];
    public int lives = 5;
    GameFrame frame;

    GamePlay(GameFrame frame){
        this.frame = frame;
    }

    void setLevel(String lvlWord){
        wordCheck = new char[levelWord.length()];
        this.levelWord = lvlWord;
    }

    void checkAnswer(char answer){
        boolean found = false;
        for (int i = 0; i < levelWord.length(); i++){
            if (answer == levelWord.charAt(i)){
                frame.swapAnswerSpace(i,answer);
                found =  true;
            }
        }

        if (!found) {
            lives--;
            if (lives == 0){
                frame.gameOverText();
            }
        }
        else if(levelCleared()){
            frame.levelClearedText();
        }
    }

    void updateCheck(char letter){
        for (int i = 0; i < levelWord.length(); i++){
            if (levelWord.charAt(i) == letter){
                wordCheck[i] = letter;
            }
        }
    }

    Boolean gameOver(){
        return lives <= 0;
    }

    Boolean levelCleared(){
        char[] check = levelWord.toCharArray();
        for (int i = 0; i < levelWord.length(); i++){
            if (check[i] != wordCheck[i]){
                return false;
            }
        }
        return true;
    }

    public void resetGamePlay(){
        lives = 5;
        levelWord = "                       ";
    }
}
