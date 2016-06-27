package mx.unam.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public abstract class RegisterActivityDMO extends AppCompatActivity
{
    protected Context context;

    protected EditText mUser;
    protected EditText mPassword;

    protected PreferenceUtil writer;

    protected UserDataSource user_DAO;

    protected ModelUser user;

    protected String mUserName;
    protected String password;

    protected boolean new_user_ENABLED;
}
