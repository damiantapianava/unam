package mx.unam.login;

import android.content.Intent;
import android.widget.Toast;

public final class StarterActivityIMP extends StarterActivityDMO implements Runnable
{
    @Override
    public void run()
    {
        if(user_ENABLED)
        {
            Toast.makeText(context, "Login Toast", Toast.LENGTH_SHORT).show();

            intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("user_email", user_email);

            parent.startActivity(intent);

        } else {

            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
