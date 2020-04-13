package com.pavan.app1modulemathops;

import android.os.RemoteException;
import android.util.Log;

import com.pavan.apptwoezypay.IMathOpsApp2;

public class MathOps {

    private int result;

    public int getMathOpsResult(int num1, int num2, boolean isAdd, IMathOpsApp2 addService) {

        try {
            if (addService == null) {
                Log.d("MathOps", "add service is null ");
            } else {
                result = addService.add(num1, num2, isAdd);
            }

        } catch (RemoteException e) {

            e.printStackTrace();
            Log.d("MathOps  ", e.toString());
        }

        return result;
    }


}
