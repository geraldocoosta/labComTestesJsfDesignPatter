package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class MediaMovelSimples extends MediaMovel {


    public double calcula(SerieTemporal serieTemporal, int posicao) {
	double soma = 0;

	for (int i = 3; i > 0; i--, posicao--) {
	    soma += getIndicador().calcula(serieTemporal, posicao);
	}
	return soma / 3;
    }

    @Override
    public String nomeMedia() {
	return "Media Movel Simples - " + getIndicador().nomeMedia();
    }

}
