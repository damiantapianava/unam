package mx.unam.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculatorActivity extends CalculatorActivityDMO implements View.OnClickListener
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        number_TOKEN = "";

        calculator_TOKEN = new ArrayList<>();

        txt_display_CALC = (TextView) findViewById(R.id.txt_display_CALC);

        init_button_CALC();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_dec_CALC:
            case R.id.btn_bin_CALC:
                break;
            case R.id.btn_delete_CALC:
                delete();
                break;
            case R.id.btn_punto_CALC:
                break;
            case R.id.btn_igual_CALC:
                init_calculator_TOKEN();
                break;
            case R.id.btn_modulo_CALC:
                init_operator("MOD");
                break;
            case R.id.btn_div_CALC:
                init_operator("DIV");
                break;
            case R.id.btn_mul_CALC:
                init_operator("MUL");
                break;
            case R.id.btn_resta_CALC:
                init_operator("RES");
                break;
            case R.id.btn_suma_CALC:
                init_operator("SUM");
                break;
            case R.id.btn_uno_CALC:
                init_display_TOKEN(1);
                break;
            case R.id.btn_dos_CALC:
                init_display_TOKEN(2);
                break;
            case R.id.btn_tres_CALC:
                init_display_TOKEN(3);
                break;
            case R.id.btn_cuatro_CALC:
                init_display_TOKEN(4);
                break;
            case R.id.btn_cinco_CALC:
                init_display_TOKEN(5);
                break;
            case R.id.btn_seis_CALC:
                init_display_TOKEN(6);
                break;
            case R.id.btn_siete_CALC:
                init_display_TOKEN(7);
                break;
            case R.id.btn_ocho_CALC:
                init_display_TOKEN(8);
                break;
            case R.id.btn_nueve_CALC:
                init_display_TOKEN(9);
                break;
            case R.id.btn_cero_CALC:
                init_display_TOKEN(0);
                break;
        }
    }
}
