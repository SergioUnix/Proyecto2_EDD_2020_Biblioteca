/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;


import Objetos.Libro;
import Objetos.Usuario;
import estructuras.ArbolAVL;

import estructuras.ListaB;

import estructuras.ArbolB;
import estructuras.THash;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import presentacion.Login;

/**
 *
 * @author Sergio Ariel Ramírez Castro
 */
public class Proyecto2 {
  static void doDot( String pInput, String pOutput ) {
        try {

            String dotPath =
                "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = pInput;
            String fileOutputPath = pOutput;

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        
        
        try {
            
            
            String[] cmd = new String[4];
            cmd[0] = "cmd";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = pOutput;
            
            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }        

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        
   
        Login loguear=new Login();
            
       loguear.setVisible(true);
        
        
        //Creamos un árbol cuyos nodos contendrán solamente texto
     //   ArbolAVL arbol_texto=new ArbolAVL();
        //Llenamos con información el árbol
     //   arbol_texto.insertar_avl("Juan");
    ///    arbol_texto.insertar_avl("Pedro");
    //    arbol_texto.insertar_avl("María");
    //    arbol_texto.insertar_avl("Roberto");
    //    arbol_texto.insertar_avl("Teodoro");
    //    arbol_texto.insertar_avl("Manuel");
    //    arbol_texto.insertar_avl("Diego");
    //    arbol_texto.insertar_avl("Alejandro");
    //    arbol_texto.insertar_avl("Margarita");
    //    arbol_texto.insertar_avl("Luis");
    //    arbol_texto.insertar_avl("Hernán");
     //   arbol_texto.insertar_avl("Jaime");
    //    arbol_texto.insertar_avl("Ana");
   //     arbol_texto.insertar_avl("Francisco");
    //    arbol_texto.insertar_avl("Andrea");
        
        
     // arbol_texto.GenerarGhrapviz();
           
        
        //Graficamos el árbol generando la imagen arbol_texto.jpg
        //System.out.println(arbol_texto.getGraphAVL()+"\n");
        //arbol_texto.getGraphAVL();
        
        
            
        //Lista datos;
        //boolean ya = false;
        //boolean existe = false;  
        ArbolB raizAux = new ArbolB(2);
        
        Libro OLibro = new Libro();
        OLibro.setISBN(10763);
        OLibro.setAnio(1891);
        OLibro.setIdioma("Español");
        OLibro.setTitulo("Curso de derecho constitucional");
        OLibro.setEditorial("3M España");
        OLibro.setAutor("ESCOBAR, DAVID");
        OLibro.setEdicion(2);
        OLibro.setCategoria("Consulta");
        raizAux.insertar(10763, OLibro);    
        
        
        
        
        Libro OLibr = new Libro();
        OLibr.setISBN(1415);
        OLibr.setAnio(1891);
        OLibr.setIdioma("Ingles");
        OLibr.setTitulo("Libro dos");
        OLibr.setEditorial("3M España");
        OLibr.setAutor("ESCOBAR, DAVID");
        OLibr.setEdicion(2);
        OLibr.setCategoria("Consulta");
        raizAux.insertar(1415, OLibr);
        
        
        
        Libro OLib = new Libro();
        OLib.setISBN(1718);
        OLib.setAnio(1891);
        OLib.setIdioma("Ingles");
        OLib.setTitulo("Libro tres");
        OLib.setEditorial("3M España");
        OLib.setAutor("ESCOBAR, DAVID");
        OLib.setEdicion(2);
        OLib.setCategoria("Consulta");
        raizAux.insertar(1718, OLib);
        
        
        
        Libro OLi = new Libro();
        OLi.setISBN(2122);
        OLi.setAnio(1891);
        OLi.setIdioma("Ingles");
        OLi.setTitulo("Libro cuatro");
        OLi.setEditorial("3M España");
        OLi.setAutor("ESCOBAR, DAVID");
        OLi.setEdicion(2);
        OLi.setCategoria("Consulta");
        raizAux.insertar(2122, OLi);
        

                
        Libro OL = new Libro();
        OL.setISBN(5512);
        OL.setAnio(1891);
        OL.setIdioma("Ingles");
        OL.setTitulo("Libro cinco");
        OL.setEditorial("3M España");
        OL.setAutor("ESCOBAR, DAVID");
        OL.setEdicion(2);
        OL.setCategoria("Consulta");
        raizAux.insertar(5512, OL);
                
       // System.out.println(raizAux.sizeElementos());
        
        
       // raizAux.eliminar(5512);
       // System.out.println("no elementos " +raizAux.sizeElementos());
        
        
       // raizAux.eliminar(2122);
        //System.out.println("no. elementos "+raizAux.sizeElementos());
        
        
        //System.out.println("\n grafica \n "+raizAux.getTxt());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //System.out.println(raizAux.getTxt());
        
        
        
        
        
        //////////////////////////////tabla Hash
        // THash prueba=new THash();
        
        //Usuario username=new Usuario();
       // username.setApellido("Ramirez");
       // username.setCarnet(201020252);
       // username.setCarrera("Inge Sistemas");
        //username.setNombre("Sergio");    
       // prueba.Insertar(username);
        

       // Usuario usernam=new Usuario();
       // usernam.setApellido("Lopez");
       // usernam.setCarnet(201614154);
        //usernam.setCarrera("Inge Electrica");
        //usernam.setNombre("Eduardo");    
        //prueba.Insertar(usernam);
        //        Usuario userna=new Usuario();
        //userna.setApellido("Mendez");
        //userna.setCarnet(201715256);
        //userna.setCarrera("Inge Sistemas");
        //userna.setNombre("Madelyn");    
        //prueba.Insertar(userna);
        //        Usuario usern=new Usuario();
        //usern.setApellido("Sagastume");
        //usern.setCarnet(201835142);
        //usern.setCarrera("Inge Civil");
        //usern.setNombre("Byron");    
       // prueba.Insertar(usern);
        
         //       Usuario user=new Usuario();
        //user.setApellido("Tejaxun");
        //user.setCarnet(201923145);
        //user.setCarrera("Inge Agronoma");
        //user.setNombre("Chejo");    
        //prueba.Insertar(user);
        
        //Usuario use=new Usuario();
        //use.setApellido("Ramirez");
        //use.setCarnet(202078457);
        //use.setCarrera("Inge Electronica");
        //use.setNombre("Genesis");    
       // prueba.Insertar(use);
        
        
        
        
               
       //System.out.println("\n");
        //System.out.println(prueba.generarTxt());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


    





/////////////////////////Es para lectura del data de un block Chain
  //  JSONParser parser = new JSONParser();
        
    //    try {
            
      //      Object obj = parser.parse(new FileReader("usuario.json"));
        //    JSONObject jsonObject = (JSONObject) obj;
         //   System.out.println("JSON LEIDO: " + jsonObject);
            
           
   //         JSONArray array = (JSONArray) jsonObject.get("DATA");
     //       System.out.println("");
            
     //       for(int i = 0 ; i < array.size() ; i++) {
       //         JSONObject jsonObject1 = (JSONObject) array.get(i);                                         
        
        //        JSONArray array2 = (JSONArray) jsonObject1.get("CREAR_USUARIO");
                         
                
                
        //         for(int j = 0 ; j < array2.size() ; j++) {
        //         JSONObject jsonObject2 = (JSONObject) array2.get(i);
                     
               // System.out.println("DATOS DEL USUARIO: " + i);
               // System.out.println("Carnet: " + Integer.parseInt((String) jsonObject2.get("Carnet")));
               // System.out.println("Nombre: " + jsonObject2.get("Nombre"));
               // System.out.println("Apellido: " + jsonObject2.get("Apellido"));
               // System.out.println("Carrera: " + jsonObject2.get("Carrera"));
               // System.out.println("Password: " + jsonObject2.get("Password"));
               // System.out.println("");
          //       }
                
              
          //  }
            
       /// } catch(FileNotFoundException e) { }
       // catch(IOException e) { }
       // catch(ParseException e) { }
        
  }






    
    
    }
