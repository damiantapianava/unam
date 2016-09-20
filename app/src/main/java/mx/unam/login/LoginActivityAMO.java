package mx.unam.login;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public abstract class LoginActivityAMO extends LoginActivityDMO
{
    protected void init_preference()
    {
        preference = new PreferenceUtil(context);

        remember_login_ENABLED = preference.isRemember_login_ENABLED();
                        userID = preference.getUserId();

        checkBox.setChecked(remember_login_ENABLED);

        if(remember_login_ENABLED && userID > 0)
        {
            user_DAO = new UserDataSource(context);

            user = user_DAO.findUserById(userID);

            if(user != null)
            {
                       email.setText(user.getUserName());
                    password.setText(user.getPassword());
                txtLastLogin.setText(user.getLast_login_date());
            }
        }
    }

    protected void logout()
    {
        preference = new PreferenceUtil(context);

        preference.remove("user_id");
    }

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

                //user = preference.getUser();

                user_DAO = new UserDataSource(context);

                user = user_DAO.findUser(user_email, pass);

                if(user != null)
                {
                    user_ENABLED = (user.getUserName().equals(user_email)) && user.getPassword().equals(pass);
                }

                if(user == null)
                {
                    Toast.makeText(context, "You need register",Toast.LENGTH_SHORT).show();

                } else if(user_ENABLED) {

                    Toast.makeText(context, "Login Toast", Toast.LENGTH_SHORT).show();

                    preference.saveUserId(user);

                    boolean update_OK = user_DAO.update_login_date(user);

                    if(update_OK) {
                        intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("user_email", user_email);
                        intent.putExtra("remember_login_ENABLED", remember_login_ENABLED);

                        startActivity(intent);

                        intent_service = new Intent(context, ServiceTimer.class);
                        intent_service.putExtra("elapsed_time", preference.getElapsedTime());

                        startService(intent_service);

                    } else {

                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }

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
