package mx.unam.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends DetailsActivityAMO implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        manager = getFragmentManager();

        txt = (TextView) findViewById(R.id.detail_username);

        user_email = getIntent().getExtras().getString("user_email");

        init_profile_id();

        user_email = String.format(getString(R.string.hello), user_email);

        txt.setText(user_email);

        findViewById(R.id.btn_perfil_fragment).setOnClickListener(this);
        findViewById(R.id.btn_lista_fragment).setOnClickListener(this);

        txtTimer = (TextView) findViewById(R.id.txtTimer);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        filter = new IntentFilter();
        filter.addAction(ServiceTimer.ACTION_SEND_TIMER);

        registerReceiver(broadcastReceiver, filter);

        Log.d(ServiceTimer.TAG, "DetailsActivity.OnResume(): ");
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        unregisterReceiver(broadcastReceiver);

        Log.d(ServiceTimer.TAG, "DetailsActivity.onPause(): ");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        context = getApplicationContext();

        preference = new PreferenceUtil(context);
        preference.saveElapsedTime(counter);

        stopService(new Intent(context, ServiceTimer.class));

        Log.d(ServiceTimer.TAG, "DetailsActivity.onDestroy(): " + counter);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_perfil_fragment:
                init_perfil_fragment();
                break;

            case R.id.btn_lista_fragment:
                init_lista_fragment();
                break;
        }
    }
}
