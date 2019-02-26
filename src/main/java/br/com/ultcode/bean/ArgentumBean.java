package br.com.ultcode.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.ultcode.argentum.grafico.GeradorDeModeloGrafico;
import br.com.ultcode.argentum.modelo.Candlestick;
import br.com.ultcode.argentum.modelo.CandlestickFactory;
import br.com.ultcode.argentum.modelo.Negociacao;
import br.com.ultcode.argentum.modelo.SerieTemporal;
import br.com.ultcode.argentum.ws.ClientWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

    private static final long serialVersionUID = -7555060192228793349L;
    private List<Negociacao> negociacoes;
    private LineChartModel modeloGrafico;

    public ArgentumBean() {
	negociacoes = new ClientWebService().getNegociacoes();
	List<Candlestick> candles = new CandlestickFactory().constroiCandles(negociacoes);
	SerieTemporal serie = new SerieTemporal(candles);
	
	GeradorDeModeloGrafico geradorGrafico = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
	geradorGrafico.plotaMediaMovelSimples();
	modeloGrafico = geradorGrafico.getModeloGrafico();
    }

    public LineChartModel getModeloGrafico() {
	return modeloGrafico;
    }

    public List<Negociacao> getNegociacoes() {
	return negociacoes;
    }
}
