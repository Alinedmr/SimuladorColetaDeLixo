package Caminhos;

public class CaminhaoGrande {
    protected int capacidadeMaxima = 20000;
    protected int cargaAtual;

    public void carregar(int quantidade) {
        cargaAtual += quantidade;
        if (cargaAtual > capacidadeMaxima) {
            cargaAtual = capacidadeMaxima;
        }
    }

    public boolean prontoParaPartir() {
        return cargaAtual >= capacidadeMaxima;
    }

    public void baixar() {
        System.out.println("Caminhão grande partiu para o aterro com " + cargaAtual + " kg.");
        cargaAtual = 0;

    }
    public int getCapacidade(){
        return capacidadeMaxima;
    }
    public int getCargaAtual(){
        return cargaAtual;
    }
}
