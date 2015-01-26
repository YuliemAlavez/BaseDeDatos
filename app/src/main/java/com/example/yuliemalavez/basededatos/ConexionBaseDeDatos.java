package com.example.yuliemalavez.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by yuliemalavez on 21/01/15.
 */
public class ConexionBaseDeDatos {
    private SQLiteDatabase db;
    private Context nContext;
    private BaseDeDatos objBD;

    //Constructor de la Clase
    //Recibe como parámetro una variable de Tipo contexto
    // Esto debido a que Para acceder o crear la BD lo pide la Clase SQLiteOpenHelper
    public ConexionBaseDeDatos(Context c){
        nContext=c;

    }
    public void abrirConexion(){
        objBD =new BaseDeDatos(nContext,"database1.db",null,1 );
        db=objBD.getWritableDatabase();
    }

    public void cerrarConexion(){
        db.close();
    }

    public boolean insertar(String nombre, String apellido,String telefono,String email){
        boolean resultado=false;

        try{
            String query="INSERT INTO personas(Nombre, Apellido, Telefono, Email) VALUES('"+nombre+"','"+apellido+"','"+telefono+"','"+email+"')";

            //String query="INSERT INTO personas(Nombre, Apellido, Telefono, Email) VALUES(a,b,c,d)";

            db.execSQL(query);
            resultado=true;
            return resultado;
        }
        catch (Exception e){
            resultado=false;
            return resultado;
        }
    }

}
