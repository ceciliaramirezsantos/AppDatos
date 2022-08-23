package com.example.appdatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBsqlite (context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {




        override fun onCreate(db: SQLiteDatabase) {

            val query = ("CREATE TABLE " + TABLE_NAME + " ("
                    + ID_COLUMNA + " INTEGER PRIMARY KEY, " +
                    NOMBRE_COlUMNA + " TEXT," +
                    EDAD_COLUMNA + " TEXT" + ")")


            db.execSQL(query)
        }

        override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
            onCreate(db)
        }


        fun addName(nombre : String, edad : String ){


            val values = ContentValues()


            values.put(NOMBRE_COlUMNA, nombre)
            values.put(EDAD_COLUMNA, edad)


            val db = this.writableDatabase


            db.insert(TABLE_NAME, null, values)


            db.close()
        }


        fun getName(): Cursor? {


            val db = this.readableDatabase


            return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

        }

        companion object{

        private val DATABASE_NAME = "PRUEBA"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "Registros_table"
        val ID_COLUMNA = "id"
        val NOMBRE_COlUMNA = "nombre"
        val EDAD_COLUMNA = "edad"
    }
}