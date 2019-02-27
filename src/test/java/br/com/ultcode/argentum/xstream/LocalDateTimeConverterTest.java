package br.com.ultcode.argentum.xstream;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.ultcode.argentum.modelo.Negociacao;

class LocalDateTimeConverterTest {

    String xmlEsperado = "<negociacao>\n" + "  <preco>20.0</preco>\n" + "  <quantidade>15</quantidade>\n" + "  <data>\n"
	    + "    <time>1518660000000</time>\n" + "    <timezone>America/Sao_Paulo</timezone>\n" + "  </data>\n"
	    + "</negociacao>";

    @Test
    void converterObjetoNegociacaoEmXML() {
	Negociacao negociacao = new Negociacao(20, 15, LocalDateTime.of(2018, 02, 15, 00, 00));

	XStream xStream = new XStream(new DomDriver());
	xStream.alias("negociacao", Negociacao.class);
	xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());

	String xml = xStream.toXML(negociacao);

	assertEquals(xmlEsperado, xml);
    }

    @Test
    void deveGerarObjetoDeUmXml() {
	XStream stream = new XStream(new DomDriver());
	stream.alias("negociacao", Negociacao.class);
	stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());

	Negociacao fromXML = (Negociacao) stream.fromXML(xmlEsperado);

	Negociacao negociacao = new Negociacao(20.0, 15, LocalDateTime.of(2018, 02, 15, 00, 00));

	assertEquals(negociacao, fromXML);

    }

}
