package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Objetos 
    private EditText editText_altura;
    private EditText editText_peso;
    private TextView textView_imc;
    private TextView textView_peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_altura = findViewById(R.id.edit_text_altura);
        editText_peso = findViewById(R.id.edit_text_peso);
        textView_imc = findViewById(R.id.text_view_imc);
        textView_imc.setText("");
        textView_peso = findViewById(R.id.text_view_peso);
        textView_peso.setText("");
    }

    public void calcular(View v)
    {
        try {
            Double altura, peso, calculo, calculoMin, calculoMax;
            String imc;
            altura = Double.parseDouble(editText_altura.getText().toString().
                    replace(",","."));
            peso = Double.parseDouble(editText_peso.getText().toString().
                    replace(",","."));

            calculo = peso/Math.pow(altura,2);
            calculoMin = 18.6 * Math.pow(altura,2);
            calculoMax = 24.9 * Math.pow(altura,2);


            if(calculo <= 18.5 )
            {
                imc = "abaixo do peso";
                textView_imc.setTextColor(getResources().getColor(R.color.colorMagreza));
            }
            else if (calculo <= 24.9)
            {
                imc = "peso ideal";
                textView_imc.setTextColor(getResources().getColor(R.color.colorSaudavel));
            }
            else if(calculo <= 29.9)
            {
                imc = "levemente acima do peso";
                textView_imc.setTextColor(getResources().getColor(R.color.colorSobrepeso));
            }
            else if(calculo <= 34.9)
            {
                imc = "obesidade grau 1";
                textView_imc.setTextColor(getResources().getColor(R.color.colorObeso1));
            }
            else if (calculo <= 39.9)
            {
                imc = "obesidade grau 2 (severa)";
                textView_imc.setTextColor(getResources().getColor(R.color.colorObeso2));
            }
            else // acima de 40
            {
                imc = "obesidade grau 3 (mórbida)";
                textView_imc.setTextColor(getResources().getColor(R.color.colorObeso3));
            }

            textView_imc.setText("Seu imc é: "+calculo.toString().
                    replace(".",",").substring(0,4)+"\r\n"+"("+
                    imc.toString()+")");
            textView_peso.setText("Seu peso ideal é entre:\r\n"+
                    calculoMin.toString().replace(".",",").
                            substring(0,4)+"Kg ~ "+calculoMax.toString().
                    replace(".",",").substring(0,4)+"Kg");
        }
        catch (Throwable e)
        {
            textView_imc.setText("Informe os valores corretamente!");
        }
    }
}
