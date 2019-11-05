package br.edu.ifsc.lydiagarcia.bd_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("mydb", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS notas(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo VARCHAR NOT NULL," +
                "texto VARCHAR);");

        //db.execSQL("INSERT INTO  notas VALUES (null, 'Desespero', '');");

        // O INSERT abaixo é o mesmo que o INSERT acima.
        // Porém, a classe ContentValues evita SQLInjections e é mais organizada

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", "Desespero++");
        contentValues.put("texto", "Agora eu estou mais desesperada");

        db.insert("notas", null, contentValues);

        Cursor cursor = db.rawQuery("SELECT * FROM notas", null, null);

        // Já que o cursor teria parado na última linha de inserção
        cursor.moveToFirst();

        String id, titulo, texto;

        ArrayList<String> arrayList = new ArrayList<>();

        while(!cursor.isAfterLast()){

            id = cursor.getString(cursor.getColumnIndex("id"));
            titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            texto = cursor.getString(cursor.getColumnIndex("texto"));

            arrayList.add(titulo);

            Log.d("tabelaNotas", id + " " + titulo + " " + texto);

            cursor.moveToNext();

        }

        listView.findViewById(R.id.list_view);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayList
        );

        listView.setAdapter(adapter);

        /*
        * Anotações para ListViews e RecyclerViews
        *
        * DataSet é o conjunto de dados, que no caso é o cursor
        *
        * Para o sistema saber onde colocar cada item na activity, usa-se o Adapter
        * O Adapter, com o DataSet e o Template, consegue rearranjar no ListView
        *
        * */

    }
}
