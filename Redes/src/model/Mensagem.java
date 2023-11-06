package model;

import java.io.Serializable;

public class Mensagem implements Serializable {

    private String nome;
    private long id;
    private long id_destinatario;
    private long id_remetente;
    private String texto;

    public Mensagem(String nome, String texto) {
        super();
        this.nome = nome;
        this.texto = texto;
    }

    public Mensagem(long id, long id_destinatario, long id_remetente, String texto) {
        this.id = id;
        this.id_destinatario = id_destinatario;
        this.id_remetente = id_remetente;
        this.texto = texto;
    }

    public Mensagem(long id, long id_remetente, String texto) {
        this.id_destinatario = 0;
        this.id = id;
        this.id_remetente = id_remetente;
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Mensagem [nome=" + nome + ", texto=" + texto + "]";
    }

}
