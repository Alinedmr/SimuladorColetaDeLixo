package Simulador;

public class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    // Adicionar um evento à fila (no final da fila)
    public void adicionar(Evento evento) {
        No novoNo = new No(evento);
        if (fim == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
    }

    // Remover e retornar o primeiro evento da fila (do início)
    public Evento remover() {
        if (inicio == null) {
            return null; // Fila vazia
        }
        Evento evento = inicio.getEvento();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        return evento;
    }

    // Verificar o evento no topo da fila (sem remover)
    public Evento topo() {
        return (inicio != null) ? inicio.getEvento() : null;
    }

    // Verificar se a fila está vazia
    public boolean vazia() {
        return inicio == null;
    }
}
