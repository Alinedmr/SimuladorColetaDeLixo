package Caminhos;

public abstract class CaminhaoPequeno {
    protected int capacidade;
    protected int cargaAtual;
    protected int viagensHoje;
    protected int maxViagensPorDia;

    public CaminhaoPequeno(int capacidade, int maxViagemPorDia) {
        this.capacidade = capacidade;
        this.cargaAtual = 0;
        this.viagensHoje = 0;
        this.maxViagensPorDia = maxViagemPorDia;
    }

    public abstract boolean coletar(int quantidade);

    public boolean estaCheio() {

        return cargaAtual >= capacidade;
    }

    public void descarregar() {
        System.out.println("Descarregando " + cargaAtual + " kg.");
        cargaAtual = 0;
    }

    public int getCargaAtual() {
        return cargaAtual;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void carregar(int quantidade) {
        if (cargaAtual + quantidade <= capacidade) {
            cargaAtual += quantidade;
        }
    }
    public boolean podeViajar() {
        return viagensHoje < maxViagensPorDia;
    }

    public void registrarViagem() {
        viagensHoje++;
    }

    public void resetarViagens() {
        viagensHoje = 0;
    }

    public int getViagensHoje() {
        return viagensHoje;
    }

    public int getMaxViagensPorDia() {
        return maxViagensPorDia;
    }

}
