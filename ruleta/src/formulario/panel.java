/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;
import clases.clsListaCircular;
import clases.lscolor;
import nodos.nodoLD;
import nodos.coloresnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author eduard
 */
public class panel extends javax.swing.JFrame {

    private clsListaCircular oblc;
    private lscolor colores;
    private int px,py,auxz;
    private double radianes;
    public boolean bandera;
    
    /**
     * Creates new form panel
     */
    public panel() {
        initComponents();
        this.oblc=new clsListaCircular();
        this.colores=new lscolor();
        this.bandera=false;
        px = 10;
        radianes=0;
        py = 40;
        auxz=0;
    }

    public void apuntaganador(){
        Graphics gg = this.getGraphics();
        gg.setColor(Color.red);
        int x[]={110,90,130};
        int y[]={50,0,0};
        gg.fillPolygon(x,y,3);
    }
    
    public void graficadorintegrantes(){
        Graphics gg = this.getGraphics();
        gg.clearRect(px+220, py, 100, 400);
        nodoLD nodoaux = this.oblc.getListaC();
        nodoLD nodoaux1 = this.oblc.getListaC();
        int i =0;
        this.oblc.longituddecircular();
        int cuadro=py;
        int texto=py+15;
        
        lscolor objAuxLD = new lscolor();
        objAuxLD.setIndex(this.colores.getIndex());
        objAuxLD.irPrimero();
        
        coloresnd nodoLDPri = objAuxLD.getIndex();
        
        while(nodoaux!=null){
            int rojo = nodoLDPri.getRojo();
            int azul = nodoLDPri.getAzul();
            int verde = nodoLDPri.getVerde();
            String ss = nodoaux.getDetalle();
            gg.setColor(new Color(rojo,verde, azul));
            if (nodoaux.getRefDer()==nodoaux1) {
                if (i==0) {
                    gg.fillRect(px+220, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                }
                else{
                    gg.fillRect(px+220, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                }
                nodoaux=null;
            }else{
                if (i==0) {
                    gg.fillRect(px+220, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                }
                else{
                    gg.fillRect(px+220, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                }
                cuadro=cuadro+30;
                texto=texto+30;
                nodoaux=nodoaux.getRefDer();
            }
            i++;
            nodoLDPri = nodoLDPri.getRefDer();
        }
    }
    
    public void graficarlistacircular(String Iniciado){
        Graphics gg = this.getGraphics();
        Graphics2D g2d=(Graphics2D)gg;
        gg.clearRect(px, py, 200, 200);
        
        if (Iniciado=="Si") {
            this.radianes=this.radianes+0.25;
            g2d.rotate(this.radianes,110,140);
            //g2d.scale(0.7,0.7);
            //g2d.translate(5, 5);
            //6.25 vuelta completa
        }
        
        nodoLD nodoaux = this.oblc.getListaC();
        nodoLD nodoaux1 = this.oblc.getListaC();
        int i =0;
        this.oblc.longituddecircular();
        int longitud=this.oblc.getLongi();
        int sumagrados=0;
        int cuadro=py;
        int texto=py+15;
        
        lscolor objAuxLD = new lscolor();
        objAuxLD.setIndex(this.colores.getIndex());
        objAuxLD.irPrimero();
        
        coloresnd nodoLDPri = objAuxLD.getIndex();
        
        while(nodoaux!=null){
            int grados=0;
            int rojo = nodoLDPri.getRojo();
            int azul = nodoLDPri.getAzul();
            int verde = nodoLDPri.getVerde();
            g2d.setColor(new Color(rojo,verde, azul));
            if (nodoaux.getRefDer()==nodoaux1) {
                if (i==0) {
                    grados = 1 * 360 / 1;
                    g2d.fillArc(10, py, 200, 200, 0, grados);
                    sumagrados=sumagrados+grados;
                }
                else{
                    grados = 1 * 360 / longitud;
                    g2d.fillArc(10, py, 200, 200, sumagrados, grados);
                    sumagrados=sumagrados+grados;
                }
                nodoaux=null;
            }else{
                if (i==0) {
                    grados = 1 * 360 / longitud;
                    g2d.fillArc(10, py, 200, 200, 0, grados);
                    sumagrados=sumagrados+grados;
                }
                else{
                    grados = 1 * 360 / longitud;
                    g2d.fillArc(10, py, 200, 200, sumagrados, grados);
                    sumagrados=sumagrados+grados;
                }
                cuadro=cuadro+30;
                texto=texto+30;
                nodoaux=nodoaux.getRefDer();
            }
            i++;
            nodoLDPri = nodoLDPri.getRefDer();
        }
    }
    
    public void movercoloresruleta(){
        int con=0;
        int limite=this.oblc.getLongi()*ThreadLocalRandom.current().nextInt(20, 35);
        int velocidad=0;
        String Iniciado="No";
        graficarlistacircular(Iniciado);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fallo");
        }
        while(this.bandera==false){
            if (con<100) {
                velocidad=100;
            }
            else if(con <150){
                velocidad=150;
            }else{
                velocidad=200;
            }
            try {
                Thread.sleep(velocidad);
                Iniciado="Si";
                graficarlistacircular(Iniciado);
                apuntaganador();
                con++;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Fallo");
            }
            if (con==limite) {
                this.bandera=true;
            }
        }
        determinacionganador();
        this.bandera=false;
        mostradormensajeganador();
    }
        
    public void mostradormensajeganador(){
        JOptionPane.showMessageDialog(this, "Ganador "+this.oblc.getCadganador());
    }
    
    public void determinacionganador(){
        double totalvueltas;
        if (this.oblc.getLongi()<=5) {
            totalvueltas=this.radianes/6;
        }
        else if(this.oblc.getLongi()>5 && this.oblc.getLongi()<=8){
            totalvueltas=this.radianes/6.10;
        }
        else if(this.oblc.getLongi()==9 || this.oblc.getLongi()==10){
            totalvueltas=this.radianes/6.19;
        }
        else if(this.oblc.getLongi()==11){
            totalvueltas=this.radianes/6.15;
        }
        else{
            totalvueltas=this.radianes/6.20;
        }
        while(totalvueltas>=1.00){
            totalvueltas--;
        }
        double gradoscirculo = totalvueltas*100;//1
        int porcentaje=100/this.oblc.getLongi();//12.5
        boolean bag=false;
        int auxactual=0;
        int auxsiguiente=porcentaje;
        int nodoi=0;
        int nodoaux=0;
        while(bag==false && gradoscirculo!=0){
            if (gradoscirculo>=auxactual && gradoscirculo<auxsiguiente) {
                bag=true;
                nodoaux=nodoi;
            }
            auxactual=auxsiguiente;
            auxsiguiente=auxsiguiente+porcentaje;
            nodoi++;
        }
        this.oblc.funcionganadores(nodoaux);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        praticipante_text = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        praticipante_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel.setText("Nombre:");

        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton2.setText("Jugar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(praticipante_text))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(praticipante_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rojo = ThreadLocalRandom.current().nextInt(0, 255);
        int verde = ThreadLocalRandom.current().nextInt(0, 255);
        int azul = ThreadLocalRandom.current().nextInt(0, 255);
        this.colores.insertarDer(rojo, verde, azul);
        int cod = this.oblc.getLongi();
        String ss = praticipante_text.getText();
        praticipante_text.setText("");
        this.oblc.insertarDer(cod, ss);
        String Iniciado="No";
        graficarlistacircular(Iniciado);
        graficadorintegrantes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.radianes=0;
        movercoloresruleta();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel;
    private javax.swing.JTextField praticipante_text;
    // End of variables declaration//GEN-END:variables
}
