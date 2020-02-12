package com.example.komal.Client_Server;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainClient extends Activity {

    TextView response;
    EditText editTextAddress,editTextPort;
    Button buttonConnect, buttonClear;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
        editTextAddress = (EditText)findViewById(R.id.addressEditText);
        editTextPort=(EditText)findViewById(R.id.portEditText);
        buttonClear=(Button)findViewById(R.id.clearButton);
        buttonConnect=(Button)findViewById(R.id.connectButton);
        response=(TextView)findViewById(R.id.responseTextView);

        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client myClient=new Client(editTextAddress.getText().toString(),Integer.parseInt(editTextPort.getText().toString()),response);
                myClient.execute();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.setText("");
            }
        });
    }
}
