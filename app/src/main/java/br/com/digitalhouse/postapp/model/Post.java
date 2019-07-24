package br.com.digitalhouse.postapp.model;

public class Post {

    private String urlImagem;
    private String titulo;
    private String descricao;
    private String data;
    private String autor;

    public Post() {
    }

    public Post(String urlImagem, String titulo, String descricao, String data, String autor) {
        this.urlImagem = urlImagem;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.autor = autor;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
