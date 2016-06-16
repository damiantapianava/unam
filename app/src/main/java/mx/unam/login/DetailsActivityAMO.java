package mx.unam.login;

import android.os.Bundle;
import android.widget.Toast;

public class DetailsActivityAMO extends DetailsActivityDMO
{
    protected void init_profile_id()
    {
        letra_inicial = (int) user_email.charAt(LETRA_INICIAL);

        rango_AM_ENABLED = (letra_inicial > 64 && letra_inicial < 78) || (letra_inicial >  96 && letra_inicial < 110);
        rango_NZ_ENABLED = (letra_inicial > 77 && letra_inicial < 91) || (letra_inicial > 109 && letra_inicial < 123);

        profile_id = R.drawable.ic_action_settings_voice;

        if(rango_AM_ENABLED)
        {
            profile_id = R.drawable.ic_editor_insert_emoticon;
        }

        if(rango_NZ_ENABLED)
        {
            profile_id = R.drawable.ic_action_settings_voice;
        }
    }

    protected void init_perfil_fragment()
    {
        bundle = new Bundle();
        bundle.putString("username", user_email);
        bundle.putInt("img_view_profile_id", profile_id);

        fragment_profile = ProfileFragment.getInstance();
        fragment_profile.setBundle(bundle);

        manager.beginTransaction().replace(R.id.holder_fragment, fragment_profile).commit();
    }

    protected void init_lista_fragment()
    {
        fragment_XML = (ProfileFragment) manager.findFragmentById(R.id.fragment_XML);

        if (fragment_XML != null)
        {
            fragment_XML.changeIMG();
        }

        manager.beginTransaction().replace(R.id.holder_fragment, new ListaFragment()).commit();
    }
}
