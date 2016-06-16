package mx.unam.login;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public abstract class DetailsActivityDMO extends AppCompatActivity
{
    protected FragmentManager manager;

    protected ProfileFragment fragment_profile;
    protected ProfileFragment fragment_XML;

    protected Bundle bundle;

    protected TextView txt;

    protected String user_email;

    protected int profile_id;

    protected final int LETRA_INICIAL = 0;

    protected int letra_inicial;

    protected boolean rango_AM_ENABLED;
    protected boolean rango_NZ_ENABLED;

}
