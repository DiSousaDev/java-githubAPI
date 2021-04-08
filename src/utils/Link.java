/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author ederc
 */
public class Link {
    
    
    public static void abrir(String url) {
        
        Desktop desktop = Desktop.getDesktop();
        
        URI uri = null;
        
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir link" + e);
        }
        
        try {
            desktop.browse(uri);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir link" + e);
        }
    }
    
    
}


