package br.com.ultcode.argentum.indicadores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.ultcode.argentum.modelo.SerieTemporal;

class MediaMovelSimplesTest {

    @Test
    void testandoSeRetornaAMediaPonderadaComValoresCorretos() {

	SerieTemporal serieTemporal = UtilGeraSeriesTemporais.retornaSerieTemporal(1, 2, 3, 4, 5, 6);

	MediaMovel mms = new MediaMovelSimples();
	assertEquals(6.0 / 3, mms.calcula(serieTemporal, 2), 0.00001);
	assertEquals(9.0 / 3, mms.calcula(serieTemporal, 3), 0.00001);
	assertEquals(12.0 / 3, mms.calcula(serieTemporal, 4), 0.00001);
	assertEquals(15.0 / 3, mms.calcula(serieTemporal, 5), 0.00001);
    }

}
