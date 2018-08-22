package com.company.zoo;

import java.util.List;

import static java.lang.String.format;

public class GameManager {
    private final IOManager ioManager;
    private boolean shouldContinue;

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        playGame();
        ioManager.showMessage(Texts.END_OF_THE_GAME);
    }

    private void playGame() {
        shouldContinue = true;

        do {
            //
            shouldContinue = false;

        } while (shouldContinue);
    }
}
