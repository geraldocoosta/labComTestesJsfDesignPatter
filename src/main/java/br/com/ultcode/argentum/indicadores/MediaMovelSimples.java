package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements MediaMovel {

    private Indicador indicador;

    public MediaMovelSimples() {
	indicador = new Fechamento();
    }

    public MediaMovelSimples(Indicador indicador) {
	this.indicador = indicador;
    }

    public double calcula(SerieTemporal serieTemporal, int posicao) {
	double soma = 0;

	for (int i = 3; i > 0; i--, posicao--) {
	    soma += indicador.calcula(serieTemporal, posicao);
	}
	return soma / 3;
    }

    @Override
    public String nomeMedia() {
	return "Media Movel Simples - " + indicador.nomeMedia();
    }

}
