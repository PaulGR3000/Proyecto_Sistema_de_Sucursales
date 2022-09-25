package sucursales.logic;

public class Sucursal {
    String codigo;
    String referencia;
    String direccion;
    String zonaje;


    public Sucursal(String codigo, String referencia,String direccion, String zonaje) {
        this.codigo = codigo;
        this.referencia = referencia;
        this.direccion=direccion;
        this.zonaje=zonaje;
    }


    public Sucursal() {
        this("","","","");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getZonaje() {
        return zonaje;
    }

    public void setZonaje(String zonaje) {
        this.zonaje = zonaje;
    }



}
