package br.com.ultcode.argentum.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    @Test
    void testandoSeEMesmoDiaComHorariosIguais() {
	LocalDateTime agora = LocalDateTime.now();
	LocalDateTime agoraEsperado = agora;

	assertTrue(new Negociacao(20.0, 13, agora).isMesmoDia(agoraEsperado));
    }

    @Test
    void testandoSeEMesmoDiaComHorariosDiferentes() {
	LocalDateTime agora = LocalDateTime.now();
	LocalDateTime esperado = agora.plusHours(1);

	assertTrue(new Negociacao(20.0, 13, agora).isMesmoDia(esperado));
    }

    @Test
    void testandoSeNaoEMesmoDiaComDiasDiferentes() {
	LocalDateTime agora = LocalDateTime.now();
	LocalDateTime esperado = agora.plusDays(1);

	assertFalse(new Negociacao(20.0, 13, agora).isMesmoDia(esperado));
    }

    @Test
    void testandoSeNaoEMesmoDiaComHorariosAnosDiferentes() {
	LocalDateTime agora = LocalDateTime.now();
	LocalDateTime agoraEsperado = agora.plusYears(1);

	assertFalse(new Negociacao(20.0, 13, agora).isMesmoDia(agoraEsperado));
    }

}
