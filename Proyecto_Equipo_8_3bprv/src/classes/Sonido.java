/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Sonido {
    
    public static void play(File archivo){
        try {
            Clip clip=AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(archivo);
            clip.open(ais);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            JOptionPane.showMessageDialog(null,"Ocurrió un error al abrir el archivo");
        }
    }
}
