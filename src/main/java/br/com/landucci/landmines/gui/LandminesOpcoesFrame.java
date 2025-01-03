package br.com.landucci.landmines.gui;

import br.com.landucci.landmines.LandminesDificuldadeEnum;
import br.com.landucci.landmines.LandminesTemasEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandminesOpcoesFrame extends JDialog {

    public static final String TITLE = "Opções";

    private JComboBox comboTema;
    private JComboBox comboDificuldade;

    private LandminesFrame mainFrame;

    public LandminesOpcoesFrame(final LandminesFrame mainFrame) {
        super(mainFrame, TITLE);
        this.mainFrame = mainFrame;

        configurarFrame();
        configurarComponentes();
    }

    private void configurarFrame() {
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setSize(new Dimension(400, 300));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(mainFrame);
        this.setResizable(false);
    }

    private void configurarComponentes() {
        createComponentesTema();
        createComponentesDificuldade();
        createBotaoOk();
    }

    private void createComponentesTema() {
        final var labelTema = new JLabel("Tema:");
        labelTema.setBounds(10, 10, 50, 30);

        this.comboTema = new JComboBox(LandminesTemasEnum.values());
        this.comboTema.setBounds(60, 10, 300, 30);
        this.comboTema.setSelectedItem(this.mainFrame.getTema());

        this.getContentPane().add(labelTema);
        this.getContentPane().add(this.comboTema);
    }

    private void createComponentesDificuldade() {
        final var labelDificuldade = new JLabel("Dificuldade:");
        labelDificuldade.setBounds(10, 50, 50, 30);

        this.comboDificuldade = new JComboBox(LandminesDificuldadeEnum.values());
        this.comboDificuldade.setBounds(60, 50, 300, 30);
        this.comboDificuldade.setSelectedItem(this.mainFrame.getDificuldade());

        this.getContentPane().add(labelDificuldade);
        this.getContentPane().add(this.comboDificuldade);
    }

    private void createBotaoOk() {
        final var botaoOk = new JButton("OK");
        botaoOk.setBounds(150, 200, 100, 30);
        botaoOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setTema((LandminesTemasEnum) comboTema.getSelectedItem());
                mainFrame.setDificuldade((LandminesDificuldadeEnum) comboDificuldade.getSelectedItem());
                mainFrame.inicializar();
                mainFrame.reiniciarTela();
                dispose();
            }
        });
        getContentPane().add(botaoOk);
    }
}
