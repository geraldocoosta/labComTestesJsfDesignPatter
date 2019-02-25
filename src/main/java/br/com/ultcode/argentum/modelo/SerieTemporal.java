package br.com.ultcode.argentum.modelo;

import java.util.List;

public class SerieTemporal {

    private final List<Candlestick> candles;
    
    public SerieTemporal(List<Candlestick> candles) {
	this.candles = candles;
    }
    
}
