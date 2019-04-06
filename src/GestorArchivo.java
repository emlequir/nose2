
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author licho
 */
public class GestorArchivo {

    public void crearDirectorio() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese directorio ");
        String ruta = teclado.nextLine();
        Path directorio = Paths.get(ruta);
        if (Files.exists(directorio)) {
            System.out.println("El directorio ya existe");
        } else {
            try {
                Files.createDirectories(directorio);
                System.out.println("El directorio fue creado");
            } catch (IOException e) {
                System.out.println("El directorio no pudo ser creado");
            }
        }
    }

    public void crearArchivo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa del archivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        System.out.println("Ingrese el texto a guardar en el archivo");
        String texto = teclado.nextLine();
        try {
            Files.write(archivo, texto.getBytes());
            System.out.println("Se ha guardado el archivo");
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser guardado");
        }
    }

    public void leerArchivo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa del arhivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es:\n" + texto);
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
    }

    public void copiarArchivo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo original");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        System.out.println("Ingrese la ruta de destino de la copia");
        String newRuta = teclado.nextLine();
        Path newArchivo = Paths.get(newRuta);
        try {
            Files.copy(archivo, newArchivo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("El archivo fue copiado exitosamente");
        } catch (IOException e) {
            System.out.println("El achivo no pudo ser copiado");
        }
    }

    public void eliminarArchivo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        try {
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fue eliminado exitosamente");
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser eliminado");
        }
    }

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Selecciona la operación a realizar");
        System.out.println("1- Crear directorio");
        System.out.println("2- Crear archivo de texto");
        System.out.println("3- Leer archivo de texto");
        System.out.println("4- Copiar archivo");
        System.out.println("5- Eliminar arhivo");

        int opcion = teclado.nextInt();
        seleccion(opcion);
    }

    public void seleccion(int open) {
        switch (open) {
            case 1:
                crearDirectorio();
                break;
            case 2:
                crearArchivo();
                break;
            case 3:
                leerArchivo();
                break;
            case 4:
                copiarArchivo();
                break;
            case 5:
                eliminarArchivo();
                break;
        }
    }

}
