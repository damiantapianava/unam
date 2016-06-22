package mx.unam.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class PreferenceUtil
{
    private static final String FILE_NAME = "unam_pref";

    private final SharedPreferences sp;

    public PreferenceUtil(Context context)
    {
        sp = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }

    public void saveUser(ModelUser modelUser)
    {
        //TODO validar si modelUser==null
        sp.edit().putString("user_name",     modelUser.getUserName()).apply();
        sp.edit().putString("user_password", modelUser.getPassword()).apply();
    }

    public ModelUser getUser()
    {
        String mUser     = sp.getString("user_name",null);
        String mPassword = sp.getString("user_password",null);

        if(TextUtils.isEmpty(mUser) || TextUtils.isEmpty(mPassword))
        {
            return null;
        }

        return new ModelUser(mUser,mPassword);

    }


}
