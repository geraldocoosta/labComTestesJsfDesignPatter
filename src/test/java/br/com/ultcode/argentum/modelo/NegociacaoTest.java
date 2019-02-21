package br.com.ultcode.argentum.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class NegociacaoTest {

    @Test
    void testandoSePrecoDaNegociacaoNegativoLargaExcecao() {
	assertThrows(IllegalArgumentException.class, () -> new Negociacao(-20.0, 22, LocalDateTime.now()));
    }

    @Test
    void testandoSeQuantidadeDaNegociacaoNegativoLargaExcecao() {
	assertThrows(IllegalArgumentException.class, () -> new Negociacao(20.0, -22, LocalDateTime.now()));
    }
    
    @Test
    void testandoSeUmaDataNulaLargaExcecao() {
	assertThrows(IllegalArgumentException.class, () -> new Negociacao(20.0, 20, null));
    }
}
