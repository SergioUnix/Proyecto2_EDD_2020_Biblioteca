/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;


import java.io.FileWriter;
import java.io.PrintWriter;


/**
 *
 * @author Sergio Ariel Ramírez Castro
 */
public class NodoAVL {
    private NodoAVL der; 
    private NodoAVL izq; 
    private String key; 
    private int altura; // balance Factor de equilibrio der - izq 
    private ArbolB arbolB; 
    
    
    // constructores 
    public NodoAVL(){
    }
    public NodoAVL(String dato){
        this.key = dato; 
        this.der = null ; 
        this.izq = null; 
        this.altura = 1; 
        arbolB = new ArbolB(2);
    }
    public NodoAVL(NodoAVL der , NodoAVL izq , String dato){
          this.der = der ; 
          this.izq = izq; 
          this.key = dato;
          this.altura = 1; 
            arbolB = new ArbolB(2);
    }
     public NodoAVL(String dato , int altura){
          this.der = null ; 
          this.izq = null; 
          this.key = dato;
          this.altura = altura;
          this.altura = 1; 
            arbolB = new ArbolB(2);
    }
     
    public ArbolB getArbolB(){
    return arbolB;
    }
    public void vaciarArbolB(){
    this.arbolB = new ArbolB(2);
    }
 
    public NodoAVL getDer() {
        return der;
    }

    public void setDer(NodoAVL der) {
        this.der = der;
    }

    public NodoAVL getIzq() {
        return izq;
    }

    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String dato) {
        this.key = dato;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
     
     
    
    
    
}
