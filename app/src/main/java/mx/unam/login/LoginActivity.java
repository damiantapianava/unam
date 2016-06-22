package mx.unam.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends LoginActivityDMO implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        email    = (EditText) findViewById(R.id.main_ACT_email);
        password = (EditText) findViewById(R.id.main_ACT_password);

        loading = findViewById(R.id.progress);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_init_calculator).setOnClickListener(this);
        findViewById(R.id.btnRegisterLogin).setOnClickListener(this);

        preference = new PreferenceUtil(getApplicationContext());
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
        }
    }
}
