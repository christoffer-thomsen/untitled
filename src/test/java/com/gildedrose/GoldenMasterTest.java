package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class GoldenMasterTest {
    @Test
    void multi_day_simulation() {
        final var buffer = new ByteArrayOutputStream();
        final var printStream = new PrintStream(buffer);
        System.setOut(printStream);

        TexttestFixture.main(new String[]{});

        Approvals.verify(buffer.toString());
    }
}
