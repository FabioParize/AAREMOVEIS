package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santalu.maskedittext.MaskEditText;

public class MainActivity extends AppCompatActivity {

    private MaskEditText cpf;
    private MaskEditText data_nascimento;
    private MaskEditText renda_mensal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpf = findViewById(R.id.cpf);
        data_nascimento = findViewById(R.id.data_nascimento);
        renda_mensal = findViewById(R.id.renda_mensal);

        String cpf_id = cpf.getText().toString();
        String data_id = data_nascimento.getText().toString();
        String renda_id = renda_mensal.getText().toString();
    }

    public void Segundatela (View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}