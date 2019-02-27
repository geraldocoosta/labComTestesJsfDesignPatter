package br.com.ultcode.argentum.indicadores;

import br.com.ultcode.argentum.modelo.SerieTemporal;

public interface Indicador {

    double calcula(SerieTemporal serieTemporal, int posicao);

    String nomeMedia();
}
