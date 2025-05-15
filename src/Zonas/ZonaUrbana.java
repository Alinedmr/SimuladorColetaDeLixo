package Zonas;

import java.util.Random;

public class ZonaUrbana {
    private String nome;
    private int lixoAcumulado;  // Lixo acumulado na zona

    public ZonaUrbana(String nome) {
        this.nome = nome;
        this.lixoAcumulado = 0;
    }

    // Método para gerar lixo aleatório
    public void gerarLixo() {
        int quantidade = new Random().nextInt(500) + 100;  // Gera entre 100kg e 600kg de lixo
        lixoAcumulado += quantidade;
        System.out.println(nome + ": Gerou " + quantidade + "kg de lixo. Total: " + lixoAcumulado + "kg.");
    }

    // Método para o caminhão pequeno coletar o lixo
    public int coletarLixo(int quantidade) {
        int coletado = Math.min(quantidade, lixoAcumulado);
        lixoAcumulado -= coletado;
        return coletado;
    }

    public int getLixoAcumulado() {
        return lixoAcumulado;
    }

    public String getNome() {
        return nome;
    }
}
