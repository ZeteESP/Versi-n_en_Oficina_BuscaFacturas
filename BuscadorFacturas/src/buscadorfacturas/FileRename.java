/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfacturas;

/**
 *
 * @author Adrián
 */
public class FileRename {
    
    public FileRename(String nombreInicial, String nombreFinal) throws Exception {
        Runtime r = Runtime.getRuntime();
        String[] comando = {"cmd", "/C", "ren "+ponerComitasCarpetasConEspacios(nombreInicial)+" "+ponerComitasCarpetasConEspacios(nombreFinal)};
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
    
    
    
}
