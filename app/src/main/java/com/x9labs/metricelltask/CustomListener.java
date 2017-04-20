package com.x9labs.metricelltask;

/**
 * Created by crix9 on 20/04/2017.
 */

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

public class CustomListener extends PhoneStateListener {
    Context mContext;


    public CustomListener(Context context) {
        mContext = context;
    }

    @Override
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);

        if (signalStrength.isGsm()) {
            MainActivity.signalStrengthValue.setText(Integer.toString(signalStrength.getGsmSignalStrength()));
        }
    }

    @Override
    public void onCellLocationChanged(CellLocation location) {
        super.onCellLocationChanged(location);
        if (location instanceof GsmCellLocation) {
            GsmCellLocation cellLocation = (GsmCellLocation) location;
            MainActivity.cellLocationValue.setText(cellLocation.toString());
        } else if (location instanceof CdmaCellLocation) {
            CdmaCellLocation cellLocation = (CdmaCellLocation) location;
            MainActivity.cellLocationValue.setText(cellLocation.toString());
        }else{
            MainActivity.cellLocationValue.setText(location.toString());
        }

    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        switch (serviceState.getState()) {
            case ServiceState.STATE_IN_SERVICE:

                MainActivity.serviceStateValue.setText("In Service");
                break;
            case ServiceState.STATE_OUT_OF_SERVICE:

                MainActivity.serviceStateValue.setText("Out of Service");
                break;
            case ServiceState.STATE_EMERGENCY_ONLY:

                MainActivity.serviceStateValue.setText("Emergency Calls Only");
                break;
            case ServiceState.STATE_POWER_OFF:

                MainActivity.serviceStateValue.setText("Power off");
                break;
        }
    }
}
