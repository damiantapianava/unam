package mx.unam.login;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class CalculatorActivityDMO extends AppCompatActivity implements View.OnClickListener
{
    protected TextView txt_display_CALC;

    protected String number_TOKEN;

    protected List<String> calculator_TOKEN;

    protected boolean operator_ENABLED;

    protected void init_button_CALC()
    {
        findViewById(R.id.btn_dec_CALC).setOnClickListener(this);
        findViewById(R.id.btn_bin_CALC).setOnClickListener(this);
        findViewById(R.id.btn_delete_CALC).setOnClickListener(this);
        findViewById(R.id.btn_modulo_CALC).setOnClickListener(this);
        findViewById(R.id.btn_siete_CALC).setOnClickListener(this);
        findViewById(R.id.btn_ocho_CALC).setOnClickListener(this);
        findViewById(R.id.btn_nueve_CALC).setOnClickListener(this);
        findViewById(R.id.btn_div_CALC).setOnClickListener(this);
        findViewById(R.id.btn_cuatro_CALC).setOnClickListener(this);
        findViewById(R.id.btn_cinco_CALC).setOnClickListener(this);
        findViewById(R.id.btn_seis_CALC).setOnClickListener(this);
        findViewById(R.id.btn_mul_CALC).setOnClickListener(this);
        findViewById(R.id.btn_uno_CALC).setOnClickListener(this);
        findViewById(R.id.btn_dos_CALC).setOnClickListener(this);
        findViewById(R.id.btn_tres_CALC).setOnClickListener(this);
        findViewById(R.id.btn_resta_CALC).setOnClickListener(this);
        findViewById(R.id.btn_punto_CALC).setOnClickListener(this);
        findViewById(R.id.btn_cero_CALC).setOnClickListener(this);
        findViewById(R.id.btn_igual_CALC).setOnClickListener(this);
        findViewById(R.id.btn_suma_CALC).setOnClickListener(this);
    }

    protected void delete()
    {
        int end = number_TOKEN.length();

        if(end > 0)
        {
            number_TOKEN = number_TOKEN.substring(0, end-1);
        }

        txt_display_CALC.setText(number_TOKEN);
    }

    protected void init_display_TOKEN(int btn_value_CALC)
    {
        number_TOKEN +=  btn_value_CALC + "";

        calculator_TOKEN.add(btn_value_CALC + "");

        txt_display_CALC.setText(number_TOKEN);

        operator_ENABLED = true;
    }

    protected void init_operator(String operator)
    {
        if(operator_ENABLED)
        {
            calculator_TOKEN.add(operator);

            number_TOKEN += operator;

            txt_display_CALC.setText(number_TOKEN);

            operator_ENABLED = !operator_ENABLED;
        }
    }

    protected void init_calculator_TOKEN()
    {
        Integer result = 0;

        String left, operator, right;
        Integer number_left, number_right;

            left = calculator_TOKEN.get(0);
        operator = calculator_TOKEN.get(1);
           right = calculator_TOKEN.get(2);

         number_left = Integer.parseInt(left);
        number_right = Integer.parseInt(right);

        if (operator.equals("SUM")) {

            result = number_left + number_right;

        } else if (operator.equals("RES")) {

            result = number_left - number_right;

        } else if (operator.equals("MUL")) {

            result = number_left * number_right;

        } else if (operator.equals("DIV")) {

            result = number_left / number_right;

        } else if (operator.equals("MOD")) {

            result = number_left % number_right;

        }

        number_TOKEN = result + "";

        txt_display_CALC.setText(number_TOKEN);

        calculator_TOKEN = new ArrayList<>();
        calculator_TOKEN.add(number_TOKEN);

        operator_ENABLED = true;

    }

    private void procces_list()
    {
        /*
        for(int index = 3; index < calculator_TOKEN.size(); index++)
        {
            token = calculator_TOKEN.get(index);

            number = Integer.parseInt(token);

            if(operator_ENABLED)
            {
                if (token.equals("SUM")) {

                    result += number;

                } else if (token.equals("RES")) {

                    result -= number;

                } else if (token.equals("MUL")) {

                    result *= number;

                } else if (token.equals("DIV")) {

                    result += number;

                } else if (token.equals("MOD")) {

                    result %= number;

                }

                operator_ENABLED = !operator_ENABLED;
            }

            operator_ENABLED = !operator_ENABLED;
        }
*/
    }
}
