package ejecucion;

import empresa.Catalogo;
import empresa.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ejecucion.Home.catalogo;

public class ventanaEditarProducto extends JDialog {
    private JTextField CODIGO;
    private JTextField DESCRIPCION;
    private JTextField STOCK;
    private JTextField STOCKMINIMO;
    private JTextField PRECIO;
    private JButton enviarProductoButton;
    private JButton CANCELARButton;
    private JPanel EditarProducto;

    public ventanaEditarProducto() {
        setContentPane(EditarProducto);

        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == CANCELARButton){
                    cancelar();
                }
            }
        });
        enviarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == enviarProductoButton){
                    editar();
                    cancelar();
                }
            }
        });
    }
    private void editar(){
        if (catalogo.existeProducto(Integer.parseInt(CODIGO.getText()))){
            Producto productoEditar = catalogo.getProducto(Integer.parseInt(CODIGO.getText()));
            productoEditar.editar(productoEditar, Integer.parseInt(CODIGO.getText()), DESCRIPCION.getText(), Integer.parseInt(PRECIO.getText()), Integer.parseInt(STOCK.getText()), Integer.parseInt(STOCKMINIMO.getText()));
        }
    }

    private void cancelar(){
        this.setVisible(false);
    }

    public static void main(String[] args) {
        try {
            ventanaEditarProducto frameVentanaEditarProducto = new ventanaEditarProducto();
            frameVentanaEditarProducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frameVentanaEditarProducto.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}