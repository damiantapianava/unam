package mx.unam.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public abstract class StarterActivityDMO
{
    protected Context context;
    protected Activity parent;
    protected Intent intent;

    protected String user_email;

    protected boolean user_ENABLED;

    public void setUser_ENABLED(boolean user_ENABLED)
    {
        this.user_ENABLED = user_ENABLED;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public void setActivity(Activity activity)
    {
        parent = activity;
    }

    public void setEmail(String email)
    {
        user_email = email;
    }
}
