package com.example.appdatos

import android.content.Context
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.view.menu.MenuView
import androidx.cursoradapter.widget.CursorAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appdatos.databinding.ActivityListDatosBinding
import com.example.appdatos.databinding.ActivityMainBinding
import java.lang.reflect.Array.set

class ListDatos : AppCompatActivity() {

    private lateinit var binding: ActivityListDatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBsqlite(this, null)


        val cursor = db.getName()


        cursor!!.moveToFirst()
        binding.txtNombrelist.append(cursor.getColumnIndex(DBsqlite.NOMBRE_COlUMNA).toString()+"\n")
       // binding.mostrarEdad.append(cursor.getColumnIndex(DBsqlite.EDAD_COLUMNA).toString() +"\n")





        while(cursor.moveToNext()){

            binding.txtNombrelist.append(cursor.getString(cursor.getColumnIndex(DBsqlite.NOMBRE_COlUMNA)) +"\n")
           // binding.mostrarEdad.append(cursor.getString(cursor.getColumnIndex(DBsqlite.EDAD_COLUMNA)) +"\n")

        }


        cursor.close()

    }

    inner class CursorAdapterList(context: Context, cursor: Cursor):CursorAdapter(context,cursor,
        FLAG_REGISTER_CONTENT_OBSERVER){


        override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {

            val inflater = LayoutInflater.from(context)
            return inflater.inflate(R.layout.list_item,parent,false)
        }

        override fun bindView(view: View?, context: Context?, cursor: Cursor?) {

            val bindingItems= ItemListviewBinding.bind(view!!)
            bindingItems.


        }






        }
    }


}