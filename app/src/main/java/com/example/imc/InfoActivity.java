package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView textView_info_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textView_info_resultado = findViewById(R.id.txt_view_info_resultado);

        Intent telaInfo = getIntent();
        String mensagem = telaInfo.getStringExtra("RESULTADO");
        textView_info_resultado.setText("Valor recebido:\r\n"+mensagem);
    }
}
