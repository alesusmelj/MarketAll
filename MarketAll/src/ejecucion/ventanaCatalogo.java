package ejecucion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaCatalogo extends JFrame{
    JFrame frame = new JFrame();
    private JButton CARGARPRODUCTOButton;
    private JButton EDITARPRODUCTOButton;
    private JButton LISTARPRODUCTOButton;
    private JButton BAJAPRODUCTOButton;
    private JPanel catalogoPanel;
    private JButton VOLVERButton;


    ventanaCatalogo(){

        setContentPane(catalogoPanel);

        CARGARPRODUCTOButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == CARGARPRODUCTOButton){
                    ventanaCargaProducto frameVentanaCargaProducto = new ventanaCargaProducto();
                    frameVentanaCargaProducto.setTitle("MarketAll- Cargar Producto");
                    frameVentanaCargaProducto.setSize(500, 500);
                    frameVentanaCargaProducto.setVisible(true);
                }
            }
        });
        EDITARPRODUCTOButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == EDITARPRODUCTOButton){
                    ventanaEditarProducto frameVentanaEditarProducto = new ventanaEditarProducto();
                    frameVentanaEditarProducto.setTitle("MarketAll- Editar Producto");
                    frameVentanaEditarProducto.setSize(500, 500);
                    frameVentanaEditarProducto.setVisible(true);
                }
            }
        });
        LISTARPRODUCTOButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == LISTARPRODUCTOButton){
                    ventanaListarProducto frameVentanaListarProducto = new ventanaListarProducto();
                    frameVentanaListarProducto.setTitle("MarketAll- Listar Producto");
                    frameVentanaListarProducto.setSize(500, 500);
                    frameVentanaListarProducto.setVisible(true);
                }
            }
        });
        BAJAPRODUCTOButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == BAJAPRODUCTOButton){
                    ventanaEliminarProducto frameVentanaEliminarProducto = new ventanaEliminarProducto();
                    frameVentanaEliminarProducto.setTitle("MarketAll- Eliminar Producto");
                    frameVentanaEliminarProducto.setSize(500, 500);
                    frameVentanaEliminarProducto.setVisible(true);
                }
            }
        });
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == VOLVERButton){
                    cancelar();
                }
            }
        });
    }

    private void cancelar(){
        this.setVisible(false);
    }

    public static void main(String[] args) {
        try {
            ventanaCatalogo frameVentanaCatalogo = new ventanaCatalogo();
            frameVentanaCatalogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frameVentanaCatalogo.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
