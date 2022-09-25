package sucursales.presentation.sucursales;

import sucursales.Application;
import sucursales.logic.Empleado;
import sucursales.logic.Sucursal;
import sucursales.logic.Service;

import java.awt.desktop.AppForegroundListener;
import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        model.setSucursales(Service.instance().sucursalesSearch(""));
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar(String filtro){
        List<Sucursal> rows = Service.instance().sucursalesSearch(filtro);
        model.setSucursales(rows);
        model.commit();
    }

    public void agregar(Sucursal e){
        Service.instance().agregarSucursal(e);
        this.buscar("");
    }

    public void show(){
        Application.window.setContentPane(view.getPanel());
    }

    public void editar(int row){
        String codigo = model.getSucursales().get(row).getCodigo();
        Sucursal e=null;
        try {
            e= Service.instance().sucursalGet(codigo);
            Application.sucursalController.editar(e);
        } catch (Exception ex) {}
    }

    public void borrar(int row) {
        String codigo = model.getSucursales().get(row).getCodigo();
        Sucursal e=null;
        try {
            e= Service.instance().sucursalGet(codigo);
            Service.instance().sucursalDelete(e);
            this.buscar("");
        } catch (Exception ex) {}
    }

    public void preAgregar(){
        Application.sucursalController.preAgregar();
    }




}
