package mx.unam.login;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public abstract class LoginActivityDMO extends AppCompatActivity
{
    protected Context context;

    protected EditText email;
    protected EditText password;
    protected View loading;

    protected PreferenceUtil preference;

    protected ModelUser user;

    protected Intent intent;

    protected String user_email;
    protected String pass;

    protected boolean user_ENABLED;

    protected final long seconds = 1000 * 1;

    protected void processData()
    {
        user_email = email.getText().toString();
              pass = password.getText().toString();

        loading.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                loading.setVisibility(View.GONE);

                user = preference.getUser();

                if(user != null)
                {
                    user_ENABLED = (user.getUserName().equals(user_email)) && user.getPassword().equals(pass);
                }

                if(user == null)
                {
                    Toast.makeText(context, "You need register",Toast.LENGTH_SHORT).show();

                } else if(user_ENABLED) {

                    Toast.makeText(context, "Login Toast", Toast.LENGTH_SHORT).show();

                    intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("user_email", user_email);

                    startActivity(intent);

                } else {

                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }, seconds);
    }

    protected void launchRegister()
    {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

        startActivity(intent);
    }
}
