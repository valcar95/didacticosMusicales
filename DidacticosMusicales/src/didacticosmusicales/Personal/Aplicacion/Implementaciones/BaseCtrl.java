package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BaseCtrl {
    private final String RutaArchivoLog="C:\\didacticosMusicales\\didacticos-musicales.txt";
    private final String DirectorioArchivo="C:\\didacticosMusicales";

    public BaseCtrl(){
        this.CrearArchivoSiNoExiste();
    }

    protected void RegistrarLog(Exception e){
        try{
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            String metodo=stackTraceElements[2].getMethodName();
            String mensaje=e.getMessage();
            if(mensaje==null){
                mensaje=e.getClass().toString();
            }
            String separadorLinea=System.getProperty( "line.separator" );
            FileWriter fileStream = new FileWriter(RutaArchivoLog,true);
            fileStream.append("------------------------------------------------------------");
            fileStream.append(separadorLinea+"Transacción: "+metodo);
            fileStream.append(separadorLinea+"Modulo: Personal");
            fileStream.append(separadorLinea+"Error: "+mensaje);
            fileStream.append(separadorLinea+"Fecha y Hora: "+(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")).format(new Date()));
            fileStream.append(separadorLinea+"------------------------------------------------------------");
            fileStream.append(separadorLinea);
            fileStream.append(separadorLinea);
            fileStream.close();
        }
        catch (Exception ex){}
    }

    private void CrearArchivoSiNoExiste(){
        try{
            Path dir = Paths.get(DirectorioArchivo);
            if (!Files.exists(dir)){
                Files.createDirectories(dir);
            }
            File f = new File(RutaArchivoLog);
            if(!(f.exists() && !f.isDirectory())) {
                Path file = Paths.get(RutaArchivoLog);
                Files.write(file, new ArrayList<String>(), Charset.forName("UTF-8"));
            }
        }catch(Exception ex){}
    }
}
