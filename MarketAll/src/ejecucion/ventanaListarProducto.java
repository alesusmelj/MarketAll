package ejecucion;

import empresa.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import static ejecucion.Home.catalogo;

public class ventanaListarProducto extends JDialog {
    private JPanel ListarProducto;
    private JTable table1;

    public ventanaListarProducto() {
        setContentPane(ListarProducto);
    }

    public static void main(String[] args) {
        try {
            ventanaListarProducto frameVentanaListarProducto = new ventanaListarProducto();
            frameVentanaListarProducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frameVentanaListarProducto.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createUIComponents() {
        String[] columnNames = {"Cod.",
                "Descripcion",
                "Stock",
                "Stock Min.",
                "Precio"};

        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        table1 = new JTable(dtm) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ArrayList<Producto> productos = catalogo.getLista();
        if (productos.size() > 0) {
            for (Producto producto : productos) {
                Object[] row = {producto.getCodigo(), producto.getDescripcion(), producto.getStock(), producto.getStockMinimo(), producto.getPrecio()};
                dtm.addRow(row);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay productos cargados.");
        }

    }
}


