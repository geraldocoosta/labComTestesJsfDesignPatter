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
    private final List<Negociacao> negociacoes;
    private LineChartModel modeloGrafico;
    private String mediaMovel;
    private String indicador;

    public ArgentumBean() {
	negociacoes = new ClientWebService().getNegociacoes();
	geraGrafico();
    }

    public void geraGrafico() {
	List<Candlestick> candles = new CandlestickFactory().constroiCandles(negociacoes);
	SerieTemporal serie = new SerieTemporal(candles);

	GeradorDeModeloGrafico geradorGrafico = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
	geradorGrafico.plotaMediaMovelSimples(mediaMovel,indicador);
	modeloGrafico = geradorGrafico.getModeloGrafico();
    }

    public LineChartModel getModeloGrafico() {
	return modeloGrafico;
    }

    public List<Negociacao> getNegociacoes() {
	return negociacoes;
    }

    public String getMediaMovel() {
	return mediaMovel;
    }

    public void setMediaMovel(String mediaMovel) {
	this.mediaMovel = mediaMovel;
    }

    public String getIndicador() {
	return indicador;
    }

    public void setIndicador(String indicador) {
	this.indicador = indicador;
    }

}
