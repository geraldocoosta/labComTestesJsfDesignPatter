package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements MediaMovel {

    private Indicador indicador;

    public MediaMovelPonderada() {
	indicador = new Fechamento();
    }

    public MediaMovelPonderada(Indicador indicador) {
	this.indicador = indicador;
    }

    @Override
    public double calcula(SerieTemporal serieTemporal, int posicao) {
	int peso = 3;
	double soma = 0;

	for (int i = 3; i > 0; i--, peso--, posicao--) {
	    soma += indicador.calcula(serieTemporal, posicao) * peso;
	}
	return soma / 6;
    }

    @Override
    public String nomeMedia() {
	return "Media movel ponderada - " + indicador.nomeMedia();
    }

}
