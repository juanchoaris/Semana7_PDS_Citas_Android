package com.example.citasmedicassemana7;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Database_administrator {
    Connection connect;
    String url = "jdbc:mysql://34.121.51.170:3306/citasmedicas_semana8";
    String user = "root";
    String pass = "123456";

    public boolean connectSQL() {

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            Log.d("MyTag", "Conexion Exitosa");
            return true;
        } catch (Exception err) {
            Log.d("MyTag", err.toString());
            return false;
        }
    }

    public boolean insertRecord(Model cita) {

        try {
            String instruccionSQL = "INSERT INTO CitasMedicas (`Nombres`, `Apellidos`, `Documento`, `Correo`, `Especialidad`, `Fecha`) " +
                    "VALUES ('" + cita.getNombres() + "', '" + cita.getApellidos() + "', '" + cita.getDocumento() + "', '" + cita.getCorreo() + "', '" +
                    cita.getEspecialidad() + "', '" + cita.getFecha() + "')";

            connect.prepareStatement(instruccionSQL).execute();
            Log.d("MyTag", "Cita Registrada");
            return true;

        } catch (Exception err) {
            Log.d("MyTag", err.toString());
            return false;
        }
    }

    public ArrayList<String> selectRecord() {

        try {
            String instruccionSQL = "SELECT * FROM CitasMedicas";

            ResultSet rs = connect.prepareStatement(instruccionSQL).executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantidadColumnas = rsmd.getColumnCount();

            ArrayList<String> lista = new ArrayList<>();

            while (rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                String Cita = "";
                for (int i = 0; i < cantidadColumnas; i++){
                     Cita = Cita  + " | " +  rs.getObject(i + 1);
                }

                lista.add(Cita);
            }


            Log.d("MyTag", "Cita Registrada");
            return lista;

        } catch (Exception err) {
            Log.d("MyTag", err.toString());
            return new ArrayList<>();
        }
    }
}

