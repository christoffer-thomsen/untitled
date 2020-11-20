package com.gildedrose;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private String goldenMaster = "OMGHAI!\n" +
            "-------- day 0 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 10, 20\n" +
            "Aged Brie, 2, 0\n" +
            "Elixir of the Mongoose, 5, 7\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
            "Conjured Mana Cake, 3, 6\n" +
            "\n" +
            "-------- day 1 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 9, 19\n" +
            "Aged Brie, 1, 1\n" +
            "Elixir of the Mongoose, 4, 6\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
            "Conjured Mana Cake, 2, 5\n\n";

    @Test
    void foo() {

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);

        TexttestFixture.main(new String[]{});

        // Put things back
        System.out.flush();
        System.setOut(old);

        assertEquals(goldenMaster, baos.toString());
    }

}
