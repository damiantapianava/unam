package mx.unam.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragmentDMO extends Fragment
{
    protected View view;
    protected TextView txt;
    protected ImageView img_view;

    private static ProfileFragment singleton = null;

    protected Bundle bundle;

    protected String username;

    protected int profile_id;

    protected boolean change = true;

    public static ProfileFragment getInstance()
    {
        if(singleton == null)
        {
            singleton = new ProfileFragment();
        }

        return singleton;
    }

    public void setBundle(Bundle bundle)
    {
        if(singleton != null)
        {
            singleton.setArguments(bundle);
        }
    }

    public void changeIMG()
    {
        img_view.setImageResource(change ? R.drawable.ic_editor_insert_emoticon : R.drawable.ic_action_settings_voice);

        change = !change;
    }
}
