package com.example.miapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvmulta;
    EditText etdni,etnombres,etsueldo;
    Button btnnuevo, btncalcular,btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Aqui enlazamos las variables de MainActivity con activity_main
        etdni= (EditText) findViewById(R.id.etdni);
        etnombres= (EditText) findViewById(R.id.etnombres);
        etsueldo= (EditText) findViewById(R.id.etsueldo);
        btnnuevo=(Button) findViewById(R.id.btnnuevo);
        btncalcular=(Button) findViewById(R.id.btncalcular);
        btnsalir=(Button) findViewById(R.id.btnsalir);
        tvmulta = (TextView) findViewById(R.id.tvmulta);

    }
    public void setBtnnuevo(View view){
        etdni.setText("");
        etnombres.setText("");
        etsueldo.setText("0.00");
        tvmulta.setText("0.00");
        etdni.requestFocus();
    }
    public void setBtncalcular(View view){

        Double sueldo,multa;
        sueldo=Double.parseDouble(etsueldo.getText().toString());
        multa=0.10*sueldo;
        tvmulta.setText("S/" + multa.toString());
    }
    public void setBtnsalir(View view)
    {
        finish();;
    }
}