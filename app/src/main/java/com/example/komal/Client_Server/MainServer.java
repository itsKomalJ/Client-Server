package com.example.komal.Client_Server;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainServer extends Activity
{
    Server server;
    TextView infoip,msg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_server);
        infoip=(TextView)findViewById(R.id.infoip);
        msg=(TextView)findViewById(R.id.msg);
        server = new Server(this);
        infoip.setText("\n"+server.getIpAddress()+":"+server.getPort()+"\n\n");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        server.onDestroy();
    }
}
