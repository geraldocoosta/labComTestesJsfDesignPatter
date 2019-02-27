package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class Abertura implements Indicador {

    @Override
    public double calcula(SerieTemporal serieTemporal, int posicao) {
	return serieTemporal.getCandle(posicao).getAbertura();
    }

    @Override
    public String nomeMedia() {
	return "Abertura";
    }

}
