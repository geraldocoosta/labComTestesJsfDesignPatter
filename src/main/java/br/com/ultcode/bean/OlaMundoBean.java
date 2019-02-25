package br.com.ultcode.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

    private String mensagem = "Koé boy ta na humildade?";
    private String nome;

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getMensagem() {
	return mensagem;
    }

    public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
    }

    public void botaoClicado() {
	System.out.println("O nome digitado foi: " + nome);
    }

}
