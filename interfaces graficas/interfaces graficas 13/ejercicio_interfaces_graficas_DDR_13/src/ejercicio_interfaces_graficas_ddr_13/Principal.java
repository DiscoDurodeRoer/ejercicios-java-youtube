package ejercicio_interfaces_graficas_ddr_13;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import ppt.Mano;
import ppt.PiedraPapelTijera;

public class Principal extends javax.swing.JFrame {
    
    private PiedraPapelTijera juego;
    private int pGanadasJ1, pGanadasJ2;
    
    public Principal() {
        initComponents();
        this.crearImagenes();
        this.crearGrupos();
        this.pGanadasJ1 = 0;
        this.pGanadasJ2 = 0;
        this.juego = new PiedraPapelTijera();
        
    }
    
    private void crearImagenes() {
        this.lblPiedraJ1.setIcon(new ImageIcon("./img/ppt_piedra.jpg"));
        this.lblPapelJ1.setIcon(new ImageIcon("./img/ppt_papel.jpg"));
        this.lblTijeraJ1.setIcon(new ImageIcon("./img/ppt_tijera.jpg"));
        
        this.lblPiedraJ2.setIcon(new ImageIcon("./img/ppt_piedra.jpg"));
        this.lblPapelJ2.setIcon(new ImageIcon("./img/ppt_papel.jpg"));
        this.lblTijeraJ2.setIcon(new ImageIcon("./img/ppt_tijera.jpg"));
        
    }
    
    private void crearGrupos() {
        this.buttonGroup1.add(this.rbPiedraJ1);
        this.buttonGroup1.add(this.rbPapelJ1);
        this.buttonGroup1.add(this.rbTijeraJ1);
        
        this.buttonGroup2.add(this.rbPiedraJ2);
        this.buttonGroup2.add(this.rbPapelJ2);
        this.buttonGroup2.add(this.rbTijeraJ2);
    }
    
    private int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnJugar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPartidasJ2 = new javax.swing.JTextField();
        txtPartidasJ1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTijeraJ1 = new javax.swing.JLabel();
        lblPiedraJ1 = new javax.swing.JLabel();
        lblPapelJ1 = new javax.swing.JLabel();
        lblTijeraJ2 = new javax.swing.JLabel();
        lblPapelJ2 = new javax.swing.JLabel();
        lblPiedraJ2 = new javax.swing.JLabel();
        rbTijeraJ2 = new javax.swing.JRadioButton();
        rbPiedraJ2 = new javax.swing.JRadioButton();
        rbPapelJ2 = new javax.swing.JRadioButton();
        rbPiedraJ1 = new javax.swing.JRadioButton();
        rbPapelJ1 = new javax.swing.JRadioButton();
        rbTijeraJ1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Piedra, papel y tijera");
        setMinimumSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 120, 40));

        jLabel7.setText("Jugador 2");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        jLabel8.setText("Jugador 1");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        txtPartidasJ2.setEditable(false);
        txtPartidasJ2.setText("0");
        getContentPane().add(txtPartidasJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 120, -1));

        txtPartidasJ1.setEditable(false);
        txtPartidasJ1.setText("0");
        getContentPane().add(txtPartidasJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 120, -1));

        jLabel9.setText("Partidas ganadas J1");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jLabel10.setText("Partidas ganadas J2");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        lblTijeraJ1.setText("jLabel1");
        getContentPane().add(lblTijeraJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 200, 200));

        lblPiedraJ1.setText("jLabel1");
        getContentPane().add(lblPiedraJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 200, 200));

        lblPapelJ1.setText("jLabel1");
        getContentPane().add(lblPapelJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 200, 200));

        lblTijeraJ2.setText("jLabel1");
        getContentPane().add(lblTijeraJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 200, 200));

        lblPapelJ2.setText("jLabel1");
        getContentPane().add(lblPapelJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 200, 200));

        lblPiedraJ2.setText("jLabel1");
        getContentPane().add(lblPiedraJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 200, 200));

        rbTijeraJ2.setEnabled(false);
        getContentPane().add(rbTijeraJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, -1, -1));

        rbPiedraJ2.setEnabled(false);
        getContentPane().add(rbPiedraJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));

        rbPapelJ2.setEnabled(false);
        getContentPane().add(rbPapelJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, -1, -1));
        getContentPane().add(rbPiedraJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        getContentPane().add(rbPapelJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));
        getContentPane().add(rbTijeraJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        
        boolean seleccionado = false;
        
        JRadioButton[] botones = {this.rbPiedraJ1, this.rbPapelJ1, this.rbTijeraJ1};
        for (int i = 0; i < botones.length; i++) {
            if (botones[i].isSelected()) {
                seleccionado = true;
            }
        }
        
        if (!seleccionado) {
            JOptionPane.showMessageDialog(this, "J1: elige tu mano");
        } else {
            
            Mano j1 = null, j2 = null;
            
            if (this.rbPiedraJ1.isSelected()) {
                j1 = Mano.PIEDRA;
            }
            
            if (this.rbPapelJ1.isSelected()) {
                j1 = Mano.PAPEL;
            }
            
            if (this.rbTijeraJ1.isSelected()) {
                j1 = Mano.TIJERA;
            }
            
            int manoAleatoria = this.generaNumeroAleatorio(0, 2);
            
            switch (manoAleatoria) {
                case 0:
                    this.rbPiedraJ2.setSelected(true);
                    j2 = Mano.PIEDRA;
                    break;
                case 1:
                    this.rbPapelJ2.setSelected(true);
                    j2 = Mano.PAPEL;
                    break;
                case 2:
                    this.rbTijeraJ2.setSelected(true);  
                    j2 = Mano.TIJERA;
                    break;
            }
            
            int resultado = this.juego.ganador(j1, j2);
            
            switch (resultado) {
                case 0:
                    JOptionPane.showMessageDialog(this, "¡Empate!");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(this, "¡J1 gana!");
                    this.pGanadasJ1++;
                    this.txtPartidasJ1.setText(this.pGanadasJ1 + "");
                    break;
                case -1:
                    JOptionPane.showMessageDialog(this, "¡J2 gana!");
                    this.pGanadasJ2++;
                    this.txtPartidasJ2.setText(this.pGanadasJ2 + "");
                    break;
            }
            
            this.buttonGroup1.clearSelection();
            this.buttonGroup2.clearSelection();
        }
        

    }//GEN-LAST:event_btnJugarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblPapelJ1;
    private javax.swing.JLabel lblPapelJ2;
    private javax.swing.JLabel lblPiedraJ1;
    private javax.swing.JLabel lblPiedraJ2;
    private javax.swing.JLabel lblTijeraJ1;
    private javax.swing.JLabel lblTijeraJ2;
    private javax.swing.JRadioButton rbPapelJ1;
    private javax.swing.JRadioButton rbPapelJ2;
    private javax.swing.JRadioButton rbPiedraJ1;
    private javax.swing.JRadioButton rbPiedraJ2;
    private javax.swing.JRadioButton rbTijeraJ1;
    private javax.swing.JRadioButton rbTijeraJ2;
    private javax.swing.JTextField txtPartidasJ1;
    private javax.swing.JTextField txtPartidasJ2;
    // End of variables declaration//GEN-END:variables
}
