package br.com.landucci.landmines;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CLSImagens {
	public static BufferedImage ICON_FLAG = null;
	public static BufferedImage ICON_BOMB = null;
	public static BufferedImage ICON_INTERROGATION = null;
	public static BufferedImage ICON_HIDE = null;
	public static BufferedImage ICON_QUESTION = null;

	static {
		try {
			ICON_FLAG = ImageIO.read(CLSImagens.class.getResourceAsStream("flag.png"));
			ICON_BOMB = ImageIO.read(CLSImagens.class.getResourceAsStream("bomb.png"));
			ICON_INTERROGATION = ImageIO.read(CLSImagens.class.getResourceAsStream("interrogation.png"));
			ICON_HIDE = ImageIO.read(CLSImagens.class.getResourceAsStream("hide.png"));
			ICON_QUESTION = ImageIO.read(CLSImagens.class.getResourceAsStream("question.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
