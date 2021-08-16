package com.jsstech.telephonyappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txtdata);


        TelephonyManager telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String networkcountryISo=telephonyManager.getNetworkCountryIso();
        String simCountryISo=telephonyManager.getSimCountryIso();
        String simOperationName=telephonyManager.getSimOperatorName();

        String PhoneType="";

        int phoneType=telephonyManager.getPhoneType();
        switch (phoneType){
            case (TelephonyManager.PHONE_TYPE_CDMA):
                PhoneType = "cdma";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                PhoneType = "Gsm";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                PhoneType = "none";
                break;

        }
        boolean checkRomaing=telephonyManager.isNetworkRoaming();
        String data= "Your mobile details are below....\n";
        data += "\n Network country Iso is -  " +networkcountryISo;
        data += "\n Sim country Iso is -   " +simCountryISo;
        data += "\n Network type is - "   +PhoneType;
        data += "\n Romaing on is -   "  +checkRomaing;
        data += "\n Operator on is -  " +simOperationName;
textView.setText(data);
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }
}