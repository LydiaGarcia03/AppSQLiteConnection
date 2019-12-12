package br.edu.ifsc.lydiagarcia.bd_notas.Model;

public class Notas {

    int id;
    String titulo;
    String texto;

    public Notas(int id, String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }
}
