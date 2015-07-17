package org.nuxeo.robovm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NuxeoStore {
    private List<String> fortunes = Arrays.asList(
            "RoboVM rocks!",
            "RoboVM is awesome!"
    );

    private static Random rng = new Random();

    public String getFortune() {
        return fortunes.get(rng.nextInt(fortunes.size()));
    }
}
