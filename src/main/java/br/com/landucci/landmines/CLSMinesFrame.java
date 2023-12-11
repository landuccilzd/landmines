package br.com.landucci.landmines;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CLSMinesFrame extends JFrame implements MouseListener {
	private static final long serialVersionUID = -1622952744324097868L;

	public static final int NIVEL_FACIL = 1;
	public static final int NIVEL_MEDIO = 2;
	public static final int NIVEL_DIFICIL = 3;

	private int largura;
	private int altura;

	private int nivel;
	private int totalBombas;
	private boolean[][] tabuleiro;
	private CLSMinesCelula[][] celulas;

	public CLSMinesFrame(int nivel) {
		super("LandMines");

		this.nivel = nivel;

		switch (this.nivel) {
		case NIVEL_FACIL: {
			this.largura = 15;
			this.altura = 15;
			this.totalBombas = (int) (this.largura * this.altura * 0.15f);
		}
		case NIVEL_MEDIO: {
			this.largura = 30;
			this.altura = 15;
			this.totalBombas = (int) (this.largura * this.altura * 0.17f);
		}
		case NIVEL_DIFICIL: {
			this.largura = 30;
			this.altura = 30;
			this.totalBombas = (int) (this.largura * this.altura * 0.20f);
		}
		}

		this.tabuleiro = new boolean[this.largura][this.altura];
		this.celulas = new CLSMinesCelula[this.largura][this.altura];

		GridLayout gl = new GridLayout(this.largura, this.altura, 0, 0);
		this.getContentPane().setLayout(gl);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setSize((this.largura * 20) + 16, (this.altura * 20) + 38);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		montarTabuleiro();
	}

	private void limparTabuleiro() {
		this.getContentPane().removeAll();
		GridLayout gl = (GridLayout) this.getContentPane().getLayout();
		this.getContentPane().setLayout(gl);
		this.getContentPane().repaint();
	}

	private void montarTabuleiro() {
		int[] xBombas = new int[this.totalBombas], yBombas = new int[this.totalBombas];
		for (int i = 0; i < this.totalBombas; i++) {
			xBombas[i] = (int) Math.round(Math.random() * (this.largura - 1));
			yBombas[i] = (int) Math.round(Math.random() * (this.altura - 1));
		}

		for (int y = 0; y < this.altura; y++) {
			for (int x = 0; x < this.largura; x++) {
				boolean hasBomb = false;

				for (int i = 0; i < this.totalBombas; i++) {
					int xb = xBombas[i];
					int yb = yBombas[i];

					if ((xb == x) && (yb == y)) {
						hasBomb = true;
						break;
					}
				}
				this.tabuleiro[x][y] = hasBomb;
			}
		}

		for (int y = 0; y < this.altura; y++) {
			for (int x = 0; x < this.largura; x++) {
				int qtBombasVisinhas = 0;
				qtBombasVisinhas += (x < this.largura - 1) && this.tabuleiro[x + 1][y] ? 1 : 0;
				qtBombasVisinhas += (x < this.largura - 1) && (y < this.altura - 1) && this.tabuleiro[x + 1][y + 1] ? 1
						: 0;
				qtBombasVisinhas += (x < this.largura - 1) && (y > 0) && this.tabuleiro[x + 1][y - 1] ? 1 : 0;

				qtBombasVisinhas += (y < this.largura - 1) && this.tabuleiro[x][y + 1] ? 1 : 0;
				qtBombasVisinhas += (y > 0) && this.tabuleiro[x][y - 1] ? 1 : 0;

				qtBombasVisinhas += (x > 0) && (y < this.altura - 1) && this.tabuleiro[x - 1][y + 1] ? 1 : 0;
				qtBombasVisinhas += (x > 0) && this.tabuleiro[x - 1][y] ? 1 : 0;
				qtBombasVisinhas += (x > 0) && (y > 0) && this.tabuleiro[x - 1][y - 1] ? 1 : 0;

				CLSMinesCelula celula = new CLSMinesCelula(x, y, qtBombasVisinhas, this.tabuleiro[x][y]);
				celula.addMouseListener(this);
				this.celulas[x][y] = celula;
				this.getContentPane().add(celula);
			}
		}
	}

	public List<CLSMinesCelula> getCelulasVisinhas(CLSMinesCelula celula) {
		List<CLSMinesCelula> retorno = new ArrayList<CLSMinesCelula>();

		if (celula.getPx() < this.largura - 1) {
			retorno.add(this.celulas[celula.getPx() + 1][celula.getPy()]);
		}

		if ((celula.getPx() < this.largura - 1) && (celula.getPy() < this.altura - 1)) {
			retorno.add(this.celulas[celula.getPx() + 1][celula.getPy() + 1]);
		}

		if ((celula.getPx() < this.largura - 1) && (celula.getPy() > 0)) {
			retorno.add(this.celulas[celula.getPx() + 1][celula.getPy() - 1]);
		}

		if (celula.getPy() < this.altura - 1) {
			retorno.add(this.celulas[celula.getPx()][celula.getPy() + 1]);
		}

		if (celula.getPy() > 0) {
			retorno.add(this.celulas[celula.getPx()][celula.getPy() - 1]);
		}

		if ((celula.getPx() > 0) && (celula.getPy() < this.altura - 1)) {
			retorno.add(this.celulas[celula.getPx() - 1][celula.getPy() + 1]);
		}

		if (celula.getPx() > 0) {
			retorno.add(this.celulas[celula.getPx() - 1][celula.getPy()]);
		}

		if ((celula.getPx() > 0) && (celula.getPy() > this.altura - 1)) {
			retorno.add(this.celulas[celula.getPx() - 1][celula.getPy() - 1]);
		}

		return retorno;
	}

	public void jogar(CLSMinesCelula celula) {
		celula.setClicked(true);
		if (celula.getNumber() == 0) {
			for (CLSMinesCelula c : getCelulasVisinhas(celula)) {
				if (!c.isClicked()) {
					jogar(c);
				}
			}
		}
	}

	public void revelar() {
		for (int y = 0; y < (15 * this.nivel) - 1; y++) {
			for (int x = 0; x < (15 * this.nivel) - 1; x++) {
				this.celulas[x][y].revelar();
			}
		}
		int resposta = JOptionPane.showConfirmDialog(this, "Explodiu! Deseja Jogar novamente?", "LandMines",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(CLSImagens.ICON_QUESTION));
		if (resposta == JOptionPane.YES_OPTION) {
			limparTabuleiro();
			montarTabuleiro();
		} else {
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		CLSMinesCelula celula = (CLSMinesCelula) e.getSource();
		if (celula.isClicked()) {
			return;
		}

		if (e.getButton() == 3) {
			if (!celula.isFlag() && !celula.isQuestion()) {
				celula.setQuestion(false);
				celula.setFlag(true);
			} else if (celula.isFlag()) {
				celula.setQuestion(true);
				celula.setFlag(false);
			} else {
				celula.setQuestion(false);
				celula.setFlag(false);
			}
			return;
		}

		if (celula.isFlag()) {
			return;
		}

		if (celula.isBomb()) {
			this.revelar();
			return;
		}

		celula.setFlag(false);
		celula.setQuestion(false);
		jogar(celula);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}