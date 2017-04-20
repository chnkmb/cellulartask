package com.x9labs.metricelltask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;


public class MainActivity extends AppCompatActivity {

    public static TextView cellLocationValue, signalStrengthValue, serviceStateValue;
    TelephonyManager telephonyManager;
    PhoneStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cellLocationValue = (TextView) findViewById(R.id.cellLocationValue);
        signalStrengthValue = (TextView) findViewById(R.id.signalStrengthValue);
        serviceStateValue = (TextView) findViewById(R.id.serviceStateValue);

        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        listener = new CustomListener(this);
        telephonyManager.listen(listener,
                PhoneStateListener.LISTEN_SIGNAL_STRENGTHS | PhoneStateListener.LISTEN_SERVICE_STATE | PhoneStateListener.LISTEN_CELL_LOCATION );
    }
}

