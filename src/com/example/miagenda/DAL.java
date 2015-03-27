package com.example.miagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAL extends SQLiteOpenHelper 
{ 
	private static final String db= "DbEventos.sqlite";
	private static final byte dbVersion=1;
	
	public DAL(Context context)
	{
        super(context, db, null, dbVersion);

	}

@Override
public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("create table TblEvento (codigo integer primary key, actividad text,fecha data, hora time, lugar text)");
	}

@Override

public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("drop table if exists TblEvento");//eliminar
		db.execSQL("create table TblEvento (codigo integer primaty key, actividad text,fecha text, hora text, lugar text)");
	}
}