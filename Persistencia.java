import java.io.*;
import java.io.IOException;

public class Persistencia{
    public static void crearBasura() throws IOException{
        File impHistorial = new File("historial.txt");
        FileWriter writer = null;
        PrintWriter pw = null;

        if(!impHistorial.exists()){
            try{
                impHistorial.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creando el archivo");
            }
        }
        try{
            writer = new FileWriter(impHistorial, true);
            pw = new PrintWriter(writer);
            pw.println("Nombre: "+ Entrada.pedirNombre());
            pw.println("Documento: " + Entrada.pedirIdentificacion());
            pw.println("Caneca: " + Entrada.color);
            pw.println("Material: " + Entrada.pedirMaterial());
            pw.println("Color: " + Entrada.pedirColor());
            pw.println("Calificacion: " + Salida.pedirCalificacion());
        }catch(IOException exception){
            System.err.println("Error escribiendo en el archivo");
        }finally{
            try{
                if (null != writer)
                writer.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}


