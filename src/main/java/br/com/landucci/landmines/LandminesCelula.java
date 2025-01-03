package br.com.landucci.landmines;

public class LandminesCelula {

    private final int posicaoX;
    private final int posicaoY;
    private boolean bomb;
//    private LandminesQuantidadeBombasEnum quantidadeBombas;
    private int quantidadeBombas;

    public LandminesCelula(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.bomb = false;
        this.quantidadeBombas = 0;
    }

    public void posicionarBomba() {
        this.bomb = true;
        this.quantidadeBombas = 0;
    }

    public void atribuirNumero(final int numero) {
        if (hasBomb()) {
            return;
        }
        this.quantidadeBombas = numero;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public boolean hasBomb() {
        return bomb;
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

}
