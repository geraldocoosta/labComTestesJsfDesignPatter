package br.com.ultcode.argentum.modelo;

import java.time.LocalDateTime;

public final class Negociacao {
	private final double preco;
	private final int quantidade;
	private final LocalDateTime time;

	public Negociacao(double preco, int quantidade, LocalDateTime time) {

		if (preco < 0 || quantidade < 0) {
			throw new IllegalArgumentException("O preco e a quantidade não podem ser menores que 0");
		}

		if (time == null) {
			throw new IllegalArgumentException("Deve haver uma data");
		}

		this.preco = preco;
		this.quantidade = quantidade;
		this.time = time;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public double getVolume() {
		return preco * quantidade;
	}

}
