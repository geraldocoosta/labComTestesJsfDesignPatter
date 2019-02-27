package br.com.ultcode.argentum.indicadores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.ultcode.argentum.modelo.Candlestick;
import br.com.ultcode.argentum.modelo.SerieTemporal;

public class UtilGeraSeriesTemporais {

    public static SerieTemporal retornaSerieTemporal(double... valores) {
	List<Candlestick> candles = new ArrayList<>();
	for (double valor : valores) {
	    candles.add(new Candlestick(valor, valor, valor, valor, 200, LocalDateTime.now()));
	}
	return new SerieTemporal(candles);
    }

}
