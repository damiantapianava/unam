package mx.unam.login;


import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public abstract class LoginActivityDMO extends AppCompatActivity
{
    protected EditText email;
    protected EditText password;
    protected View loading;

    protected Context context;

    protected Handler handler;

    protected StarterActivityIMP starter;

    protected String user_email;
    protected String pass;

    protected boolean user_ENABLED;

    protected final long seconds = 1000 * 1;
}
