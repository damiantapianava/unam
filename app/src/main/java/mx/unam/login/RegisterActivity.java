package mx.unam.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText mUser;
    private EditText mPassword;

    private PreferenceUtil writer;

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
        String mUserName = mUser.getText().toString();
        String password  = mPassword.getText().toString();
        //salvar al disco ;)
        //TODO validar si vienen vacios
        writer = new PreferenceUtil(getApplicationContext());
        writer.saveUser(new ModelUser(mUserName, password));

        finish();
    }
}
