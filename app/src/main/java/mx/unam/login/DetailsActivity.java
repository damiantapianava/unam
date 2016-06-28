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

    @Override
    protected void onResume()
    {
        super.onResume();

        filter = new IntentFilter();
        filter.addAction(ServiceTimer.ACTION_SEND_TIMER);

        registerReceiver(broadcastReceiver, filter);

        Log.d(ServiceTimer.TAG,"OnResume, se reinicia boradcast");
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        Log.d(ServiceTimer.TAG,"onPause quitando broadcast");

        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        Log.d(ServiceTimer.TAG,"OnDestroy, terminando servicio");

        stopService(new Intent(getApplicationContext(), ServiceTimer.class));
    }
}
