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

public class tradicionesLambayecanas extends AppCompatActivity {
    EditText txtpedido, txtevento,txtcantidad;
    TextView lnltotal;
    Button btnnuevoo, btncalcularr, btnsalirr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tradiciones_lambayecanas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtpedido =(EditText) findViewById(R.id.txtpedido);
        txtevento =(EditText) findViewById(R.id.txtevento);
        txtcantidad =(EditText) findViewById(R.id.txtcantidad);
        lnltotal = (TextView) findViewById(R.id.lbltotal);
        btncalcularr = (Button) findViewById(R.id.btncalcularr);
        btnnuevoo = (Button) findViewById(R.id.btnnuevoo);
        btnsalirr = (Button) findViewById(R.id.btnsalirr);

    }

    public void setBtnnuevoo (View view){
        txtpedido.setText("");
        txtevento.setText("");
        txtcantidad.setText("0.00");
        lnltotal.setText("0.00");
        txtpedido.requestFocus();
    }
    public void setBtncalcularr(View view){
        Double cantidad;
        Double total = 0.00;
        cantidad = Double.parseDouble(txtcantidad.getText().toString());
        if(cantidad <= 200){
            total = 95.00 * cantidad;
        }
        else if (cantidad > 200 && cantidad <= 300){
            total=85.00 * cantidad;
        }
        else {
            total=75.00 * cantidad;
        }
        lnltotal.setText("S/" + String.format("%.2f", total));
    }
    public void setBtnsalirr(View view)
    {
        finish();;
    }


}