package Caminhos;

public class CaminhaoPequenoPadrao extends CaminhaoPequeno {

    public CaminhaoPequenoPadrao(int capacidade, int maxViagensPorDia) {
        super(capacidade, maxViagensPorDia); // Chama o construtor da classe pai para inicializar a capacidade
    }

    @Override
    public boolean coletar(int quantidade) {
        if (cargaAtual + quantidade <= capacidade) {
            cargaAtual += quantidade;
            return true;
        }
        return false;
    }
}
