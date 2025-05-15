package Estações;

import Caminhos.CaminhaoPequeno;
import Caminhos.CaminhaoGrande;

public class EstacaoPadrao extends EstacaoTransferencia {

    private int lixoArmazenado;  // Armazena o lixo coletado pelos caminhões pequenos

    public EstacaoPadrao(String nome) {
        super(nome);
        this.lixoArmazenado = 0;
    }

    @Override
    public void receberCaminhaoPequeno(CaminhaoPequeno caminhao) {
        // Recebe lixo do caminhão pequeno
        int lixoColetado = caminhao.getCargaAtual();
        lixoArmazenado += lixoColetado;
        caminhao.descarregar(); // Descarrega o lixo do caminhão pequeno
        System.out.println("Estação " + getNome() + " recebeu " + lixoColetado + "kg de lixo do caminhão pequeno.");
    }

    @Override
    public void descarregarParaCaminhaoGrande(CaminhaoGrande caminhao) {
        // Descarrega o lixo acumulado na estação para um caminhão grande
        caminhao.carregar(lixoArmazenado);
        System.out.println("Estação " + getNome() + " carregou caminhão grande com " + lixoArmazenado + "kg.");
        lixoArmazenado = 0;  // Após descarregar, o lixo na estação é zerado
    }
}
