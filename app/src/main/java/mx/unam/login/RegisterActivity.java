package mx.unam.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText mUser;
    private EditText mPassword;

    private PreferenceUtil writer;

    protected UserDataSource userDataSource;

    protected ModelUser user;

    protected String mUserName;
    protected String password;

    protected boolean new_user_ENABLED;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

            mUser = (EditText) findViewById(R.id.mUserRegister);
        mPassword = (EditText) findViewById(R.id.mPasswordRegister);

        findViewById(R.id.btnRegisterUser).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        try
        {
            mUserName = mUser.getText().toString();
            password  = mPassword.getText().toString();

            new_user_ENABLED = !TextUtils.isEmpty(mUserName) && !TextUtils.isEmpty(password);

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }

        if(new_user_ENABLED)
        {
            user = new ModelUser(mUserName, password);

            writer = new PreferenceUtil(getApplicationContext());
            writer.saveUser(user);

            userDataSource = new UserDataSource(this);
            boolean add_OK = userDataSource.saveItem(user);

            if(add_OK) {
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
