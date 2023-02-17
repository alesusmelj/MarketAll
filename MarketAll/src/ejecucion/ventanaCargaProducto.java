package ejecucion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ejecucion.Home.catalogo;

import empresa.*;
public class ventanaCargaProducto extends JDialog{
    private JTextField Codigo;
    private JTextField Precio;
    private JTextField Stock;
    private JTextField StockMinimo;
    private JTextField Descripcion;
    private JButton ENVIARButton;
    private JButton CANCELARButton;
    private JPanel CargaProducto;
    private Producto newProducto;



    public ventanaCargaProducto(){

        setContentPane(CargaProducto);
        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == CANCELARButton){
                    cancelar();
                }
            }
        });
        ENVIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ENVIARButton){
                    enviar();
                }
            }
        });
    }

    public static void main(String[] args){
        try{
            ventanaCargaProducto frameVentanaCargaProducto = new ventanaCargaProducto();
            frameVentanaCargaProducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frameVentanaCargaProducto.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void enviar(){
        Integer result;

        newProducto = new Producto(Integer.parseInt(Codigo.getText()), Descripcion.getText(), Integer.parseInt(Precio.getText()), Integer.parseInt(Stock.getText()), Integer.parseInt(StockMinimo.getText()));
        result = catalogo.agregarProductoCatalogo(newProducto);
        if (result == -1){
            JOptionPane.showMessageDialog(null, "Stock menor al Stock minimo");
        }
        if (result == -2){
            JOptionPane.showMessageDialog(null, "El codigo ya esta ingresado");
        }

        this.setVisible(false);
    }

    private void cancelar(){
        this.newProducto = null;
        this.setVisible(false);
    }

    public Producto getProducto(){
        return newProducto;
    }
}

