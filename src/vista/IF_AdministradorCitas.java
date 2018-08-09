/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

 
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.joda.time.*;

/**
 *
 * @author office depot
 */
public class IF_AdministradorCitas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ZZZ_InternalFrame_DoctorCita
     */
    public IF_AdministradorCitas() {
        initComponents();
        this.setLocation(-6, -25);
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
        Administrador_Citas_Insertar_Btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Administrador_Citas_TablaCitas_Table = new javax.swing.JTable();
        Administrador_Citas_TablaCitas_Table.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 24));
        jLabel5 = new javax.swing.JLabel();
        Administrador_Citas_Mostrar_CBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Administrador_Citas_OrdenarPor_CBox = new javax.swing.JComboBox<>();
        jPanel21 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(10);
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Administrador_Citas_NombrePaciente_Txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Administrador_Citas_Id_Txt = new javax.swing.JTextField();
        Administrador_Citas_NombreDoctor_Txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Administrador_Citas_NombreRecepcionista_Txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Administrador_Citas_Descripcion_Txt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Administrador_Citas_Conclusion_Txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Administrador_Citas_Estado_Txt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Administrador_Citas_Fecha_DPicker = new org.jdesktop.swingx.JXDatePicker();
        Administrador_Citas_Fecha_DPicker.setFormats( new String[] {"dd/MM/yyyy"});  
        Administrador_Citas_Fecha_DPicker.setLinkDate(System.currentTimeMillis(), "Hoy es: {0}");  
        Administrador_Citas_Fecha_DPicker.setFont(new Font("Calibri", Font.PLAIN, 24));
        Administrador_Citas_Hora_Spinner = new javax.swing.JSpinner();
        SpinnerDateModel modeloSpinnerHora = new SpinnerDateModel();
        modeloSpinnerHora.setCalendarField(Calendar.MINUTE);

        Administrador_Citas_Hora_Spinner = new JSpinner();
        Administrador_Citas_Hora_Spinner.setModel(modeloSpinnerHora);
        Administrador_Citas_Hora_Spinner.setEditor(new JSpinner.DateEditor(Administrador_Citas_Hora_Spinner, "h:mm a"));
        Administrador_Citas_Actualizar_Btn = new javax.swing.JButton();
        Administrador_Citas_Eliminar_Btn = new javax.swing.JButton();
        Administrador_Citas_Limpiar_Btn = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel6.setBackground(new java.awt.Color(29, 132, 99));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Citas");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        Administrador_Citas_Insertar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Administrador_Citas_Insertar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Administrador_Citas_Insertar_Btn.setText("Insertar");
        Administrador_Citas_Insertar_Btn.setActionCommand("");
        Administrador_Citas_Insertar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Administrador_Citas_Insertar_Btn.setBorderPainted(false);
        Administrador_Citas_Insertar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Administrador_Citas_Insertar_BtnActionPerformed(evt);
            }
        });

        Administrador_Citas_TablaCitas_Table.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_TablaCitas_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id cita", "CURP del doctor", "CURP del paciente", "CURP del Recepcionista", "Fecha de cita"
            }
        ));
        Administrador_Citas_TablaCitas_Table.setRowHeight(24);
        jScrollPane1.setViewportView(Administrador_Citas_TablaCitas_Table);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Mostrar:");

        Administrador_Citas_Mostrar_CBox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_Mostrar_CBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Activas", "Inactivas"}));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setText("Ordenar por:");

        Administrador_Citas_OrdenarPor_CBox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_OrdenarPor_CBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id","CURP Doctor","CURP Paciente","CURP Recepcionista", "Fecha"}));

        jPanel21.setBackground(new java.awt.Color(29, 132, 99));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel133.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Información de cita");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("Id del paciente:");

        Administrador_Citas_NombrePaciente_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_NombrePaciente_Txt.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setText("Id:");

        Administrador_Citas_Id_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_Id_Txt.setEnabled(false);

        Administrador_Citas_NombreDoctor_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_NombreDoctor_Txt.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setText("Id del doctor:");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setText("Id del recepcionista:");

        Administrador_Citas_NombreRecepcionista_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Administrador_Citas_NombreRecepcionista_Txt.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel15.setText("Descripción:");

        Administrador_Citas_Descripcion_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel17.setText("Conclusión:");

        Administrador_Citas_Conclusion_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel16.setText("Fecha:");

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel18.setText("Hora:");

        Administrador_Citas_Estado_Txt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel20.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Estado_Txt))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Hora_Spinner))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Fecha_DPicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Conclusion_Txt))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Descripcion_Txt))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_NombreRecepcionista_Txt, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_NombreDoctor_Txt))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_NombrePaciente_Txt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Administrador_Citas_Id_Txt, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Administrador_Citas_Id_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Administrador_Citas_NombrePaciente_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Administrador_Citas_NombreDoctor_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Administrador_Citas_NombreRecepcionista_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Administrador_Citas_Descripcion_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Administrador_Citas_Conclusion_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Administrador_Citas_Fecha_DPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Administrador_Citas_Hora_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(Administrador_Citas_Estado_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel133)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel133)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        Administrador_Citas_Actualizar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Administrador_Citas_Actualizar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Administrador_Citas_Actualizar_Btn.setText("Actualizar");
        Administrador_Citas_Actualizar_Btn.setActionCommand("");
        Administrador_Citas_Actualizar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Administrador_Citas_Actualizar_Btn.setBorderPainted(false);
        Administrador_Citas_Actualizar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Administrador_Citas_Actualizar_BtnActionPerformed(evt);
            }
        });

        Administrador_Citas_Eliminar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Administrador_Citas_Eliminar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Administrador_Citas_Eliminar_Btn.setText("Eliminar");
        Administrador_Citas_Eliminar_Btn.setActionCommand("");
        Administrador_Citas_Eliminar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Administrador_Citas_Eliminar_Btn.setBorderPainted(false);
        Administrador_Citas_Eliminar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Administrador_Citas_Eliminar_BtnActionPerformed(evt);
            }
        });

        Administrador_Citas_Limpiar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Administrador_Citas_Limpiar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Administrador_Citas_Limpiar_Btn.setText("Limpiar");
        Administrador_Citas_Limpiar_Btn.setActionCommand("");
        Administrador_Citas_Limpiar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Administrador_Citas_Limpiar_Btn.setBorderPainted(false);
        Administrador_Citas_Limpiar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Administrador_Citas_Limpiar_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Administrador_Citas_Mostrar_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Administrador_Citas_OrdenarPor_CBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(Administrador_Citas_Limpiar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Eliminar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Actualizar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Administrador_Citas_Insertar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Administrador_Citas_Mostrar_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(Administrador_Citas_OrdenarPor_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Administrador_Citas_Actualizar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Administrador_Citas_Eliminar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Administrador_Citas_Limpiar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Administrador_Citas_Insertar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Administrador_Citas_Insertar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Administrador_Citas_Insertar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Administrador_Citas_Insertar_BtnActionPerformed

    private void Administrador_Citas_Actualizar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Administrador_Citas_Actualizar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Administrador_Citas_Actualizar_BtnActionPerformed

    private void Administrador_Citas_Eliminar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Administrador_Citas_Eliminar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Administrador_Citas_Eliminar_BtnActionPerformed

    private void Administrador_Citas_Limpiar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Administrador_Citas_Limpiar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Administrador_Citas_Limpiar_BtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Administrador_Citas_Actualizar_Btn;
    public javax.swing.JTextField Administrador_Citas_Conclusion_Txt;
    public javax.swing.JTextField Administrador_Citas_Descripcion_Txt;
    public javax.swing.JButton Administrador_Citas_Eliminar_Btn;
    public javax.swing.JTextField Administrador_Citas_Estado_Txt;
    public org.jdesktop.swingx.JXDatePicker Administrador_Citas_Fecha_DPicker;
    public javax.swing.JSpinner Administrador_Citas_Hora_Spinner;
    public javax.swing.JTextField Administrador_Citas_Id_Txt;
    public javax.swing.JButton Administrador_Citas_Insertar_Btn;
    public javax.swing.JButton Administrador_Citas_Limpiar_Btn;
    public javax.swing.JComboBox<String> Administrador_Citas_Mostrar_CBox;
    public javax.swing.JTextField Administrador_Citas_NombreDoctor_Txt;
    public javax.swing.JTextField Administrador_Citas_NombrePaciente_Txt;
    public javax.swing.JTextField Administrador_Citas_NombreRecepcionista_Txt;
    public javax.swing.JComboBox<String> Administrador_Citas_OrdenarPor_CBox;
    public javax.swing.JTable Administrador_Citas_TablaCitas_Table;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}