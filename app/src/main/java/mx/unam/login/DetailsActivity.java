package mx.unam.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView txt;

    private ProfileFragment profile_1;
    private ProfileFragment profile_2;

    private String user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txt = (TextView) findViewById(R.id.detail_username);

        user_email = getIntent().getExtras().getString("user_email");

        user_email = String.format(getString(R.string.hello), user_email);

        txt.setText(user_email);

        findViewById(R.id.btn_fragment_A).setOnClickListener(this);
        findViewById(R.id.btn_fragment_B).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_fragment_A:
                profile_1 = ProfileFragment.getInstance("DAMIAN");

                getFragmentManager().beginTransaction().replace(R.id.holder_fragment, profile_1).commit();

                break;

            case R.id.btn_fragment_B:

                init_change_IMG();

                profile_2 = ProfileFragment.getInstance("JOANNA");

                getFragmentManager().beginTransaction().replace(R.id.holder_fragment, profile_2).commit();

                ProfileFragment fragment = (ProfileFragment) getFragmentManager().findFragmentById(R.id.fragment_XML);

                if (fragment != null)
                {
                    fragment.changeIMG();

                }

                getFragmentManager().beginTransaction().replace(R.id.holder_fragment, new ListaFragment()).commit();

                break;
        }
    }

    private void init_change_IMG()
    {

    }
}
