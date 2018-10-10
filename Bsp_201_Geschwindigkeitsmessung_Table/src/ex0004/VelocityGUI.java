package ex0004;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VelocityGUI extends javax.swing.JFrame
{

    VeloCityTableModel model = new VeloCityTableModel();

    public VelocityGUI()
    {
        initComponents();
        tbMeasurement.setModel(model);
        tbMeasurement.setDefaultRenderer(Object.class, new VeloCityTableRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pmVelo = new javax.swing.JPopupMenu();
        miHinzufuegen = new javax.swing.JMenuItem();
        miLoeschen = new javax.swing.JMenuItem();
        miDurchschnitt = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMeasurement = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menue = new javax.swing.JMenu();
        miLoad = new javax.swing.JMenuItem();
        miSave = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, miHinzufuegen, org.jdesktop.beansbinding.ELProperty.create("Hinzufügen"), miHinzufuegen, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        miHinzufuegen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onAddMeasure(evt);
            }
        });
        pmVelo.add(miHinzufuegen);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, miLoeschen, org.jdesktop.beansbinding.ELProperty.create("Löschen"), miLoeschen, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        miLoeschen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onRemoveData(evt);
            }
        });
        pmVelo.add(miLoeschen);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, miDurchschnitt, org.jdesktop.beansbinding.ELProperty.create("Durchschnitt berechnen"), miDurchschnitt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        miDurchschnitt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onDisplayAverage(evt);
            }
        });
        pmVelo.add(miDurchschnitt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setComponentPopupMenu(pmVelo);

        tbMeasurement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMeasurement.setComponentPopupMenu(pmVelo);
        jScrollPane1.setViewportView(tbMeasurement);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setComponentPopupMenu(pmVelo);

        menue.setText("Datei");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, miLoad, org.jdesktop.beansbinding.ELProperty.create("Laden"), miLoad, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        miLoad.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onLoadData(evt);
            }
        });
        menue.add(miLoad);

        miSave.setText("Speichern");
        miSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onSaveData(evt);
            }
        });
        menue.add(miSave);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onExit(evt);
            }
        });
        menue.add(miExit);

        jMenuBar1.add(menue);

        setJMenuBar(jMenuBar1);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onLoadData(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onLoadData
    {//GEN-HEADEREND:event_onLoadData

        try
        {
            model.load();
            model.fireTableDataChanged();
        } catch (IOException ex)
        {
            Logger.getLogger(VelocityGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(VelocityGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_onLoadData

    private void onSaveData(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onSaveData
    {//GEN-HEADEREND:event_onSaveData
        try
        {
            model.save();
        } catch (IOException ex)
        {
            Logger.getLogger(VelocityGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_onSaveData

    private void onExit(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onExit
    {//GEN-HEADEREND:event_onExit
        dispose();
    }//GEN-LAST:event_onExit

    private void onAddMeasure(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onAddMeasure
    {//GEN-HEADEREND:event_onAddMeasure
        VeloCityDLG dlg = new VeloCityDLG(this, true);
        dlg.setVisible(true);
        if (dlg.isOk())
        {
            Measurement m = dlg.getMeasurement();
            model.add(m);
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_onAddMeasure

    private void onRemoveData(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onRemoveData
    {//GEN-HEADEREND:event_onRemoveData

        try
        {
            int i = tbMeasurement.getSelectedRow();
            model.remove(i);
            model.fireTableDataChanged();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Zeile aus, um sie zu löschen!!!");
        }
    }//GEN-LAST:event_onRemoveData

    private void onDisplayAverage(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onDisplayAverage
    {//GEN-HEADEREND:event_onDisplayAverage

        try
        {
            model.berechneDurchschnitt();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Fehler beim Berechnen des Durchschnitts!!!");
        }
    }//GEN-LAST:event_onDisplayAverage

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VelocityGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menue;
    private javax.swing.JMenuItem miDurchschnitt;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miHinzufuegen;
    private javax.swing.JMenuItem miLoad;
    private javax.swing.JMenuItem miLoeschen;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JPopupMenu pmVelo;
    private javax.swing.JTable tbMeasurement;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
