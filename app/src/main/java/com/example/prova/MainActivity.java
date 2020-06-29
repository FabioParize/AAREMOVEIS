package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private MaskEditText cpf;
    private MaskEditText data_nasc;
    private EditText renda_mensal;

    private Calendar pagamento;
    private BigDecimal saldo = new BigDecimal("0");

    private String data_id;
    private BigDecimal renda_id = new BigDecimal("0");
    private String cpf_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpf = findViewById(R.id.cpf);
        data_nasc = findViewById(R.id.data_nascimento);
        renda_mensal = (EditText) findViewById(R.id.renda_mensal);

        data_id = data_nasc.getText().toString();
       // renda_id = new BigDecimal(String.valueOf(renda_mensal.getText()));


    }

    public void calcular(View view){

        if(TextUtils.isEmpty(cpf.getText()) ||
                TextUtils.isEmpty(data_nasc.getText()) ||
                TextUtils.isEmpty(renda_mensal.getText())){
            Toast.makeText(MainActivity.this, "Campos não podem ser vazio", Toast.LENGTH_LONG).show();
            return;
        }


        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = (Date)form.parse(data_id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        pagamento = Calendar.getInstance();
        pagamento.add(Calendar.DAY_OF_MONTH, 20);

        saldo = new BigDecimal("0,7").multiply(renda_id);
    }

    public void Segundatela (View view){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatado = dateFormat.format(pagamento);

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("mesRecebe", formatado);
        b.putString("saldo", String.valueOf(saldo));

        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}