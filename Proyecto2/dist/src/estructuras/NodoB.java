/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author ADMIN
 */
public class NodoB {
    
    public int []valores;
    public NodoB []nodo;
    public static int numValores;
    public boolean tengoHijos = false;
    public int ocupados = 0;
    public NodoB padre;
    public static int count;
    public NodoB(){
        count++;
       nodo = new NodoB [ArbolB.grado * 2 + 3];
       valores = new int [ArbolB.grado * 2 + 1];
    }
}
