package classes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.SwingWorker;

public class ObtenerClima extends SwingWorker<Void, Void>{
    JLabel text,temp,hum,icon;

    public ObtenerClima(JLabel text, JLabel temp, JLabel hum, JLabel icon) {
        this.text = text;
        this.temp = temp;
        this.hum = hum;
        this.icon = icon;
    }

    
    
    public Void doInBackground() throws InterruptedException{
        while(true){
            if(isCancelled()){
                return null;
            }
            try {
                String RESOURCE = "http://dataservice.accuweather.com/currentconditions/v1/236233?apikey=xA1ZR50q3VyDU5pVGZ7gwvyxugBLGWM2&language=es-MX&details=true"; 
                URL url = new URL(RESOURCE);
                URLConnection conn = url.openConnection();
                BufferedReader response = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line=response.readLine())!=null){
                    String[] values = line.split(",");

                    String[] values2;

                    values2= values[2].split(":");
                    this.text.setText(values2[1]);

                    values2= values[7].split(":");
                    this.temp.setText(values2[3]);

                    values2= values[25].split(":");
                    this.hum.setText(values2[1]);

                    values2= values[3].split(":");
                    ImageIcon icon = new ImageIcon("src/icons/"+values2[1]+".png");
                    //icon = new ImageIcon(icon.getImage().getScaledInstance(this.icon.getWidth(),this.icon.getHeight(),Image.SCALE_SMOOTH));
                    this.icon.setIcon(icon);
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("No se pudo establecer la conexión con el servidor");
                return null;
            }
            Thread.sleep(3600000);
        }
    }

    
    
}