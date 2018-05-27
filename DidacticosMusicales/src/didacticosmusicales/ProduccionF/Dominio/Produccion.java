/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Dominio;

import didacticosmusicales.ProduccionF.Datos.ConexionBD;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author hecto
 */
public class Produccion {
    private Inventario inventario;
    private List<Pedido> pedidos;
    private List<Proveedor> proveedores;
    
    private ConexionBD cBD;

    public Produccion() {
        
        this.pedidos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Material> materiales = new ArrayList<>();
        inventario = Inventario.getInstance(materiales,productos);
        cBD = new ConexionBD(this);
    }   

    
    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    
    
    public Date darFechaEstimada(String idProducto){
        Calendar c = Calendar.getInstance();
        int diaActual = c.get(Calendar.DATE);
        int mesActual = c.get(Calendar.MONTH);
        int añoActual = c.get(Calendar.YEAR);
        int diasEstimados = 0;
        
        
        Producto p = inventario.buscarProducto(idProducto);
        
        boolean disponibleProducto = true;
        boolean disponibleMaterial = true;
        if(inventario.mostrarCantidadProducto(idProducto) == 0){
            disponibleProducto = false;
            diasEstimados = 0;
        }
        else if (inventario.mostrarCantidadMaterial(p.getMaterial().getNombre()) == 0){
            disponibleMaterial = false;
        }
        if(disponibleProducto == false && disponibleMaterial == false){
            diasEstimados = p.getMaterial().getMarPro().get(0).getTiempoDeEntrega() + p.getTiempoElaboracion();
        }
        else if(disponibleMaterial == true && disponibleProducto == false){
            diasEstimados = p.getTiempoElaboracion();
        }
        else if(disponibleProducto == true){
            diasEstimados = 0;
        }
        c.add(Calendar.DATE, diasEstimados);
        Date fechaEstimada = new Date(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE));
        return fechaEstimada;
    }
    public int realizarPedido(String material, int cantidad){
        Material m = inventario.buscarMaterial(material);
        MaterialPorProveedor mp = m.getMarPro().get(0);
        Calendar c = Calendar.getInstance();
        Pedido ultimoP = pedidos.get(pedidos.size()- 1);
        int idNuevoP = ultimoP.getIdentificador() + 1;
        Pedido pedido = new Pedido(c.getTime(), idNuevoP, mp, cantidad);
        mp.getProveedor().enviarPedidoPorWebsite(mp,cantidad);        
        pedidos.add(pedido);
        cBD.agregarPedido(pedido);
        return idNuevoP;     
        
    }
    public int realizarPedido(String material, int cantidad, String proveedor){
        Material m = inventario.buscarMaterial(material);
        MaterialPorProveedor mp = null;
        
        for(int i = 0; i < m.getMarPro().size();i++){
            if(m.getMarPro().get(i).getProveedor().getNombre().equals(proveedor)){
                mp = m.getMarPro().get(i);
                break;
            }
        }
        Calendar c = Calendar.getInstance();
        Pedido ultimoP;
        int idNuevoP = 1;
        if(pedidos.size() != 0){
            ultimoP = pedidos.get(pedidos.size()- 1);
            idNuevoP = ultimoP.getIdentificador() + 1;
        }
        
        
        Pedido pedido = new Pedido(c.getTime(), idNuevoP, mp, cantidad);
        mp.getProveedor().enviarPedidoPorWebsite(mp,cantidad);        
        pedidos.add(pedido);
        cBD.agregarPedido(pedido);
        return idNuevoP; 
    }
    public void recibirPedido(int identificador){
        Pedido p = buscarPedido(identificador);
        if( p == null){
            System.out.println("No se encotro el pedido");
            return;
        }
        cBD.eliminarMaterial(p.getMaterialProveedor().getMaterial());
        int cantidadEnInventario = p.getMaterialProveedor().getMaterial().getCantidadEnInventario();
        p.getMaterialProveedor().getMaterial().setCantidadEnInventario(p.getCantidad()+cantidadEnInventario);        
        cBD.agregarMaterial(p.getMaterialProveedor().getMaterial());
    }
    
    public void agregarPedido(boolean activo, Date fechaDeLlegada, Date fechaEnvio, int identificador, String material,String proveedor, int cantidad){
        Proveedor pe = buscarProveedor(proveedor);
        MaterialPorProveedor mp = pe.buscarMaterial(material);
        Pedido p;
        p = new Pedido(activo, fechaDeLlegada, fechaEnvio, identificador, mp, cantidad);
        pedidos.add(p);
        
    }
    
    public Pedido buscarPedido(int identificador){
        Iterator<Pedido> it = pedidos.iterator();
        while(it.hasNext()){
            Pedido p = it.next();
            if(p.getIdentificador() == identificador){
                return p;
            }
        }
        return null;
    }
    public Proveedor buscarProveedor(String nombre){
        
        Iterator<Proveedor> it = proveedores.iterator();
        while(it.hasNext()){
            Proveedor p = it.next();
            if(p.getNombre().equals(nombre)){
                return p;
            }
        }
        return null;
    }
    
    public void ingresarNuevoProducto(String nombre, String id, String material, int cantMaterial, int precio, int tiempoElaboracion){
        Material m = inventario.buscarMaterial(material);
        if(m == null){
            System.out.println("nose encontro material");
            return;
        }
        Producto p = new Producto(nombre,id,m,cantMaterial,precio,tiempoElaboracion);
        inventario.ingresarNuevoProducto(p);
        cBD.agregarProducto(p);
    }
        public void ingresarNuevoProducto(String nombre, String id, String material, int cantMaterial, int precio, int tiempoElaboracion, boolean b){
        Material m = inventario.buscarMaterial(material);
        if(m == null){
            System.out.println("nose encontro material");
            return;
        }
        Producto p = new Producto(nombre,id,m,cantMaterial,precio,tiempoElaboracion);
        inventario.ingresarNuevoProducto(p);
    }
    public void eliminarProducto(String id){
        cBD.eliminarProducto(inventario.buscarProducto(id));
        inventario.eliminarProducto(id);
    }
    public void modificarProducto(String id, String nombre, String material, int cantMaterial, int precio, int tiempoElaboracion){
        Producto p = inventario.buscarProducto(id);
        Material m = inventario.buscarMaterial(material);
        if(m == null){
            System.out.println("No se encontro material");
            return;            
        }
        p.modificarProducto(nombre, m, cantMaterial, precio, tiempoElaboracion);
    }
 
    
    public void ingresarNuevoProveedor(String nombre, String telefono, String webSite, String material, int precio, int tiempo){
        Material m = inventario.buscarMaterial(material);
        MaterialPorProveedor mp = null;
        Proveedor p = new Proveedor(nombre, telefono, webSite);
        if(m == null){            
            m = new Material(material);
            cBD.agregarMaterial(m);
            mp = new MaterialPorProveedor(p, m,precio, tiempo);             
            m.agregarProveedor(mp);            
            inventario.ingresarNuevoMaterial(m);
        }else{
            mp = new MaterialPorProveedor(p, m,precio, tiempo);
        } 
        p.agregrarMatProveedor(mp);
        proveedores.add(p);  
        System.out.println(p.getNombre());
        cBD.agregarProveedor(p);
    }
    public void eliminarProveedor(Proveedor proveedor){
        proveedores.remove(proveedor);
        Iterator<MaterialPorProveedor> it = proveedor.getMateriales().iterator();
        while(it.hasNext()){
            MaterialPorProveedor p = it.next();
            Material m = p.getMaterial();
            m.getMarPro().remove(p);
        }
        cBD.eliminarProveedor(proveedor);
    }
    public void agregarMaterial(String proveedor,String material, int precio, int tiempo){
        Material m = inventario.buscarMaterial(material);        
        if(m == null){            
            m = new Material(material);           
            inventario.ingresarNuevoMaterial(m);
            Proveedor p = this.buscarProveedor(proveedor);
            p.agregarMaterial(m, precio, tiempo);
        }else{
            Proveedor p = this.buscarProveedor(proveedor);
            p.agregarMaterial(m, precio, tiempo);
        } 
    }
    public void entregarMaterial(String nombre, int cantidad){
        inventario.buscarMaterial(nombre).setCantidadEnInventario(cantidad);
    }

    public void ingresarNuevoProveedor(String nombre, String telefono, String webSite, String material, int precio, int tiempo, boolean b) {
        Material m = inventario.buscarMaterial(material);
        MaterialPorProveedor mp = null;
        Proveedor p = new Proveedor(nombre, telefono, webSite);
        if(m == null){            
            m = new Material(material);
            mp = new MaterialPorProveedor(p, m,precio, tiempo);             
            m.agregarProveedor(mp);            
            inventario.ingresarNuevoMaterial(m);
        }else{
            mp = new MaterialPorProveedor(p, m,precio, tiempo);
        } 
        p.agregrarMatProveedor(mp);
        proveedores.add(p);  
        System.out.println(p.getNombre());
    }
}
