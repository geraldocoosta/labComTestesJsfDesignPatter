package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class MediaMovelSimples {

    public double calcula(SerieTemporal serieTemporal, int posicao) {
	double soma = 0;

	for (int i = 3; i > 0; i--, posicao--) {
	    soma += serieTemporal.getCandle(posicao).getFechamento();
	}
	return soma / 3;
    }

}
