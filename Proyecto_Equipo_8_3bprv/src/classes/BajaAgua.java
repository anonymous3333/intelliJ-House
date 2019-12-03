/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 *
 * @author kevin
 */
public class BajaAgua extends SwingWorker<Void, Void>{
    
    private final JProgressBar lBar;  //Barra de progreso con el el porcentaje de agua
    private final JLabel nllaves;     //Label con el número de llaves abiertas
    private final JLabel porcentaje;  //Label con el porcentaje de agua
    private final JToggleButton llave_paso;   //Botón de llave de paso
    private boolean stop=false;     //Bandera de continuación
    private int dif;    //Diferencia entre llaves abiertas
    
    public BajaAgua(JProgressBar bar,JLabel nllaves,JLabel porcentaje,JToggleButton llave_paso){
        this.lBar=bar;
        this.nllaves=nllaves;
        this.porcentaje=porcentaje;
        this.llave_paso=llave_paso;
    }
    
    @Override
    public Void doInBackground(){
        this.lBar.setOrientation(SwingConstants.VERTICAL);
        this.lBar.setValue(Integer.parseInt(porcentaje.getText()));
        try {
            while(true){
                dif=Integer.parseInt(nllaves.getText());
                //Si la llave de paso está abierta y la cantidad de agua está dentro de los límites, quita el bloqueo
                if(llave_paso.isSelected() && Integer.parseInt(porcentaje.getText())<=100 && Integer.parseInt(porcentaje.getText())>=0){
                    stop=false;
                }
                
                //Si no hay llaves abiertas, la llave de paso está abierta, y el llenado no está detenido
                //entonces llena el tanque
                if(dif==0 && llave_paso.isSelected() && stop==false){
                    porcentaje.setText(Integer.toString(Integer.parseInt(porcentaje.getText())+10));
                    lBar.setValue(Integer.parseInt(porcentaje.getText()));
                }else if(dif>0 && stop==false){//Si hay llaves abiertas y no está bloqueado vacía baja el nivel del agua
                    porcentaje.setText(Integer.toString(Integer.parseInt(porcentaje.getText())-dif));
                    lBar.setValue(Integer.parseInt(porcentaje.getText()));
                }
                //Si se sale de los límites detiene el llenado/vaciado
                if(Integer.parseInt(porcentaje.getText())<0 || Integer.parseInt(porcentaje.getText())>100){
                    this.done();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió el proceso");
            return null;
        }
    }

    @Override
    protected void done() {
        stop=true;
        if(Integer.parseInt(porcentaje.getText())<=0){
            this.porcentaje.setText("0");
        }else if(Integer.parseInt(porcentaje.getText())>=100){
            this.porcentaje.setText("100");
        }
    }    
}
