
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger
 */
public class Notas extends javax.swing.JFrame {

    /**
     * Creates new form Notas
     */
    public Notas() {
        initComponents();
          NotasFundo F = new NotasFundo();
          this.add(F,BorderLayout.CENTER);
          this.pack();
          this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
    }
        @Override
    public Component add(Component cmpnt) {
        return super.add(cmpnt);
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
        nota1 = new javax.swing.JTextField();
        nota2 = new javax.swing.JTextField();
        nota3 = new javax.swing.JTextField();
        nota4 = new javax.swing.JTextField();
        salvarNota = new javax.swing.JButton();
        limparNota = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nomeNota = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nota1:");

        jLabel2.setText("Nota2:");

        jLabel3.setText("Nota3:");

        jLabel4.setText("Nota4:");

        nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota1ActionPerformed(evt);
            }
        });

        nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota2ActionPerformed(evt);
            }
        });

        nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota3ActionPerformed(evt);
            }
        });

        nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota4ActionPerformed(evt);
            }
        });

        salvarNota.setText("Salvar");
        salvarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarNotaActionPerformed(evt);
            }
        });

        limparNota.setText("Limpar");
        limparNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparNotaActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(nota1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(nota2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(nota3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(nota4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel6)
                        .add(27, 27, 27))
                    .add(layout.createSequentialGroup()
                        .add(salvarNota)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(limparNota)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(nomeNota, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(nota1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(nomeNota, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(nota2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(nota3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(nota4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(salvarNota)
                    .add(limparNota))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarNotaActionPerformed
        // TODO add your handling code here:
        Aluno aluno = DataBase.buscaPorNome(nomeNota.getText());
        if(aluno==null){
            System.out.println("aluno nao encontrado");
        }
        else{
            aluno.setNota1(nota1.getText());
            aluno.setNota2(nota2.getText());
            aluno.setNota3(nota3.getText());
            aluno.setNota4(nota4.getText());
            this.dispose();
            
        }

    }//GEN-LAST:event_salvarNotaActionPerformed

    private void nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota1ActionPerformed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_nota1ActionPerformed

    private void nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota2ActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_nota2ActionPerformed

    private void nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota3ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nota3ActionPerformed

    private void nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota4ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nota4ActionPerformed

    private void limparNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparNotaActionPerformed
        // TODO add your handling code here:
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
        nota4.setText("");
        nomeNota.setText("");
    }//GEN-LAST:event_limparNotaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Notas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton limparNota;
    private javax.swing.JTextField nomeNota;
    private javax.swing.JTextField nota1;
    private javax.swing.JTextField nota2;
    private javax.swing.JTextField nota3;
    private javax.swing.JTextField nota4;
    private javax.swing.JButton salvarNota;
    // End of variables declaration//GEN-END:variables
}
