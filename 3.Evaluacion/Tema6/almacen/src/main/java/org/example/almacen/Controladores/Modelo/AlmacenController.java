package org.example.almacen.Controladores.Modelo;

import javafx.scene.control.ComboBox;
import org.example.almacen.Modelo.Producto;
import org.example.almacen.Modelo.Proveedor;

import java.util.List;

public class AlmacenController {
    // "Jefe" de todos los controllers.

    private static Producto producto;
    private static List<Proveedor> listaProveedores;

    public static void buscarProducto(String nombre) throws Exception
    {
        producto = ProductoController.buscarProducto(nombre);
        producto.setListaProveedores(listaProveedores);
    }

    public static void buscarPorProducto(int codigo) throws Exception
    {
        // buscar proveedores de un producto.
        listaProveedores = ProductoProveedorController.buscarPorProducto(codigo);
    }

    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception
    {
        return ProveedorController.crearObjetoProveedor(codigoProveedor);
    }

    public static void llenarCombo(ComboBox<String> cbProveedores) throws Exception
    {
        for (Proveedor p: listaProveedores) {
            cbProveedores.getItems().add(p.getNombre());
        }
    }

    public static float precioVenta(String nombre) throws Exception {
        AlmacenController.buscarProducto(nombre);
        return producto.getPrecio();
    }

    public static void actualizarProductoCompra(int unidades, float precio, String nombre) throws Exception {
        buscarProducto(nombre);
        producto.setUnidades(producto.getUnidades()+unidades);
        producto.setPrecio(precio);
        ProductoController.actualizar(producto);
    }
    public static void actualizarProductoVenta(int unidades, String nombre) throws Exception {
        buscarProducto(nombre);
        producto.setUnidades(producto.getUnidades()-unidades);
        ProductoController.actualizar(producto);
    }
}
