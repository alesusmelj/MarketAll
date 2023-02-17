package ejecucion;

import empresa.Catalogo;
import empresa.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JFrame {
    private JButton CATALOGOButton;
    private JButton VENTAButton;
    private JButton RANKINGButton;
    private JPanel mainPanel;

    static Catalogo catalogo;

    public Home() {

        setContentPane(mainPanel);
        setTitle("MarketAll");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        CATALOGOButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == CATALOGOButton) {
                    ventanaCatalogo frameVentanaCatalogo = new ventanaCatalogo();
                    frameVentanaCatalogo.setTitle("MarketAll - Catalogo");
                    frameVentanaCatalogo.setSize(500, 500);
                    frameVentanaCatalogo.setVisible(true);
                }
            }
        });

        VENTAButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == VENTAButton) {
                    ventanaVenta frameVentanaVenta = new ventanaVenta();
                    frameVentanaVenta.setTitle("MarketAll - Ventas");
                    frameVentanaVenta.setSize(500, 500);
                    frameVentanaVenta.setVisible(true);

                }
            }
        });
        RANKINGButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == RANKINGButton) {
                    ventanaRanking frameVentanaRanking = new ventanaRanking();
                    frameVentanaRanking.setTitle("MarketAll - Ranking");
                    frameVentanaRanking.setVisible(true);
                    frameVentanaRanking.setSize(500, 500);
                }
            }
        });
    }

    public static void main(String[] args) {
        Home myframe = new Home();
        catalogo = new Catalogo();


        for (int i = 0; i < 20; ++i) {
            Producto nuevo = new Producto(i, "Prueba " + i, 1000, 100, 10);
            catalogo.agregarProductoCatalogo(nuevo);
        }


    }

}


