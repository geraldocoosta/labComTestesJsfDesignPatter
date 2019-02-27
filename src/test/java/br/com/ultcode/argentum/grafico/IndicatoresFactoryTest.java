package br.com.ultcode.argentum.grafico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.ultcode.argentum.indicadores.Indicador;

class IndicatoresFactoryTest {

    @Test
    void testandoSeClassesRetornamInstanciasCorretamenteComMediaPonderada() {
	Class<? extends Indicador> clazzIndicador = retornaAClasse("MediaMovelPonderada", "Abertura");
	assertEquals("br.com.ultcode.argentum.indicadores.MediaMovelPonderada", clazzIndicador.getName());
    }

    @Test
    void testandoSeClassesRetornamInstanciasCorretamenteComMediaSimples() {
	Class<? extends Indicador> clazzIndicador = retornaAClasse("MediaMovelSimples", "Abertura");
	assertEquals("br.com.ultcode.argentum.indicadores.MediaMovelSimples", clazzIndicador.getName());
    }

    @Test
    void testandoSeClassesRetornamInstanciasCorretamenteComIndicadorFechamento() {
	Class<? extends Indicador> clazzIndicador = retornaAClasse(null, "Fechamento");
	assertEquals("br.com.ultcode.argentum.indicadores.Fechamento", clazzIndicador.getName());
    }

    @Test
    void testandoSeClassesRetornamInstanciasCorretamenteComIndicadorAbertura() {
	Class<? extends Indicador> clazzIndicador = retornaAClasse(null, "Abertura");
	assertEquals("br.com.ultcode.argentum.indicadores.Abertura", clazzIndicador.getName());
    }

    private Class<? extends Indicador> retornaAClasse(String mediaMovel, String Indicador) {
	IndicatoresFactory indicatoresFactory = new IndicatoresFactory(mediaMovel, Indicador);
	Indicador instanciaIndicador = indicatoresFactory.instanciaIndicador();
	Class<? extends Indicador> clazzIndicador = instanciaIndicador.getClass();
	return clazzIndicador;
    }

}
