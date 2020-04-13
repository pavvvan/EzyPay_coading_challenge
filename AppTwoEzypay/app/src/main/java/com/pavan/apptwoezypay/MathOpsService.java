package com.pavan.apptwoezypay;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MathOpsService extends Service {
    public IBinder onBind(Intent intent) {

        return mBinder;
    }


    private final IMathOpsApp2.Stub mBinder = new IMathOpsApp2.Stub() {
        @Override
        public int add(int num1, int num2, boolean isAdd) throws RemoteException {
            System.out.println("ADD " +num1+num2);
            if(isAdd){
                return num1+num2;
            }
            else {
                return num1-num2;
            }
        }
        };
}
