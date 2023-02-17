package empresa;

import java.util.*;

public class Catalogo {

    private ArrayList<Producto> arrayProductos;

    public Catalogo() {
        arrayProductos = new ArrayList<Producto>();
    }

    public Integer agregarProductoCatalogo(Producto producto) {

        if(producto.getStock() < producto.getStockMinimo()) {
            System.out.println("Stock menor al Stock minimo");
            return -1;
        }

        if(!existeProducto(producto.getCodigo())) {
            arrayProductos.add(producto);
            return 1;
        }
        else {
            System.out.println("El codigo ya esta ingresado");
            return -2;
        }
    }

    public ArrayList<Producto> getLista(){
        return this.arrayProductos;
    }

    public ArrayList<Producto> getRanking(){
        ArrayList<Producto> ranking;
        ranking = arrayProductos;
        //ordeno el ranking comparando la cantidad de ventas
        ranking.sort((productoUno, productoDos) -> productoDos.getCantVentas() - productoUno.getCantVentas());
        return ranking;
    }

    public boolean existeProducto(int codigo) {
        boolean j = false;
        for(Producto i : arrayProductos) {
            if(codigo == i.getCodigo()) {
                j = true;
                break;
            }
        }
        return j;
    }

    public Producto getProducto(int codigo) {
        boolean j = false;
        for(Producto i : arrayProductos) {
            if(codigo == i.getCodigo()) {
                return i;
            }
        }
        return null;
    }

    private Producto productoCopia(int codigo) {
        for(Producto i :  arrayProductos){
            if(codigo == i.getCodigo()) {
                double precio = i.getPrecio();
                int stock = i.getStock();
                int stockMinimo = i.getStockMinimo();
                String descripcion = i.getDescripcion();
                Producto j = new Producto(codigo, descripcion , precio, stock, stockMinimo);
                return j;
            }
        }
        return null;
    }


    public void actualizarStock(int codigo, int cantVenta) {

        if(existeProducto(codigo)) {
            for(Producto i : arrayProductos) {
                if(codigo == i.getCodigo()) {
                    int stockActual = i.getStock();
                    i.setStock(stockActual - cantVenta);
                    break;
                }
            }
        }
        else {
            System.out.println("Producto inexistente");
        }
    }

    public void eliminarProductoCatalogo(Producto producto) {
        if(existeProducto(producto.getCodigo())) {
            for(Producto i : arrayProductos) {
                if(producto.getCodigo() == i.getCodigo()) {
                    arrayProductos.remove(i);
                    break;
                }
            }
        }
        else {
            System.out.println("Producto inexistente");
        }
    }

    public double ventaProducto(int codigo, int cantidad, int caso) {
        double total = 0;
        if(existeProducto(codigo)) {
            Producto i = productoCopia(codigo);
            if((i.getStock() - cantidad) > i.getStockMinimo()) {
                switch(caso) {
                    case 0:
                        total = cantidad * i.getPrecio();
                        break;

                    case 1:
                        total = cantidad * i.getPrecio();
                        total = total - total * 0.10;
                        break;

                    case 2:
                        total = cantidad * i.getPrecio();
                        total = total + total * 0.06;
                        break;

                    case 3:
                        total = cantidad * i.getPrecio();
                        total = total + total * 0.12;
                        break;

                    case 4:
                        total = cantidad * i.getPrecio();
                        total = total + total * 0.2;
                        break;
                }
            }
            actualizarStock(codigo, cantidad);
        }
        else {
            System.out.println("No hay suficiente stock");
            return -1;
        }
        return total;
    }

}
