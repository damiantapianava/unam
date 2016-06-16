package mx.unam.login;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileFragment extends Fragment
{
    private View view;
    private TextView txt;
    private ImageView img_view;

    private Bundle bundle;

    private String username;

    private boolean change = true;

    public static ProfileFragment getInstance(String name) {
        ProfileFragment pf = new ProfileFragment();

        Bundle b = new Bundle();
        b.putString("username", name);
        pf.setArguments(b);

        return pf;
    }

    public void changeIMG()
    {
        img_view.setImageResource(change ? R.drawable.ic_editor_insert_emoticon : R.drawable.ic_editor_insert_emoticon);

        change = !change;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.profile_fragment, container, false);

        img_view = (ImageView) view.findViewById(R.id.img_profile);

        txt = (TextView) view.findViewById(R.id.txt_user_fragment);

        bundle = getArguments();

        if(bundle != null)
        {
            username = bundle.getString("username");

        } else {

            username = "XML inflate";
        }

        txt.setText(username);

        return view;
    }
}
