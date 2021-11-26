package manejoarchivos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ManejoArchivos {
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        //con esto creamos un objeto del tipo "File en memoria"
        try {
            //para creear el archivo en el hd hacemos lo siguiente:
            PrintWriter salida = new PrintWriter(archivo);
            // cerramos el flujo
            //cerramos el archivo
            salida.close();
            //cuando mandamos a llamar el metodo, se creea el archivo
            System.out.println("Se ha creeado el archivo");
            
        } catch (FileNotFoundException ex) {
            //reportamos la excepcion
            ex.printStackTrace(System.out);
        }
        
    }
    // escribimos el archivo, lo sobreescribimos no agrega(ojo)
    public static void escribirArchivo(String nombreArchivo, String contenido){
         File archivo = new File(nombreArchivo);
        //con esto creamos un objeto del tipo "File en memoria"
        try {
            //para creear el archivo en el hd hacemos lo siguiente:
            PrintWriter salida = new PrintWriter(archivo);
//            sobreacargamos el metdo
            
            salida.println(contenido);
            
            // cerramos el flujo
            //cerramos el archivo
            salida.close();
            //cuando mandamos a llamar el metodo, se creea el archivo
            System.out.println("Se ha escrito el archivo");
            
        } catch (FileNotFoundException ex) {
            //reportamos la excepcion
            ex.printStackTrace(System.out);
        }
    }
    // creamos un metodo para agregar contenido al archivo
    
    public static void anexarArchivo(String nombreArchivo, String contenido){
         File archivo = new File(nombreArchivo);
        //con esto creamos un objeto del tipo "File en memoria"
        try {
           
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            //filewriter nombremos el archivo y con el true, confirmamos la sobreescritura
//            sobreacargamos el metdo
            
            salida.println(contenido);
            
            // cerramos el flujo
            //cerramos el archivo
            salida.close();
            //cuando mandamos a llamar el metodo, se creea el archivo
            System.out.println("Se ha anexado contenido al archivo");
            
        } catch (FileNotFoundException ex) {
            //reportamos la excepcion
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void leerArchivo(String nombreArchivo){
        var archivo = new File(nombreArchivo);
        try {
            //para leer archivos utilisamo bufferreader(lee lineas completas)
            // filereader no lee lineas completas
            //creeamos el objeto buffer reader
            var entrada =new BufferedReader(new FileReader(archivo));
            //definimos las variables para leer lineas completas del archivo
            var lectura = entrada.readLine();
            //recorremos y leemos las lineas con un ciclo while
            while(lectura != null){//leemos hasta que haya una linea en blanco
                System.out.println("lectura = " + lectura);
                //seguimos leyendo 
                lectura = entrada.readLine();
            }
            entrada.close();
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
