package com.company.zoo;

public class Main {

    public static void main(String[] args) {
        final IOManager ioManager = new IOManagerConsole();
        final GameManager gameManager = new GameManager(ioManager);
        ioManager.showMessage(Texts.WELCOME);
        boolean notEnd;
        do {
            gameManager.play();
            notEnd = ioManager.getDecision(Texts.PLAY_AGAIN);
        } while (notEnd);
    }
}
