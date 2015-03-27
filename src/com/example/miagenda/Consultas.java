package com.example.miagenda;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class Consultas
{
   public static String insertarEvento(String cod, String actividad, String fecha, String hora, String lugar, MainActivity v)
   {
	   DAL conexion = new DAL(v);
	   SQLiteDatabase db = conexion.getWritableDatabase();
	   String resultado="";
	   ContentValues registro = new ContentValues();
	   registro.put("codigo",Integer.parseInt(cod));
	   registro.put("actividad", actividad);
	   registro.put("fecha",fecha);
	   registro.put("hora",hora);
	   registro.put("lugar",lugar);
	   
	   try
	   {
		   db.insert("TblEvento",null,registro);
		   resultado = "Insertado con Exito";
	   }
	   catch (Exception e)
	   {
		   resultado="Error en la Insersion";
	   }
	   return resultado;
   }
   
   public static String[] ConsultarEvento(String cod, MainActivity v )
   {
	   String[] datos =new String[0];
	   DAL conexion = new DAL(v);
	   SQLiteDatabase db = conexion.getReadableDatabase();
	   datos = buscar(db,cod);
	   return datos;
	   
   }
   
   private static String[] buscar(SQLiteDatabase db, String codigo)
   {
	   Cursor cursor = db.rawQuery("select codigo,actividad,fecha,hora,lugar from TblEvento where codigo="+codigo, null);
	   String[] result = new String[0];
	   if (cursor.moveToFirst())
	   {
		   result = new String[5];
		   for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext())
		   {
			   result[0]=""+cursor.getInt(0);
			   result[1]=cursor.getString(1);
			   result[2]=cursor.getString(2);
			   result[3]=cursor.getString(3);
			   result[4]=cursor.getString(4);
			   
		   }
	   }
	   
	   db.close();
	   return result;
   }
   
   public static String borrar(String codigo, MainActivity v)
   {
	   String respuesta="";
	   DAL admin = new DAL(v);
	   SQLiteDatabase db = admin.getWritableDatabase();
	   
	   try 
	   {
		   db.execSQL("delete from TblEvento where codigo="+codigo);
		   respuesta="el evento ah sido eliminado";
	   }
	   catch(Exception e)
	   {
		   respuesta="El evento no ah podido ser eliminado";
	   }
	   db.close();
	   return respuesta;
   }
   
   public static String modificarEvento(String cod, String actividad, String fecha, String hora, String lugar, MainActivity v)
   {
	   DAL conexion = new DAL(v);
	   SQLiteDatabase db = conexion.getWritableDatabase();
	   String resultado="";
	   
	   try
	   {
		   db.execSQL("UPDATE TblEvento set actividad ='"+actividad+"',fecha='"+fecha+"',hora='"+hora+"',lugar='"+lugar+"' WHERE codigo="+cod);
		   resultado="El evento ah sido actualizado";
	   }
	   catch(Exception e)
	   {
		   resultado="El evento no ah podido ser actualizado";
	   }
	   db.close();
	   return resultado;
	   
   }
   
   
   
   
   
}
