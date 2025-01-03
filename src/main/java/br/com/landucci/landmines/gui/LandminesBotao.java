package br.com.landucci.landmines.gui;

import br.com.landucci.landmines.LandminesCelula;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class LandminesBotao extends JLabel {
	@Serial
    private static final long serialVersionUID = -4520316770903106847L;

    private final LandminesCelula celula;
	private boolean clicked = false;
	private boolean flag = false;
	private boolean question = false;
    private final LandminesFrame frame;

	public LandminesBotao(final LandminesFrame frame, final LandminesCelula celula) {
        this.celula = celula;
        this.frame = frame;
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.addMouseListener(new LandminesMouseAdapter(frame));
		configurarComponente();
	}

	private void configurarComponente() {
		this.setText("");
		this.setIcon(null);

		if (this.question) {
			this.setIcon(new ImageIcon(this.frame.getTema().getIconInterrogation()));
			return;
		}

		if (this.flag) {
			this.setIcon(new ImageIcon(this.frame.getTema().getIconFlag()));
			return;
		}

		if (this.clicked) {
            this.setText(this.celula.getQuantidadeBombasAsString());
            this.setForeground(this.frame.getTema().getCorTexto());
            this.setBackground(this.frame.getTema().getCorFundo());
            this.setOpaque(true);
		}

		if (!this.clicked) {
			this.setIcon(new ImageIcon(this.frame.getTema().getIconHide()));
		}
	}

	public void revelar() {
		if (isBomb()) {
			this.setIcon(new ImageIcon(this.frame.getTema().getIconBomb()));
		}
	}

	public int getPx() {
		return this.celula.getPosicaoX();
	}

	public int getPy() {
		return this.celula.getPosicaoY();
	}

	public boolean isClicked() {
		return clicked;
	}

	public boolean isBomb() {
		return this.celula.hasBomb();
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isQuestion() {
		return question;
	}

	public int getQuantidadeBombas() {
		return this.celula.getQuantidadeBombas();
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
		configurarComponente();
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		configurarComponente();
	}

	public void setQuestion(boolean question) {
		this.question = question;
		configurarComponente();
	}

}