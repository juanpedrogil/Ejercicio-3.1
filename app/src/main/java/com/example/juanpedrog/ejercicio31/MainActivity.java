package com.example.juanpedrog.ejercicio31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button clic;
    public  static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clic=findViewById(R.id.clic);
        data=findViewById(R.id.data);
        clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process=new GetJson();
                process.execute();
            }
        });
    }
}
