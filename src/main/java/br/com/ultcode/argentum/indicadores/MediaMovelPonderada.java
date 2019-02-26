package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada {

    public double calcula(SerieTemporal serieTemporal, int posicao) {
	int peso = 3;
	double soma = 0;

	for (int i = 3; i > 0; i--, peso--, posicao--) {
	    soma += serieTemporal.getCandle(posicao).getFechamento() * peso;
	} 
	return soma / 6;
    }

}
