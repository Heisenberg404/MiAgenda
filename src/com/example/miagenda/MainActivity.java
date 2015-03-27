package com.example.miagenda;

import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnGuardar=(Button) findViewById(R.id.BtnGuardar);
		Button btnEliminar=(Button) findViewById(R.id.BtnEliminar);
		Button btnModificar=(Button) findViewById(R.id.BtnModificar);
		Button btnConsultar=(Button) findViewById(R.id.BtnConsultar);
		
		btnGuardar.setOnClickListener(this);
		btnEliminar.setOnClickListener(this);
		btnConsultar.setOnClickListener(this);
		btnModificar.setOnClickListener(this);
		
		
		
		
	}

	@Override
	public void onClick(View v) {

		if (v.getId()==R.id.BtnGuardar)
		{
			
			EditText et1 = (EditText) findViewById(R.id.et_codigo);
			EditText et2= (EditText) findViewById(R.id.et_actividad);
			EditText et3= (EditText) findViewById(R.id.et_fecha);
			EditText et4= (EditText) findViewById(R.id.et_hora);
			EditText et5= (EditText) findViewById(R.id.et_lugar);
			
			if(et1.getText().toString().equals("") || et2.getText().toString().equals("") || et3.getText().toString().equals("") || et4.getText().toString().equals("")|| et5.getText().toString().equals(""))
			{
				String mensajeGuardar = ("Primero debes llenar los campos");
				Toast.makeText(this, mensajeGuardar, Toast.LENGTH_LONG).show();
			}
			else
			{
			String mensajeGuardar = Consultas.insertarEvento(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), this);
			Toast.makeText(this, mensajeGuardar, Toast.LENGTH_LONG).show();
			
			et1.setText("");
			et2.setText("");
			et3.setText("");
			et4.setText("");
			et5.setText("");
		
			}
		}
		
		if (v.getId()==R.id.BtnConsultar)
		{
			EditText et1= (EditText) findViewById(R.id.et_codigo);
			EditText et2= (EditText) findViewById(R.id.et_actividad);
			EditText et3= (EditText) findViewById(R.id.et_fecha);
			EditText et4= (EditText) findViewById(R.id.et_hora);
			EditText et5= (EditText) findViewById(R.id.et_lugar);
			if(et1.getText().toString().equals(""))
			{
				String mensajeConsultar = ("Primero debes indicar un codigo");
				Toast.makeText(this, mensajeConsultar, Toast.LENGTH_LONG).show();
			}
			else
			{
			String[] datos = Consultas.ConsultarEvento(et1.getText().toString(), this);
			String mensajeConsulta="";
			
				if (datos.length>0)
				{
					et1.setText(datos[0]);
					et2.setText(datos[1]);
					et3.setText(datos[2]);
					et4.setText(datos[3]);
					et5.setText(datos[4]);
					mensajeConsulta="Usuario Encontrado";
				}
				else
					mensajeConsulta="Usuario No Encontrado";
			
					Toast.makeText(this, mensajeConsulta, Toast.LENGTH_LONG).show();
			
			}
		}
		
		if (v.getId()==R.id.BtnEliminar)
		{
			EditText et1= (EditText) findViewById(R.id.et_codigo);
			EditText et2= (EditText) findViewById(R.id.et_actividad);
			EditText et3= (EditText) findViewById(R.id.et_fecha);
			EditText et4= (EditText) findViewById(R.id.et_hora);
			EditText et5= (EditText) findViewById(R.id.et_lugar);
			if(et1.getText().toString().equals(""))
			{
				String mensajeConsultar = ("Primero debes indicar un codigo");
				Toast.makeText(this, mensajeConsultar, Toast.LENGTH_LONG).show();
			}
			else
			{	
				String mensajeEliminar = Consultas.borrar(et1.getText().toString(), this);
				Toast.makeText(this, mensajeEliminar, Toast.LENGTH_LONG).show();
				et1.setText("");
				et2.setText("");
				et3.setText("");
				et4.setText("");
				et5.setText("");
			}
		}
		
		if (v.getId()==R.id.BtnModificar)
		{
			EditText et1= (EditText) findViewById(R.id.et_codigo);
			EditText et2= (EditText) findViewById(R.id.et_actividad);
			EditText et3= (EditText) findViewById(R.id.et_fecha);
			EditText et4= (EditText) findViewById(R.id.et_hora);
			EditText et5= (EditText) findViewById(R.id.et_lugar);
			if(et1.getText().toString().equals(""))
			{
				String mensajeModificar = ("Primero debes indicar un codigo");
				Toast.makeText(this, mensajeModificar, Toast.LENGTH_LONG).show();
			}
			else
			{
				String mensajeModificar = Consultas.modificarEvento(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), this);
				Toast.makeText(this, mensajeModificar, Toast.LENGTH_LONG).show();
				et1.setText("");
				et2.setText("");
				et3.setText("");
				et4.setText("");
				et5.setText("");
			}
		}
	}
		
}
	
	
		
	
	

