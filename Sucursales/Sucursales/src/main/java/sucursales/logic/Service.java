package sucursales.logic;

import sucursales.data.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static Service theInstance;

    public static Service instance(){
        if (theInstance == null){
            theInstance = new Service();
        }
        return theInstance;
    }

    private Data data;

    private Service(){
        data = new Data();
    }

    public List<Empleado> empleadosSearch(String filtro){
        return data.getEmpleados().stream().filter(e->e.getNombre().contains(filtro)).collect(Collectors.toList());
    }
    public List<Sucursal> sucursalesSearch(String filtro){
        return data.getSucursales().stream().filter(e -> e.getReferencia().contains(filtro)).collect(Collectors.toList());

    }
    public void agregarEmpleado(Empleado empleado){
        List es = data.getEmpleados().stream().filter(e->e.getCedula().equals(empleado.getCedula())).collect(Collectors.toList());
        if(es.isEmpty()){
            data.getEmpleados().add(empleado);
        }
    }

    public void agregarSucursal(Sucursal sucursal){
        List es = data.getSucursales().stream().filter(e->e.getCodigo().equals(sucursal.getCodigo())).collect(Collectors.toList());
        if(es.isEmpty()){
            data.getSucursales().add(sucursal);
        }
    }

    public void empleadoUpdate(Empleado empleado) throws Exception{
        Empleado result;
        try{
            result = this.empleadoGet(empleado.cedula);
            data.getEmpleados().remove(result);
            data.getEmpleados().add(empleado);
        }catch (Exception e) {
            throw new Exception("Empleado no existe");
        }
    }

    public Empleado empleadoGet(String cedula) throws Exception{
        Empleado result = data.getEmpleados().stream().filter(e->e.getCedula().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Empleado no existe");
    }

    public void empleadoDelete(Empleado empleado) throws Exception {
        Empleado result = data.getEmpleados().stream().filter(e->e.getCedula().equals(empleado.getCedula())).findFirst().orElse(null);
        if (result!=null) data.getEmpleados().remove(empleado);
        else throw new Exception("Empleado no existe");
    }

    public void sucursalUpdate(Sucursal sucursal) throws Exception{
        Sucursal result;
        try{
            result = this.sucursalGet(sucursal.codigo);
            data.getSucursales().remove(result);
            data.getSucursales().add(sucursal);
        }catch (Exception e) {
            throw new Exception("Sucursal no existe");
        }
    }

    public Sucursal sucursalGet(String codigo) throws Exception{
        Sucursal result = data.getSucursales().stream().filter(e->e.getCodigo().equals(codigo)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Sucursal no existe");
    }


    public void sucursalDelete(Sucursal sucursal) throws Exception {
        Sucursal result = data.getSucursales().stream().filter(e->e.getCodigo().equals(sucursal.getCodigo())).findFirst().orElse(null);
        if (result!=null) data.getSucursales().remove(sucursal);
        else throw new Exception("Sucursal no existe");
    }

}




