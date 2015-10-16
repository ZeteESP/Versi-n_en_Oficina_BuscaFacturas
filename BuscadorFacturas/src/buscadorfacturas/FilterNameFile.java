/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfacturas;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Adrián
 */
public class FilterNameFile implements FilenameFilter {

    String nombre;
    FilterNameFile(String nombre){
        this.nombre=nombre;
    }
    
    @Override
    public boolean accept(File dir, String name) {
        
        return nombre.equals(name);
    }
    
}
