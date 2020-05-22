/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import estructuras.ArbolAVL;

/**
 *
 * @author ADMIN
 */
public class Usuario {
    
   
    private int Carnet;
    private String Nombre;
    private String Apellido;
    private String Carrera;
    private String Password;
    public ArbolAVL biblio;
    
    public Usuario(){
    this.Carnet=0; 
    this.biblio=new ArbolAVL();
    }

    public Usuario(int car, String Nom, String Ape, String Carre, String pas) {
        this.Carnet=car;
        this.Nombre=Nom;
        this.Apellido=Ape;
        this.Carrera=Carre;
        this.Password=pas;
        
    }

    
    
    
    
public ArbolAVL getAVL(){
return this.biblio;}    
    
    
    
    
    
public void setPassword(String a){
this.Password=a;}   
public String getPassword(){
return this.Password;}
    
public void setCarnet(int a){
this.Carnet=a;}
public int getCarnet(){
return this.Carnet;}

public void setNombre(String a){
    this.Nombre=a;
}
public String getNombre(){return this.Nombre;}

public void setApellido(String a){
this.Apellido=a;}
public String getApellido(){return this.Apellido;}

public void setCarrera(String a){this.Carrera=a;}
public String getCarrera(){return this.Carrera;}




  
}