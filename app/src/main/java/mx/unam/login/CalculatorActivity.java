package mx.unam.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends CalculatorActivityAMO implements View.OnClickListener
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        number_TOKEN = "";

        txt_display_CALC = (TextView) findViewById(R.id.txt_display_CALC);

        init_button_CALC();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_dec_CALC:
                init_calculator_mode(true);
                break;
            case R.id.btn_bin_CALC:
                init_calculator_mode(false);
                break;
            case R.id.btn_delete_CALC:
                delete();
                break;
            case R.id.btn_punto_CALC:
                number_TOKEN +=  ".";

                txt_display_CALC.setText(number_TOKEN);

                operator_ENABLED = true;
                break;
            case R.id.btn_igual_CALC:
                init_calculator_TOKEN();
                break;
            case R.id.btn_modulo_CALC:
                init_operator("%");
                break;
            case R.id.btn_div_CALC:
                init_operator("/");
                break;
            case R.id.btn_mul_CALC:
                init_operator("*");
                break;
            case R.id.btn_resta_CALC:
                init_operator("-");
                break;
            case R.id.btn_suma_CALC:
                init_operator("+");
                break;
            case R.id.btn_uno_CALC:
                init_number_TOKEN(1);
                break;
            case R.id.btn_dos_CALC:
                init_number_TOKEN(2);
                break;
            case R.id.btn_tres_CALC:
                init_number_TOKEN(3);
                break;
            case R.id.btn_cuatro_CALC:
                init_number_TOKEN(4);
                break;
            case R.id.btn_cinco_CALC:
                init_number_TOKEN(5);
                break;
            case R.id.btn_seis_CALC:
                init_number_TOKEN(6);
                break;
            case R.id.btn_siete_CALC:
                init_number_TOKEN(7);
                break;
            case R.id.btn_ocho_CALC:
                init_number_TOKEN(8);
                break;
            case R.id.btn_nueve_CALC:
                init_number_TOKEN(9);
                break;
            case R.id.btn_cero_CALC:
                init_number_TOKEN(0);
                break;
        }
    }
}
