/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import Objetos.Usuario;
import estructuras.NodoHash;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class THash {

    int Size; 
    NodoHash[] tabla; 

    public THash() {
        tabla = new NodoHash[45]; //inicializado con el tamano de las intrucciones del proyecto
        Size = 45;
    }

     public void Insertar(Usuario nuevo) {
        if (exist(nuevo.getCarnet())) {
            System.out.println(" El Carnet ya Existe -- No se puede ingresar ");

        } else {

            int id_posicion = nuevo.getCarnet() % this.Size; 
            if (tabla[id_posicion] == null) {
               
                tabla[id_posicion] = new NodoHash(id_posicion, nuevo);
            } else {
                System.out.println("Existe una colision en la posicion : " + id_posicion);
                NodoHash nue = new NodoHash(id_posicion, nuevo);
                NodoHash referencia = getUltimoDeLa_fila(id_posicion);
                referencia.setSig(nue);
            }

        }
    }

    private NodoHash getUltimoDeLa_fila(int casilla) {
        for (int i = 0; i < this.tabla.length; i++) {
            if (this.tabla[i] != null && casilla == i) {
                NodoHash ultimo = null;
                NodoHash aux = this.tabla[i];
                while (aux != null) {
                    ultimo = aux;
                    aux = aux.getSig();
                }
                return ultimo;
            }
        }
        return null;
    }

    public boolean exist(int carnet) {
        for (int i = 0; i < this.tabla.length; i++) {
            if (this.tabla[i] != null) {
                NodoHash aux = this.tabla[i];
                while (aux != null) {
                    if (aux.getUsuario().getCarnet() == carnet) {
                        return true;
                    }
                    aux = aux.getSig();
                }

            }
        }

        return false;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////    
        public boolean login(int carnet, String pass) {
        boolean result=false;    
            
        for (int i = 0; i < this.tabla.length; i++) {
            if (this.tabla[i] != null) {
                NodoHash aux = this.tabla[i];
                while (aux != null) {
                    if (aux.getUsuario().getCarnet() == carnet && aux.getUsuario().getPassword().equals(pass)) {
                        result=true;
                    }
                       System.out.println("datos buscando : " + aux.getUsuario().getCarnet() + "  "+aux.getUsuario().getPassword()+"\n");
                    aux = aux.getSig();
                }

            }
        }

        return result;
    }
        
        
       //////////////////////////////////////////////////////////  Obtengo solo el usuario    
        public String obtener_usuario(int carnet) {
        String result="";    
            
        for (int i = 0; i < this.tabla.length; i++) {
            if (this.tabla[i] != null) {
                NodoHash aux = this.tabla[i];
                while (aux != null) {
                    if (aux.getUsuario().getCarnet() == carnet) {
                        result=aux.getUsuario().getNombre();
                    }
                    aux = aux.getSig();
                }

            }
        }

        return result;
    }    
        
        

    public void imprimir() {
        System.out.println("");
        System.out.println(" --------- Imprimo Table ------------");
        NodoHash[] tablaAux = tabla;

        for (int x = 0; x < Size; x++) {  

            if (tablaAux[x] != null) {
                NodoHash aux = tablaAux[x];
                while (aux != null) {
                    System.out.print(aux.getUsuario().getCarnet() + " ");
                    aux = aux.getSig();
                }
                System.out.println("");
                System.out.println("--------------");
            }

        }
    }

    public Usuario search(int carnet) {

        NodoHash[] tablaAux = tabla;
        for (int x = 0; x < Size; x++) { 

            if (tablaAux[x] != null) {
                NodoHash aux = tablaAux[x];
                while (aux != null) {
                    if (aux.getUsuario().getCarnet() == carnet) {
                        return aux.getUsuario();
                    }
                    aux = aux.getSig();
                }
                System.out.println("");
                System.out.println("--------------");
            }

        }
        System.out.println("No existe en la tabla ");
        return null;
    }

    public void eliminar(int carnet) {

        NodoHash[] tablaAux = tabla;
        for (int x = 0; x < Size; x++) {
          
            if (tablaAux[x] != null) {
                NodoHash aux = tablaAux[x];

                if (aux.getSig() == null && aux.getUsuario().getCarnet() == carnet) {
                    tabla[aux.getPosicion()] = null; // lo elimino directo 
                    System.out.println("caso 1: eliminando fila ");
                    return;
                }

                // SI LLEGO HASTA ACA ESPERARIA QUE LO QUE VOY A ELIMINAR YA SEA UNA POSICION  QUE CONTIENE COLISION
                
           
                    NodoHash ant = null;
                    int c = 0 ; 
                    while (aux != null && aux.getUsuario().getCarnet() != carnet) {
                        c++;
                        ant = aux;
                        aux = aux.getSig();
                    }
                    
                    if(aux != null){
                        
                        if(ant == null && aux.getUsuario().getCarnet() == carnet){
                            System.out.println("caso 2: eliminando si no tengo anterior");
                           this.tabla[x] = aux.getSig();
                           return;
                        }
                        
                        
                        if(aux.getUsuario().getCarnet() == carnet){
                            System.out.println("caso 3: eliminando entre nodos o ultimo ");
                            NodoHash ref_anterior = reference(ant.getUsuario().getCarnet());
                            ref_anterior.setSig(aux.getSig());
                            return;
                        }
                        
                    }
            }

        }
        System.out.println("no esta en la tabla ");
    }

    public String getTxt() {
        String auxCadena = "digraph Hash{\nfontcolor = white; fontsize = \"35\";\n";
        auxCadena += "style = filled; charset = latin1;\n";
        auxCadena += "bgcolor = white; color = lightgrey;\nnode[fillcolor =  black, fontcolor = white , color = darkorange1,style = filled, shape =rectangle];\n";
        String ranking = "";

        NodoHash[] tablaAux = tabla;
        for (int x = 0; x < Size; x++) { 

            if (tablaAux[x] != null) {

                ranking += "{rank = same; ";
                NodoHash aux = tablaAux[x];
                while (aux != null) {
                    String carnet = String.valueOf(aux.getId());
                    auxCadena += "node" + carnet  + "[label=\"" + aux.getUsuario().getNombre() + "\" " + " ];\n";
                    ranking += "node" + carnet  + " ";
                    aux = aux.getSig();
                }
                ranking += "}\n";
                auxCadena += ranking;
                ranking = "";
                System.out.println("");
                System.out.println("--------------");

            }

        }

      
        NodoHash[] tab = tabla; 
        for (int y = 0; y < Size; y++) { 

            if (tab[y] != null) {
                NodoHash auxiliar = tablaAux[y];

                for (int k = y + 1; k < Size; k++) {
                    if (tablaAux[k] != null) {
                        
                        String ID1 = String.valueOf(tab[y].getId());
                        String ID2 = String.valueOf(tab[k].getId());
                        auxCadena += "node" + ID1  + " -> " + "node" + ID2  + "[ arrowhead = \"empty\"  ];\n";
                        break;
                    }

                }

                while (auxiliar != null) {

                    if (auxiliar.getSig() != null) {
                        String id1 = String.valueOf(auxiliar.getId());
                        String id2 = String.valueOf(auxiliar.getSig().getId());
                        auxCadena += "node" + id1  + " -> " + "node" + id2  + "[ arrowhead = \"empty\"  ];\n";
                    }
                    auxiliar = auxiliar.getSig();
                }
            }

        }

        auxCadena += "\n}";
        
       
      
         return auxCadena;
    }
    
    //////////////////////////////////aca genero mi txt y .png
          public void crearTxT(String cadena) {
        File f;
        FileWriter wr;
        try {
            f = new File("Tabla_Hash.txt");
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
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "Tabla_Hash.png", "Tabla_Hash.txt");
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

        File miArchivo = new File("Tabla_Hash.png");
        try {
            Desktop.getDesktop().open(miArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO ENCUENTRA LA RUTA DE LA IMAGEN");
        }

    }

    
    
    
    
    
    
    
    
    
    

    public NodoHash reference(int carnet) {

        NodoHash[] tablaAux = tabla;
        for (int x = 0; x < Size; x++) { 

            if (tablaAux[x] != null) {
                NodoHash aux = tablaAux[x];
                while (aux != null) {
                    if (aux.getUsuario().getCarnet() == carnet) {
                        return aux;
                    }
                    aux = aux.getSig();
                }
                System.out.println("");
                System.out.println("--------------");
            }

        }
        System.out.println("No existe en la Tabla ");
        return null;
    }

    public boolean login(String carnet, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
