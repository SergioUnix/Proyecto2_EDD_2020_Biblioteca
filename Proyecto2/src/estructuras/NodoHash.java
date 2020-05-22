/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import Objetos.Usuario;

/**
 *
 * @author ADMIN
 */


public class NodoHash {
    private int posicion; 
    private NodoHash sig; 
    private Usuario usuario; 
    private int id_grap;
    
    public NodoHash(int posicion,Usuario usuario){
        this.id_grap = VarP.ID_HASH;
        VarP.ID_HASH++;// ESTATICO 
        this.posicion = posicion; 
        this.usuario = usuario; 
        this.sig = null;

    }

    public int getPosicion() {
        return posicion;
    }
    public int getId(){
    return id_grap; 
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public NodoHash getSig() {
        return sig;
    }
    public void setSig(NodoHash sig) {
        this.sig = sig;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
