package br.com.ultcode.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.ultcode.argentum.modelo.Candlestick;
import br.com.ultcode.argentum.modelo.CandlestickFactory;
import br.com.ultcode.argentum.modelo.Negociacao;
import br.com.ultcode.argentum.reader.LeitorXml;

public class ClientWebService {
    
    public static final String URL_WS = "https://argentumws-spring.herokuapp.com/negociacoes"; 

    public List<Negociacao> getNegociacoes() {

	HttpURLConnection connection = null;
	try {
	    URL url = new URL(URL_WS);
	    connection = (HttpURLConnection) url.openConnection();

	    InputStream content = connection.getInputStream();

	    return new LeitorXml().carrega(content);
	} catch (IOException e) {
	    throw new RuntimeException(e);
	} finally {
	    if (connection != null)
		connection.disconnect();
	}

    }

    public static void main(String[] args) {

	ClientWebService ws = new ClientWebService();

	List<Negociacao> negociacoes = ws.getNegociacoes();

	negociacoes.forEach(System.out::println);

	List<Candlestick> constroiCandles = new CandlestickFactory().constroiCandles(negociacoes);
	System.out.println();
	constroiCandles.forEach(System.out::println);
    }
}
