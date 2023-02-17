package ejecucion;

import empresa.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ejecucion.Home.catalogo;

public class ventanaEliminarProducto extends JFrame{
    private JTextField CODIGOPRODUCTO;
    private JButton ELIMINARButton;
    private JButton CANCELARButton;
    private JPanel eliminarProductoPanel;

    public ventanaEliminarProducto(){
        setContentPane(eliminarProductoPanel);
        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == CANCELARButton){
                    cancelar();
                }
            }
        });

        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ELIMINARButton){
                    eliminar();
                    cancelar();
                }
            }
        });
    }

    private void eliminar(){
        if(catalogo.existeProducto(Integer.parseInt(CODIGOPRODUCTO.getText()))){
            Producto productoEliminar = catalogo.getProducto(Integer.parseInt(CODIGOPRODUCTO.getText()));
            catalogo.eliminarProductoCatalogo(productoEliminar);
            productoEliminar = null;
        }
    }

    private void cancelar(){
        this.setVisible(false);
    }


    public static void main(String[] args){
        try {
            ventanaEliminarProducto frameVentanaEliminarProducto = new ventanaEliminarProducto();
            frameVentanaEliminarProducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frameVentanaEliminarProducto.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
