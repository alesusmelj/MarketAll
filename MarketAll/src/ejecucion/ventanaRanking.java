package ejecucion;

import empresa.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import static ejecucion.Home.catalogo;

public class ventanaRanking extends JDialog {

    private JPanel Ranking;
    private JTable table1;

    ventanaRanking() {
        setContentPane(Ranking);
    }

    private void createUIComponents() {
        String[] columnNames = {"Posición",
                "Cod.",
                "Producto",
                "Ventas"};

        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        table1 = new JTable(dtm) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Producto> ranking = catalogo.getRanking();
        if (ranking.size() > 0) {
            int posicion = 1;
            for (Producto producto : ranking) {
                Object[] row = {posicion++, producto.getCodigo(), producto.getDescripcion(), producto.getCantVentas()};
                dtm.addRow(row);
                if (posicion == 11) {
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ventas.");
        }

    }


}
