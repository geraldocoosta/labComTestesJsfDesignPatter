package br.com.ultcode.argentum.indicadores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.ultcode.argentum.modelo.SerieTemporal;

class MediaMovelPonderadaTest {

    @Test
    void testandoSeRetornaAMediaPonderadaComValoresCorretos() {

	SerieTemporal serieTemporal = UtilGeraSeriesTemporais.retornaSerieTemporal(1, 2, 3, 4, 5, 6);

	MediaMovelPonderada mmp = new MediaMovelPonderada();
	assertEquals(14.0 / 6, mmp.calcula(serieTemporal, 2), 0.00001);
	assertEquals(20.0 / 6, mmp.calcula(serieTemporal, 3), 0.00001);
	assertEquals(26.0 / 6, mmp.calcula(serieTemporal, 4), 0.00001);
	assertEquals(32.0 / 6, mmp.calcula(serieTemporal, 5), 0.00001);
    }

}
