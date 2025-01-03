package br.com.landucci.landmines;

import java.awt.*;

public enum LandminesQuantidadeBombasEnum {

//  new Color(244, 143, 177) - Rosa
//    new Color(155, 188, 15) - Verde
    ZERO(0, new Color(155, 188, 15)),
    UM(1, new Color(155, 188, 15)),
    DOIS(2, new Color(155, 188, 15)),
    TRES(3, new Color(155, 188, 15)),
    QUATRO(4, new Color(155, 188, 15)),
    CINCO(5, new Color(155, 188, 15)),
    SEIS(6, new Color(155, 188, 15)),
    SETE(7, new Color(155, 188, 15)),
    OITO(8, new Color(155, 188, 15));


    private final int quantidadeBombas;
    private final Color cor;

    LandminesQuantidadeBombasEnum(final int quantidadeBombas, final Color cor) {
        this.quantidadeBombas = quantidadeBombas;
        this.cor = cor;
    }

    public static LandminesQuantidadeBombasEnum getInstance(final int quantidadeBombas) {
        if (quantidadeBombas == UM.getQuantidadeBombas()) {
            return UM;
        }
        if (quantidadeBombas == DOIS.getQuantidadeBombas()) {
            return DOIS;
        }
        if (quantidadeBombas == TRES.getQuantidadeBombas()) {
            return TRES;
        }
        if (quantidadeBombas == QUATRO.getQuantidadeBombas()) {
            return QUATRO;
        }
        if (quantidadeBombas == CINCO.getQuantidadeBombas()) {
            return CINCO;
        }
        if (quantidadeBombas == SEIS.getQuantidadeBombas()) {
            return SEIS;
        }
        if (quantidadeBombas == SETE.getQuantidadeBombas()) {
            return SETE;
        }
        if (quantidadeBombas == OITO.getQuantidadeBombas()) {
            return OITO;
        }
        return ZERO;
    }

    public int getQuantidadeBombas() {
        return quantidadeBombas;
    }

    public String getQuantidadeBombasAsString() {
        if (getQuantidadeBombas() == 0) {
            return "";
        }

        return "" + getQuantidadeBombas();
    }

    public Color getCor() {
        return cor;
    }
}
