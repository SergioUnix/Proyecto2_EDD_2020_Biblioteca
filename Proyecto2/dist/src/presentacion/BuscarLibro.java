/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Objetos.Libro;
import estructuras.ArbolB;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class BuscarLibro extends javax.swing.JFrame {
   private int x;
   private int y; 
   
   String categoria_encontrada="";
   
    /**
     * Creates new form NavegacionCategoria
     */
    public BuscarLibro() {
     initComponents();     this.setLocationRelativeTo(null); //centrar el jframe
        
        ImageIcon imagensa = new ImageIcon( "src/Imagenes/salir.png");
        Icon iconosa = new ImageIcon(imagensa.getImage().getScaledInstance(lblsalir.getWidth(),lblsalir.getHeight(),Image.SCALE_DEFAULT));
        lblsalir.setIcon(iconosa);
        this.repaint();
   
 
       
          
        
        
        
        
        
        
     // Accion a realizar cuando el JComboBox cambia de item seleccionado.
		texto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                                Area1.setText("");
                                jLabel4.setText("");
				
                                obtengoLibros(texto.getText());
                                texto2.setText("");
                                
		}});   
                
                
                
                     // Accion a realizar cuando el JComboBox cambia de item seleccionado.
		texto2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Area1.setText("");
                               jLabel4.setText("");
                             
                               obtengoLibrosISBN(Integer.parseInt(texto2.getText()));
                                texto.setText("");
                                
		}}); 
                
        
  }
    
    
    public void obtengoLibros(String lib){            
     
     /////////////////todas las categorias aca en datos
     ArrayList<String> datos=new ArrayList<>();
     datos=presentacion.Login.logueado.getAVL().getDatos();
     
      ArbolB aux=new ArbolB(2);
          
     ArrayList <Libro> libros=new ArrayList<>();
     
     boolean encontrado=false;
     
         
     if (datos.size()>0){
            for (int i=0; i <= datos.size()-1;i++){
            aux =presentacion.Login.logueado.getAVL().buscar(datos.get(i)).getArbolB();
                libros=aux.getLibros();
                for(int j=0;j<libros.size();j++){
                    if(libros.get(j).getTitulo().equals(lib)){                   
                    Area1.setText("ISBN: "+libros.get(j).getISBN()+"\nAño: "+libros.get(j).getAnio()+"\nIdioma: "+libros.get(j).getIdioma()+"\nTitulo: "+libros.get(j).getTitulo()+"\nEditorial: "+libros.get(j).getEditorial()+"\nAutor: "+libros.get(j).getAutor()+"\nEdicion: "+libros.get(j).getEdicion()+"\nCategoria: "+libros.get(j).getCategoria()+"\nCarnet Propietario: "+libros.get(j).getPropietario()+"\n");
                    encontrado=true; this.categoria_encontrada=libros.get(j).getCategoria();
                    }               
                }
         
        }}else{
      
     }
     
     if(encontrado==false){
     JOptionPane.showMessageDialog(null, "No se encontro el libro");
     
     }else{ jLabel4.setText(lib);   }
     
     
    }
     
     
     public void obtengoLibrosISBN(int ISBN){            
     
     /////////////////todas las categorias aca en datos
     ArrayList<String> datos=new ArrayList<>();
     datos=presentacion.Login.logueado.getAVL().getDatos();
     
      ArbolB aux=new ArbolB(2);
          
     ArrayList <Libro> libros=new ArrayList<>();
     boolean encontrado=false;
         
     if (datos.size()>0){
            for (int i=0; i <= datos.size()-1;i++){
            aux =presentacion.Login.logueado.getAVL().buscar(datos.get(i)).getArbolB();
                libros=aux.getLibros();
                for(int j=0;j<libros.size();j++){
                    if(libros.get(j).getISBN()==ISBN){                   
                    Area1.setText("ISBN: "+libros.get(j).getISBN()+"\nAño: "+libros.get(j).getAnio()+"\nIdioma: "+libros.get(j).getIdioma()+"\nTitulo: "+libros.get(j).getTitulo()+"\nEditorial: "+libros.get(j).getEditorial()+"\nAutor: "+libros.get(j).getAutor()+"\nEdicion: "+libros.get(j).getEdicion()+"\nCategoria: "+libros.get(j).getCategoria()+"\nCarnet Propietario: "+libros.get(j).getPropietario()+"\n");
                    encontrado=true; this.categoria_encontrada=libros.get(j).getCategoria();
                    }               
                }
         
        }}else{
      
     }
     
     
          if(encontrado==false){
     JOptionPane.showMessageDialog(null, "No se encontro el libro");
     
     }else{jLabel4.setText(String.valueOf(ISBN));  }
     
    
    }
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblsalir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area1 = new javax.swing.JTextArea();
        texto = new javax.swing.JTextField();
        texto2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Libro Por Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 234, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar Libro Por ISBN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 234, 26));

        lblsalir.setText("jLabel3");
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        getContentPane().add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 89, 64));

        jLabel4.setBackground(new java.awt.Color(0, 0, 153));
        jLabel4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 380, 40));

        Area1.setBackground(new java.awt.Color(0, 0, 0));
        Area1.setColumns(20);
        Area1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        Area1.setForeground(new java.awt.Color(255, 255, 255));
        Area1.setRows(5);
        jScrollPane1.setViewportView(Area1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 320, 260));

        texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoKeyTyped(evt);
            }
        });
        getContentPane().add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 440, -1));

        texto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                texto2KeyTyped(evt);
            }
        });
        getContentPane().add(texto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 440, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Eliminar Libro Encontrado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 320, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Eras Medium ITC", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar y Eliminar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 370, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoCategoria.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 900, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked

          inicio principal=new inicio();
        principal.setVisible(true);
        
        this.dispose();        // TODO add your handling code here:
// TODO add your handling code here:
    }//GEN-LAST:event_lblsalirMouseClicked

    private void textoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoKeyTyped
       char c=evt.getKeyChar();
     if(Character.isDigit(c)){     ///////////////////  Solo se admiten Letras
     getToolkit().beep();
     evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten letras");
     
     }
        
        
     
    }//GEN-LAST:event_textoKeyTyped

    private void texto2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto2KeyTyped
         char c=evt.getKeyChar();
     if(Character.isLetter(c)){     ///////////////////  Solo se admiten Numeros
     getToolkit().beep(); evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten Numeros");
     
     }       
        
        
    }//GEN-LAST:event_texto2KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  if(!jLabel4.getText().equals("") && !texto2.getText().equals("")&& presentacion.Login.logueado.getAVL().buscar(categoria_encontrada).getArbolB().Espropietario(String.valueOf(presentacion.Login.logueado.getCarnet()))==true){
  
  presentacion.Login.logueado.getAVL().buscar(categoria_encontrada).getArbolB().eliminar(Integer.parseInt(texto2.getText()));
  JOptionPane.showMessageDialog(null, "Se elimino Correctamente"); Area1.setText("");
  }
  else if(!jLabel4.getText().equals("") && !texto.getText().equals("")&& presentacion.Login.logueado.getAVL().buscar(categoria_encontrada).getArbolB().Espropietario(String.valueOf(presentacion.Login.logueado.getCarnet()))==true){
  presentacion.Login.logueado.getAVL().buscar(categoria_encontrada).getArbolB().EliminarConNombre(jLabel4.getText());
  JOptionPane.showMessageDialog(null, "Se elimino Correctamente"); Area1.setText("");
  }
  else{
   JOptionPane.showMessageDialog(null, "No se Encontro libro para eliminar o No tiene permiso para eliminar");
  }      
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
                    Point point = MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
          x = evt.getX();
   y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JTextField texto;
    private javax.swing.JTextField texto2;
    // End of variables declaration//GEN-END:variables
}
