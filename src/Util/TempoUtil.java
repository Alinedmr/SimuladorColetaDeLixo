package Util;

public class TempoUtil {
    private int minutosTotais; // Total de minutos desde o início da simulação

    public TempoUtil() {
        this.minutosTotais = 0;
    }

    public void avancarMinutos(int minutos) {
        minutosTotais += minutos;
        // Se passou das 18h (600 minutos desde 8h), pula para o próximo dia às 08:00
        while (getMinutosDoDia() >= 600) {
            minutosTotais += (1440 - getMinutosDoDia()) + 480; // Pula para 08:00 do próximo dia
        }
    }

    public int getDia() {
        return minutosTotais / 1440 + 1;
    }

    public int getMinutosDoDia() {
        return minutosTotais % 1440;
    }

    public String getHoraFormatada() {
        int minutosDoDia = getMinutosDoDia();
        int hora = 8 + (minutosDoDia / 60);
        int minuto = minutosDoDia % 60;
        return String.format("Dia %d - %02d:%02d", getDia(), hora, minuto);
    }
}
