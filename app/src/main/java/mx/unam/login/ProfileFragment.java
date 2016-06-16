package mx.unam.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileFragment extends ProfileFragmentDMO
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.profile_fragment, container, false);

        img_view = (ImageView) view.findViewById(R.id.img_profile);

        txt = (TextView) view.findViewById(R.id.txt_user_fragment);

        bundle = getArguments();

        username = "XML inflate";

        if(bundle != null)
        {
              username = bundle.getString("username");
            profile_id = bundle.getInt("img_view_profile_id");

            img_view.setImageResource(profile_id);
        }

        txt.setText(username);

        return view;
    }
}
