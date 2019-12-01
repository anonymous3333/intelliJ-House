/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author POE3BPRV
 */
public class FORM_INICIO extends javax.swing.JFrame {
    public static ArrayList<String> estados = new ArrayList<>();
    ActualizaValores update = new ActualizaValores(estados);
    FORM_CLIMA clima;
    Integer temph1;
    Integer temph2;
    float temp_casa;
    
    //Carga de imágenes en la memoria
    ImageIcon vista_generalIcon = new ImageIcon("src/img/vista_general.jpg");
    ImageIcon salaIcon = new ImageIcon("src/img/sala.jpg");
    ImageIcon salaAIcon = new ImageIcon("src/img/salaA.jpg");
    ImageIcon cocinaIcon = new ImageIcon("src/img/cocina.jpg");
    ImageIcon cocinaAiIcon = new ImageIcon("src/img/cocinaA.jpg");
    ImageIcon hab1Icon = new ImageIcon("src/img/hab1.jpg");
    ImageIcon hab1AIcon = new ImageIcon("src/img/hab1A.jpg");
    ImageIcon hab2Icon = new ImageIcon("src/img/hab2.jpg");
    ImageIcon hab2AIcon = new ImageIcon("src/img/hab2A.jpg");
    ImageIcon hab3Icon = new ImageIcon("src/img/hab3.jpg");
    ImageIcon hab3AIcon = new ImageIcon("src/img/hab3A.jpg");
    ImageIcon bathIcon = new ImageIcon("src/img/bath.jpg");
    ImageIcon bathAiIcon = new ImageIcon("src/img/bathA.jpg");
    ImageIcon hornoIcon = new ImageIcon("src/img/horno.jpg");
    
    
    public FORM_INICIO() {
        initComponents();
        ActualizaValores update = new ActualizaValores(estados);
        update.execute();
        clima = new FORM_CLIMA();
        temp_casa=clima.TEMP+5;
        cargarImagen(vista_generalIcon, img_vistaGral);
        cargarImagen(hornoIcon, img_horno);
        img_alarma.setVisible(false);
        cargaControles();
        cargaEstados();
    }
    
    
    private void cargaEstados(){
        //Detector de movimiento
        if(this.estados.get(0).equals("1")){
            detectorMov_btn.setSelected(true);
            detectorMov_btn.setText("Detector de movimiento: ON");
            detectorMov_btn.setForeground(Color.GREEN);
        }else{
            detectorMov_btn.setText("Detector de movimiento: OFF");
            detectorMov_btn.setForeground(Color.RED);
        }
        //Luces sala
        if(this.estados.get(1).equals("1")){
            cargarImagen(salaIcon, img_sala);
            luz1.setSelected(false);
            luz1.setText("Luces: ON");
            luz1.setForeground(Color.GREEN);
        }else{
            cargarImagen(salaAIcon, img_sala);
            luz1.setSelected(true);
            luz1.setText("Luces: OFF");
            luz1.setForeground(Color.RED);
        }
        //Ventilador sala
        if(this.estados.get(2).equals("1")){
            img_venti1.setVisible(true);
            venti1_btn.setSelected(true);
            venti1_btn.setText("Ventilador: ON");
            venti1_btn.setForeground(Color.GREEN);
        }else{
            img_venti1.setVisible(false);
            venti1_btn.setSelected(false);
            venti1_btn.setText("Ventilador: OFF");
            venti1_btn.setForeground(Color.RED);
        }
        
        //Televisión sala
        if(this.estados.get(3).equals("1")){
            img_tele1.setVisible(true);
            controlTele1.setSelected(true);
            controlTele1.setText("Televisión: ON");
            controlTele1.setForeground(Color.GREEN);
        }else{
            img_tele1.setVisible(false);
            controlTele1.setSelected(false);
            controlTele1.setText("Televisión: OFF");
            controlTele1.setForeground(Color.RED);
        }
        
        //Luces cocina
        if(this.estados.get(4).equals("1")){
            cargarImagen(cocinaIcon, img_cocina);
            luz2.setSelected(false);
            luz2.setText("Luces: ON");
            luz2.setForeground(Color.GREEN);
        }else{
            cargarImagen(cocinaAiIcon, img_cocina);
            luz2.setSelected(true);
            luz2.setText("Luces: OFF");
            luz2.setForeground(Color.RED);
        }
        
        //Refri
        tempRefri.setText(this.estados.get(5));
        control_refri.setValue(new Integer(this.estados.get(5)));
        
        //Congelador
        temp_Cong.setText(this.estados.get(6));
        control_conge.setValue(new Integer(this.estados.get(6)));
        
        //Horno
        if(this.estados.get(7).equals("1")){
            img_horno.setVisible(true);
            horno.setSelected(true);
            horno.setText("Horno: ON");
            horno.setForeground(Color.GREEN);
        }else{
            img_horno.setVisible(false);
            horno.setSelected(false);
            horno.setText("Horno: OFF");
            horno.setForeground(Color.RED);
        }
        
        //Luces hab1
        if(this.estados.get(8).equals("1")){
            cargarImagen(hab1Icon, img_hab1);
            luz3.setSelected(false);
            luz3.setText("Luces: ON");
            luz3.setForeground(Color.GREEN);
        }else{
            cargarImagen(hab1AIcon, img_hab1);
            luz3.setSelected(true);
            luz3.setText("Luces: OFF");
            luz3.setForeground(Color.RED);
        }
        
        //Aire acondicionado1
        temph1=new Integer(this.estados.get(10));
        if(this.estados.get(9).equals("1")){
            tempHab1.setText(this.estados.get(10));
            controlTemp1.setValue(temph1);
            aire_acondicionado1.setSelected(true);
            aire_acondicionado1.setText("Aire acondicionado: ON");
            aire_acondicionado1.setForeground(Color.GREEN);
        }else{
            aire_acondicionado1.setSelected(false);
            controlTemp1.setValue(temph1);
            controlTemp1.setEnabled(false);
            aire_acondicionado1.setText("Aire acondicionado: OFF");
            aire_acondicionado1.setForeground(Color.RED);
            tempHab1.setText(Float.toString(temp_casa));
        }
        
        //Luces hab2
        if(this.estados.get(11).equals("1")){
            cargarImagen(hab2Icon, img_hab2);
            luz4.setSelected(false);
            luz4.setText("Luces: ON");
            luz4.setForeground(Color.GREEN);
        }else{
            cargarImagen(hab2AIcon, img_hab2);
            luz4.setSelected(true);
            luz4.setText("Luces: OFF");
            luz4.setForeground(Color.RED);
        }
        
        //Aire acondicionado2
        temph2=new Integer(this.estados.get(13));
        if(this.estados.get(12).equals("1")){
            tempHab2.setText(this.estados.get(13));
            controlTemp2.setValue(temph2);
            aire_acondicionado2.setSelected(true);
            aire_acondicionado2.setText("Aire acondicionado: ON");
            aire_acondicionado2.setForeground(Color.GREEN);
        }else{
            aire_acondicionado2.setSelected(false);
            controlTemp2.setValue(temph2);
            controlTemp2.setEnabled(false);
            aire_acondicionado2.setText("Aire acondicionado: OFF");
            aire_acondicionado2.setForeground(Color.RED);
            tempHab2.setText(Float.toString(temp_casa));
        }
        
        //Luces hab3
        if(this.estados.get(14).equals("1")){
            cargarImagen(hab3Icon, img_hab3);
            luz5.setSelected(false);
            luz5.setText("Luces: ON");
            luz5.setForeground(Color.GREEN);
        }else{
            cargarImagen(hab3AIcon, img_hab3);
            luz5.setSelected(true);
            luz5.setText("Luces: OFF");
            luz5.setForeground(Color.RED);
        }
        
        //Television hab3
        if(this.estados.get(15).equals("1")){
            img_tele2.setVisible(true);
            controlTele2.setSelected(true);
            controlTele2.setText("Televisión: ON");
            controlTele2.setForeground(Color.GREEN);
        }else{
            img_tele2.setVisible(false);
            controlTele2.setSelected(false);
            controlTele2.setText("Televisión: OFF");
            controlTele2.setForeground(Color.RED);
        }
        
        //Ventilador hab3
        if(this.estados.get(16).equals("1")){
            img_venti2.setVisible(true);
            venti2_btn.setSelected(true);
            venti2_btn.setText("Ventilador: ON");
            venti2_btn.setForeground(Color.GREEN);
        }else{
            img_venti2.setVisible(false);
            venti2_btn.setSelected(false);
            venti2_btn.setText("Ventilador: OFF");
            venti2_btn.setForeground(Color.RED);
        }
        
        //Luces baño
        if(this.estados.get(17).equals("1")){
            cargarImagen(bathIcon, img_bath);
            luz6.setSelected(false);
            luz6.setText("Luces: ON");
            luz6.setForeground(Color.GREEN);
        }else{
            cargarImagen(bathAiIcon, img_bath);
            luz6.setSelected(true);
            luz6.setText("Luces: OFF");
            luz6.setForeground(Color.RED);
        }
    }
    
    private void cargaControles(){
        SpinnerNumberModel minisplit = new SpinnerNumberModel(16,16,30,1);
        SpinnerNumberModel minisplit2 = new SpinnerNumberModel(16,16,30,1);
        
        controlTemp1.setModel(minisplit);
        controlTemp2.setModel(minisplit2);
        
        SpinnerNumberModel refri = new SpinnerNumberModel(7,1,7,1);
        control_refri.setModel(refri);
        
        
        SpinnerNumberModel congelador = new SpinnerNumberModel(-14,-25,-14,1);
        control_conge.setModel(congelador);
    }
    
    private void cerrarForm(){
        ImageIcon imagen = new ImageIcon("src/img/salir.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        int opcion=JOptionPane.showConfirmDialog(null, "Está seguro?", "Salir del formulario",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,imagen);
        if(opcion==0)
            this.dispose();
    }
    
    private void cargarImagen(ImageIcon image, JLabel component){
        image = new ImageIcon(image.getImage().getScaledInstance(component.getWidth(),component.getHeight(),Image.SCALE_SMOOTH));
        component.setIcon(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Paneles = new javax.swing.JTabbedPane();
        panel_vGeneral = new javax.swing.JPanel();
        img_alarma = new javax.swing.JLabel();
        img_vistaGral = new javax.swing.JLabel();
        detectorMov_btn = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panel_Sala = new javax.swing.JPanel();
        img_tele1 = new javax.swing.JLabel();
        img_venti1 = new javax.swing.JLabel();
        img_venti1D = new javax.swing.JLabel();
        venti1_btn = new javax.swing.JToggleButton();
        luz1 = new javax.swing.JToggleButton();
        img_sala = new javax.swing.JLabel();
        controlTele1 = new javax.swing.JToggleButton();
        panel_Cocina = new javax.swing.JPanel();
        tempRefri = new javax.swing.JLabel();
        temp_Cong = new javax.swing.JLabel();
        img_horno = new javax.swing.JLabel();
        img_cocina = new javax.swing.JLabel();
        luz2 = new javax.swing.JToggleButton();
        horno = new javax.swing.JToggleButton();
        control_refri = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        control_conge = new javax.swing.JSpinner();
        panel_Hab1 = new javax.swing.JPanel();
        img_hab1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tempHab1 = new javax.swing.JLabel();
        aire_acondicionado1 = new javax.swing.JToggleButton();
        luz3 = new javax.swing.JToggleButton();
        controlTemp1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        panel_Hab2 = new javax.swing.JPanel();
        img_hab2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tempHab2 = new javax.swing.JLabel();
        aire_acondicionado2 = new javax.swing.JToggleButton();
        luz4 = new javax.swing.JToggleButton();
        controlTemp2 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        panel_Hab3 = new javax.swing.JPanel();
        img_tele2 = new javax.swing.JLabel();
        img_venti2 = new javax.swing.JLabel();
        img_venti2D = new javax.swing.JLabel();
        img_hab3 = new javax.swing.JLabel();
        venti2_btn = new javax.swing.JToggleButton();
        luz5 = new javax.swing.JToggleButton();
        controlTele2 = new javax.swing.JToggleButton();
        panel_Bath = new javax.swing.JPanel();
        img_bath = new javax.swing.JLabel();
        luz6 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InteliJ House");
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1366, 720));

        Paneles.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        panel_vGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_alarma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alarma.gif"))); // NOI18N
        img_alarma.setText("jLabel12");
        panel_vGeneral.add(img_alarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 500, 270));

        img_vistaGral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                img_vistaGralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                img_vistaGralMouseExited(evt);
            }
        });
        panel_vGeneral.add(img_vistaGral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 560, 630));

        detectorMov_btn.setText("Detector de movimiento: OFF");
        detectorMov_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectorMov_btnActionPerformed(evt);
            }
        });
        panel_vGeneral.add(detectorMov_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jButton1.setText("Clima exterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_vGeneral.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 170, -1));

        jButton2.setText("Niveles de agua");
        panel_vGeneral.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 160, -1));

        jButton3.setText("Registro de eventos");
        panel_vGeneral.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 160, -1));

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_vGeneral.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 100, -1));

        Paneles.addTab("Vista General", panel_vGeneral);

        panel_Sala.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_tele1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tele.gif"))); // NOI18N
        img_tele1.setText("jLabel7");
        panel_Sala.add(img_tele1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 210, 142));

        img_venti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventilador.gif"))); // NOI18N
        img_venti1.setText("jLabel13");
        panel_Sala.add(img_venti1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 180, 230));

        img_venti1D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventiladorD.jpg"))); // NOI18N
        img_venti1D.setText("jLabel7");
        panel_Sala.add(img_venti1D, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 180, 230));

        venti1_btn.setText("Ventilador: OFF");
        venti1_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venti1_btnActionPerformed(evt);
            }
        });
        panel_Sala.add(venti1_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 90, 160, 30));

        luz1.setText("Luces: ON");
        luz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luz1ActionPerformed(evt);
            }
        });
        panel_Sala.add(luz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 160, 30));

        img_sala.setText("sala_de_estar");
        panel_Sala.add(img_sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1050, 670));

        controlTele1.setText("Televisión: OFF");
        controlTele1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlTele1ActionPerformed(evt);
            }
        });
        panel_Sala.add(controlTele1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 140, 160, 30));

        Paneles.addTab("Sala", panel_Sala);

        panel_Cocina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tempRefri.setBackground(new java.awt.Color(0, 0, 0));
        tempRefri.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tempRefri.setForeground(new java.awt.Color(0, 255, 0));
        tempRefri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempRefri.setText("7 C");
        panel_Cocina.add(tempRefri, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 50, 20));

        temp_Cong.setBackground(new java.awt.Color(0, 0, 0));
        temp_Cong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        temp_Cong.setForeground(new java.awt.Color(0, 255, 0));
        temp_Cong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp_Cong.setText("-14 C");
        panel_Cocina.add(temp_Cong, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 50, 20));

        img_horno.setText("jLabel8");
        panel_Cocina.add(img_horno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 120, 90));

        img_cocina.setText("cocina");
        img_cocina.setToolTipText("");
        panel_Cocina.add(img_cocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 960, 840));

        luz2.setText("Luces: ON");
        luz2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luz2ActionPerformed(evt);
            }
        });
        panel_Cocina.add(luz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 200, -1));

        horno.setText("Horno: OFF");
        horno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hornoActionPerformed(evt);
            }
        });
        panel_Cocina.add(horno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 170, 50));

        control_refri.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                control_refriStateChanged(evt);
            }
        });
        panel_Cocina.add(control_refri, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 120, -1));

        jLabel3.setText("Temperatura del refrigerador:");
        panel_Cocina.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, 220, 30));

        jLabel4.setText("Temperatura del congelador");
        panel_Cocina.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 210, 30));

        control_conge.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                control_congeStateChanged(evt);
            }
        });
        panel_Cocina.add(control_conge, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 120, -1));

        Paneles.addTab("Cocina", panel_Cocina);

        panel_Hab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_hab1.setText("hab1");
        panel_Hab1.add(img_hab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1050, 670));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Temperatura de la habitación:");
        panel_Hab1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, -1, 20));

        tempHab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempHab1.setText("temp");
        panel_Hab1.add(tempHab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 200, 60, 30));

        aire_acondicionado1.setText("Aire acondicionado: OFF");
        aire_acondicionado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aire_acondicionado1ActionPerformed(evt);
            }
        });
        panel_Hab1.add(aire_acondicionado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 70, 160, 30));

        luz3.setText("Luces: ON");
        luz3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luz3ActionPerformed(evt);
            }
        });
        panel_Hab1.add(luz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 160, 30));

        controlTemp1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                controlTemp1StateChanged(evt);
            }
        });
        panel_Hab1.add(controlTemp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 140, 50, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control de temperatura:");
        panel_Hab1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, 140, 20));

        Paneles.addTab("Habitacion 1", panel_Hab1);

        panel_Hab2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_hab2.setText("hab2");
        panel_Hab2.add(img_hab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1050, 670));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Temperatura de la habitación:");
        panel_Hab2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, -1, 20));

        tempHab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempHab2.setText("temp");
        panel_Hab2.add(tempHab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 200, 50, 20));

        aire_acondicionado2.setText("Aire acondicionado: OFF");
        aire_acondicionado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aire_acondicionado2ActionPerformed(evt);
            }
        });
        panel_Hab2.add(aire_acondicionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 70, 160, 30));

        luz4.setText("Luces: ON");
        luz4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luz4ActionPerformed(evt);
            }
        });
        panel_Hab2.add(luz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 160, 30));

        controlTemp2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                controlTemp2StateChanged(evt);
            }
        });
        panel_Hab2.add(controlTemp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 140, 50, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Control de temperatura:");
        panel_Hab2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, 140, 20));

        Paneles.addTab("Habitacion 2", panel_Hab2);

        panel_Hab3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_tele2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tele.gif"))); // NOI18N
        img_tele2.setText("jLabel7");
        panel_Hab3.add(img_tele2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 152, 210, 150));

        img_venti2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventilador.gif"))); // NOI18N
        img_venti2.setText("ventilador2");
        panel_Hab3.add(img_venti2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 180, 230));

        img_venti2D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventiladorD.jpg"))); // NOI18N
        img_venti2D.setText("jLabel7");
        panel_Hab3.add(img_venti2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 180, 230));

        img_hab3.setText("hab3");
        panel_Hab3.add(img_hab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1050, 670));

        venti2_btn.setText("Ventilador: OFF");
        venti2_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venti2_btnActionPerformed(evt);
            }
        });
        panel_Hab3.add(venti2_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 80, 150, -1));

        luz5.setText("Luces: ON");
        luz5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luz5ActionPerformed(evt);
            }
        });
        panel_Hab3.add(luz5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 150, -1));

        controlTele2.setText("Televisión: OFF");
        controlTele2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlTele2ActionPerformed(evt);
            }
        });
        panel_Hab3.add(controlTele2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 120, 150, -1));

        Paneles.addTab("Habitacion 3", panel_Hab3);

        panel_Bath.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_bath.setText("bath");
        panel_Bath.add(img_bath, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1050, 670));

        luz6.setText("Luces: ON");
        luz6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luz6ActionPerformed(evt);
            }
        });
        panel_Bath.add(luz6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 140, -1));

        Paneles.addTab("Baño", panel_Bath);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Paneles)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Paneles)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void venti2_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venti2_btnActionPerformed
        // TODO add your handling code here:
        if(venti2_btn.isSelected()){
            Sonido.play("src/audio/ventilador.wav", false);
            venti2_btn.setText("Ventilador: ON");
            venti2_btn.setForeground(Color.GREEN);
            img_venti2.setVisible(true);
            this.estados.set(16,"1");
        }else{
            Sonido.play("src/audio/ventilador.wav", false);
            venti2_btn.setText("Ventilador: OFF");
            venti2_btn.setForeground(Color.RED);
            img_venti2.setVisible(false);
            this.estados.set(16,"0");
        }
    }//GEN-LAST:event_venti2_btnActionPerformed

    private void aire_acondicionado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aire_acondicionado2ActionPerformed
        // TODO add your handling code here:

        if(aire_acondicionado2.isSelected()){
            aire_acondicionado2.setText("Aire acondicionado: ON");
            aire_acondicionado2.setForeground(Color.GREEN);
            Sonido.play("src/audio/aire_acondicionado.wav",false);
            controlTemp2.setEnabled(true);
            this.tempHab2.setText(controlTemp2.getValue().toString());
            this.estados.set(12,"1");
        }else{
            aire_acondicionado2.setText("Aire acondicionado: OFF");
            aire_acondicionado2.setForeground(Color.RED);
            Sonido.play("src/audio/aire_acondicionado.wav",false);
            controlTemp2.setEnabled(false);
            this.tempHab2.setText(Float.toString(temp_casa));
            this.estados.set(12,"0");;
        }
    }//GEN-LAST:event_aire_acondicionado2ActionPerformed

    private void aire_acondicionado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aire_acondicionado1ActionPerformed
        // TODO add your handling code here:
        float temperature;
        if(aire_acondicionado1.isSelected()){
            aire_acondicionado1.setText("Aire acondicionado: ON");
            aire_acondicionado1.setForeground(Color.GREEN);
            Sonido.play("src/audio/aire_acondicionado.wav",false);
            controlTemp1.setEnabled(true);
            this.tempHab1.setText(controlTemp1.getValue().toString());
            this.estados.set(9,"1");
        }else{
            aire_acondicionado1.setText("Aire acondicionado: OFF");
            aire_acondicionado1.setForeground(Color.RED);
            Sonido.play("src/audio/aire_acondicionado.wav",false);
            controlTemp1.setEnabled(false);
            this.tempHab1.setText(Float.toString(temp_casa));
            this.estados.set(9,"0");
        }
    }//GEN-LAST:event_aire_acondicionado1ActionPerformed

    private void venti1_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venti1_btnActionPerformed
        // TODO add your handling code here:
        if(venti1_btn.isSelected()){
            Sonido.play("src/audio/ventilador.wav", false);
            venti1_btn.setText("Ventilador: ON");
            venti1_btn.setForeground(Color.GREEN);
            img_venti1.setVisible(true);
            this.estados.set(3,"1");
        }else{
            Sonido.play("src/audio/ventilador.wav", false);
            venti1_btn.setText("Ventilador: OFF");
            venti1_btn.setForeground(Color.RED);
            img_venti1.setVisible(false);
            this.estados.set(3,"0");
        }
    }//GEN-LAST:event_venti1_btnActionPerformed

    private void detectorMov_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectorMov_btnActionPerformed
        // TODO add your handling code here:
        if(detectorMov_btn.isSelected()){
            detectorMov_btn.setText("Detector de movimiento: ON");
            detectorMov_btn.setForeground(Color.GREEN);
            this.estados.set(0,"1");
        }else{
            detectorMov_btn.setText("Detector de movimiento: OFF");
            detectorMov_btn.setForeground(Color.RED);
            this.estados.set(0,"0");
        }
    }//GEN-LAST:event_detectorMov_btnActionPerformed

    private void img_vistaGralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_vistaGralMouseExited
        // TODO add your handling code here:
        if(detectorMov_btn.isSelected()){
            img_alarma.setVisible(false);
        }
    }//GEN-LAST:event_img_vistaGralMouseExited

    private void img_vistaGralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_vistaGralMouseEntered
        // TODO add your handling code here:
        if(detectorMov_btn.isSelected()){
            img_alarma.setVisible(true);
        }
    }//GEN-LAST:event_img_vistaGralMouseEntered

    private void hornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hornoActionPerformed
        // TODO add your handling code here:
        if(horno.isSelected()){
            Sonido.play("src/audio/horno.wav", false);
            img_horno.setVisible(true);
            horno.setText("Horno: ON");
            horno.setForeground(Color.GREEN);
            this.estados.set(7,"1");
        }else{
            img_horno.setVisible(false);
            horno.setText("Horno: OFF");
            horno.setForeground(Color.RED);
            this.estados.set(7,"0");
        }
    }//GEN-LAST:event_hornoActionPerformed

    private void luz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luz1ActionPerformed
        // TODO add your handling code here:
        if(luz1.isSelected()){
            Sonido.play("src/audio/switch.wav", false);
            luz1.setText("Luces: OFF");
            luz1.setForeground(Color.RED);
            cargarImagen(salaAIcon, img_sala);
            this.estados.set(1,"0");
        }else{
            Sonido.play("src/audio/switch.wav", false);
            luz1.setText("Luces: ON");
            luz1.setForeground(Color.GREEN);
            cargarImagen(salaIcon, img_sala);
            this.estados.set(1,"1");
        }

    }//GEN-LAST:event_luz1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clima.setLocationRelativeTo(this);
        clima.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cerrarForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void controlTemp1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_controlTemp1StateChanged
        // TODO add your handling code here:
            tempHab1.setText(controlTemp1.getValue().toString());
            this.estados.set(10,tempHab1.getText());
    }//GEN-LAST:event_controlTemp1StateChanged

    private void controlTemp2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_controlTemp2StateChanged
        // TODO add your handling code here

            tempHab2.setText(controlTemp2.getValue().toString());
            this.estados.set(13,tempHab2.getText());
    }//GEN-LAST:event_controlTemp2StateChanged

    private void control_refriStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_control_refriStateChanged
        // TODO add your handling code here:
        tempRefri.setText(control_refri.getValue().toString());
        this.estados.set(5,control_refri.getValue().toString());
    }//GEN-LAST:event_control_refriStateChanged

    private void control_congeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_control_congeStateChanged
        // TODO add your handling code here:
        temp_Cong.setText(control_conge.getValue().toString());
        this.estados.set(6,control_conge.getValue().toString());
    }//GEN-LAST:event_control_congeStateChanged

    private void controlTele1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlTele1ActionPerformed
        // TODO add your handling code here:
        if(controlTele1.isSelected()){
            img_tele1.setVisible(true);
            controlTele1.setText("Televisión: ON");
            controlTele1.setForeground(Color.GREEN);
            this.estados.set(2,"1");
        }else{
            img_tele1.setVisible(false);
            controlTele1.setText("Televisión: OFF");
            controlTele1.setForeground(Color.RED);
            this.estados.set(2,"0");
        }
    }//GEN-LAST:event_controlTele1ActionPerformed

    private void controlTele2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlTele2ActionPerformed
        // TODO add your handling code here:
        if(controlTele2.isSelected()){
            img_tele2.setVisible(true);
            controlTele2.setText("Televisión: ON");
            controlTele2.setForeground(Color.GREEN);
            this.estados.set(15,"1");
        }else{
            img_tele2.setVisible(false);
            controlTele2.setText("Televisión: OFF");
            controlTele2.setForeground(Color.RED);
            this.estados.set(15,"0");
        }
    }//GEN-LAST:event_controlTele2ActionPerformed

    private void luz3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luz3ActionPerformed
        // TODO add your handling code here:
        if(luz3.isSelected()){
            Sonido.play("src/audio/switch.wav", false);
            luz3.setText("Luces: OFF");
            luz3.setForeground(Color.RED);
            cargarImagen(hab1AIcon, img_hab1);
            this.estados.set(8,"0");
        }else{
            Sonido.play("src/audio/switch.wav", false);
            luz3.setText("Luces: ON");
            luz3.setForeground(Color.GREEN);
            cargarImagen(hab1Icon, img_hab1);
            this.estados.set(8,"1");
        }
    }//GEN-LAST:event_luz3ActionPerformed

    private void luz4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luz4ActionPerformed
        // TODO add your handling code here:
        if(luz4.isSelected()){
            Sonido.play("src/audio/switch.wav", false);
            luz4.setText("Luces: OFF");
            luz4.setForeground(Color.RED);
            cargarImagen(hab2AIcon, img_hab2);
            this.estados.set(11,"0");
        }else{
            Sonido.play("src/audio/switch.wav", false);
            luz4.setText("Luces: ON");
            luz4.setForeground(Color.GREEN);
            cargarImagen(hab2Icon, img_hab2);
            this.estados.set(11,"1");
        }
    }//GEN-LAST:event_luz4ActionPerformed

    private void luz2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luz2ActionPerformed
        // TODO add your handling code here:
        if(luz2.isSelected()){
            Sonido.play("src/audio/switch.wav", false);
            luz2.setText("Luces: OFF");
            luz2.setForeground(Color.RED);
            cargarImagen(cocinaAiIcon, img_cocina);
            this.estados.set(4,"0");
        }else{
            Sonido.play("src/audio/switch.wav", false);
            luz2.setText("Luces: ON");
            luz2.setForeground(Color.GREEN);
            cargarImagen(cocinaIcon, img_cocina);
            this.estados.set(4,"1");
        }
    }//GEN-LAST:event_luz2ActionPerformed

    private void luz5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luz5ActionPerformed
        // TODO add your handling code here:
        if(luz5.isSelected()){
            Sonido.play("src/audio/switch.wav", false);
            luz5.setText("Luces: OFF");
            luz5.setForeground(Color.RED);
            cargarImagen(hab3AIcon, img_hab3);
            this.estados.set(14,"0");
        }else{
            Sonido.play("src/audio/switch.wav", false);
            luz5.setText("Luces: ON");
            luz5.setForeground(Color.GREEN);
            cargarImagen(hab3Icon, img_hab3);
            this.estados.set(14,"1");
        }
    }//GEN-LAST:event_luz5ActionPerformed

    private void luz6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luz6ActionPerformed
        // TODO add your handling code here:
        if(luz6.isSelected()){
            Sonido.play("src/audio/switch.wav", false);
            luz6.setText("Luces: OFF");
            luz6.setForeground(Color.RED);
            cargarImagen(bathAiIcon, img_bath);
            this.estados.set(17,"0");
        }else{
            Sonido.play("src/audio/switch.wav", false);
            luz6.setText("Luces: ON");
            luz6.setForeground(Color.GREEN);
            cargarImagen(bathIcon, img_bath);
            this.estados.set(17,"1");
        }
    }//GEN-LAST:event_luz6ActionPerformed

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
            java.util.logging.Logger.getLogger(FORM_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORM_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORM_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORM_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORM_INICIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Paneles;
    private javax.swing.JToggleButton aire_acondicionado1;
    private javax.swing.JToggleButton aire_acondicionado2;
    private javax.swing.JToggleButton controlTele1;
    private javax.swing.JToggleButton controlTele2;
    private javax.swing.JSpinner controlTemp1;
    private javax.swing.JSpinner controlTemp2;
    private javax.swing.JSpinner control_conge;
    private javax.swing.JSpinner control_refri;
    private javax.swing.JToggleButton detectorMov_btn;
    private javax.swing.JToggleButton horno;
    private javax.swing.JLabel img_alarma;
    private javax.swing.JLabel img_bath;
    private javax.swing.JLabel img_cocina;
    private javax.swing.JLabel img_hab1;
    private javax.swing.JLabel img_hab2;
    private javax.swing.JLabel img_hab3;
    private javax.swing.JLabel img_horno;
    private javax.swing.JLabel img_sala;
    private javax.swing.JLabel img_tele1;
    private javax.swing.JLabel img_tele2;
    private javax.swing.JLabel img_venti1;
    private javax.swing.JLabel img_venti1D;
    private javax.swing.JLabel img_venti2;
    private javax.swing.JLabel img_venti2D;
    private javax.swing.JLabel img_vistaGral;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton luz1;
    private javax.swing.JToggleButton luz2;
    private javax.swing.JToggleButton luz3;
    private javax.swing.JToggleButton luz4;
    private javax.swing.JToggleButton luz5;
    private javax.swing.JToggleButton luz6;
    private javax.swing.JPanel panel_Bath;
    private javax.swing.JPanel panel_Cocina;
    private javax.swing.JPanel panel_Hab1;
    private javax.swing.JPanel panel_Hab2;
    private javax.swing.JPanel panel_Hab3;
    private javax.swing.JPanel panel_Sala;
    private javax.swing.JPanel panel_vGeneral;
    public static javax.swing.JLabel tempHab1;
    public static javax.swing.JLabel tempHab2;
    private javax.swing.JLabel tempRefri;
    private javax.swing.JLabel temp_Cong;
    private javax.swing.JToggleButton venti1_btn;
    private javax.swing.JToggleButton venti2_btn;
    // End of variables declaration//GEN-END:variables
}
