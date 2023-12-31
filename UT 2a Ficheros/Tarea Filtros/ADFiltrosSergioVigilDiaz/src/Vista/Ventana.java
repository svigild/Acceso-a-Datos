/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Logica.Filtros;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Sergio
 */
public class Ventana extends javax.swing.JFrame {
    
    private DefaultListModel<String> listModel;
    private boolean filterImagenes = false;
    private boolean filterVideos = false;
    private boolean filterDirectorios = false;
    private boolean filterTamañoMinimo = false;
    private long minFileSize = 0; // Tamaño mínimo de archivo en bytes
    private boolean filterModificados24Horas = false;
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        listModel = new DefaultListModel<>();
        jListArchivos.setModel(listModel);
        jTextField1.setText("C:\\");
    
         // Define un renderizador personalizado para el JList
        ListCellRenderer<? super String> renderer = new DefaultListCellRenderer() {
            private Icon folderIcon = getScaledIcon("/resource/folder.png", 20, 20); // Ajusta el tamaño aquí
            private Icon fileIcon = getScaledIcon("/resource/file.png", 20, 20); // Ajusta el tamaño aquí

            private Icon getScaledIcon(String path, int width, int height) {
                ImageIcon icon = new ImageIcon(getClass().getResource(path));
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            }

            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component rendererComponent = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    String valueString = value.toString();
                    if (!valueString.contains(".")){
                        setIcon(folderIcon);
                    } else {
                        setIcon(fileIcon);
                    }
                    
                }
                return rendererComponent;
            }
        };

        jListArchivos.setCellRenderer(renderer);
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelSeleccionarDirectorio = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonBuscarDirectorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListArchivos = new javax.swing.JList<>();
        jLabelSeleccionarFiltro = new javax.swing.JLabel();
        jRadioButtonImagenes = new javax.swing.JRadioButton();
        jRadioButtonVideos = new javax.swing.JRadioButton();
        jRadioButtonDirectorios = new javax.swing.JRadioButton();
        jRadioButtonTamaño = new javax.swing.JRadioButton();
        jRadioButtonModificados = new javax.swing.JRadioButton();
        jTextFieldTamaño = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filtrar archivos");
        setBackground(new java.awt.Color(255, 102, 204));
        setIconImage(getIconImage());
        setResizable(false);

        jLabelSeleccionarDirectorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelSeleccionarDirectorio.setText("Selecciona el directorio");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setText("jTextField1");

        jButtonBuscarDirectorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscarDirectorio.setText("Explorar");
        jButtonBuscarDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDirectorioActionPerformed(evt);
            }
        });

        jListArchivos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(jListArchivos);

        jLabelSeleccionarFiltro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelSeleccionarFiltro.setText("Selecciona el filtro a aplicar");

        buttonGroup1.add(jRadioButtonImagenes);
        jRadioButtonImagenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonImagenes.setText("Imágenes");
        jRadioButtonImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonImagenesActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonVideos);
        jRadioButtonVideos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonVideos.setText("Vídeos");
        jRadioButtonVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVideosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonDirectorios);
        jRadioButtonDirectorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonDirectorios.setText("Directorios");
        jRadioButtonDirectorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDirectoriosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTamaño);
        jRadioButtonTamaño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonTamaño.setText("Tamaño mínimo");
        jRadioButtonTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTamañoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonModificados);
        jRadioButtonModificados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonModificados.setText("Modificados en las últimas 24 horas");
        jRadioButtonModificados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonModificadosActionPerformed(evt);
            }
        });

        jTextFieldTamaño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldTamaño.setText("0");
        jTextFieldTamaño.setToolTipText("Tamaño mínimo de los ficheros en bytes");

        jButtonFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonFiltrar.setLabel("Filtrar");
        jButtonFiltrar.setMargin(new java.awt.Insets(2, 14, 2, 14));
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarDirectorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonImagenes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabelSeleccionarDirectorio))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabelSeleccionarFiltro)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonVideos)
                            .addComponent(jRadioButtonModificados)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonTamaño)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButtonDirectorios))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSeleccionarDirectorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscarDirectorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addComponent(jLabelSeleccionarFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonImagenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonVideos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDirectorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTamaño)
                    .addComponent(jTextFieldTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonModificados)
                .addGap(24, 24, 24)
                .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDirectorioActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            jTextField1.setText(selectedDirectory.getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonBuscarDirectorioActionPerformed

    private void jRadioButtonVideosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVideosActionPerformed
        filterVideos = jRadioButtonVideos.isSelected();
    }//GEN-LAST:event_jRadioButtonVideosActionPerformed

    private void jRadioButtonDirectoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDirectoriosActionPerformed
        filterDirectorios = jRadioButtonDirectorios.isSelected();
    }//GEN-LAST:event_jRadioButtonDirectoriosActionPerformed

    private void jRadioButtonTamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTamañoActionPerformed
        try {
        minFileSize = Long.parseLong(jTextFieldTamaño.getText());
        filterTamañoMinimo = jRadioButtonTamaño.isSelected();
    } catch (NumberFormatException e) {
        // Manejar error si el usuario ingresa un valor no válido
    }
    }//GEN-LAST:event_jRadioButtonTamañoActionPerformed

    private void jRadioButtonModificadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonModificadosActionPerformed
        filterModificados24Horas = jRadioButtonModificados.isSelected();
    }//GEN-LAST:event_jRadioButtonModificadosActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        listModel.clear(); // Limpiar la lista antes de mostrar los archivos

        if (jRadioButtonImagenes.isSelected()) {
            filterImagenes();
        }
        if (jRadioButtonVideos.isSelected()) {
            filterVideos();
        }
        if (jRadioButtonDirectorios.isSelected()) {
            filterDirectorios();
        }
        if (jRadioButtonTamaño.isSelected()) {
            filterPorTamaño();
        }
        if (jRadioButtonModificados.isSelected()) {
            filterModificados24Horas();
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void filterImagenes() {
        String selectedDirectoryPath = jTextField1.getText();
        File selectedDirectory = new File(selectedDirectoryPath);

        if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
            Filtros filtro = new Filtros(selectedDirectory);
            List<String> imagenes = filtro.filtrarPorImagen();
            listModel.addAll(imagenes);
        }
    }

    private void filterVideos() {
        String selectedDirectoryPath = jTextField1.getText();
        File selectedDirectory = new File(selectedDirectoryPath);

        if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
            Filtros filtro = new Filtros(selectedDirectory);
            List<String> videos = filtro.filtrarPorVideo();
            listModel.addAll(videos);
        }
    }

    private void filterDirectorios() {
        String selectedDirectoryPath = jTextField1.getText();
        File selectedDirectory = new File(selectedDirectoryPath);

        if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
            Filtros filtro = new Filtros(selectedDirectory);
            List<String> directorios = filtro.filtrarPorDirectorio();
            listModel.addAll(directorios);
        }
    }

    private void filterPorTamaño() {
        String selectedDirectoryPath = jTextField1.getText();
        File selectedDirectory = new File(selectedDirectoryPath);

        if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
            double minSize = Double.parseDouble(jTextFieldTamaño.getText());
            Filtros filtro = new Filtros(selectedDirectory);
            List<String> archivos = filtro.filtrarPorTamaño(minSize);
            listModel.addAll(archivos);
        }
    }

    private void filterModificados24Horas() {
        String selectedDirectoryPath = jTextField1.getText();
        File selectedDirectory = new File(selectedDirectoryPath);

        if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
            Filtros filtro = new Filtros(selectedDirectory);
            List<String> modificados = filtro.filtrarPorModificado24Horas();
            listModel.addAll(modificados);
        }
    }
    
    private void jRadioButtonImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonImagenesActionPerformed
        filterImagenes = jRadioButtonImagenes.isSelected();
        listModel.clear();
    }//GEN-LAST:event_jRadioButtonImagenesActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    private void filterFiles() {
        listModel.clear(); // Limpiar la lista antes de mostrar los archivos

    String selectedDirectoryPath = jTextField1.getText();
    File selectedDirectory = new File(selectedDirectoryPath);

    if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
        // Crear una instancia de la clase Filtros
        Filtros filtro = new Filtros(selectedDirectory);

        // Verificar qué filtros están activados por el usuario y aplicarlos
        if (filterImagenes) {
            List<String> imagenes = filtro.filtrarPorImagen();
            listModel.addAll(imagenes);
        }
        if (filterVideos) {
            List<String> videos = filtro.filtrarPorVideo();
            listModel.addAll(videos);
        }
        if (filterDirectorios) {
            List<String> directorios = filtro.filtrarPorDirectorio();
            listModel.addAll(directorios);
        }
        if (filterTamañoMinimo) {
            List<String> tamaños = filtro.filtrarPorTamaño(Double.parseDouble(jTextFieldTamaño.getText()));
            listModel.addAll(tamaños);
        }
        if (filterModificados24Horas) {
            List<String> modificados = filtro.filtrarPorModificado24Horas();
            listModel.addAll(modificados);
        }
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBuscarDirectorio;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabelSeleccionarDirectorio;
    private javax.swing.JLabel jLabelSeleccionarFiltro;
    private javax.swing.JList<String> jListArchivos;
    private javax.swing.JRadioButton jRadioButtonDirectorios;
    private javax.swing.JRadioButton jRadioButtonImagenes;
    private javax.swing.JRadioButton jRadioButtonModificados;
    private javax.swing.JRadioButton jRadioButtonTamaño;
    private javax.swing.JRadioButton jRadioButtonVideos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldTamaño;
    // End of variables declaration//GEN-END:variables
}
