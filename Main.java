package org.example;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        List<Dice> diceList = Arrays.asList(
                new Dice(new int[]{0, 1, 2, 3, 4, 5}),
                new Dice(new int[]{0, 1, 2, 3, 4, 5}),
                new Dice(new int[]{0, 1, 2, 3, 4, 5})
        );

        Table table = new Table();
        Probability probability = new Probability();


        DiceGame game = new DiceGame(diceList, table, probability);
        game.start();

    }
}