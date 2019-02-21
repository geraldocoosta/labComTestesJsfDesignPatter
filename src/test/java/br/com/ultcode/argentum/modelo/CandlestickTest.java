package br.com.ultcode.argentum.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CandlestickTest {

    @Test
    void testandoSeCandlestickAceitaValorMinimoMaiorQueOMaximo() {
	assertThrows(IllegalArgumentException.class, () -> new CandlestickBuilder().setAbertura(20).setFechamento(30)
		.setMaximo(10).setMinimo(88).setVolume(3500).setData(LocalDateTime.now()).builder());
    }

    @Test
    void testandoSeCandlestickComValoresDeAberturaEFechamentoIguaisRetornaAlta() {
	Candlestick candle = new CandlestickBuilder().setAbertura(20).setFechamento(20).setMaximo(50).setMinimo(40)
		.setVolume(3500).setData(LocalDateTime.now()).builder();

	assertTrue(candle.isAlta());
    }

}
