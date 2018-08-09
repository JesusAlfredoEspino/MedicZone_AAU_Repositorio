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
public class IF_RecepcionistaEditarPaciente extends javax.swing.JInternalFrame {

    /**
     * Creates new form editarPaciente
     */
    public IF_RecepcionistaEditarPaciente() {
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
        Recepcionista_Editar_GuardarCambios_Btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Recepcionista_Editar_TablaEditar_Table = new javax.swing.JTable();
        Recepcionista_Editar_TablaEditar_Table.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 24));
        Recepcionista_Editar_Panel_Info = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jScrollPane9.getVerticalScrollBar().setUnitIncrement(10);
        jPanel20 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        Recepcionista_Editar_Nombre_Txt = new javax.swing.JTextField();
        Recepcionista_Editar_Genero_CBox = new javax.swing.JComboBox<>();
        Recepcionista_Editar_EstadoCivil_CBox = new javax.swing.JComboBox<>();
        Recepcionista_Editar_Curp_Txt = new javax.swing.JTextField();
        Recepcionista_Editar_Correo_Txt = new javax.swing.JTextField();
        Recepcionista_Editar_Direccion_Txt = new javax.swing.JTextField();
        Recepcionista_Editar_Celular_Txt = new javax.swing.JTextField();
        Recepcionista_Editar_Telefono_Txt = new javax.swing.JTextField();
        Recepcionista_Editar_FechaN_DPicker = new org.jdesktop.swingx.JXDatePicker();
        Recepcionista_Editar_Id_Txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Recepcionista_Editar_ApellidoPaterno_Txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Recepcionista_Editar_ApellidoMaterno_Txt = new javax.swing.JTextField();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel6.setBackground(new java.awt.Color(29, 132, 99));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar pacientes");

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

        Recepcionista_Editar_GuardarCambios_Btn.setBackground(new java.awt.Color(255, 255, 255));
        Recepcionista_Editar_GuardarCambios_Btn.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        Recepcionista_Editar_GuardarCambios_Btn.setText("Guardar cambios");
        Recepcionista_Editar_GuardarCambios_Btn.setActionCommand("");
        Recepcionista_Editar_GuardarCambios_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        Recepcionista_Editar_GuardarCambios_Btn.setBorderPainted(false);

        Recepcionista_Editar_TablaEditar_Table.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Recepcionista_Editar_TablaEditar_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pedro Sola", "20", "PSOL1234"},
                {"Juan Escutia", "19", "JESC5678"},
                {"Gonzalo Salas", "17", "GSAL9010"},
                {"Tomas Guerrero ", "24", "TGUE1112"}
            },
            new String [] {
                "Nombre", "Edad", "CURP"
            }
        ));
        Recepcionista_Editar_TablaEditar_Table.setRowHeight(24);
        jScrollPane1.setViewportView(Recepcionista_Editar_TablaEditar_Table);

        Recepcionista_Editar_Panel_Info.setBackground(new java.awt.Color(29, 132, 99));
        Recepcionista_Editar_Panel_Info.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel133.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Informacion de paciente");

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel134.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel134.setText("Nombre");

        jLabel137.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel137.setText("Fecha de nacimiento");

        jLabel141.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel141.setText("Correo");

        jLabel143.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel143.setText("Dirección");

        jLabel145.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel145.setText("Telefono");

        jLabel147.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel147.setText("Celular");

        jLabel148.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel148.setText("Genero");

        jLabel150.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel150.setText("Estado civil");

        jLabel152.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel152.setText("CURP");

        Recepcionista_Editar_Nombre_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        Recepcionista_Editar_Genero_CBox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Recepcionista_Editar_Genero_CBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));

        Recepcionista_Editar_EstadoCivil_CBox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Recepcionista_Editar_EstadoCivil_CBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));

        Recepcionista_Editar_Curp_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        Recepcionista_Editar_Correo_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        Recepcionista_Editar_Direccion_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        Recepcionista_Editar_Celular_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        Recepcionista_Editar_Telefono_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        Recepcionista_Editar_FechaN_DPicker.setFormats( new String[] {"dd/MM/yyyy"});
        Recepcionista_Editar_FechaN_DPicker.setLinkDate(System.currentTimeMillis(), "Hoy es: {0}");
        Recepcionista_Editar_FechaN_DPicker.setFont(new Font("Calibri", Font.PLAIN, 24));

        Recepcionista_Editar_Id_Txt.setEditable(false);
        Recepcionista_Editar_Id_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Apellido paterno");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Apellido materno");

        Recepcionista_Editar_ApellidoMaterno_Txt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Id_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel147)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Celular_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel134)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Nombre_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_ApellidoPaterno_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_ApellidoMaterno_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel137)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_FechaN_DPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Genero_CBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_EstadoCivil_CBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel152)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Curp_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel141)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Correo_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel143)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Direccion_Txt))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel145)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recepcionista_Editar_Telefono_Txt)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Recepcionista_Editar_Id_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(Recepcionista_Editar_Nombre_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Recepcionista_Editar_ApellidoPaterno_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Recepcionista_Editar_ApellidoMaterno_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(Recepcionista_Editar_FechaN_DPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(Recepcionista_Editar_Genero_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(Recepcionista_Editar_EstadoCivil_CBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(Recepcionista_Editar_Curp_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(Recepcionista_Editar_Correo_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(Recepcionista_Editar_Direccion_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(Recepcionista_Editar_Telefono_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147)
                    .addComponent(Recepcionista_Editar_Celular_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel20);

        javax.swing.GroupLayout Recepcionista_Editar_Panel_InfoLayout = new javax.swing.GroupLayout(Recepcionista_Editar_Panel_Info);
        Recepcionista_Editar_Panel_Info.setLayout(Recepcionista_Editar_Panel_InfoLayout);
        Recepcionista_Editar_Panel_InfoLayout.setHorizontalGroup(
            Recepcionista_Editar_Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Recepcionista_Editar_Panel_InfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel133)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        Recepcionista_Editar_Panel_InfoLayout.setVerticalGroup(
            Recepcionista_Editar_Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Recepcionista_Editar_Panel_InfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel133)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(478, 478, 478))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Recepcionista_Editar_GuardarCambios_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recepcionista_Editar_Panel_Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Recepcionista_Editar_Panel_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Recepcionista_Editar_GuardarCambios_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(615, 615, 615))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Recepcionista_Editar_ApellidoMaterno_Txt;
    public javax.swing.JTextField Recepcionista_Editar_ApellidoPaterno_Txt;
    public javax.swing.JTextField Recepcionista_Editar_Celular_Txt;
    public javax.swing.JTextField Recepcionista_Editar_Correo_Txt;
    public javax.swing.JTextField Recepcionista_Editar_Curp_Txt;
    public javax.swing.JTextField Recepcionista_Editar_Direccion_Txt;
    public javax.swing.JComboBox<String> Recepcionista_Editar_EstadoCivil_CBox;
    public org.jdesktop.swingx.JXDatePicker Recepcionista_Editar_FechaN_DPicker;
    public javax.swing.JComboBox<String> Recepcionista_Editar_Genero_CBox;
    public javax.swing.JButton Recepcionista_Editar_GuardarCambios_Btn;
    public javax.swing.JTextField Recepcionista_Editar_Id_Txt;
    public javax.swing.JTextField Recepcionista_Editar_Nombre_Txt;
    public javax.swing.JPanel Recepcionista_Editar_Panel_Info;
    public javax.swing.JTable Recepcionista_Editar_TablaEditar_Table;
    public javax.swing.JTextField Recepcionista_Editar_Telefono_Txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}