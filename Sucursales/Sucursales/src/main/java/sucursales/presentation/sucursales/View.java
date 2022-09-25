package sucursales.presentation.sucursales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTextField referenciaFld;
    private JButton buscarFld;
    private JButton agregarFld;
    private JTable sucursalesFld;
    private JLabel referenciaLbl;
    private JTextField codigoFld;
    private JTextField direccionFld;
    private JTextField zonajeFld;
    private JButton borrarB;
    private JButton reporteBoton;

    public View() {
        buscarFld.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              controller.buscar(referenciaFld.getText());

            }
        });

        borrarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=sucursalesFld.getSelectedRow();
                controller.borrar(row);
            }
        });


        agregarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { controller.preAgregar();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable updatedModel, Object parametros) {
        int[] cols = {TableModel.CODIGO, TableModel.REFERENCIA,TableModel.DIRECCION,TableModel.ZONAJE};
        sucursalesFld.setModel(new TableModel(cols, model.getSucursales()));
        sucursalesFld.setRowHeight(30);
        this.panel.revalidate();
    }

}
