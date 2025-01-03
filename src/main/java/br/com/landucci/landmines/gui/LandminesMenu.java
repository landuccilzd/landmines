package br.com.landucci.landmines.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandminesMenu extends JMenuBar {

    public LandminesMenu(final LandminesFrame mainFrame) {
        final var menuArquivo = createMenuArquivo(mainFrame);
        this.add(menuArquivo);
    }

    private static JMenu createMenuArquivo(final LandminesFrame mainFrame) {
        final var opcoesAction = createOpcoesAction(mainFrame);

        final var menuArquivo = new JMenu("Arquivo");
        menuArquivo.add(opcoesAction);
        return menuArquivo;
    }

    private static JMenuItem createOpcoesAction(final LandminesFrame mainFrame) {
        final var opcoesAction = new JMenuItem("Opções");
        opcoesAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final var opcoesFrame = new LandminesOpcoesFrame(mainFrame);
                opcoesFrame.setVisible(true);
            }
        });
        return opcoesAction;
    }
}
