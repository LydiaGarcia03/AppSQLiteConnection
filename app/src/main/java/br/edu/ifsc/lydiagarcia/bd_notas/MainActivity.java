package br.edu.ifsc.lydiagarcia.bd_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

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

        while(!cursor.isAfterLast()){

            id = cursor.getString(cursor.getColumnIndex("id"));
            titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            texto = cursor.getString(cursor.getColumnIndex("texto"));

            Log.d("tabelaNotas", id + " " + titulo + " " + texto);

            cursor.moveToNext();

        }



    }
}
