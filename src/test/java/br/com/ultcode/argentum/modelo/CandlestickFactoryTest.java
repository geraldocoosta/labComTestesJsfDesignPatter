package br.com.ultcode.argentum.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() {

	LocalDateTime hoje = LocalDateTime.now();

	Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
	Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
	Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
	Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

	LocalDateTime amanha = hoje.plusDays(1);

	Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
	Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

	LocalDateTime depois = hoje.plusDays(2);

	Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
	Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

	List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5,
		negociacao6, negociacao7, negociacao8);

	CandlestickFactory fabrica = new CandlestickFactory();

	List<Candlestick> candles = fabrica.constroiCandles(negociacoes);

	assertEquals(negociacao7.getPreco(), candles.get(0).getAbertura(), 0.0001);
	assertEquals(negociacao8.getPreco(), candles.get(0).getFechamento(), 0.0001);

	assertEquals(negociacao5.getPreco(), candles.get(1).getAbertura(), 0.0001);
	assertEquals(negociacao6.getPreco(), candles.get(1).getFechamento(), 0.0001);

	assertEquals(negociacao1.getPreco(), candles.get(2).getAbertura(), 0.0001);
	assertEquals(negociacao4.getPreco(), candles.get(2).getFechamento(), 0.0001);
    }

}
