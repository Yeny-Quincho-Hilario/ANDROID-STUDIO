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

public class Confecciones_Fast extends AppCompatActivity {
    EditText txtdnii, txtnombre, txtsueldomin, txtpuntos;
    Button btnnuevos, btncalculos, btnsalirse;
    TextView lblabono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confecciones_fast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtdnii = (EditText) findViewById(R.id.txtdnii);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtsueldomin = (EditText) findViewById(R.id.txtsueldomin);
        txtpuntos = (EditText) findViewById(R.id.txtpuntos);
        btnnuevos = (Button) findViewById(R.id.btnnuevos);
        btncalculos = (Button) findViewById(R.id.btncalculos);
        btnsalirse = (Button) findViewById(R.id.btnsalirse);
        lblabono = (TextView) findViewById(R.id.lblabono);
    }

    public void setBtnnuevos (View view){
        txtdnii.setText("");
        txtnombre.setText("");
        txtsueldomin.setText("0.00");
        txtpuntos.setText("0.00");
        lblabono.setText("0.00");
        txtdnii.requestFocus();
    }
    public void setBtncalculos (View view){
        Double sueldo;
        int puntos;
        Double abono = 0.00;
        sueldo = Double.parseDouble(txtsueldomin.getText().toString());
        puntos = Integer.parseInt(txtpuntos.getText().toString());
        if ( puntos <= 100){
            abono = sueldo;
        }
        else if ( puntos > 100 && puntos <=150){
            abono = sueldo*2;
        }
        else{
            abono = sueldo*3;
        }
        lblabono.setText("S/" + String.format("%.2f", abono));
    }
    public void setBtnsalirse(View view) {
        finish();
    }
}