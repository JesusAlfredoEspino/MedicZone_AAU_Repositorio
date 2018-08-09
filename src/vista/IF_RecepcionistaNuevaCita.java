/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.joda.time.*;
/**
 *
 * @author Daniela Ramírez
 */
public class IF_RecepcionistaNuevaCita extends javax.swing.JInternalFrame {

    /**
     * Creates new form nuevaCita
     */
    public IF_RecepcionistaNuevaCita() {
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

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Recepcionista_Cita_Curp_Txt = new javax.swing.JTextField();
        Recepcionista_Cita_Agendar_Btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Recepcionista_Cita_TablaCita_Table = new javax.swing.JTable();
        Recepcionista_Cita_TablaCita_Table.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 24));
        Recepcionista_Cita_Paciente_Txt = new javax.swing.JTextField();
        Recepcionista_Cita_FechaN_CBox = new org.jdesktop.swingx.JXDatePicker();
        Recepcionista_Cita_FechaN_CBox.setFormats( new String[] {"dd/MM/yyyy"});
        Recepcionista_Cita_FechaN_CBox.setLinkDate(System.currentTimeMillis(), "Hoy es: {0}");
        Recepcionista_Cita_FechaN_CBox.setFont(new Font("Calibri", Font.PLAIN, 24));
        Recepcionista_Cita_Hora_Spinner = new javax.swing.JSpinner();
        SpinnerDateModel modeloSpinnerHora = new SpinnerDateModel();
        modeloSpinnerHora.setCalendarField(Calendar.MINUTE);

        Recepcionista_Cita_Hora_Spinner = new JSpinner();
        Recepcionista_Cita_Hora_Spinner.setModel(modeloSpinnerHora);
        Recepcionista_Cita_Hora_Spinner.setEditor(new JSpinner.DateEditor(Recepcionista_Cita_Hora_Spinner, "h:mm a"));
        Recepcionista_Cita_idPaciente_Txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Recepcionista_Cita_Descripcion_Txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Recepcionista_Cita_Limpiar_Btn = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setMaximumSize(new java.awt.Dimension(960, 693));
        jPanel5.setMinimumSize(new java.awt.Dimension(960, 693));

        jPanel6.setBackground(new java.awt.Color(29, 132, 99));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nueva Cita");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Elija un paciente");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel7.setText("Fecha:");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel9.setText("Hora:");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        Recepcionista_Cita_Curp_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Cita_Curp_Txt.setEnabled(false);
        Recepcionista_Cita_Curp_Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recepcionista_Cita_Curp_TxtActionPerformed(evt);
            }
        });

        Recepcionista_Cita_Agendar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Recepcionista_Cita_Agendar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Cita_Agendar_Btn.setText("Agendar cita");
        Recepcionista_Cita_Agendar_Btn.setActionCommand("");
        Recepcionista_Cita_Agendar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Recepcionista_Cita_Agendar_Btn.setBorderPainted(false);
        Recepcionista_Cita_Agendar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recepcionista_Cita_Agendar_BtnActionPerformed(evt);
            }
        });

        Recepcionista_Cita_TablaCita_Table.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Recepcionista_Cita_TablaCita_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"David", "Carillo", "Rosales", "ASNFAUA"},
                {"Jesus", "Verde", "Osuna", "NBJNQNE"},
                {"Alfredo", "Espino", "Cardenas", "EICJNNFFN"},
                {"Omar", "Hernandez", "Coto", "IOOCOOO"}
            },
            new String [] {
                "Nombre", "A. Paterno", "A. Materno", "CURP"
            }
        ));
        Recepcionista_Cita_TablaCita_Table.setRowHeight(24);
        jScrollPane1.setViewportView(Recepcionista_Cita_TablaCita_Table);

        Recepcionista_Cita_Paciente_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Cita_Paciente_Txt.setEnabled(false);

        Recepcionista_Cita_idPaciente_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Cita_idPaciente_Txt.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel11.setText("Id:");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel12.setText("Nombre:");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel13.setText("CURP:");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        Recepcionista_Cita_Descripcion_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel14.setText("Descripcion:");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        Recepcionista_Cita_Limpiar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Recepcionista_Cita_Limpiar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Cita_Limpiar_Btn.setText("Limpiar(NoFuncional)");
        Recepcionista_Cita_Limpiar_Btn.setActionCommand("");
        Recepcionista_Cita_Limpiar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Recepcionista_Cita_Limpiar_Btn.setBorderPainted(false);
        Recepcionista_Cita_Limpiar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recepcionista_Cita_Limpiar_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Recepcionista_Cita_Curp_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Recepcionista_Cita_Paciente_Txt))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Recepcionista_Cita_idPaciente_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Recepcionista_Cita_Hora_Spinner)
                                    .addComponent(Recepcionista_Cita_FechaN_CBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Recepcionista_Cita_Descripcion_Txt))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Recepcionista_Cita_Limpiar_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Cita_Agendar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_idPaciente_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_FechaN_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_Paciente_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_Hora_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_Curp_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_Descripcion_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Recepcionista_Cita_Agendar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Cita_Limpiar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

        //JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "hh:mm a");
        //de.getTextField().setEditable( false );
        //jSpinner1.setEditor(de);

        //System.out.println(de.getFormat().format(jSpinner1.getValue()));
        System.out.println(jPanel5.getSize());

    }//GEN-LAST:event_jLabel9MouseClicked

    private void Recepcionista_Cita_Curp_TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recepcionista_Cita_Curp_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recepcionista_Cita_Curp_TxtActionPerformed

    private void Recepcionista_Cita_Agendar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recepcionista_Cita_Agendar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recepcionista_Cita_Agendar_BtnActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void Recepcionista_Cita_Limpiar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recepcionista_Cita_Limpiar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recepcionista_Cita_Limpiar_BtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Recepcionista_Cita_Agendar_Btn;
    public javax.swing.JTextField Recepcionista_Cita_Curp_Txt;
    public javax.swing.JTextField Recepcionista_Cita_Descripcion_Txt;
    public org.jdesktop.swingx.JXDatePicker Recepcionista_Cita_FechaN_CBox;
    public javax.swing.JSpinner Recepcionista_Cita_Hora_Spinner;
    public javax.swing.JButton Recepcionista_Cita_Limpiar_Btn;
    public javax.swing.JTextField Recepcionista_Cita_Paciente_Txt;
    public javax.swing.JTable Recepcionista_Cita_TablaCita_Table;
    public javax.swing.JTextField Recepcionista_Cita_idPaciente_Txt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
