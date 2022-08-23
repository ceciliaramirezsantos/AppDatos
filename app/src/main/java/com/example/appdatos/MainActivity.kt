package com.example.appdatos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appdatos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener{

            val db = DBsqlite(this, null)

            val nombre = binding.txtNombre.text.toString()
            val edad = binding.txtEdad.text.toString()


            db.addName(nombre, edad)

            Toast.makeText(this, nombre + " Guardado con Exito", Toast.LENGTH_LONG).show()

            binding.txtNombre.text.clear()
            binding.txtEdad.text.clear()

        }




        binding.btnMostrar.setOnClickListener{


            val db = DBsqlite(this, null)


            val cursor = db.getName()

            cursor!!.moveToFirst()
            binding.mostrarNombre.append(cursor.getColumnIndex(DBsqlite.NOMBRE_COlUMNA).toString()+"\n")
            binding.mostrarEdad.append(cursor.getColumnIndex(DBsqlite.EDAD_COLUMNA).toString() +"\n")




            while(cursor.moveToNext()){

                binding.mostrarNombre.append(cursor.getString(cursor.getColumnIndex(DBsqlite.NOMBRE_COlUMNA)) +"\n")
                binding.mostrarEdad.append(cursor.getString(cursor.getColumnIndex(DBsqlite.EDAD_COLUMNA)) +"\n")

            }


            cursor.close()
        }


    }






}
