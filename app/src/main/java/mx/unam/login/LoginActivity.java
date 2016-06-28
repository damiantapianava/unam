package mx.unam.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends LoginActivityAMO implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        email        = (EditText) findViewById(R.id.main_ACT_email);
        password     = (EditText) findViewById(R.id.main_ACT_password);
        checkBox     = (CheckBox) findViewById(R.id.chkRememberMe);
        txtLastLogin = (TextView) findViewById(R.id.txtLastLogin);

        loading = findViewById(R.id.progress);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_init_calculator).setOnClickListener(this);
        findViewById(R.id.btnRegisterLogin).setOnClickListener(this);
        findViewById(R.id.btn_logout).setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(this);

        context = getApplicationContext();

        init_preference();
    }

    @Override
    public void onClick(View v)
    {
        context = getApplicationContext();

        switch (v.getId())
        {
            case R.id.btn_login:
                processData();
                break;
            case R.id.btn_init_calculator:
                startActivity(new Intent(context, CalculatorActivity.class));
                break;
            case R.id.btnRegisterLogin:
                launchRegister();
                break;
            case R.id.btn_logout:
                logout();
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        remember_login_ENABLED = isChecked;

        Log.d(ServiceTimer.TAG, "remember_login_ENABLED = " + remember_login_ENABLED);

        preference.setRemember_login_ENABLED(remember_login_ENABLED);
    }
}
