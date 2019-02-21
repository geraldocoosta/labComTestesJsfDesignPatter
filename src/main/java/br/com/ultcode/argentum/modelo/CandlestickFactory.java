package br.com.ultcode.argentum.modelo;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CandlestickFactory {

    public Candlestick constroiCandleParaData(List<Negociacao> negociacoes, LocalDateTime data) {
	if(data == null) {
	    throw new IllegalArgumentException("Não é permitido data nula");
	}
	
	if (negociacoes == null || negociacoes.size() == 0) {
	    return new Candlestick(0, 0, 0, 0, 0, data);
	}

	List<Negociacao> negociacoesPorData = negociacoes.stream()
		.sorted(Comparator.comparing(Negociacao::getTime))
		.collect(Collectors.toList());

	double abertura = negociacoesPorData.get(0).getPreco();
	double fechamento = negociacoesPorData.get(negociacoesPorData.size() - 1).getPreco();

	double maximo = negociacoesPorData.get(0).getPreco();
	double minimo = negociacoesPorData.get(0).getPreco();
	double volume = 0;

	for (Negociacao n : negociacoes) {
	    double preco = n.getPreco();

	    if (preco > maximo)
		maximo = preco;
	    if (preco < minimo)
		minimo = preco;

	    volume += n.getVolume();
	}

	return new CandlestickBuilder().setMaximo(maximo).setMinimo(minimo).setAbertura(abertura)
		.setFechamento(fechamento).setVolume(volume).setData(data).builder();
    }
}
