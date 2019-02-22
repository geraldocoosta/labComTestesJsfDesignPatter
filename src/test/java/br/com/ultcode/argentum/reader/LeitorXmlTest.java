package br.com.ultcode.argentum.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.ultcode.argentum.modelo.Negociacao;

class LeitorXmlTest {

    @Test
    public void carregaXMLComUmaNegociacaoApenas() {

        String xmlDeTeste = "<list>\n" + 
                            "  <negociacao>\n" +
                            "    <preco>40.5</preco>\n" +
                            "    <quantidade>100</quantidade>\n" + 
                            "    <data>\n" +
                            "      <time>1459479600000</time>\n" +
                            "      <timezone>America/Sao_Paulo</timezone>\n" +
                            "    </data>\n" + 
                            "  </negociacao>\n" + 
                            "</list>";

        Negociacao negociacaoEsperada = new Negociacao(40.5, 100,
                LocalDateTime.of(2016, 04, 01, 00, 00));

        LeitorXml leitor = new LeitorXml();

        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

        List<Negociacao> negociacoes = leitor.carrega(xml);

        assertEquals(1, negociacoes.size());
        assertEquals(negociacaoEsperada, negociacoes.get(0));
    }

}
