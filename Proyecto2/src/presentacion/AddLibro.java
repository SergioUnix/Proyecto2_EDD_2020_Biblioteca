/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Objetos.Libro;
import Objetos.Usuario;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class AddLibro extends javax.swing.JFrame {

    
   private int x;
   private int y; 
    /**
     * Creates new form AddLibro
     */
    public AddLibro() {
        initComponents();  this.setLocationRelativeTo(null); //centrar el jframe
        ImageIcon imagensa = new ImageIcon( "src/Imagenes/salir.png");
        Icon iconosa = new ImageIcon(imagensa.getImage().getScaledInstance(lblsalir.getWidth(),lblsalir.getHeight(),Image.SCALE_DEFAULT));
        lblsalir.setIcon(iconosa);
        this.repaint();
        
        
        
     combo1.removeAllItems();
     DefaultComboBoxModel modelo = new DefaultComboBoxModel ();
     ArrayList<String> datos=new ArrayList<>();
     datos=presentacion.Login.logueado.getAVL().getDatos();
         
     if (datos.size()>0){
            for (int i=0; i <= datos.size()-1;i++){
            modelo.addElement(datos.get(i));
         
        }}else{
      
     }
    
        combo1.setModel(modelo);
          
        
        
        
        
        
        
        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idioma = new javax.swing.JTextField();
        isbn = new javax.swing.JTextField();
        ano = new javax.swing.JTextField();
        editorial = new javax.swing.JTextField();
        titulo = new javax.swing.JTextField();
        edicion = new javax.swing.JTextField();
        autor = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblsalir = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();

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
        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Libro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 304, 70));

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ISBN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Año");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Idioma");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Titulo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Autor");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 102));
        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Editorial");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 102));
        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Categoria");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 102));
        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Edicion");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        idioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idiomaActionPerformed(evt);
            }
        });
        idioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idiomaKeyTyped(evt);
            }
        });
        getContentPane().add(idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 289, -1));

        isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnActionPerformed(evt);
            }
        });
        isbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                isbnKeyTyped(evt);
            }
        });
        getContentPane().add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 289, -1));

        ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoActionPerformed(evt);
            }
        });
        ano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anoKeyTyped(evt);
            }
        });
        getContentPane().add(ano, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 289, -1));

        editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialActionPerformed(evt);
            }
        });
        getContentPane().add(editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 289, -1));

        titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloActionPerformed(evt);
            }
        });
        titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tituloKeyTyped(evt);
            }
        });
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 289, -1));

        edicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edicionKeyTyped(evt);
            }
        });
        getContentPane().add(edicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 289, -1));

        autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorActionPerformed(evt);
            }
        });
        autor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                autorKeyTyped(evt);
            }
        });
        getContentPane().add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 289, -1));

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 102));
        jToggleButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Agregar Libro");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, 84));

        lblsalir.setText("jLabel11");
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        getContentPane().add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 60, 50));

        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 290, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregarLibro.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 812, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idiomaActionPerformed

    private void isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnActionPerformed

    private void anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoActionPerformed

    private void editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editorialActionPerformed

    private void tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloActionPerformed

    private void autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       
        
      if(presentacion.Login.logueado.getAVL().exist(combo1.getSelectedItem().toString())==true){///// si encuentra la categoria ya solo inserto los libros
                
                   
             
                Libro lib=new Libro();                
                lib.setISBN(Integer.parseInt(isbn.getText()));
                lib.setAnio(Integer.parseInt(ano.getText()));
                lib.setIdioma(idioma.getText());
                lib.setTitulo(titulo.getText());
                lib.setEditorial(editorial.getText());
                lib.setAutor(autor.getText());
                lib.setEdicion(Integer.parseInt(edicion.getText()));
                lib.setCategoria(combo1.getSelectedItem().toString());
                lib.setPropietario(String.valueOf(presentacion.Login.logueado.getCarnet()));
                
                presentacion.Login.logueado.biblio.buscar(combo1.getSelectedItem().toString()).getArbolB().insertar(Integer.parseInt(isbn.getText()), lib);
                Limpiar();
                JOptionPane.showMessageDialog(null, "Se agrego exitosamente el libro");
              
                }else{JOptionPane.showMessageDialog(null, "Primero debe crear la categoria nueva para ingresar");
                
                
               }   
        
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void Limpiar(){
    isbn.setText("");
    ano.setText("");
    idioma.setText("");
    titulo.setText("");
    editorial.setText("");
    autor.setText("");
    edicion.setText("");
    
    
    
    }
   
    
    
    
    private void isbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnKeyTyped
         char c=evt.getKeyChar();
     if(Character.isLetter(c)){     ///////////////////  Solo se admiten Numeros
     getToolkit().beep(); evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten Numeros");
     
     }
        
        
    }//GEN-LAST:event_isbnKeyTyped

    private void idiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idiomaKeyTyped
     char c=evt.getKeyChar();
     if(Character.isDigit(c)){     ///////////////////  Solo se admiten Letras
     getToolkit().beep();
     evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten letras");
     
     }
    }//GEN-LAST:event_idiomaKeyTyped

    private void anoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anoKeyTyped
              char c=evt.getKeyChar();
     if(Character.isLetter(c)){     ///////////////////  Solo se admiten Numeros
     getToolkit().beep(); evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten Numeros");
     }
    }//GEN-LAST:event_anoKeyTyped

    private void edicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edicionKeyTyped
             char c=evt.getKeyChar();
     if(Character.isLetter(c)){     ///////////////////  Solo se admiten Numeros
     getToolkit().beep(); evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten Numeros");
     
     }
    }//GEN-LAST:event_edicionKeyTyped

    private void tituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloKeyTyped
          char c=evt.getKeyChar();
     if(Character.isDigit(c)){     ///////////////////  Solo se admiten Letras
     getToolkit().beep();
     evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten letras");
     
     }
    }//GEN-LAST:event_tituloKeyTyped

    private void autorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorKeyTyped
            char c=evt.getKeyChar();
     if(Character.isDigit(c)){     ///////////////////  Solo se admiten Letras
     getToolkit().beep();
     evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten letras");
     
     }
    }//GEN-LAST:event_autorKeyTyped

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
               
   x = evt.getX();
   y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
                     Point point = MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked
        OperSLibros Oper=new OperSLibros();
        Oper.setVisible(true);
        
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_lblsalirMouseClicked

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
            java.util.logging.Logger.getLogger(AddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano;
    private javax.swing.JTextField autor;
    private javax.swing.JComboBox combo1;
    private javax.swing.JTextField edicion;
    private javax.swing.JTextField editorial;
    private javax.swing.JTextField idioma;
    private javax.swing.JTextField isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
