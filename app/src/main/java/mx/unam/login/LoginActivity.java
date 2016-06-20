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
        }
    }

    private void processData()
    {
        user_email = email.getText().toString();
              pass = password.getText().toString();

        user_ENABLED = (user_email.equals("damian")) && pass.equals("pass");

        user_ENABLED = true;

        loading.setVisibility(View.VISIBLE);

        starter = new StarterActivityIMP();
        starter.setContext(context);
        starter.setActivity(this);
        starter.setEmail(user_email);
        starter.setUser_ENABLED(user_ENABLED);

        handler = new Handler();
        handler.postDelayed(starter, seconds);

        loading.setVisibility(View.GONE);
    }
}
