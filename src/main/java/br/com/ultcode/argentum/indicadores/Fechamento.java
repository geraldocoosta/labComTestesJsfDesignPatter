package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public class Fechamento implements Indicador {

    @Override
    public double calcula(SerieTemporal serieTemporal, int posicao) {
	return serieTemporal.getCandle(posicao).getFechamento();
    }

    @Override
    public String nomeMedia() {
	return "Fechamento";
    }

}
