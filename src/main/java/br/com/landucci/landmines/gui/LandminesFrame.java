package br.com.landucci.landmines.gui;

import br.com.landucci.landmines.LandminesBoard;
import br.com.landucci.landmines.LandminesDificuldadeEnum;
import br.com.landucci.landmines.LandminesTemasEnum;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class LandminesFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = -1622952744324097868L;
    public static final String MENSAGEM_JOGAR_NOVAMENTE = "Explodiu! Deseja Jogar novamente?";
    public static final String LAND_MINES = "LandMines";
    public static final int TAMANHO_BOTAO = 30;

    private int largura;
    private int altura;
    private LandminesBoard tabuleiro;
    private LandminesBotao[][] botoes;

    private LandminesTemasEnum tema = LandminesTemasEnum.VERDE;
    private LandminesDificuldadeEnum dificuldade = LandminesDificuldadeEnum.MEDIO;

    public LandminesFrame() {
        super(LAND_MINES);
        inicializar();
        this.montarTela();
    }

    protected void inicializar() {
        this.largura = this.dificuldade.getQuantidadeCelulasLargura();
        this.altura = this.dificuldade.getQuantidadeCelulasAltura();
        this.botoes = new LandminesBotao[this.largura][this.altura];
        this.tabuleiro = new LandminesBoard(this.dificuldade);
        this.configurarFrame();
    }

    private void configurarFrame() {
        final var layout = new GridLayout(largura, altura, 0, 0);
        this.getContentPane().setLayout(layout);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setSize((largura * TAMANHO_BOTAO) + 16, (altura * TAMANHO_BOTAO) + 12);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setJMenuBar(new LandminesMenu(this));
    }

    private void montarTela() {
        final var modeloTabuleiro = this.tabuleiro.getTabuleiro();

        for (var y = 0; y < this.altura; y++) {
            for (var x = 0; x < this.largura; x++) {
                final var botao = new LandminesBotao(this, modeloTabuleiro[x][y]);
                this.getContentPane().add(botao);
                this.botoes[x][y] = botao;
            }
        }

        this.getContentPane().revalidate();
    }

    private void limparTela() {
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
    }

    protected void reiniciarTela() {
        this.tabuleiro.reiniciar();
        this.limparTela();
        this.montarTela();
    }

    private List<LandminesBotao> getCelulasVisinhas(final LandminesBotao botao) {
		final var retorno = new ArrayList<LandminesBotao>();

		if (botao.getPx() < this.largura - 1) {
			retorno.add(this.botoes[botao.getPx() + 1][botao.getPy()]);
		}

		if ((botao.getPx() < this.largura - 1) && (botao.getPy() < this.altura - 1)) {
			retorno.add(this.botoes[botao.getPx() + 1][botao.getPy() + 1]);
		}

		if ((botao.getPx() < this.largura - 1) && (botao.getPy() > 0)) {
			retorno.add(this.botoes[botao.getPx() + 1][botao.getPy() - 1]);
		}

		if (botao.getPy() < this.altura - 1) {
			retorno.add(this.botoes[botao.getPx()][botao.getPy() + 1]);
		}

		if (botao.getPy() > 0) {
			retorno.add(this.botoes[botao.getPx()][botao.getPy() - 1]);
		}

		if ((botao.getPx() > 0) && (botao.getPy() < this.altura - 1)) {
			retorno.add(this.botoes[botao.getPx() - 1][botao.getPy() + 1]);
		}

		if (botao.getPx() > 0) {
			retorno.add(this.botoes[botao.getPx() - 1][botao.getPy()]);
		}

		if ((botao.getPx() > 0) && (botao.getPy() > this.altura - 1)) {
			retorno.add(this.botoes[botao.getPx() - 1][botao.getPy() - 1]);
		}

		return retorno;
	}

    protected void jogar(final LandminesBotao botao) {
        if (botao.isClicked() || botao.isFlag() || botao.isQuestion()) {
            return;
        }

        botao.setClicked(true);
        if (botao.getQuantidadeBombas() == 0) {
            for (LandminesBotao b : getCelulasVisinhas(botao)) {
                this.jogar(b);
            }
        }
    }

	protected void revelar() {
        for (final var component: this.getContentPane().getComponents()) {
            final var botao = (LandminesBotao) component;
            botao.revelar();
        }

        final var resposta = JOptionPane.showOptionDialog(this, MENSAGEM_JOGAR_NOVAMENTE, LAND_MINES,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(this.getTema().getIconQuestion()),
                new String[] {"SIM", "NÃO"}, "SIM");

        if (resposta != JOptionPane.YES_OPTION) {
            System.exit(0);
        }

        this.reiniciarTela();
	}

    public LandminesTemasEnum getTema() {
        return tema;
    }

    public LandminesDificuldadeEnum getDificuldade() {
        return dificuldade;
    }

    public void setTema(LandminesTemasEnum tema) {
        this.tema = tema;
    }

    public void setDificuldade(LandminesDificuldadeEnum dificuldade) {
        this.dificuldade = dificuldade;
    }
}