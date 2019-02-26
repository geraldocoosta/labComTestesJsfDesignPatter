package br.com.ultcode.argentum.grafico;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.ultcode.argentum.indicadores.MediaMovelSimples;
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

    public void plotaMediaMovelSimples() {
	LineChartSeries linha = new LineChartSeries();
	linha.setLabel("Media Movel Simples - Fechamento");

	MediaMovelSimples indicador = new MediaMovelSimples();
	double valor = 0;
	for (int i = comeco; i <= fim; i++) {

	    valor = indicador.calcula(serie, i);
	    linha.set(i, valor);
	}
	
	this.modeloGrafico.addSeries(linha);
    }
    
    public LineChartModel getModeloGrafico() {
	return modeloGrafico;
    }
}
