/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



/**
 *
 * @author kevin
 */



public class ClimaActual {
    
    public String TEXT;
    public float TEMPERATURE;
    public int HUMEDITY;
    public String ICON;
    
    public void obtenerClima(String KEY, String LOCATION_KEY, String LANGUAGE, String DETAILS) throws MalformedURLException, IOException{
        String RESOURCE = "http://dataservice.accuweather.com/currentconditions/v1/236233?apikey="+KEY+"&language="+LANGUAGE+"&details="+DETAILS;
        StringBuilder result = new StringBuilder();  
        URL url = new URL(RESOURCE);
        URLConnection conn = url.openConnection();
        BufferedReader response = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line=response.readLine())!=null){
            String[] values = line.split(",");
//            for(String e : values){
//                System.out.println(e);
//            }
            String[] values2;
            
            values2= values[2].split(":");
            this.TEXT=values2[1];
            
            values2= values[7].split(":");
            this.TEMPERATURE=Float.parseFloat(values2[3]);
            
            values2= values[25].split(":");
            this.HUMEDITY=Integer.parseInt(values2[1]);
            
            values2= values[3].split(":");
            this.ICON=values2[1];
       }
    }
}