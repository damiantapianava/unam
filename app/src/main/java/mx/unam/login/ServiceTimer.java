package mx.unam.login;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class ServiceTimer extends ServiceTimerDMO
{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        Log.d(TAG, "ServiceTimer.onCreate(): ");

        handler.post(runnable);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        elapsed_time = intent.getExtras().getInt("elapsed_time");

        Log.d(TAG, "ServiceTimer.onStartCommand(): " + elapsed_time);

        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        Log.d(TAG, "ServiceTimer.OnDestroy(): ");

        handler.removeCallbacks(runnable);
    }
}
