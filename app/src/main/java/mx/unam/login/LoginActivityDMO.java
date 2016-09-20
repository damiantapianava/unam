package mx.unam.login;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public abstract class LoginActivityDMO extends AppCompatActivity
{
    protected Context context;

    protected EditText email;
    protected EditText password;
    protected TextView txtLastLogin;
    protected View loading;
    protected CheckBox checkBox;

    protected UserDataSource user_DAO;
    protected PreferenceUtil preference;

    protected ModelUser user;

    protected Intent intent;
    protected Intent intent_service;

    protected String user_email;
    protected String pass;

    protected Integer userID;

    protected boolean user_ENABLED;
    protected boolean remember_login_ENABLED;

    protected final long seconds = 1000 * 1;

}
