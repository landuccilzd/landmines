package br.com.landucci.landmines;

public enum LandminesDificuldadeEnum {

    FACIL("Fácil (15 X 15 - 33 bombas)", 15, 15, 0.15f),
    MEDIO("Médio (20 x 20 - 68 bombas)", 20, 20, 0.17f),
    DIFICIL("Difícil (30 x 30 - 180 bombas)", 30, 30, 0.20f);

    private String nome;
    private int quantidadeCelulasLargura;
    private int quantidadeCelulasAltura;
    private int totalBombas;

    LandminesDificuldadeEnum(final String nome, final int quantidadeCelulasLargura, final int quantidadeCelulasAltura, final float fator) {
        this.nome = nome;
        this.quantidadeCelulasLargura = quantidadeCelulasLargura;
        this.quantidadeCelulasAltura = quantidadeCelulasAltura;
        this.totalBombas = (int) (this.quantidadeCelulasLargura * this.quantidadeCelulasAltura * fator);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeCelulasLargura() {
        return quantidadeCelulasLargura;
    }

    public int getQuantidadeCelulasAltura() {
        return quantidadeCelulasAltura;
    }

    public int getTotalBombas() {
        return totalBombas;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
