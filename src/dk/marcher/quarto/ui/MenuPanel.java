/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.marcher.quarto.ui;

/**
 *
 * @author marcher89
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jButton1.setText("New Game");
        jButton1.setMaximumSize(new java.awt.Dimension(120, 29));
        jButton1.setMinimumSize(new java.awt.Dimension(120, 29));
        jButton1.setName(""); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(120, 29));
        jButton1.setSize(new java.awt.Dimension(120, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGamePressed(evt);
            }
        });
        add(jButton1);

        jButton2.setText("Exit");
        jButton2.setMaximumSize(new java.awt.Dimension(120, 29));
        jButton2.setMinimumSize(new java.awt.Dimension(120, 29));
        jButton2.setPreferredSize(new java.awt.Dimension(120, 29));
        jButton2.setSize(new java.awt.Dimension(120, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitPressed(evt);
            }
        });
        add(jButton2);
    }// </editor-fold>//GEN-END:initComponents

    private void exitPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitPressed
        System.exit(0);
    }//GEN-LAST:event_exitPressed

    private void newGamePressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGamePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_newGamePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
