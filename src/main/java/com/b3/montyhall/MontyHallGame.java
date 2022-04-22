package com.b3.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHallGame {

    private List<MontyHallBox> montyHallBoxList = new ArrayList<>();
    private final int numberOfBoxes = 3;

    public List<MontyHallBox> getMontyHallBoxList() {
        return montyHallBoxList;
    }
    public void setMontyHallBoxList(List<MontyHallBox> montyHallBoxList) {
        this.montyHallBoxList = montyHallBoxList;
    }

    public MontyHallGame() {

        for(int i = 0; i < numberOfBoxes; ++i) {
            montyHallBoxList.add(new MontyHallBox());
        }
        randomlyAddAWin();
    }

    private void randomlyAddAWin() {
        Random random = new Random();
        int intBoxNumberWinWin = random.nextInt(numberOfBoxes - 1);

        montyHallBoxList.get(intBoxNumberWinWin).setWinsCar(true);
    }

    public MontyHallBox pickAndRemoveFirstBox() throws IncorrectNumberOfBoxesException {

        if(getMontyHallBoxList().size() != numberOfBoxes) {
            throw new IncorrectNumberOfBoxesException("pickFirstBox anropad i fel ordning");
        }


        Random random = new Random();
        int intRandomChoseBox = random.nextInt(montyHallBoxList.size());
        return montyHallBoxList.remove(intRandomChoseBox);
    }
    public void removeOneEmptyRemaingBox() throws IncorrectNumberOfBoxesException {

        if(getMontyHallBoxList().size() != numberOfBoxes - 1) {
            throw new IncorrectNumberOfBoxesException("removeOneEmptyRemaingBox anropad i fel ordning");
        }

        boolean isWinFirstRemainingBox = montyHallBoxList.get(0).isWinsCar();
        if(!isWinFirstRemainingBox) {
            montyHallBoxList.remove(0);
        } else montyHallBoxList.remove(1);

    }

    public MontyHallBox switchBox()  throws IncorrectNumberOfBoxesException  {
        if(getMontyHallBoxList().size() != numberOfBoxes - 2) {
            throw new IncorrectNumberOfBoxesException("switchBox anropad i fel ordning");
        }

        return montyHallBoxList.get(0);
    }

}
