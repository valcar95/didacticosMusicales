/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hecto
 */
public class ConexionBD {

    private Produccion produccion;
    private String direccionProveedores;
    private String direccionPedidos;
    private String direccionProductos;
    private String direccionMateriales;

    public ConexionBD(Produccion p) {
        this.direccionProveedores = new File("proveedores.txt").getAbsolutePath();
        this.direccionPedidos = new File("pedidos.txt").getAbsolutePath();
        this.direccionProductos = new File("productos.txt").getAbsolutePath();
        this.direccionMateriales = new File("materiales.txt").getAbsolutePath();
        this.produccion = p;
        System.out.println (new File (".").getAbsolutePath ());
        this.iniciar();
    }

    public void iniciar() {

        try {
            FileReader fr = new FileReader(direccionProveedores);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null && line != "") {
                cargarProveedor(line);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione el archivo correcto");
        }
        try {
            FileReader fr = new FileReader(direccionPedidos);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null && line != "") {
                cargarPedidos(line);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione el archivo correcto");
        }
        try {

            FileReader fr = new FileReader(direccionProductos);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null && line != "") {
                cargarProducto(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "");
        }
        try {

            FileReader fr = new FileReader(direccionMateriales);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null && line != "") {
                cargarMaterial(line);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "");
        }

    }

    private void cargarProveedor(String texto) {
        ArrayList<String> p = new ArrayList();
        char[] x = texto.toCharArray();
        boolean esTelefono = false;
        boolean esWeb = false;
        boolean esMatPro = false;
        boolean esPUM = false;
        boolean esTEM = false;
        String t = "";
        int posicion = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == ',' && esTelefono == false) {
                p.add(t);
                esTelefono = true;
                t = "";
            } else if (x[i] == ',' && esWeb == false) {
                p.add(t);
                esWeb = true;
                t = "";
            } else if (x[i] == ',' && esMatPro == false) {
                p.add(t);
                t = "";
            } else if (x[i] == '[' && esMatPro == false) {
                p.add(t);
                esMatPro = true;
                t = "";

            } else if (x[i] == ',' && esMatPro == true && esPUM == false) {
                p.add(t);
                t = "";
                esPUM = true;
            } else if (x[i] == ',' && esMatPro == true && esTEM == false) {
                p.add(t);
                t = "";
                esTEM = true;
            } else if (x[i] == ']' && esMatPro == true) {
                p.add(t);
                t = "";
                esMatPro = false;
                posicion = i;
                esPUM = false;
                esTEM = false;
                i = x.length;
            } else if (x[i] != ']' && x[i] != ',' && x[i] != '[') {
                t = t + x[i];
            }

        }

        produccion.ingresarNuevoProveedor(p.get(0), p.get(1), p.get(2), p.get(3), Integer.parseInt(p.get(4)), Integer.parseInt(p.get(5)), true);
        String nombrePro = p.get(0);

        if (posicion >= x.length) {
            return;
        }
        for (int i = posicion + 1; i < x.length; i++) {

            if (x[i] == '[' && esMatPro == false) {
                esMatPro = true;
                t = "";
                p.clear();
            } else if (x[i] == ',' && esMatPro == true && esPUM == false) {
                p.add(t);
                t = "";
                esPUM = true;
            } else if (x[i] == ',' && esMatPro == true && esTEM == false) {
                p.add(t);
                t = "";
                esTEM = true;
            } else if (x[i] == ']' && esMatPro == true) {
                p.add(t);
                t = "";
                esMatPro = false;
                esPUM = false;
                esTEM = false;

                produccion.agregarMaterial(nombrePro, p.get(0), Integer.parseInt(p.get(1)), Integer.parseInt(p.get(2)));
            } else if (x[i] != ']' && x[i] != ',' && x[i] != '[') {
                t = t + x[i];
            }
        }

    }

    public void agregarProveedor(Proveedor p) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(direccionProveedores, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(p.toString() + "\r\n");

            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(Proveedor p) {
        try {

            File inFile = new File(direccionProveedores);

            if (!inFile.isFile()) {
                System.out.println("no hay file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(direccionProveedores));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                String lineToRemove = p.toString();
                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void cargarPedidos(String texto) {
        int identificador = 0;
        String material = "";
        String proveedor = "";
        int cantidad = 0;
        boolean activo = true;
        Date fechaE = null;
        Date fechaLL = null;

        char[] x = texto.toCharArray();
        int cont = 0;
        String t = "";
        for (int i = 0; i < x.length; i++) {
            if (x[i] == ',' && cont == 0) {
                identificador = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 1) {
                material = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 2) {
                proveedor = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 3) {
                cantidad = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 4) {
                activo = Boolean.parseBoolean(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 5) {
                SimpleDateFormat fm = new SimpleDateFormat("MM//dd//yyyy HH:mm:ss");
                try {
                    fechaE = fm.parse(t);
                } catch (Exception e) {

                }
                t = "";
                cont++;
            } else if (x[i] == ',' && cont == 6) {
                if (t == "NOLLEGA") {
                    fechaLL = null;
                } else {
                    SimpleDateFormat fm = new SimpleDateFormat("MM//dd//yyyy HH:mm:ss");
                    try {
                        fechaLL = fm.parse(t);
                    } catch (Exception e) {

                    }
                }

                cont++;
                t = "";
            } else if (x[i] != ',') {
                t = t + x[i];
            }
        }
        produccion.agregarPedido(activo, fechaLL, fechaE, identificador, material, proveedor, cantidad);

    }

    public void agregarPedido(Pedido p) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(direccionPedidos, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(p.toString() + "\r\n");

            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarProducto(String texto) {
        String nombre = null;
        String id = null;
        String material = null;
        int cantMaterial = 0;
        int precio = 0;
        int tiempoElaboracion = 0;
        int cantidadEnInventario = 0;

        char[] x = texto.toCharArray();
        int cont = 0;
        String t = "";
        for (int i = 0; i < x.length; i++) {
            if (x[i] == ',' && cont == 0) {
                nombre = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 1) {
                id = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 2) {
                material = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 3) {
                cantMaterial = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 4) {
                precio = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 5) {
                tiempoElaboracion = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 6) {
                cantidadEnInventario = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] != ',') {
                t = t + x[i];
            }
        }
        produccion.ingresarNuevoProducto(nombre, id, material, cantMaterial, precio, tiempoElaboracion, true);
        produccion.getInventario().buscarProducto(id).setCantidadEnInventario(cantidadEnInventario);
    }

    public void agregarProducto(Producto p) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(direccionProductos, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(p.toString() + "\r\n");

            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(Producto p) {
        try {

            File inFile = new File(direccionProductos);

            if (!inFile.isFile()) {
                System.out.println("no hay file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(direccionProductos));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                String lineToRemove = p.toString();
                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cargarMaterial(String texto) {
        String nombre = "";
        int cantidadEnInventario = 0;
        int contador = 0;
        String t = "";
        char[] x = texto.toCharArray();
        for (int i = 0; i < x.length; i++) {
            if (x[i] == ',' && contador == 0) {
                nombre = t;
                contador++;
                t = "";
            } else if (x[i] == ',' && contador == 1) {
                cantidadEnInventario = Integer.parseInt(t);
                contador++;
                t = "";
            } else if (x[i] != ',') {
                t = t + x[i];
            }

        }
        Material m = produccion.getInventario().buscarMaterial(nombre);
        m.setCantidadEnInventario(cantidadEnInventario);
    }

    public void agregarMaterial(Material p) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(direccionMateriales, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(p.toString() + "\r\n");

            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMaterial(Material p) {
        try {

            File inFile = new File(direccionMateriales);

            if (!inFile.isFile()) {
                System.out.println("no hay file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(direccionMateriales));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                String lineToRemove = p.toString();
                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
