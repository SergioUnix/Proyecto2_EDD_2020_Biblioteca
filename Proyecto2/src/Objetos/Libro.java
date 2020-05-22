/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author ADMIN
 */
public class Libro {
    
    
    private int ISBN; 
    private String titulo; 
    private  String editorial; 
    private int anio; 
    private int edicion; 
    private String idioma ; 
    private int carnet_creador;
    
    private String categoria ; 
    private String autor;
    
    private String propietario;
    
    public Libro(){
    this.ISBN = 0 ; 
    }

    public Libro(int ISBN, String titulo, String editorial, int anio, int edicion, String idioma, int carnet_creador,String catego, String auto, String propi) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editorial = editorial;
        this.anio = anio;
        this.edicion = edicion;
        this.idioma = idioma;
        this.carnet_creador = carnet_creador;
        this.categoria=catego;
        this.autor=auto;
        this.propietario=propi;
    }
    
    public String getPropietario() {
        return this.propietario;
    }
  public void setPropietario(String propi){
  this.propietario=propi;
  }       
  public String getAutor() {
        return this.autor;
    }
  public void setAutor(String auto){
  this.autor=auto;
  }
  
  public String getCategoria() {
        return this.categoria;
    }
  public void setCategoria(String catego){
  this.categoria=catego;
  }
  
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCarnet_creador() {
        return carnet_creador;
    }

    public void setCarnet_creador(int carnet_creador) {
        this.carnet_creador = carnet_creador;
    }
    
    
    
}