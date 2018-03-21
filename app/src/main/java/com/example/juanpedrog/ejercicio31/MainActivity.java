package com.example.juanpedrog.ejercicio31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button clic;
    public  static TextView pais,ciudad,descripcion,temperatura,presion,humedad,temp_min,temp_max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clic=findViewById(R.id.clic);
        pais=findViewById(R.id.pais);
        ciudad=findViewById(R.id.ciudad);
        descripcion=findViewById(R.id.descripcion);
        temperatura=findViewById(R.id.temperatura);
        presion=findViewById(R.id.presion);
        humedad=findViewById(R.id.humedad);
        temp_min=findViewById(R.id.temp_min);
        temp_max=findViewById(R.id.temp_max);
        clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process=new GetJson();
                process.execute();
            }
        });
    }
}
