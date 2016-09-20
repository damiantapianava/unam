package mx.unam.login;

import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public abstract class DetailsActivityDMO extends AppCompatActivity
{
    protected Context context;

    protected FragmentManager manager;

    protected ProfileFragment fragment_profile;
    protected ProfileFragment fragment_XML;

    protected IntentFilter filter;

    protected Bundle bundle;

    protected TextView txt;
    protected TextView txtTimer;

    protected PreferenceUtil preference;

    protected String user_email;

    protected int profile_id;

    protected final int LETRA_INICIAL = 0;

    protected int letra_inicial;
    protected int counter;

    protected boolean rango_AM_ENABLED;
    protected boolean rango_NZ_ENABLED;

    protected BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            counter = intent.getExtras().getInt("timer");

            txtTimer.setText(String.format("Session lenght %s seconds", counter));
        }
    };

}
