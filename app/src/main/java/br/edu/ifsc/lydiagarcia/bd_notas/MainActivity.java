package br.edu.ifsc.lydiagarcia.bd_notas;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

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

        db.execSQL("INSERT INTO  notas VALUES (null, 'Desespero', '');");

    }
}
