package mx.unam.login;

public abstract class CalculatorActivityAMO extends CalculatorActivityDMO
{
    protected void delete()
    {
        result = 0D;

        int end = number_TOKEN.length();

        if(end > 0)
        {
            number_TOKEN = number_TOKEN.substring(0, end - 1);
        }

        number_TOKEN = "";

        txt_display_CALC.setText(number_TOKEN);
    }

    protected void init_number_TOKEN(int btn_value_CALC)
    {
        number_TOKEN +=  btn_value_CALC + "";

        txt_display_CALC.setText(number_TOKEN);

        operator_ENABLED = true;
    }

    protected void init_operator(String operator)
    {
        if(operator_ENABLED)
        {
            number_TOKEN += operator;

            txt_display_CALC.setText(number_TOKEN);

            operator_ENABLED = !operator_ENABLED;
        }
    }

    protected void init_calculator_TOKEN()
    {
        try
        {
            parser = new RecursiveParserIMP();

            result = parser.evaluateIntern(number_TOKEN);

            number_TOKEN = result + "";

            operator_ENABLED = true;

            txt_display_CALC.setText(number_TOKEN);

        } catch (ParserException e) {

            e.printStackTrace();
        }
    }
}
