package com.example.yuliemalavez.basededatos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AgregarElemento extends ActionBarActivity {

    private EditText nombre,apellido,telefono,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_elemento);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agregar_elemento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void limpiar(View view){
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        email.setText("");
    }
    public void agregar(View view){
        //Declaramos variables

        /*String nombre,apellido,telefono,email;

        //Obtenemos Texto de los TextEdit
        nombre=this.nombre.getText().toString();
        apellido=this.apellido.getText().toString();
        telefono=this.telefono.getText().toString();
        email=this.email.getText().toString();
*/

        //Creamos el Objeto para acceder a la BD
        ConexionBaseDeDatos ObjCnx = new ConexionBaseDeDatos(this);

        ObjCnx.abrirConexion(); //Abrimos Conexión
        String a="hola";
        //Ejecuta el método para Insertar Datos
        if(ObjCnx.insertar(a,a,a,a)==true){
            String texto ="Elemento Agregado Corectamente";
            Toast toast = Toast.makeText(this, texto, Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            String texto ="Error al Agregar Elemento";
            Toast toast = Toast.makeText(this, texto, Toast.LENGTH_LONG);
            toast.show();
        }

        //Cerramos Conexión

        ObjCnx.cerrarConexion();
    }
}
