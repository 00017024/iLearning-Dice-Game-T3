package org.example;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import java.util.List;


public class Table {
    public String generateTable() {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("#", "Computer", "User");
        table.addRule();
        table.addRow("1", "Generates a random number", "`x ∈ {0,1,2,3,4,5}`");
        table.addRule();
        table.addRow("2", "Generates a secret key", "");
        table.addRule();
        table.addRow("3", "Calculates and displays", "Selects a number");
        table.addRow("", "`HMAC(key).calculate(x)`", "`y ∈ {0,1,2,3,4,5}`");
        table.addRule();
        table.addRow("4", "Calculates the result", "");
        table.addRow("", "`(x + y) % 6`", "");
        table.addRule();
        table.addRow("5", "Shows both the result", "and the key");
        table.addRule();

        return table.render();
    }

    public String generateProbabilityTable(List<Dice> diceList, Probability probability) {
        AsciiTable table = new AsciiTable();
        table.getRenderer().setCWC(new CWC_LongestLine());


        table.addRule();
        table.addRow("User dice \\ v",
                        diceList.get(0).getSidesAsString(),
                        diceList.get(1).getSidesAsString(),
                        diceList.get(2).getSidesAsString())
                .setTextAlignment(TextAlignment.CENTER);
        table.addRule();


        for (int i = 0; i < diceList.size(); i++) {
            Dice dice = diceList.get(i);
            List<Double> probabilities = probability.calculateProbabilities(dice, diceList);


            String[] row = new String[diceList.size() + 1];
            row[0] = dice.getSidesAsString(); // Row header
            for (int j = 0; j < probabilities.size(); j++) {
                row[j + 1] = probabilities.get(j) == null ? "-" : String.format("%.4f", probabilities.get(j));
            }

            table.addRow((Object[]) row).setTextAlignment(TextAlignment.RIGHT);
            table.addRule();
        }

        return table.render();
    }
}
