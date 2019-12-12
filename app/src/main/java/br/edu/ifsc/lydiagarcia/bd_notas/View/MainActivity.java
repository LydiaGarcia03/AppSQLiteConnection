package br.edu.ifsc.lydiagarcia.bd_notas.View;

import androidx.appcompat.app.AppCompatActivity;
import br.edu.ifsc.lydiagarcia.bd_notas.DAO.NotasDAO;
import br.edu.ifsc.lydiagarcia.bd_notas.R;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    NotasDAO notasDAO;
    EditText etTitulo, etTexto;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notasDAO = new NotasDAO(this);

        etTitulo = findViewById(R.id.etTitulo);
        etTexto = findViewById(R.id.etTexto);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }

    public void salvar(){

        String strTitulo, strTexto;

        strTitulo = etTitulo.getText().toString();
        strTexto = etTexto.getText().toString();

        notasDAO.insertNotas(strTitulo, strTexto);

    }
}

/*
*
* retornar que já tinha dados salvos no Toast e settar o text ds campos com os dados salvos
*
* */