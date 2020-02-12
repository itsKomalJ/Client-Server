package com.example.komal.Client_Server;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myDialog();
        Button b1,b2,b3;

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1,et2;
                et1=(EditText)findViewById(R.id.et1);
                et2=(EditText)findViewById(R.id.et2);
                String s1=et1.getText().toString();
                String s2=et2.getText().toString();
                Intent i1=new Intent(MainActivity.this,MainServer.class);
                i1.putExtra("ip",s1);
                i1.putExtra("port",s2);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1,et2;
                et1=(EditText)findViewById(R.id.et1);
                et2=(EditText)findViewById(R.id.et2);
                String s1=et1.getText().toString();
                String s2=et2.getText().toString();
                Intent i=new Intent(MainActivity.this,MainClient.class);
                i.putExtra("ip",s1);
                i.putExtra("port",s2);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

















    private void myDialog() {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(R.drawable.welcome_dialog);
        b.setTitle("WELCOME");
        b.setMessage("SELECT SERVER OR CLIENT");
        b.setPositiveButton("OK",null);
        AlertDialog d=b.create();
        d.show();
    }

}