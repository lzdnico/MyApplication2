package com.uestc.nico.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMAAnswer;
    private TextView textViewMReceiver;
    private EditText editTextMA1;
    private EditText editTextMA2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMAAnswer=(TextView)findViewById(R.id.textViewMAAnswer);
        textViewMReceiver=(TextView)findViewById(R.id.textViewMSend);
        editTextMA1=(EditText)findViewById(R.id.editTextMA1);
        editTextMA2=(EditText)findViewById(R.id.editTextMA2);


        findViewById(R.id.buttonMAAnswer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=0,y=0,z;
                x=Integer.parseInt(editTextMA1.getText().toString());
                y=Integer.parseInt(editTextMA2.getText().toString());
                z=x+y;
                textViewMAAnswer.setText(Integer.toString(z));
            }
        });




        findViewById(R.id.buttonMOPenGoogle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com")));
            }
        });

        findViewById(R.id.buttonMOPenBaidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com")));
            }
        });

        findViewById(R.id.buttonMOpenFacebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.jianshu.com/p/2ee0e74abbdf")));
            }
        });




        findViewById(R.id.buttonMSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,TheAnotherAty.class);
                i.putExtra("data","I'am Nico.This year i am 21 years old.Nice to meet you!This is my first android app! ");
                startActivityForResult(i,0);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textViewMReceiver.setText("另一个Aty发送回来的数据是:  "+data.getStringExtra("data1"));
    }
}
