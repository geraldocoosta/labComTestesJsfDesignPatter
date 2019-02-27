package br.com.ultcode.argentum.indicadores;

public abstract class MediaMovel implements Indicador {

    private final Indicador indicador;

    public Indicador getIndicador() {
        return indicador;
    }

    public MediaMovel() {
	indicador = new Fechamento();
    }

    public MediaMovel(Indicador indicador) {
	this.indicador = indicador;
    }


}