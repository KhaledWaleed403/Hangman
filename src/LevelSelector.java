import java.util.Random;

public class LevelSelector {
    public String[] levels = {"Quizzical","Zephyr","Jazz","Sphinx","Mnemonic",
                               "Cryptic", "Polyglot","Pizzazz","Gnarled", "Xylophone", "level"
                              ,"Guru", "JAZZ","xenophobia","euphemism", "triangulation", "bugaboo"
                               ,"misdirection","Twelfth", "Onyx", "Nymph", "SHADOW", "Glyph"
                                ,"ANCIENT", "Psyche", "fax","FACTS", "cyst", "hymn", "GUITAR",
                                "BAD","THRONES","GOAL","DREAM","PATHETIC","DEMON","GHOST","POSSIBLE",
                                "PRACTICE","SWORD","GAMBLE","TRADE","JOB","ARCHITECT","MOTHER","PALE",
                                "BROKEN","SMALL","RING","WARD","CAMP","TREE","CRAZY","GOAT","MATERIALIZE",
                                "MAGIC","FISH","WEAVE","SNAIL","SUPPORT","HARD","EASY","TALK","WALK",
                                "TEST","WIZARD","WINDOWS","DEVELOPER","FAIL","HAIL","SHOW","MOVIES",
                                "COMICAL","LAUGHABLE","TASK","HUNTERS","DOG","WOLF","OCEAN","CONTINENT",
                                "PROTECT","SPACE","MOUNTAIN","BREAKING","GALAXY","SUN","DAY","MONTH","SALARY",
                                "MARVEL","MEDICAL","ROBOT","INVENTION","INTELLIGENCE","RELEGATE","MACHINE",
                                "MECHANICAL","OIL","SOAP","FINAL"};
    public String selectedLevel;
    private Random randomLevel;

    LevelSelector(){

    }
    public void selectLevel(int index){
        selectedLevel = levels[index];
    }

    public int selectRandomLevel(){
        randomLevel = new Random();
        return randomLevel.nextInt(100);
    }

    public String getSelectedLevel(){
        return selectedLevel.toUpperCase();
    }

    public void resetLevelSelector(){
        selectedLevel = null;
        randomLevel = null;
    }
}
