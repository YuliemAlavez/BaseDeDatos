package com.example.yuliemalavez.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuliemalavez on 21/01/15.
 */
public class BaseDeDatos extends SQLiteOpenHelper{
    //Query para crear las tablas en la bd


    String query="CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, Telefono TEXT, Email TEXT)";

    //Constructor de la clase
    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS personas");
        //Se crea la nueva versión de la tabla
        db.execSQL(query);
    }
}
