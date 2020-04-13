package com.pavan.apponeezypay;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pavan.app1modulemathops.MathOps;
import com.pavan.apptwoezypay.IMathOpsApp2;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputOne, inputTwo;
    Button addBtn, subBtn;
    TextView resultTV;

    private Context context;
    protected IMathOpsApp2 AddService;
    ServiceConnection AddServiceConnection;
    private int result;
    private String StringAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initConnection();
    }

    public void initConnection() {

        AddServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {

                AddService = null;
                Log.d("MathOps", "Binding - Service disconnected");

            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                AddService = IMathOpsApp2.Stub.asInterface((IBinder) service);
                Log.d("MathOps", "Binding is done - Service connected");

            }
        };
        if (AddService == null) {
            Intent it = new Intent();
            Log.d("MathOps", "Binding is done - Service connected  ");
            it.setAction("service.MathOpsService");
            it.setPackage("com.pavan.apptwoezypay");
            // binding to remote service
            bindService(it, AddServiceConnection, Service.BIND_AUTO_CREATE);
        }

    }

    private void initViews() {
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        inputOne = findViewById(R.id.inputOne);
        inputTwo = findViewById(R.id.inputTwo);
        resultTV = findViewById(R.id.resultTV);
        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.addBtn:
                 StringAction = "Addition";
                getResult(true);
                break;

            case R.id.subBtn:
                 StringAction = "Substraction";
                getResult(false);
                break;
        }

    }

    private void getResult(boolean isAdd) {



        if(inputOne.getText().toString().length()>0 && inputTwo.getText().toString().length()>0){
            int num1 = Integer.parseInt(inputOne.getText().toString());
            int num2 = Integer.parseInt(inputTwo.getText().toString());
            MathOps mathOps = new MathOps();
            int result = mathOps.getMathOpsResult(num1, num2, isAdd, AddService);
            resultTV.setText("Input One - "+num1+"\n"+"Input Two - "+num2+"\n"+"Action - "+StringAction+"\n"+"Output is - "+result);


        }
        else {

            Toast.makeText(this,"Input field cannot be empty",Toast.LENGTH_SHORT).show();
        }

    }

}
