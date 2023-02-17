package empresa;

public class Producto {

    private int codigo;
    private double precio;
    private int stock;
    private int stockMinimo;
    private String descripcion;
    private int cantVentas;

    public Producto(int codigo, String descripcion, double precio, int stock, int stockMinimo){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.cantVentas = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }

    public void editar(Producto producto, int codigo, String descripcion, double precio, int stock, int stockMinimo) {
        producto.setStock(stock);
        producto.setCodigo(codigo);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStockMinimo(stockMinimo);
    }


}
