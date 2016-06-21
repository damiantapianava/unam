package mx.unam.login;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public abstract class CalculatorActivityDMO extends AppCompatActivity implements View.OnClickListener
{
    protected TextView txt_display_CALC;

    protected RecursiveParserIMP parser;

    protected Double result = 0D;

    protected String number_TOKEN;

    protected boolean operator_ENABLED;

    protected void init_button_CALC()
    {
        findViewById(R.id.btn_dec_CALC).setOnClickListener(this);
        findViewById(R.id.btn_bin_CALC).setOnClickListener(this);
        findViewById(R.id.btn_delete_CALC).setOnClickListener(this);
        findViewById(R.id.btn_modulo_CALC).setOnClickListener(this);
        findViewById(R.id.btn_div_CALC).setOnClickListener(this);
        findViewById(R.id.btn_mul_CALC).setOnClickListener(this);
        findViewById(R.id.btn_resta_CALC).setOnClickListener(this);
        findViewById(R.id.btn_punto_CALC).setOnClickListener(this);
        findViewById(R.id.btn_cero_CALC).setOnClickListener(this);
        findViewById(R.id.btn_igual_CALC).setOnClickListener(this);
        findViewById(R.id.btn_suma_CALC).setOnClickListener(this);
        findViewById(R.id.btn_uno_CALC).setOnClickListener(this);
        findViewById(R.id.btn_dos_CALC).setOnClickListener(this);
        findViewById(R.id.btn_tres_CALC).setOnClickListener(this);
        findViewById(R.id.btn_cuatro_CALC).setOnClickListener(this);
        findViewById(R.id.btn_cinco_CALC).setOnClickListener(this);
        findViewById(R.id.btn_seis_CALC).setOnClickListener(this);
        findViewById(R.id.btn_siete_CALC).setOnClickListener(this);
        findViewById(R.id.btn_ocho_CALC).setOnClickListener(this);
        findViewById(R.id.btn_nueve_CALC).setOnClickListener(this);
    }

    protected void init_calculator_mode(boolean btn_ENBLED)
    {
        findViewById(R.id.btn_dos_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_tres_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_cuatro_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_cinco_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_seis_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_siete_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_ocho_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_nueve_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_modulo_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_div_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_mul_CALC).setEnabled(btn_ENBLED);
        findViewById(R.id.btn_resta_CALC).setEnabled(btn_ENBLED);
    }

}
