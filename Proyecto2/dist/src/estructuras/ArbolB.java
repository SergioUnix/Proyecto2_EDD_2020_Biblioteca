/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;
import Objetos.Libro;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Sergio Ariel Ramirez Castro
 */

public class ArbolB
{
    
    
    public static int grado;
    public boolean esRaiz;
    public NodoB primerNodo;
    public int nivel = 1;
    public int imprimir = 1;
    public String cadena_nodos="";
    public String cadena_direccion="";
    public ListaB ListaB = new ListaB();
    
    public String arbol="";
    public String aux="";
    
    
    
        ////////////////aca estan los objetos
    ArrayList <Libro> libros=new ArrayList<>();
    
    
    
     //////obtengo los libros que existen en el arbol
    public ArrayList<Libro> getLibros(){    
    return this.libros;
    }
    
    //////Cuantos elementos hay ingresados en el arbol
    public int sizeElementos(){    
    return this.libros.size();
    }
    

    //////////// Obtengo el Objeto libro solo al ingresar ISBN
    public Libro obtener(int ISBN){
    Libro result=new Libro();     
        
      for(int i=0;i<=this.libros.size()-1;i++){
              if(ISBN == this.libros.get(i).getISBN()){
               result = this.libros.get(i);
             }
    
    }
      return result;
    }
    
     //////////// Obtengo el Objeto libro solo al ingresar el nombre
    public Libro obtenerCnombre(String libro){
    Libro result=new Libro();     
        
      for(int i=0;i<=this.libros.size()-1;i++){
              if(libro == this.libros.get(i).getTitulo()){
               result = this.libros.get(i);
             }
    
    }
      return result;
    }
    
    
    
    
    ////////////////Obtengo el Nombre
    
    public String obtenerNombre(int ISBN){
    String Nom="";     
        
      for(int i=0;i<=this.libros.size()-1;i++){
              if(ISBN == this.libros.get(i).getISBN()){
               Nom = this.libros.get(i).getTitulo();
             }
    
    }
      return Nom;
    }
    
    
    
    ////////////////Remuevo el objeto no del arbol B sino de libros
    
    public void removeLibroLista(int ISBN){
          
      for(int i=0;i<=this.libros.size()-1;i++){
              if(ISBN == this.libros.get(i).getISBN()){
            this.libros.remove(i);
             }
    
    }
      
    }
    
    
    
    
    
    
        ////////////////elimina del arbol B y de la lista de objetos atravez del nombre
    
    public void EliminarConNombre(String nombre){
    int index=-1;     
        
      for(int i=0;i<=this.libros.size()-1;i++){
              if(this.libros.get(i).getTitulo().equals(nombre)){
               index = this.libros.get(i).getISBN();
             }
    
    }           
      this.eliminar(index);
         
    }
    
    
    
    //////////////// Verifico si es dueno del libro atravez de su carnet
    
    public boolean Espropietario(String ESBN){
    boolean result=false;     
        
      for(int i=0;i<=this.libros.size()-1;i++){
              if(this.libros.get(i).getPropietario().equals(ESBN)){
               result=true;
             }
    
    }           
      return result;
         
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ArbolB(int grado)
    {
        this.grado = grado;
        primerNodo = new NodoB ();
        ListaB llevarIngresos = new ListaB();
        esRaiz = true;
    }
    
    
    public String getNod(){
        return this.cadena_nodos;    
    }
    
    
    public String getDir(){
        return this.cadena_direccion;    
    }
    
    
    
    
    
    
    public void insertar (int valor, Libro lib) {
       if(lib.getISBN()!=0){
        libros.add(lib);}
        
        
        if (primerNodo.tengoHijos==false) {
            int j = 0;
            for (int i = 0; i<primerNodo.valores.length; i++) {
                if (primerNodo.valores[i] == 0) {
                    primerNodo.valores[i] = valor;
                    ListaB.ingresados.add(valor);
                    j = i;
                    ordenar(primerNodo.valores,6);
                    break;
                }
            }
            if (j == 2*grado) {
                split(primerNodo);
            }
        } else {
            setTengoHijos(primerNodo);
            ingresarEnHijos(primerNodo, valor);
            
        }
    }
    
    
    
    
    
      public void ordenar(int arr[], int longitud){
       longitud = 0;
       for(int i = 0; i < arr.length; i++){
           if(arr[i] != 0){
               longitud++;
            }else{
            break;
            }
        }
             for(int ord = 0; ord < longitud; ord++){
            for(int ord1 = 0; ord1 < longitud - 1 ; ord1++){
             if(arr[ord1] > arr[ord1 + 1]){
                        int tmp = arr[ord1];
                        arr[ord1] = arr[ord1+1];
                        arr[ord1+1] = tmp;
                      
              }
           }
       }
    }
    public void setTengoHijos (NodoB nodo) {
        if (nodo == primerNodo) {
            if (primerNodo.nodo[0]!= null) {
                primerNodo.tengoHijos = true;
            } 
        }
        for (int i = 0; i<nodo.nodo.length; i++) {
            if (nodo.nodo[i] != null) {
                nodo.tengoHijos = true;
               // System.out.println("valor "+nodo.nodo[i].valores[0]+"\n");
                setTengoHijos(nodo.nodo[i]);
            }
        }
    }
    public void ingresarEnHijos(NodoB conHijos, int valor) {
        boolean entro = false;
        if(conHijos != null && !conHijos.tengoHijos){
            ubicarValorEnArreglo(conHijos, valor);
            entro = true;
        }
        for(int i = 0; conHijos != null && i < 2*grado + 1  && !entro; i++){
            if(valor < conHijos.valores[i] || conHijos.valores[i] == 0){
                entro = true;
                ingresarEnHijos(conHijos.nodo[i], valor);
                i = 2*grado;
            }
        } 
    }
    public void ubicarValorEnArreglo(NodoB nodoA, int valor){
        int cont = 0;
        while(cont <= 2*grado){
            if (nodoA.valores[cont]==0) { 
                nodoA.valores[cont]=valor;
                ordenar(nodoA.valores, 5);
                ListaB.ingresados.add(valor);
                if (cont == 2*grado) {
                    split(nodoA);
                }
                break;
            }
            cont++;
        }
    }
     public void ordenarNodos(NodoB aOrdenar){
       int i,j;
       i = 0;
       NodoB tmp;
       
       while(i < 2 * grado + 3 && aOrdenar.nodo[i] != null){
           j = 0;
           while(j < 2 * grado +2  && aOrdenar.nodo[j] != null && aOrdenar.nodo[j+1] != null){
               if(aOrdenar.nodo[j].valores[0] > aOrdenar.nodo[j+1].valores[0] ){
                   tmp = aOrdenar.nodo[j];
                   aOrdenar.nodo[j] = aOrdenar.nodo[j+1];
                   aOrdenar.nodo[j+1] = tmp;
                }
                j++;
            }
            i++;
        }   
    }
    public void split (NodoB nodo) {
       
        NodoB hijoIzq = new NodoB();
        NodoB hijoDer = new NodoB();
        
        //split general 
        if (nodo.nodo[0]!=null) { //si tiene hijos antes de hacer el split entonces
            for (int i = 0; i <grado+1; i++) { // los separa los hijos del nodo en hijoIzq e hijoDer
                hijoIzq.nodo[i] = nodo.nodo[i];
                hijoIzq.nodo[i].padre = hijoIzq;
                nodo.nodo[i] = null;
                hijoDer.nodo[i] = nodo.nodo[grado+1+i];
                hijoDer.nodo[i].padre = hijoDer;
                nodo.nodo[grado+1+i] = null;
            }
        }

        for (int i =0; i<grado; i++){ //guarda los valores en hijoIzq e hijoDer
            hijoIzq.valores[i] = nodo.valores[i];
            nodo.valores[i] = 0;
            hijoDer.valores[i] = nodo.valores[grado+1+i];
            nodo.valores[grado+1+i] = 0;
        }
        nodo.valores[0] = nodo.valores[grado];
        nodo.valores[grado] = 0; //queda en nodo solo el valor que "subio"
        
        nodo.nodo[0] = hijoIzq; //asigna a nodo el nuevo hijo izquierdo (hijoIzq)
        nodo.nodo[0].padre = nodo; // se hizo en primer ciclo
        nodo.nodo[1] = hijoDer; // asigna a nodo el nuevo hijo derecho (hijoDer)
        nodo.nodo[1].padre = nodo; // se hizo en el primer ciclo        
        setTengoHijos(primerNodo);
        ordenarNodos(nodo);
        

        if (nodo.padre!=null) { // luego del split y asignar los hijos (hijoIzq, hijoDer), subir el valor al padre
            boolean subido = false;
            for (int i = 0; i<nodo.padre.valores.length && subido==false; i++) {
                if (nodo.padre.valores[i] == 0) {
                    nodo.padre.valores[i] = nodo.valores[0];
                    subido = true;
                    nodo.valores[0] = 0;
                    ordenar(nodo.padre.valores, 5);
                }
            }
            int posHijos = 0;
            for (int i = 0; i<2*grado+3 ; i++) {
                if (nodo.padre.nodo[i]!=null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            nodo.padre.nodo[posHijos] = nodo.nodo[0];
            nodo.padre.nodo[posHijos+1] = nodo.nodo[1];
            nodo.padre.nodo[posHijos].padre = nodo.padre;
            nodo.padre.nodo[posHijos+1].padre = nodo.padre;
            int aqui = 0;
            for (int i =0; i<2*grado+3 && nodo.padre.nodo[i]!=null; i++) {
                if (nodo.padre.nodo[i].valores[0] == nodo.valores[0]) {
                    aqui = i;
                    break;
                }
            }
            NodoB papa = nodo.padre;
            nodo = null;
            int j = aqui;
            while (j<2*grado+2 && papa.nodo[j]!=null && papa.nodo[j+1]!=null) {
                papa.nodo[j] = papa.nodo[j+1];
                j++;
            }
            papa.nodo[j] = null;
            ordenar(papa.valores,5);
            ordenarNodos(papa);
            if (papa.valores[2*grado]!=0) {
                split(papa);
            }
        }
    }
       public void eliminar(int valor) { //elimina de la lista el valor y vuelve a crear el arbol
        boolean encontrado = false;
        int j = 0;
        for (int i=0; i<ListaB.ingresados.size() && !encontrado; i++) {
            if (ListaB.ingresados.get(i) == valor) {
                encontrado = true;
                j = i;
            }
        }
        
        if (encontrado==true) {//////////////////////////////////////////////////////////////////si es verdadero quita de la lista libro 
        this.removeLibroLista(valor);
        }
        
        
        if (encontrado==true) {
            ListaB.ingresados.remove(j);
        } else {
            System.out.println("El valor a eliminar no se encuentra en el arbol B");
        }
        ArrayList<Integer> auxiliar = ListaB.ingresados;
        ListaB.ingresados = new ArrayList<Integer>();
        primerNodo = new NodoB();
        primerNodo.tengoHijos = false;
        for(int k = 0; k < auxiliar.size(); k++){
            Integer y = auxiliar.get(k);
            int o = y.intValue();
            
            Libro vacio=new Libro(); 
            
            insertar(o,vacio);
        }
    }
    public boolean buscar(int valor){
        boolean esta = false;
        for(int i = 0; i < ListaB.ingresados.size() && !esta; i++){
            if(ListaB.ingresados.get(i) == valor){
                esta = true;
                System.out.println("El elemento buscado si se encuentra en el arbol B");
                return esta;
            }
        }
        System.out.println("El elemento buscado no se encuentra en el arbol B");
        return false;
    }
    
    
    
    

    
        
        
    public String recorrer(NodoB nodo) {
        arbol += "\n";
        for (int i =0; i<2*grado+1; i++) {
            if (nodo.nodo[i] != null) {
                if (i == 0) {
                    nivel++;
                    imprimir = 1;
                } else {                   
                    imprimir ++;
                }
                recorrer(nodo.nodo[i]);             ////////////////////////////////////
             }
            
            
         if (nodo.nodo[i] != null) {
            arbol += "[ ";
         }
            int hijo=0;  int padre=0;
            for (int j = 0; nodo.nodo[i]!=null && j<nodo.nodo[i].valores.length; j++) {
                
                
                if (nodo.nodo[i].valores[j] != 0) {
                    hijo= nodo.nodo[i].valores[0];  /////primer numero del hijo 
                    padre=nodo.nodo[i].padre.valores[0];//////////primer numero del nodo de padre
                    aux+=nodo.nodo[i].valores[j]+" "+this.obtenerNombre(nodo.nodo[i].valores[j])+"|";//////////este es para los nodos de ghrapviz     
                                          
                    arbol += nodo.nodo[i].valores[j] + "N"+nodo.nodo[i].padre.valores[0]+", ";
                                  
                }
            }
        
            if (nodo.nodo[i] != null) {
         
           this.cadena_nodos +="nodo"+hijo+"[ label =\""+aux+"\"]  \n";
           this.cadena_direccion += "nodo"+padre+"->"+"nodo"+hijo+"\n";
           
           aux="";
           
                
                
            arbol += " ]";
            }
            }
        
        if (arbol.length() > (2*grado+3)*4) {
             return arbol;
        }
        return arbol;
    }
    public String llamarRecorrer() {
        String mostrar = recorrer(primerNodo);
        nivel = 1;
        imprimir = 1;
        return arbol;
    }
    
    
    
    
    
    
    
    
public String getTxt() {
    this.arbol="";
    this.aux="";
this.cadena_nodos="";
this.cadena_direccion="";
this.llamarRecorrer(); 
String cadena="digraph arbolB{\n" +
"rankdir=TB;\n" +
"node [shape = record, style=filled, fontcolor = black fillcolor=darkorange1 color=dark];    \n";

int hijo=0;  int padre=0;
String aux="";


for(int i = 0; i < primerNodo.valores.length && primerNodo.valores[i] != 0; i++){
    hijo =primerNodo.valores[0];
    aux += primerNodo.valores[i] +" "+this.obtenerNombre(primerNodo.valores[i])+ "|";
 }

cadena +="nodo"+hijo+"[ label =\""+aux+"\"]  \n";


cadena+=this.cadena_nodos;
cadena+=this.cadena_direccion;
cadena+="}";
       
        return cadena;
    }
    
  ///////////////////////////////////esto es para los generar txt y .png


      public void crearTxT(String cadena) {
        File f;
        FileWriter wr;
        try {
            f = new File("Arbol_B.txt");
            wr = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(wr);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(cadena + "\n");
            salida.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " NO ESCRIBE ");
        }

    }
    
    
    
    
    public void GenerarGhrapviz() {
        String archivoDot=getTxt();
        this.crearTxT(archivoDot);
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "Arbol_B.png", "Arbol_B.txt");
            pbuilder.redirectErrorStream(true);
            pbuilder.start();
            JOptionPane.showMessageDialog(null, "Imagen Generada");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO GENERAR LA IMAGEN");
        }
   abreArchivo();
    }

    
     private void abreArchivo() {
        // SOLO ABRE MI ARCHIVO

        File miArchivo = new File("Arbol_B.png");
        try {
            Desktop.getDesktop().open(miArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO ENCUENTRA LA RUTA DE LA IMAGEN");
        }

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public boolean esNumero(String s){
        try{
           Integer.parseInt(s);
           return true;
        }catch(NumberFormatException e){
            return false;
        }
        }
        
}
