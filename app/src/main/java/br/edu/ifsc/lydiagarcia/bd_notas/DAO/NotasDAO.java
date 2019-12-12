package br.edu.ifsc.lydiagarcia.bd_notas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import br.edu.ifsc.lydiagarcia.bd_notas.Model.Notas;

public class NotasDAO {

    SQLiteDatabase db;

    public NotasDAO(Context c) {
        db = c.openOrCreateDatabase("aulaSQLite", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS notas (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "texto TEXT);");
    }

    public ArrayList<Notas> getNotas(){

        ArrayList<Notas> result = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM notas", null, null);
        cursor.moveToFirst();

        int id;
        String titulo, texto;

        while(!cursor.isAfterLast()){

            id = cursor.getInt(cursor.getColumnIndex("id"));
            titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            texto = cursor.getString(cursor.getColumnIndex("texto"));

            result.add(new Notas(id, titulo, texto));

            cursor.moveToNext();

        }

        return result;

    }

    public void insertNotas(String titulo, String texto){

        ContentValues contentValues = new ContentValues();
        contentValues.put(titulo, texto);

        db.insert("notas", null, contentValues);

    }
}
