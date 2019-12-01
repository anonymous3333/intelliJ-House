/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class Archivos {
    private String cadena;
    
    public void leeArchivo(String path){
        String content = null;
        try {
            
            java.io.FileReader fr = new java.io.FileReader(path);
            try (BufferedReader br = new BufferedReader(fr)) {
                while((content=br.readLine())!=null){
                    this.cadena=content;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Ourrió un error al intentar abrir el archivo");
        }
    }
    
    public void escribeArchivo(String content,String path,boolean append){
        try {
            try (FileWriter fw = new FileWriter(path, append)) {
                fw.write(content+"\n");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar escribir en el archivo...");
        }
        
    }

    public String getCadena() {
        return cadena;
    }
}
