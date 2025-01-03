package br.com.landucci.landmines;

import java.awt.*;
import java.awt.image.BufferedImage;

public enum LandminesTemasEnum {

    ROSA("Rosa", "rosa/", new Color(136, 14, 79), new Color(244, 143, 177)),
    VERDE("Verde", "verde/", new Color(15, 56, 15), new Color(155, 188, 15));

    private final String nome;
    private final String nomePasta;
    private final Color corFundo;
    private final Color corTexto;

    private final LandminesImagens imagens;

    LandminesTemasEnum(final String nome, final String nomePasta, final Color corFundo, final Color corTexto) {
        this.nome = nome;
        this.nomePasta = nomePasta;
        this.corFundo = corFundo;
        this.corTexto = corTexto;
        this.imagens = new LandminesImagens(this);
    }

    public String getNome() {
        return nome;
    }

    public String getNomePasta() {
        return nomePasta;
    }

    public Color getCorFundo() {
        return corFundo;
    }

    public Color getCorTexto() {
        return corTexto;
    }


    public BufferedImage getIconFlag() {
        return this.imagens.getIconFlag();
    }

    public BufferedImage getIconBomb() {
        return this.imagens.getIconBomb();
    }

    public BufferedImage getIconInterrogation() {
        return this.imagens.getIconInterrogation();
    }

    public BufferedImage getIconHide() {
        return this.imagens.getIconHide();
    }

    public BufferedImage getIconQuestion() {
        return this.imagens.getIconQuestion();
    }

    @Override
    public String toString() {
        return getNome();
    }
}
