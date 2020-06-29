package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.santalu.maskedittext.MaskEditText;

public class MainActivity2 extends AppCompatActivity {

    private TextView saldo;
    private TextView pagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        saldo = findViewById(R.id.saldo);
        pagamento = findViewById(R.id.pagamento);

        saldo.setText(b.getString("mesRecebe"));
        pagamento.setText(b.getString("saldo"));
    }
}


