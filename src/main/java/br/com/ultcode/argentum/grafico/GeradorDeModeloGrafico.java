package br.com.ultcode.argentum.grafico;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.ultcode.argentum.indicadores.Indicador;
import br.com.ultcode.argentum.modelo.SerieTemporal;

public class GeradorDeModeloGrafico {

    private final SerieTemporal serie;
    private final int comeco;
    private final int fim;
    private final LineChartModel modeloGrafico;

    public GeradorDeModeloGrafico(SerieTemporal serie, int comeco, int fim) {
	this.serie = serie;
	this.comeco = comeco;
	this.fim = fim;
	this.modeloGrafico = new LineChartModel();

	this.modeloGrafico.setTitle("Indicadores");
	this.modeloGrafico.setLegendPosition("w");
    }

    public void plotaMediaMovelSimples(String mediaMovel, String indicador) {
	LineChartSeries linha = new LineChartSeries();
	
	
	IndicatoresFactory factory = new IndicatoresFactory(mediaMovel,indicador);
	Indicador instanciaIndicador = factory.instanciaIndicador();
	
	linha.setLabel(instanciaIndicador.nomeMedia());
	
	double valor = 0;
	for (int i = comeco; i <= fim; i++) {

	    valor = instanciaIndicador.calcula(serie, i);
	    linha.set(i, valor);
	}
	
	this.modeloGrafico.addSeries(linha);
    }
    
    public LineChartModel getModeloGrafico() {
	return modeloGrafico;
    }
}
