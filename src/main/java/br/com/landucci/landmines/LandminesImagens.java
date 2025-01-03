package br.com.landucci.landmines;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LandminesImagens {
	private BufferedImage iconFlag;
    private BufferedImage iconBomb;
    private BufferedImage iconInterrogation;
    private BufferedImage iconHide;
    private BufferedImage iconQuestion;

    public LandminesImagens(final LandminesTemasEnum tema) {
        try {
            this.iconFlag = ImageIO.read(LandminesImagens.class.getResourceAsStream(tema.getNomePasta() + "flag.png"));
            this.iconBomb = ImageIO.read(LandminesImagens.class.getResourceAsStream(tema.getNomePasta() + "bomb.png"));
            this.iconInterrogation = ImageIO.read(LandminesImagens.class.getResourceAsStream(tema.getNomePasta() + "interrogation.png"));
            this.iconHide = ImageIO.read(LandminesImagens.class.getResourceAsStream(tema.getNomePasta() + "hide.png"));
            this.iconQuestion = ImageIO.read(LandminesImagens.class.getResourceAsStream(tema.getNomePasta() + "question.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getIconFlag() {
        return iconFlag;
    }

    public BufferedImage getIconBomb() {
        return iconBomb;
    }

    public BufferedImage getIconInterrogation() {
        return iconInterrogation;
    }

    public BufferedImage getIconHide() {
        return iconHide;
    }

    public BufferedImage getIconQuestion() {
        return iconQuestion;
    }
}
