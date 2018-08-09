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
public class IF_RecepcionistaAgregarPaciente extends javax.swing.JInternalFrame {

    /**
     * Creates new form agregarPaciente
     */
    public IF_RecepcionistaAgregarPaciente() {
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

        Agregar_NuevoPaciente_Lbl4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Agregar_NuevoPaciente_Lbl = new javax.swing.JLabel();
        Recepcionista_Agregar_Agregar_Btn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        Recepcionista_Agregar_Limpiar_Btn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Agregar_Nombres_Lbl1 = new javax.swing.JLabel();
        Agregar_Nombres_Txt = new javax.swing.JTextField();
        Agregar_ApellidoP_Lbl1 = new javax.swing.JLabel();
        Agregar_ApellidoP_Txt = new javax.swing.JTextField();
        Agregar_ApellidoM_Lbl1 = new javax.swing.JLabel();
        Agregar_ApellidoM_Txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Agregar_Correo_Txt = new javax.swing.JTextField();
        Agregar_Telefono_Lbl1 = new javax.swing.JLabel();
        Agregar_Telefono_Txt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Agregar_Celular_Txt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Agregar_Genero_CBox = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        Agregar_Curp_Txt = new javax.swing.JTextField();
        Agregar_Direccion_Txt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Agregar_EstadoCivil_CBox = new javax.swing.JComboBox<>();
        Agregar_FechaN_CBox = new org.jdesktop.swingx.JXDatePicker();
        Agregar_FechaN_CBox.setFormats( new String[] {"dd/MM/yyyy"});
        Agregar_FechaN_CBox.setLinkDate(System.currentTimeMillis(), "Hoy es: {0}");
        Agregar_FechaN_CBox.setFont(new Font("Calibri", Font.PLAIN, 24));
        Agregar_NuevoPaciente_Lbl3 = new javax.swing.JLabel();
        Agregar_NuevoPaciente_Lbl5 = new javax.swing.JLabel();

        Agregar_NuevoPaciente_Lbl4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_NuevoPaciente_Lbl4.setForeground(new java.awt.Color(255, 255, 255));
        Agregar_NuevoPaciente_Lbl4.setText("Llene los campos");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setMaximumSize(new java.awt.Dimension(960, 693));
        jPanel5.setMinimumSize(new java.awt.Dimension(960, 693));

        jPanel6.setBackground(new java.awt.Color(29, 132, 99));

        Agregar_NuevoPaciente_Lbl.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_NuevoPaciente_Lbl.setForeground(new java.awt.Color(255, 255, 255));
        Agregar_NuevoPaciente_Lbl.setText("Nuevo paciente");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agregar_NuevoPaciente_Lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Agregar_NuevoPaciente_Lbl)
                .addContainerGap())
        );

        Recepcionista_Agregar_Agregar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Recepcionista_Agregar_Agregar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Agregar_Agregar_Btn.setText("Agregar paciente");
        Recepcionista_Agregar_Agregar_Btn.setActionCommand("");
        Recepcionista_Agregar_Agregar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Recepcionista_Agregar_Agregar_Btn.setBorderPainted(false);
        Recepcionista_Agregar_Agregar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recepcionista_Agregar_Agregar_BtnActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel20.setText("Campos obligatorios*");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        Recepcionista_Agregar_Limpiar_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Recepcionista_Agregar_Limpiar_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Agregar_Limpiar_Btn.setText("Limpiar");
        Recepcionista_Agregar_Limpiar_Btn.setActionCommand("");
        Recepcionista_Agregar_Limpiar_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Recepcionista_Agregar_Limpiar_Btn.setBorderPainted(false);
        Recepcionista_Agregar_Limpiar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recepcionista_Agregar_Limpiar_BtnActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(29, 132, 99));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setMaximumSize(new java.awt.Dimension(960, 693));
        jPanel7.setMinimumSize(new java.awt.Dimension(960, 693));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel8.setText("Fecha de nacimiento*");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        Agregar_Nombres_Lbl1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_Nombres_Lbl1.setText("Nombres*");
        Agregar_Nombres_Lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_Nombres_Lbl1MouseClicked(evt);
            }
        });

        Agregar_Nombres_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        Agregar_ApellidoP_Lbl1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_ApellidoP_Lbl1.setText("Apellido paterno*");
        Agregar_ApellidoP_Lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_ApellidoP_Lbl1MouseClicked(evt);
            }
        });

        Agregar_ApellidoP_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        Agregar_ApellidoM_Lbl1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_ApellidoM_Lbl1.setText("Apellido materno*");
        Agregar_ApellidoM_Lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_ApellidoM_Lbl1MouseClicked(evt);
            }
        });

        Agregar_ApellidoM_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel13.setText("Correo");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        Agregar_Correo_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        Agregar_Telefono_Lbl1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_Telefono_Lbl1.setText("Teléfono*");
        Agregar_Telefono_Lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_Telefono_Lbl1MouseClicked(evt);
            }
        });

        Agregar_Telefono_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel21.setText("Celular");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        Agregar_Celular_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel22.setText("Género*");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        Agregar_Genero_CBox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Agregar_Genero_CBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel23.setText("CURP*");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        Agregar_Curp_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_Curp_Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_Curp_TxtActionPerformed(evt);
            }
        });

        Agregar_Direccion_Txt.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel24.setText("Dirección*");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel25.setText("Estado civil*");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        Agregar_EstadoCivil_CBox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Agregar_EstadoCivil_CBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_EstadoCivil_CBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Curp_Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Genero_CBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Celular_Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(Agregar_Telefono_Lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Telefono_Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Direccion_Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Correo_Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_FechaN_CBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(Agregar_ApellidoM_Lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_ApellidoM_Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(Agregar_Nombres_Lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_Nombres_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(Agregar_ApellidoP_Lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar_ApellidoP_Txt)))
                .addGap(10, 10, 10))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar_Nombres_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Nombres_Lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar_ApellidoP_Lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_ApellidoP_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar_ApellidoM_Lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_ApellidoM_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_FechaN_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Correo_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Direccion_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar_Telefono_Lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Telefono_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Celular_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Genero_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_Curp_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_EstadoCivil_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jScrollPane1.setViewportView(jPanel7);

        Agregar_NuevoPaciente_Lbl3.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_NuevoPaciente_Lbl3.setForeground(new java.awt.Color(255, 255, 255));
        Agregar_NuevoPaciente_Lbl3.setText("Llene los campos");

        Agregar_NuevoPaciente_Lbl5.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Agregar_NuevoPaciente_Lbl5.setForeground(new java.awt.Color(255, 255, 255));
        Agregar_NuevoPaciente_Lbl5.setText("Ingrese los datos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agregar_NuevoPaciente_Lbl5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 301, Short.MAX_VALUE)
                    .addComponent(Agregar_NuevoPaciente_Lbl3)
                    .addGap(0, 301, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agregar_NuevoPaciente_Lbl5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 195, Short.MAX_VALUE)
                    .addComponent(Agregar_NuevoPaciente_Lbl3)
                    .addGap(0, 195, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Recepcionista_Agregar_Limpiar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Agregar_Agregar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Recepcionista_Agregar_Limpiar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Agregar_Agregar_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 629, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Recepcionista_Agregar_Agregar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recepcionista_Agregar_Agregar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recepcionista_Agregar_Agregar_BtnActionPerformed

    private void Recepcionista_Agregar_Limpiar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recepcionista_Agregar_Limpiar_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recepcionista_Agregar_Limpiar_BtnActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void Agregar_Nombres_Lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_Nombres_Lbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_Nombres_Lbl1MouseClicked

    private void Agregar_ApellidoP_Lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_ApellidoP_Lbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_ApellidoP_Lbl1MouseClicked

    private void Agregar_ApellidoM_Lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_ApellidoM_Lbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_ApellidoM_Lbl1MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void Agregar_Telefono_Lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_Telefono_Lbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_Telefono_Lbl1MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void Agregar_Curp_TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_Curp_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_Curp_TxtActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Agregar_ApellidoM_Lbl1;
    public javax.swing.JTextField Agregar_ApellidoM_Txt;
    public javax.swing.JLabel Agregar_ApellidoP_Lbl1;
    public javax.swing.JTextField Agregar_ApellidoP_Txt;
    public javax.swing.JTextField Agregar_Celular_Txt;
    public javax.swing.JTextField Agregar_Correo_Txt;
    public javax.swing.JTextField Agregar_Curp_Txt;
    public javax.swing.JTextField Agregar_Direccion_Txt;
    public javax.swing.JComboBox<String> Agregar_EstadoCivil_CBox;
    public org.jdesktop.swingx.JXDatePicker Agregar_FechaN_CBox;
    public javax.swing.JComboBox<String> Agregar_Genero_CBox;
    public javax.swing.JLabel Agregar_Nombres_Lbl1;
    public javax.swing.JTextField Agregar_Nombres_Txt;
    public javax.swing.JLabel Agregar_NuevoPaciente_Lbl;
    public javax.swing.JLabel Agregar_NuevoPaciente_Lbl3;
    public javax.swing.JLabel Agregar_NuevoPaciente_Lbl4;
    private javax.swing.JLabel Agregar_NuevoPaciente_Lbl5;
    public javax.swing.JLabel Agregar_Telefono_Lbl1;
    public javax.swing.JTextField Agregar_Telefono_Txt;
    public javax.swing.JButton Recepcionista_Agregar_Agregar_Btn;
    public javax.swing.JButton Recepcionista_Agregar_Limpiar_Btn;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}