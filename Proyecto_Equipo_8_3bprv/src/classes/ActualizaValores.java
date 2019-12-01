/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.SwingWorker;

/**
 *
 * @author Everardo
 */
public class ActualizaValores extends SwingWorker<Void, Void>{
    ArrayList<String> lista_status_actual;     //Display status of calculation
    ArrayList<String> lista_status_anterior;
    String valorAct,valorAnt; 
    Iterator<String> itrActual, itrAnterior;
    //Iterator<String> itrAnterior;
    //=new ArrayList<>();
    
    //Constructor
    public ActualizaValores(ArrayList lista) {
        lista_status_actual= lista;
    }
    
    public Void doInBackground(){
        Archivos reader = new Archivos();
        reader.leeArchivo("estado_actual.txt");
        String[] buffer = reader.getCadena().split(",");
        for(String e: buffer){
            lista_status_actual.add(e);
        }
        lista_status_anterior = (ArrayList) lista_status_actual.clone();  
        while(true){
        if (isCancelled())    //if calcultion is canceled
         { 
           return null;
         }
        else
            { try
               {
                boolean cambios=false;
                int indice=0;
                //String valoresTotales="";
                itrActual = lista_status_actual.iterator();
                itrAnterior = lista_status_anterior.iterator();
                while(itrActual.hasNext()){
                      valorAct=itrActual.next();
                      valorAnt=itrAnterior.next();
                      if (!valorAct.equals(valorAnt)){
                          lista_status_anterior.set(indice, valorAct);
                          cambios=true;
                          //System.out.println("Hay un cambio");
                      }
                      indice++;
                      //valoresTotales+=lista_status_actual.get(indice);
                      //System.out.printf("%s",lista_status_actual.get(indice));
                }
             
                if (cambios==true)
                {   valorAnt="";
                    File archivo = new File("estado_actual.txt");
                    FileWriter guardar = new FileWriter(archivo,false);
                    itrAnterior = lista_status_anterior.iterator();
                    while(itrAnterior.hasNext()){
                        valorAnt+=itrAnterior.next();
                        if (itrAnterior.hasNext())
                            valorAnt+=",";
                    }
                    guardar.write(valorAnt);
                    guardar.close();
                }
                Thread.sleep(1000);
               } //end try
             catch (InterruptedException ex)
               { 
                 return null;
               } // end catch
              catch (IOException ex2)
              {  
              }
            } // end else  
        }
    } // end method doInBackground {
    
}
