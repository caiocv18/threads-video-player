package br.ucb.playerdevideos.models;

public class Filme {
    private String nome;
    /*duração do filme em segundos*/
    private int duracaoDoFilme;

    public Filme(String nome, int duracaoDoFilme){
        setNome(nome);
        setDuracaoDoFilme(duracaoDoFilme);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoDoFilme() {
        return duracaoDoFilme;
    }

    public void setDuracaoDoFilme(int duracaoDoFilme) {
        this.duracaoDoFilme = duracaoDoFilme;
    }
}