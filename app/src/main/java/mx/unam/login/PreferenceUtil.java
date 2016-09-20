package mx.unam.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class PreferenceUtil
{
    private static final String FILE_NAME = "unam_pref";

    private final SharedPreferences sp;

    private boolean remember_login_ENABLED;

    public PreferenceUtil(Context context)
    {
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveElapsedTime(int seconds)
    {
        sp.edit().putInt("elapsed_time", seconds);
    }

    public int getElapsedTime()
    {
        return sp.getInt("elapsed_time", 0);
    }

    public void saveUserId(ModelUser modelUser)
    {
        sp.edit().putInt("user_id",  modelUser.getId()).apply();
/*
        sp.edit().putString("user_name",     modelUser.getUserName()).apply();
        sp.edit().putString("user_password", modelUser.getPassword()).apply();
*/
    }

    public Integer getUserId()
    {
        Integer user_id = sp.getInt("user_id", -1);

        return user_id;
    }

    public void remove(String key)
    {
        sp.edit().remove(key).apply();
    }

    public ModelUser getUser()
    {
        String mUser     = sp.getString("user_name",null);
        String mPassword = sp.getString("user_password",null);

        if(TextUtils.isEmpty(mUser) || TextUtils.isEmpty(mPassword))
        {
            return null;
        }

        ModelUser user = new ModelUser();
        user.setUserName(mUser);
        user.setPassword(mPassword);

        return user;
    }

    public void setRemember_login_ENABLED(boolean remember_login_ENABLED)
    {
        sp.edit().putBoolean("key_remember_login", remember_login_ENABLED).apply();
    }

    public boolean isRemember_login_ENABLED()
    {
        remember_login_ENABLED = sp.getBoolean("key_remember_login", false);

        return remember_login_ENABLED;
    }


}
