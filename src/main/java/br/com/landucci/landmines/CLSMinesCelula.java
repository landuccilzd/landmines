package br.com.landucci.landmines;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CLSMinesCelula extends JLabel {
	private static final long serialVersionUID = -4520316770903106847L;

	private int px = 0;
	private int py = 0;
	private boolean clicked = false;
	private boolean bomb = false;
	private boolean flag = false;
	private boolean question = false;
	private int number = 0;

	public CLSMinesCelula(int x, int y, int number, boolean bomb) {
		this.px = x;
		this.py = y;
		this.bomb = bomb;
		this.number = number;
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.BOLD, 13));
		configurarComponente();
	}

	public void configurarComponente() {
		this.setText("");
		this.setIcon(null);

		if (this.question) {
			this.setIcon(new ImageIcon(CLSImagens.ICON_INTERROGATION));
			return;
		}

		if (this.flag) {
			this.setIcon(new ImageIcon(CLSImagens.ICON_FLAG));
			return;
		}

		if (this.clicked) {
			switch (this.number) {
			case 1: {
				this.setForeground(new Color(64, 80, 190));
				break;
			}
			case 2: {
				this.setForeground(new Color(29, 104, 3));
				break;
			}
			case 3: {
				this.setForeground(new Color(170, 6, 5));
				break;
			}
			case 4: {
				this.setForeground(new Color(1, 1, 132));
				break;
			}
			case 5: {
				this.setForeground(Color.ORANGE);
				break;
			}
			case 6: {
				this.setForeground(Color.MAGENTA);
				break;
			}
			case 7: {
				this.setForeground(Color.BLACK);
				break;
			}
			case 8: {
				this.setForeground(Color.CYAN);
				break;
			}
			}
			this.setText((number > 0) ? "" + number : "");
		}

		if (!this.clicked) {
			this.setIcon(new ImageIcon(CLSImagens.ICON_HIDE));
		}
	}

	public void revelar() {
		if (this.bomb) {
			this.setIcon(new ImageIcon(CLSImagens.ICON_BOMB));
			return;
		}
	}

	public int getPx() {
		return px;
	}

	public int getPy() {
		return py;
	}

	public boolean isClicked() {
		return clicked;
	}

	public boolean isBomb() {
		return bomb;
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isQuestion() {
		return question;
	}

	public int getNumber() {
		return number;
	}

	public void setPx(int x) {
		this.px = x;
	}

	public void setPy(int y) {
		this.py = y;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
		configurarComponente();
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
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

	public void setNumber(int number) {
		this.number = number;
	}
}