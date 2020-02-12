package com.example.komal.Client_Server;

import android.os.AsyncTask;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Jayesh on 03-04-2017.
 */

public class Client extends AsyncTask<Void,Void,Void>
{

    String dstAddress;
    int dstPort;
    String response="";
    TextView textResponse;

    Client(String addr,int port, TextView textResponse)
    {
        dstAddress=addr;
        dstPort=port;
        this.textResponse=textResponse;
    }

    @Override
    protected Void doInBackground(Void... arg0)
    {
        Socket socket=null;
        try
        {
            socket = new Socket(dstAddress,dstPort);
            ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];
            int bytesRead;
            InputStream inputStream=socket.getInputStream();
            while ((bytesRead=inputStream.read(buffer))!= -1)
            {
                byteArrayOutputStream.write(buffer,0,bytesRead);
                response += byteArrayOutputStream.toString("UTF-8");
            }
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
            response="UnknownHostException:"+ e.toString();

        }
        catch (IOException e)
        {
            e.printStackTrace();
            response= "IOException :"+e.toString();
        }
        finally
        {
            if(socket != null)
            {
                try
                {
                    socket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        textResponse.setText(response);
        super.onPostExecute(result);
    }
}
