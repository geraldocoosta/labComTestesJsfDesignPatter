package br.com.ultcode.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ultcode.argentum.modelo.Negociacao;
import br.com.ultcode.argentum.ws.ClientWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{

    private static final long serialVersionUID = -7555060192228793349L;
    private List<Negociacao> negociacoes;

    public ArgentumBean() {
	negociacoes = new ClientWebService().getNegociacoes();
    }

    public List<Negociacao> getNegociacoes() {
	return negociacoes;
    }
}
