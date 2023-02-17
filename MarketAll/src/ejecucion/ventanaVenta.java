package ejecucion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import empresa.*;

import static ejecucion.Home.catalogo;

public class ventanaVenta extends JDialog {
    JFrame frame = new JFrame();
    private JTextField CODIGOPRODUCTO;
    private JTextField CANTIDAD;
    private JButton ACEPTARButton;
    private JButton CANCELARButton;
    private JPanel ventaPanel;
    private JComboBox comboBoxMetodoDePago;

    ventanaVenta() {
        setContentPane(ventaPanel);
        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == CANCELARButton) {
                    cancelar();
                }
            }

        });
        ACEPTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ACEPTARButton) {
                    int caso = 0;
                    String opcion = comboBoxMetodoDePago.getSelectedItem().toString();
                    if (opcion == "Debito") {
                        caso = 0;
                    }
                    if (opcion == "Efectivo (10 % de descuento)") {
                        caso = 1;
                    }
                    if (opcion == "Credito 2 cuotas (6% de recargo)") {
                        caso = 2;
                    }
                    if (opcion == "Credito 3 cuotas (12% de recargo)") {
                        caso = 3;
                    }
                    if (opcion == "Credito 6 cuotas (20% de recargo)") {
                        caso = 4;
                    }
                    venta(caso);
                    cancelar();
                }
            }
        });
    }

    private void cancelar() {
        this.setVisible(false);
    }

    private void venta(int caso) {
        double total = 0;
        if (catalogo.existeProducto(Integer.parseInt(CODIGOPRODUCTO.getText()))) {
            Producto productoVenta = catalogo.getProducto(Integer.parseInt(CODIGOPRODUCTO.getText()));
            total = catalogo.ventaProducto(productoVenta.getCodigo(), Integer.parseInt(CANTIDAD.getText()), caso);
            if (total >= 0) {
                JOptionPane.showMessageDialog(null, "Total a Pagar: " + total);
                // Agrego una venta
                int cantVentas = productoVenta.getCantVentas();
                productoVenta.setCantVentas(cantVentas + Integer.parseInt(CANTIDAD.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Codigo Inexistente");
        }
    }

    public static void main(String[] args) {
        try {
            ventanaVenta frameVentanaVenta = new ventanaVenta();
            frameVentanaVenta.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frameVentanaVenta.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
