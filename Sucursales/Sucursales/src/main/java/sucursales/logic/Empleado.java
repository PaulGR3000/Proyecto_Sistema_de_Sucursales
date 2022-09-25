package sucursales.logic;

import sucursales.logic.Sucursal;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    String cedula;
    String nombre;
    String telefono;
    float salario;
    Sucursal sucursal;
    Sucursal zonaje;



    public Empleado(String cedula, String nombre, String telefono,float salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono=telefono;
        this.salario=salario;
        this.sucursal=sucursal;
        this.zonaje=zonaje;
    }

    public Empleado() {
        this("","","",0.0f);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public float getSalario() { return salario; }

    public void setSalario(float salario) { this.salario = salario; }

    public float salarioZonaje(String zonaje,float salario){

        float zona = Float.valueOf(zonaje);

        return ((zona/100)*salario)+salario;
    }
}
