/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfacturas;

import java.io.*;

/**
 *
 * @author Adrián
 */
public class FileCopy {

    @SuppressWarnings("empty-statement")
    public void cmdDir() throws Exception {
        Runtime r = Runtime.getRuntime();
        String[] comando = {"cmd", "/C", "dir"};
        Process p = r.exec(comando);
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String texto;
            while ((texto = bR.readLine()) != null) {
                System.out.println(texto);
            }
        }
    }

    public FileCopy(String pathFactura, String destino) throws Exception {
        Runtime r = Runtime.getRuntime();
        String[] comando = {"cmd", "/C", "copy "+ponerComitasCarpetasConEspacios(pathFactura)+" "+ponerComitasCarpetasConEspacios(destino)};
        System.out.println("filecopy" + comando[2] );
        Process p = r.exec(comando);
    }
    
    public String ponerComitasCarpetasConEspacios(String path  ){
        System.out.println(path);
        String [] carpetas=path.replace('\\', '/').split("/");
        String pathCMD="";
        
        for (int i = 0 ; i< carpetas.length;i++){
            if (carpetas[i].contains(" ")){
                carpetas [i]="\""+carpetas[i]+"\"";
            }
            if (i<carpetas.length-1)
            pathCMD += carpetas[i]+"/";
            else pathCMD += carpetas[i];
        }   
        return pathCMD.replace('/','\\');
    }
    
    public static void main(String[] args) throws Exception {
//        FileCopy fileCopy = new FileCopy("C:\\Desert.jpg","C:\\FUNDACIO\\\"CARPETA FACTURAS\"");
    }
}
