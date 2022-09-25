package sucursales.data;

import sucursales.logic.Empleado;
import sucursales.logic.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Empleado> empleados;
    private List<Sucursal>sucursales;

    public Data() {
        empleados = new ArrayList<>();
        sucursales=new ArrayList<>();

        empleados.add(new Empleado("111", "Franklin Chang","2234",1111));
        empleados.add(new Empleado("222", "Sandra Cauffman","2922",11122));
        empleados.add(new Empleado("333", "Ivan Vargas","4455",54651));


        sucursales.add(new Sucursal("44","Heredia","Por el palo de mango","2.1"));
        sucursales.add(new Sucursal("55","Alajuela","Por el palo de aguacate","3.1"));
        sucursales.add(new Sucursal("66","San Jose","Por el palo de limon","4.1"));
        sucursales.add(new Sucursal("77","Cartago","Por el palo de cas","5.1"));
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public List<Sucursal> getSucursales(){
        return sucursales;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
