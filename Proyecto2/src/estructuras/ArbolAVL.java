/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import estructuras.NodoAVL;
import java.awt.Desktop;
import java.awt.RenderingHints;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;


/**
 *
 * @author Sergio Ariel Ramírez Castro
 */
public class ArbolAVL {

    private NodoAVL root;
    private String Graph;
    
    ArrayList<String> datos=new ArrayList<>();

    
    public ArbolAVL() {
        this.root = null;
        this.Graph = "";
    }

    int getHeight(NodoAVL nodo) { // Uso esta funcion solo para evitar el null pointer 
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getAltura();
        }
    }
    
    
    private LinkedList<ArbolB> AuxCategorias;
    
    
    
    ////////////////
   public ArrayList<String> getDatos(){
      datos= new ArrayList<>();
    obtengoDatos(this.root);
    return this.datos;
    }
   
   
  
    
  
    
      private void obtengoDatos(NodoAVL raiz_tmp) {
        if (raiz_tmp != null) {

           obtengoDatos(raiz_tmp.getIzq());
            this.datos.add(raiz_tmp.getKey());
            //System.out.print(raiz_tmp.getKey() + "  ");
            obtengoDatos(raiz_tmp.getDer());
        }
    } 
    
    
      ////////////////eliminar de la lista arraylist
   public void eliminoDatos(String Categoria){
       
   if (datos.size()>0){
        for (int i=0; i <= datos.size()-1;i++){
            if(datos.get(i).equals(Categoria)){
            datos.remove("Categoria");
            }       
         
        }}else{
      
     }
    
    }  
    
    
    
    
    public LinkedList<ArbolB> getArbolesB_innorder(){
    this.AuxCategorias= new LinkedList<ArbolB>(); 
    getArbolesB_innorder(this.root);
    return AuxCategorias;
    }
    
   public void getArbolesB_innorder(NodoAVL raiz_tmp){
         if (raiz_tmp != null) {

            getArbolesB_innorder(raiz_tmp.getIzq());
            if(raiz_tmp.getArbolB() != null){
                     this.AuxCategorias.add(raiz_tmp.getArbolB());
            }
            getArbolesB_innorder(raiz_tmp.getDer());
        }
    }

    public void imprimirArbolAVL_Innorder() {
        printAvl_innorder_recursivo(this.root);
    }

    private void printAvl_innorder_recursivo(NodoAVL raiz_tmp) {
        if (raiz_tmp != null) {

            printAvl_innorder_recursivo(raiz_tmp.getIzq());
            System.out.print(raiz_tmp.getKey() + "  ");
            printAvl_innorder_recursivo(raiz_tmp.getDer());
        }
    }

    int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /*
    
    ROTACIONES 
    
     */
    NodoAVL rotacionSimple_Derecha(NodoAVL nodo) {
      
        NodoAVL aux = nodo.getIzq();
        nodo.setIzq(aux.getDer());
        // rotacion
        nodo.setIzq(aux.getDer());
        aux.setDer(nodo);
        // actualiza las  alturas 
        nodo.setAltura(max(getHeight(nodo.getIzq()), getHeight(nodo.getDer())) + 1);
        aux.setAltura(max(getHeight(aux.getIzq()), getHeight(aux.getDer())) + 1);

        return aux;
    }

    NodoAVL rotacionSimple_izquierda(NodoAVL nodoPadre) {
        NodoAVL y = nodoPadre.getDer();
        NodoAVL acarreo = y.getIzq();
        // enlaces
        y.setIzq(nodoPadre);
        nodoPadre.setDer(acarreo);
        // actualiza balances 

        nodoPadre.setAltura(max(getHeight(nodoPadre.getIzq()), getHeight(nodoPadre.getDer())) + 1);
        y.setAltura(max(getHeight(y.getIzq()), getHeight(y.getDer())) + 1);

        return y;
    }

    /*
    
    
     */
 /*
    
    FACTOR DE EQUILIBRIO 
    DER +
    IZQ -
    
     */
    int getBalance(NodoAVL raiz_temp) {
        if (raiz_temp == null) {
            return 0;
        } else {
            return getHeight(raiz_temp.getDer()) - getHeight(raiz_temp.getIzq());
        }
    }

    /*
    
                    INSERTANDO DATOS 
    
     */
    public void insertar_avl(String key) {
        key = key.toLowerCase();
        this.root = insert_recursive(this.root, key);
    }

    NodoAVL insert_recursive(NodoAVL nodo_temp, String key) {
        if (nodo_temp == null) {
            nodo_temp = (new NodoAVL(key));
        }

        if (nodo_temp.getKey().compareTo(key) < 0) {
            nodo_temp.setDer(insert_recursive(nodo_temp.getDer(), key));

        } else if (nodo_temp.getKey().compareTo(key) > 0) {
            nodo_temp.setIzq(insert_recursive(nodo_temp.getIzq(), key));
        } else { // IGUAL 
            // YA EXISTE ENTONCES NO SE AGREGA     
            return nodo_temp;

        }
        /*
    
                    PASO EXTRA PARA UN AVL 
    
         */
        // SE ACTUALIZA LA ALTURA DE EL NODO ACTUAL 
        nodo_temp.setAltura(max(getHeight(nodo_temp.getDer()), getHeight(nodo_temp.getIzq())) + 1);
        int balance = getBalance(nodo_temp);

        // condicionales para balancear nodo por nodo 
        // DER
        if (balance < -1 && key.compareTo(nodo_temp.getIzq().getKey()) < 0) {

            return rotacionSimple_Derecha(nodo_temp);
        }

        // IZQ DER 
        if (balance < -1 && key.compareTo(nodo_temp.getIzq().getKey()) > 0) {

            nodo_temp.setIzq(rotacionSimple_izquierda(nodo_temp.getIzq()));
            return rotacionSimple_Derecha(nodo_temp);
        }

        // izq
        if (balance > 1 && key.compareTo(nodo_temp.getDer().getKey()) > 0) {

            return rotacionSimple_izquierda(nodo_temp);
        }

        // der izq  
        if (balance > 1 && key.compareTo(nodo_temp.getDer().getKey()) < 0) {
            nodo_temp.setDer(rotacionSimple_Derecha(nodo_temp.getDer()));
            return rotacionSimple_izquierda(nodo_temp);
        }

        return nodo_temp;
    }

    public String getGraphAVL() {
        this.Graph = ""; // LIMPIO LA VARIABLE
        this.Graph += "digraph ARBOL { rankdir=TB; style = filled;bgcolor = white;color = lemonchiffon;node[style = filled, color = red, shape = record];   \n ";
        getGraphAVL(this.root);
        this.Graph += getGraphRecorridos();
        this.Graph += "\n }";
        //lo guarda en la variable Graph
       return this.Graph;

    }

    public void getGraphAVL(NodoAVL R_actual) {// SOBRE CARGA DEL METODO , LO HAGO EN PREORDER
        this.Graph += "VAR" + R_actual.getKey() + "[label = \" <C0>|" + R_actual.getKey() + "|<C1>" + "\" ];   \n ";

        if (R_actual.getIzq() != null) {

            this.Graph += "VAR" + R_actual.getKey() + ":C0->" + "VAR" + R_actual.getIzq().getKey() + " [arrowhead = none color = black];   \n ";
            getGraphAVL(R_actual.getIzq());
        }

        if (R_actual.getDer() != null) {

            this.Graph += "VAR" + R_actual.getKey() + ":C1->" + "VAR" + R_actual.getDer().getKey() + " [arrowhead = none color = black];   \n ";
            getGraphAVL(R_actual.getDer());
        }
    }

       public void crearTxT(String cadena) {
        File f;
        FileWriter wr;
        try {
            f = new File("Arbol_AVL.txt");
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
        String archivoDot=getGraphAVL();
        this.crearTxT(archivoDot);
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "Arbol_AVL.png", "Arbol_AVL.txt");
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

        File miArchivo = new File("Arbol_AVL.png");
        try {
            Desktop.getDesktop().open(miArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO ENCUENTRA LA RUTA DE LA IMAGEN");
        }

    }

 

    NodoAVL getNodoMinimo(NodoAVL node) { // SIEMPRE POR LA IZQUIERDA
        NodoAVL recorredor = node;
        while (recorredor.getIzq() != null) {
            recorredor = recorredor.getIzq();
        }
        return recorredor; // RETORNA EL MAS A LA IZQUIERDA 

    }

    /*
    
    
                    ELIMINAR 
    
    
     */
    NodoAVL eliminarNodoAvl(NodoAVL raiz, String key) {

        if (raiz == null) {
            return raiz;  // BUSQUEDA IMPLICITA , SI EL NODO NO SE ENCUENTRA SIMPLEMENTE RETORNAMOS  , no pasa nada en la funcion 
        }

        if (raiz.getKey().compareTo(key) > 0) {
            raiz.setIzq(eliminarNodoAvl(raiz.getIzq(), key));

        } else if (raiz.getKey().compareTo(key) < 0) {
            raiz.setDer(eliminarNodoAvl(raiz.getDer(), key));
        } else {
            // QUE PASA SI EN REALIDAD ENCONTRAMOS EL NODO 
            if ((raiz.getIzq() == null) || (raiz.getDer() == null)) {
                // CASO DE QUE SOLO TIENE UN HIJO 
                NodoAVL temporal = null;
                if (temporal == raiz.getIzq()) {
                    temporal = raiz.getDer();
                } else {
                    temporal = raiz.getIzq();
                }

                // NO CHILD  , osea un hoja solo se hace null 
                if (temporal == null) {
                    temporal = raiz;
                    raiz = null;
                } else {
                    // asigna el  unico  hijo que tenia  
                    raiz = temporal;
                }
                // FIN DEL CASO DE UN HIJO 
            } else {

                NodoAVL temporal = getNodoMinimo(raiz.getDer());

                raiz.setKey(temporal.getKey()); // copia al succersor , solo le mueve la llave 
                raiz.setDer(eliminarNodoAvl(raiz.getDer(), temporal.getKey()));// como ya tengo un key arriba , lo del lado derecho siguie con el key temporal entonce slo madno a eliminar

            }

        }

        if (raiz == null) {
            return raiz; // si es null regreso normal 
        }
        // calculo altura 
        raiz.setAltura(max(getHeight(raiz.getIzq()), getHeight(raiz.getDer())) + 1);
        int balance = getBalance(raiz); // obtenemos el factor de equilibrio y luego a realizar rotaciones

        // ROTANDO A A LA DERECHA 
        if (balance < -1 && getBalance(raiz.getIzq()) <= 0) {
            return rotacionSimple_Derecha(raiz);
        }

        // ROTANDO A LA IZQUIERDA 
        if (balance > 1 && getBalance(raiz.getDer()) >= 0) {
            return rotacionSimple_izquierda(raiz);
        }

        // DOBLE  IZQ , DER 
        if (balance < -1 && getBalance(raiz.getIzq()) > 0) {
            System.out.println(" IZQ DER PROBADA ");
            raiz.setIzq(rotacionSimple_izquierda(raiz.getIzq()));
            return rotacionSimple_Derecha(raiz);
        }

        // DER IZQ
        if (balance > 1 && getBalance(raiz.getDer()) < 0) {
            System.out.println("DER IZQ");
            raiz.setDer(rotacionSimple_Derecha(raiz.getDer()));
            return rotacionSimple_izquierda(raiz);
        }

        return raiz;
    }

    public void eliminar_avl(String key) { // publico porque si saldra de la clase 
        key = key.toLowerCase();
        eliminoDatos(key);
        this.root = eliminarNodoAvl(this.root, key);
    }

    
    public boolean exist(String categoria) {
      boolean result=false;   
    categoria = categoria.toLowerCase();
    NodoAVL find = buscar_recursivo(this.root, categoria);
    if(find!=null){result=true;}
    return result;
    }
    
    
    public NodoAVL buscar(String categoria) {
   
        categoria = categoria.toLowerCase();
        NodoAVL find = buscar_recursivo(this.root, categoria);
        return find;
    }

    private NodoAVL buscar_recursivo(NodoAVL raiz, String clave) {
        if (raiz == null) {
            return null;
        } else if (raiz.getKey().equalsIgnoreCase(clave)) {
            return raiz;
        } else if (raiz.getKey().compareTo(clave) < 0) {
            return this.buscar_recursivo(raiz.getDer(), clave);
        } else {
            return this.buscar_recursivo(raiz.getIzq(), clave);
        }
    }
    

    
    
    
    
    /* PARA RECORRIDOS */
    private LinkedList<NodoAVL> pre;
    private LinkedList<NodoAVL> inno;
    private LinkedList<NodoAVL> post;

    public String getGraphRecorridos() {
        String g = "";
        pre = new LinkedList<>();
        inno = new LinkedList<>();
        post = new LinkedList<>();
        llenarListaPreOrder(this.root);
        llenarListaInnOrder(this.root);
        llenarListaPostOrder(this.root);

        g += "\nsubgraph cluster_0 { ";
        g += "  style = filled; charset = latin1; bgcolor = black; color = white; node[fillcolor =lemonchiffon , fontcolor = dark , color = darkolivegreen3 ,style = filled, shape = record];\n";
        g += "label = \"Recor Pre\" ;\n ";
        for (int i = 0; i < this.pre.size() - 1; i++) {
            NodoAVL nodo = this.pre.get(i);
            g += "pre" + i + "[label = \"" + nodo.getKey() + "\"];\n";
            g += "pre" + i + " -> " + "pre" + (i + 1) + "[arrowhead = \"vee\" , color = \"dark\"];\n";
        }
        g += "pre" +(this.pre.size() - 1)+ "[label = \"" + this.pre.get(this.pre.size() - 1).getKey() + "\"];\n";
        g += "}";

        g += "subgraph cluster_1 { ";
        g += " style = filled; charset = latin1; bgcolor = black; color = white; node[fillcolor =steelblue3 , fontcolor = dark , color = darkolivegreen3 ,style = filled, shape = record];\n";
        g += "label = \"Record IN\" ;\n ";
        
        for (int i = 0; i < this.inno.size() - 1; i++) {
            NodoAVL nodo = this.inno.get(i);
            g += "inno" + i + "[label = \"" + nodo.getKey() + "\"];\n";
            g += "inno" + i + " -> " + "inno" + (i + 1) + "[arrowhead = \"vee\" , color = \"dark\"];\n";
        }
        g += "inno" + (this.inno.size() - 1) + "[label = \"" + this.inno.get(this.inno.size() - 1).getKey() + "\"];\n";
        
        g += "}";
        
        
        g += "subgraph cluster_2 { ";
        g += "style = filled; charset = latin1; bgcolor = black; color = white; node[fillcolor =cadetblue1 , fontcolor = dark , color = darkolivegreen3 ,style = filled, shape = record];\n";
        g += "label = \"Recor Post\" ;\n ";
        
        for (int i = 0; i < this.post.size() - 1; i++) {
            NodoAVL nodo = this.post.get(i);
            g += "post" + i + "[label = \"" + nodo.getKey() + "\"];\n";
            g += "post" + i + " -> " + "post" + (i + 1) + "[arrowhead = \"vee\" , color = \"dark\"];\n";
        }
        g += "post" + (this.post.size()-1) + "[label = \"" + this.post.get(this.post.size() - 1).getKey() + "\"];\n";
        g += "}\n";
     
        return g;

    }

    private void llenarListaPreOrder(NodoAVL actual) {
        this.pre.add(actual);
        if (actual.getIzq() != null) {
            llenarListaPreOrder(actual.getIzq());
        }
        if (actual.getDer() != null) {
            llenarListaPreOrder(actual.getDer());
        }
    }

    private void llenarListaInnOrder(NodoAVL actual) {

        if (actual.getIzq() != null) {
            llenarListaInnOrder(actual.getIzq());
        }
        this.inno.add(actual);
        if (actual.getDer() != null) {
            llenarListaInnOrder(actual.getDer());
        }
    }

    private void llenarListaPostOrder(NodoAVL actual) {

        if (actual.getIzq() != null) {
            llenarListaPostOrder(actual.getIzq());
        }

        if (actual.getDer() != null) {
            llenarListaPostOrder(actual.getDer());
        }
        this.post.add(actual);
    }

}
