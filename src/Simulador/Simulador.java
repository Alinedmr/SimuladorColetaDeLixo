package Simulador;

import Caminhos.*;
import Estações.EstacaoPadrao;
import Zonas.ZonaUrbana;
import Util.TempoUtil;

public class Simulador {
    private CaminhaoPequeno[] caminhoesPequenos;
    private CaminhaoGrande[] caminhoesGrandes;
    private EstacaoPadrao estacao;
    private ZonaUrbana[] zonas;
    private TempoUtil tempo;
    private int diaAtual = 1;

    public Simulador() {
        caminhoesPequenos = new CaminhaoPequeno[] {
                new CaminhaoPequenoPadrao(2000, 3),
                new CaminhaoPequenoPadrao(4000,3),
                new CaminhaoPequenoPadrao(8000,3),
                new CaminhaoPequenoPadrao(10000,3)
        };

        caminhoesGrandes = new CaminhaoGrande[] {
                new CaminhaoGrandePadrao(),
                new CaminhaoGrandePadrao()
        };

        estacao = new EstacaoPadrao("Estação Central");

        zonas = new ZonaUrbana[] {
                new ZonaUrbana("Zona Sul"),
                new ZonaUrbana("Zona Norte"),
                new ZonaUrbana("Zona Centro"),
                new ZonaUrbana("Zona Leste"),
                new ZonaUrbana("Zona Sudeste")
        };

        tempo = new TempoUtil();
    }

    public void iniciar(int diasSimulacao) {
        System.out.println("Iniciando simulação...\n");

        while (tempo.getDia() <= diasSimulacao) {

            //resetar viagem se for um novo dia
            if (tempo.getDia() > diaAtual) {
                for (CaminhaoPequeno caminhao : caminhoesPequenos) {
                    caminhao.resetarViagens();
                }
                diaAtual = tempo.getDia();
            }

            System.out.println("========== " + tempo.getHoraFormatada() + " ==========");

            for (ZonaUrbana zona : zonas) {
                zona.gerarLixo();


                for (CaminhaoPequeno caminhao : caminhoesPequenos) {
                   if(caminhao.podeViajar()) {
                       int capacidadeDisponivel = caminhao.getCapacidade() - caminhao.getCargaAtual();
                       if (capacidadeDisponivel > 0) {
                           int coletado = zona.coletarLixo(capacidadeDisponivel);
                           caminhao.coletar(coletado);
                           caminhao.registrarViagem();
                           System.out.println("Caminhão pequeno (" + caminhao.getCapacidade() + "kg) coletou " + coletado + "kg em " + zona.getNome());
                       } else {
                           System.out.println("Caminhão pequeno (" + caminhao.getCapacidade() + "kg) já está cheio em " + zona.getNome());
                       }
                       tempo.avancarMinutos(15);
                   }
                }
            }

            // Caminhões descarregam na estação e são transferidos
            for (CaminhaoPequeno caminhao : caminhoesPequenos) {
                int carga = caminhao.getCargaAtual();
                if(carga > 0) {
                    estacao.receberCaminhaoPequeno(caminhao);
                    System.out.println("Caminhão pequeno descarregou " + carga + "kg na estação.");
                    caminhao.descarregar();
                }
                else{
                    System.out.println("Caminhão pequeno está vazio e não descarregou.");
                }
                tempo.avancarMinutos(15);
            }

            // Caminhões grandes recolhem da estação
            for (CaminhaoGrande caminhao : caminhoesGrandes) {
                int cargaAntes = caminhao.getCargaAtual();
                estacao.descarregarParaCaminhaoGrande(caminhao);
                int cargaDepois = caminhao.getCargaAtual();
                int carregado = cargaDepois - cargaAntes;

                System.out.println("Caminhão grande carregou " + carregado + "kg na estação.");
                tempo.avancarMinutos(30);
            }
        }

        System.out.println("\nSimulação finalizada após " + (diasSimulacao) + " dias.");
    }
}
