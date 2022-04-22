package com.b3.montyhall;

public class RunMontyHallSimulations {

    public static void main(String args[]) throws IncorrectNumberOfBoxesException {

        int intFirstChosenBoxStrategy = 0, intSecondChosenBoxStrategy = 0;
        int antalSimuleringarInt = 100000;

        for (int i = 0; i < antalSimuleringarInt; ++i) {

            MontyHallGame montyHallGame = new MontyHallGame();
            MontyHallBox firstChosenBox = montyHallGame.pickAndRemoveFirstBox();
            montyHallGame.removeOneEmptyRemaingBox();
            MontyHallBox remainingBox = montyHallGame.switchBox();


            //Strategi 1
            if (firstChosenBox.isWinsCar()) {
                ++intFirstChosenBoxStrategy;
            }
            if (remainingBox.isWinsCar()) {
                ++intSecondChosenBoxStrategy;
            }
        }
        System.out.println("Att inte byta resulterade i " + intFirstChosenBoxStrategy + " vinster");
        System.out.println("Att konsekvent byta resulterade i " + intSecondChosenBoxStrategy + " vinster");
    }
}