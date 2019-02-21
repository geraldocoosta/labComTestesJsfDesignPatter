package br.com.ultcode.argentum.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CandlestickFactoryTest {

    @Test
    void testandoCandleStickFactorySeOrganizaAsDatas() {
	Negociacao neg1 = new Negociacao(20.0, 15, LocalDateTime.of(2019, 02, 23, 6, 0));
	Negociacao neg2 = new Negociacao(50.0, 22, LocalDateTime.of(2019, 02, 23, 14, 0));
	Negociacao neg3 = new Negociacao(15.0, 36, LocalDateTime.of(2019, 02, 23, 8, 0));

	Candlestick candle = new CandlestickFactory().constroiCandleParaData(Arrays.asList(neg1, neg2, neg3),
		LocalDateTime.now());

	assertEquals(20.0, candle.getAbertura(), 0.0001);
	assertEquals(50.0, candle.getFechamento(), 0.0001);
	assertEquals(50.0, candle.getMaximo(), 0.0001);
	assertEquals(15.0, candle.getMinimo(), 0.0001);
	assertEquals(1940.0, candle.getVolume(), 0.0001);
    }

    @Test
    void testandoCandlestickFactoryComUmaNegociacao() {
	Negociacao neg1 = new Negociacao(20.0, 15, LocalDateTime.now());

	Candlestick candle = new CandlestickFactory().constroiCandleParaData(Arrays.asList(neg1), LocalDateTime.now());

	assertEquals(20.0, candle.getAbertura(), 0.0001);
	assertEquals(20.0, candle.getFechamento(), 0.0001);
	assertEquals(20.0, candle.getMaximo(), 0.0001);
	assertEquals(20.0, candle.getMinimo(), 0.0001);
	assertEquals(300.0, candle.getVolume(), 0.0001);
    }

    @Test
    void testandoCandlestickFactoryComNenhumaNegociacao() {

	Candlestick candle = new CandlestickFactory().constroiCandleParaData(Arrays.asList(), LocalDateTime.now());

	assertEquals(0.0, candle.getAbertura());
	assertEquals(0.0, candle.getFechamento());
	assertEquals(0.0, candle.getMaximo());
	assertEquals(0.0, candle.getMinimo());
	assertEquals(0.0, candle.getVolume());
    }

}
