package com.b3.montyhall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MontyHallGameTest {

    public static MontyHallGame montyHallGame;

    void setUp() {
        montyHallGame = new MontyHallGame();
        MontyHallBox box1 = new MontyHallBox();
        MontyHallBox box2 = new MontyHallBox();
        box2.setWinsCar(true);
        MontyHallBox box3 = new MontyHallBox();
        List<MontyHallBox> montyHallBoxList = new ArrayList<>();
        montyHallBoxList.add(box1);
        montyHallBoxList.add(box2);
        montyHallBoxList.add(box3);
    }

    @Test
    public void constructorCreatesListOfThreeBoxes() {
        var montyHallGame = new MontyHallGame();
        assertEquals(3, montyHallGame.getMontyHallBoxList().size());
    }

    @Test
    public void onlyOneOfTheThreeBoxesIsWin() {
        var montyHallGame = new MontyHallGame();
        List<MontyHallBox> boxList = montyHallGame.getMontyHallBoxList();
        int numberOfWins = 0;
        for(MontyHallBox box: boxList) {
            if(box.isWinsCar()) {
                ++numberOfWins;
            }
        }
        assertEquals(1, numberOfWins);
    }

    @Test
    public void pickFirstBoxLeavesTwoBoxes() throws IncorrectNumberOfBoxesException {
        setUp();
        montyHallGame.pickAndRemoveFirstBox();
        List<MontyHallBox> boxList = montyHallGame.getMontyHallBoxList();
        assertEquals(2, boxList.size());
    }

    @Test
    public void pickFirstBoxLeavesOneBoxAndThrowsException() {
        setUp();
        montyHallGame.getMontyHallBoxList().remove(0);
        Exception exception = assertThrows(IncorrectNumberOfBoxesException.class, () -> {
            montyHallGame.pickAndRemoveFirstBox();
        });
        String expectedMessage = "pickFirstBox anropad i fel ordning";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void removeOneEmptyRemaingBoxLeavesOneBox() throws IncorrectNumberOfBoxesException {
        setUp();
        montyHallGame.getMontyHallBoxList().remove(0);
        montyHallGame.removeOneEmptyRemaingBox();
        List<MontyHallBox> boxList = montyHallGame.getMontyHallBoxList();
        assertEquals(1, boxList.size());
    }

    @Test
    public void removeOneEmptyRemaingBoxLeavesTwoBoxesAndThrowsException() {
        setUp();

        Exception exception = assertThrows(IncorrectNumberOfBoxesException.class, () -> {
            montyHallGame.removeOneEmptyRemaingBox();
        });

        String expectedMessage = "removeOneEmptyRemaingBox anropad i fel ordning";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void switchBoxCalledWhenWrongNumberOfBoxesRemain() {
        setUp();

        Exception exception = assertThrows(IncorrectNumberOfBoxesException.class, () -> {
            montyHallGame.switchBox();
        });
        String expectedMessage = "switchBox anropad i fel ordning";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}