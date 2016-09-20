package mx.unam.login;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public abstract class ServiceTimerDMO extends Service
{
    public static final String TAG = "unam_tag";
    public static final String ACTION_SEND_TIMER ="com.unam.clase.SEND_TIMER";

    private int counter;

    protected int elapsed_time;

    protected Handler handler = new Handler();

    protected Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            counter++;

            handler.postDelayed(runnable, 1000);

            Intent i = new Intent(ACTION_SEND_TIMER);

            i.putExtra("timer", elapsed_time + counter);

            sendBroadcast(i);

            Log.d(TAG, "int elapsed_time " + elapsed_time + " contador " + counter);
        }
    };
}
