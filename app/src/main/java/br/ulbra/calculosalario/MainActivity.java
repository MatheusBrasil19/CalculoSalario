package br.ulbra.calculosalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rgopcoes;
        Button btcalcular;
        EditText edsalario;

            edsalario = (EditText) findViewById(R.id.dinheiro);
            rgopcoes = (RadioGroup) findViewById(R.id.rbgrupo);
            btcalcular = (Button) findViewById(R.id.btnCalc);
            btcalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    double salario = Double.parseDouble(edsalario.getText().toString());
                    int op = rgopcoes.getCheckedRadioButtonId();
                    double novo_salario = 0;
                    if (op == R.id.rb40)
                        novo_salario = salario + (salario * 0.4);

                    else if (op == R.id.rb45)
                        novo_salario = salario + (salario * 0.45);
                    else
                        novo_salario = salario + (salario * 0.5);
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Novo salário");
                    dialogo.setMessage("Seu novo salário é : R$" +String.valueOf(novo_salario));
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
            });
        }
    }
