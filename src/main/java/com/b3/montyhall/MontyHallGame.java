package com.b3.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHallGame {

    private List<MontyHallBox> montyHallBoxList = new ArrayList<>();
    private final int intNumberOfBoxesFromTheBeginning = 3;

    public List<MontyHallBox> getMontyHallBoxList() {
        return montyHallBoxList;
    }
    public void setMontyHallBoxList(List<MontyHallBox> montyHallBoxList) {
        this.montyHallBoxList = montyHallBoxList;
    }

    public MontyHallGame() {

        for(int i = 0; i < intNumberOfBoxesFromTheBeginning; ++i) {
            montyHallBoxList.add(new MontyHallBox());
        }
        randomlyAddAWin();
    }

    private void randomlyAddAWin() {
        Random random = new Random();
        int intBoxIndexWithWin = random.nextInt(intNumberOfBoxesFromTheBeginning);


        montyHallBoxList.get(intBoxIndexWithWin).setWinsCar(true);
    }

    public MontyHallBox pickAndRemoveFirstBox() throws IncorrectNumberOfBoxesException {

        verifyNumberOfBoxesIsCorrect(intNumberOfBoxesFromTheBeginning, "pickFirstBox anropad i fel ordning");

        Random random = new Random();
        int intRandomChoseBox = random.nextInt(montyHallBoxList.size());
        return montyHallBoxList.remove(intRandomChoseBox);
    }
    public void removeOneEmptyRemaingBox() throws IncorrectNumberOfBoxesException {

        int expectedNumberOfBoxes = intNumberOfBoxesFromTheBeginning - 1;
        verifyNumberOfBoxesIsCorrect(expectedNumberOfBoxes, "removeOneEmptyRemaingBox anropad i fel ordning");


        boolean isWinFirstRemainingBox = montyHallBoxList.get(0).isWinsCar();
        if(!isWinFirstRemainingBox) {
            montyHallBoxList.remove(0);
        } else montyHallBoxList.remove(1);

    }

    public MontyHallBox switchBox()  throws IncorrectNumberOfBoxesException  {

        int expectedNumberOfBoxes = intNumberOfBoxesFromTheBeginning - 2;
        verifyNumberOfBoxesIsCorrect(expectedNumberOfBoxes, "switchBox anropad i fel ordning");

        return montyHallBoxList.get(0);
    }

    public void verifyNumberOfBoxesIsCorrect(int expectedNumberOfBoxes, String message) throws IncorrectNumberOfBoxesException {
        if(getMontyHallBoxList().size() != expectedNumberOfBoxes) {
            throw new IncorrectNumberOfBoxesException(message);
        }
    }

}
