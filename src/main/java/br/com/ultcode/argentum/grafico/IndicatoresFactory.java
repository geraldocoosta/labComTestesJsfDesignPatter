package br.com.ultcode.argentum.grafico;

import java.lang.reflect.InvocationTargetException;

import br.com.ultcode.argentum.indicadores.Indicador;
import br.com.ultcode.argentum.indicadores.MediaMovelSimples;

public class IndicatoresFactory {

    private String mediaMovel;
    private String indicador;
    private static final String PACOTE_INDICADORES = "br.com.ultcode.argentum.indicadores.";

    public IndicatoresFactory(String mediaMovel, String indicador) {
	this.mediaMovel = mediaMovel;
	this.indicador = indicador;
    }
    
    public IndicatoresFactory(String indicador) {
	this.indicador = indicador;
    }

    public Indicador instanciaIndicador() {
	if (indicador == null) {
	    return new MediaMovelSimples();
	}

	Class<?> clazzIndicadora;
	try {
	    clazzIndicadora = Class.forName(PACOTE_INDICADORES + indicador);
	    Indicador indicador = (Indicador) clazzIndicadora.getConstructor().newInstance();
	    if (mediaMovel != null && !mediaMovel.isEmpty()) {
		Class<?> clazzMedia = Class.forName(PACOTE_INDICADORES + mediaMovel);
		return (Indicador) clazzMedia.getConstructor(Indicador.class).newInstance(indicador);
	    }
	    return indicador;
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
		| InvocationTargetException | NoSuchMethodException | SecurityException e) {
	    throw new RuntimeException(e);
	}
    }

}
