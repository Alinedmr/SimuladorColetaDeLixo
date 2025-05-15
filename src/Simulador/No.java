package Simulador;

public class No {
    private Evento evento;
    private No proximo;

    // Construtor
    public No(Evento evento) {
        this.evento = evento;
        this.proximo = null;
    }

    // Getters e Setters
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}

