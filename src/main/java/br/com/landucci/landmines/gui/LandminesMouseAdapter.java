package br.com.landucci.landmines.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LandminesMouseAdapter extends MouseAdapter {

    private final LandminesFrame frame;

    public LandminesMouseAdapter(final LandminesFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
        LandminesBotao botao = (LandminesBotao) e.getSource();
        if (botao.isClicked()) {
            return;
        }

        if (e.getButton() == 3) {
            if (!botao.isFlag() && !botao.isQuestion()) {
                botao.setQuestion(false);
                botao.setFlag(true);
            } else if (botao.isFlag()) {
                botao.setQuestion(true);
                botao.setFlag(false);
            } else {
                botao.setQuestion(false);
                botao.setFlag(false);
            }
            return;
        }

        if (botao.isFlag()) {
            return;
        }

        if (botao.isBomb()) {
            this.frame.revelar();
            return;
        }

        botao.setFlag(false);
        botao.setQuestion(false);
        this.frame.jogar(botao);
    }
}
