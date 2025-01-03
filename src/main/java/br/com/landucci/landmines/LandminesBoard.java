package br.com.landucci.landmines;

import java.util.Random;

public class LandminesBoard {

    private final int largura;
    private final int altura;
    private final int totalBombas;
    private final LandminesCelula[][] tabuleiro;
    private final String[] bombas;
    private final Random random;

    public LandminesBoard(final LandminesDificuldadeEnum dificuldadeEnum) {
        this.random = new Random();
        this.totalBombas = dificuldadeEnum.getTotalBombas();
        this.largura = dificuldadeEnum.getQuantidadeCelulasLargura();
        this.altura = dificuldadeEnum.getQuantidadeCelulasAltura();
        this.tabuleiro = new LandminesCelula[this.largura][this.altura];
        this.bombas = new String[this.totalBombas];
        montarTabuleiro();
    }

    public void reiniciar() {
        montarTabuleiro();
    }

    private void montarTabuleiro() {
        distribuirBombas();
        posicionarBombas();
        popularTabuleiro();
    }

    private void distribuirBombas() {
        for (var i = 0; i < this.totalBombas - 1; i++) {
            this.bombas[i] = this.random.nextInt(this.largura - 1) + ";" + this.random.nextInt(this.altura - 1);
        }
    }

    private void posicionarBombas() {
        for (var y = 0; y < this.altura; y++) {
            for (var x = 0; x < this.largura; x++) {
                this.tabuleiro[x][y] = new LandminesCelula(x, y);

                for (var i = 0; i < this.totalBombas - 1; i++) {
                    final var posicaoBomba = bombas[i].split(";");
                    final var xb = Integer.parseInt(posicaoBomba[0]);
                    final var yb = Integer.parseInt(posicaoBomba[1]);

                    if (((xb == x) && (yb == y))) {
                        this.tabuleiro[x][y].posicionarBomba();
                        break;
                    }
                }
            }
        }
    }

    private void popularTabuleiro() {
        for (int y = 0; y < this.altura; y++) {
            for (int x = 0; x < this.largura; x++) {
                int qtBombasVisinhas = contarBOmbasVizinhas(x, y);
                this.tabuleiro[x][y].atribuirNumero(qtBombasVisinhas);
            }
        }
    }

    private int contarBOmbasVizinhas(int x, int y) {
        var qtBombasVisinhas = 0;
        qtBombasVisinhas += (x < this.largura - 1) && this.tabuleiro[x + 1][y].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (x < this.largura - 1) && (y < this.altura - 1) && this.tabuleiro[x + 1][y + 1].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (x < this.largura - 1) && (y > 0) && this.tabuleiro[x + 1][y - 1].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (y < this.altura - 1) && this.tabuleiro[x][y + 1].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (y > 0) && this.tabuleiro[x][y - 1].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (x > 0) && (y < this.altura - 1) && this.tabuleiro[x - 1][y + 1].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (x > 0) && this.tabuleiro[x - 1][y].hasBomb() ? 1 : 0;
        qtBombasVisinhas += (x > 0) && (y > 0) && this.tabuleiro[x - 1][y - 1].hasBomb() ? 1 : 0;
        return qtBombasVisinhas;
    }

    public LandminesCelula[][] getTabuleiro() {
        return tabuleiro;
    }
}
