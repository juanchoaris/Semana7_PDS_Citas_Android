package com.example.citasmedicassemana7;

public class Model {
    private String Nombres;
    private String Apellidos;
    private String Documento;
    private String Correo;
    private String Especialidad;
    private String Fecha;


    public Model(String _Nombres,String _Apellidos, String _Documento,
                 String _Correo, String _Especialidad, String _Fecha ){

        this.setNombres(_Nombres);
        this.setApellidos(_Apellidos);
        this.setDocumento(_Documento);
        this.setCorreo(_Correo);
        this.setEspecialidad(_Especialidad);
        this.setFecha(_Fecha);

    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }


}
