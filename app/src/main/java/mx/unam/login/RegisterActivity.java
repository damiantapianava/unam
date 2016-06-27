package mx.unam.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends RegisterActivityDMO implements View.OnClickListener
{

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
        context = getApplicationContext();

        try
        {
            mUserName = mUser.getText().toString();
            password  = mPassword.getText().toString();

            new_user_ENABLED = !TextUtils.isEmpty(mUserName) && !TextUtils.isEmpty(password);

        } catch (Exception e) {

            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }

        if(new_user_ENABLED)
        {
            user = new ModelUser();
            user.setUserName(mUserName);
            user.setPassword(password);

/*
            writer = new PreferenceUtil(context);
            writer.saveUser(user);
*/

            user_DAO = new UserDataSource(context);
            boolean add_OK = user_DAO.persist(user);

            if(add_OK)
            {
                finish();

            } else {

                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
