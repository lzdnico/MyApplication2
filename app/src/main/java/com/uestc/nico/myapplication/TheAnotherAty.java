package com.uestc.nico.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TheAnotherAty extends AppCompatActivity {

    private TextView textViewAReceiver;
    private EditText editTextAC1;
    private EditText editTextAC2;
    private TextView textViewACAnswer;
    private EditText editTextASend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_another_aty);


        textViewAReceiver=(TextView)findViewById(R.id.textViewAReceiver);
        editTextAC1=(EditText)findViewById(R.id.editTextAC1);
        editTextAC2=(EditText)findViewById(R.id.editTextAC2);
        textViewACAnswer=(TextView)findViewById(R.id.textViewACAnswer);
        editTextASend=(EditText) findViewById(R.id.editTextASend);


        findViewById(R.id.buttonACAnswer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=0,y=0,z;
                x=Integer.parseInt(editTextAC1.getText().toString());
                y=Integer.parseInt(editTextAC2.getText().toString());
                z=x-y;
                textViewACAnswer.setText(Integer.toString(z));
            }
        });



        Intent i1=getIntent();
        textViewAReceiver.setText(i1.getStringExtra("data"));



        findViewById(R.id.buttonASend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                setResult(1,i);
                i.putExtra("data1",editTextASend.getText().toString());
                finish();
            }
        });
    }
}
