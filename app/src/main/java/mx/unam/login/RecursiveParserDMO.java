package mx.unam.login;

public abstract class RecursiveParserDMO
{
    protected int find(String s, char c)
    {
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;

            if (s.charAt(i) == c && count == 0)

                return i;
        }
        return -1;
    }

    protected double evaluate(String s)
    {
        if (s.indexOf("-'") > 0)
        {
            return Double.parseDouble(s.substring(0, (s.indexOf("-") - 1))) - Double.parseDouble(s.substring((s.indexOf("-") + 1), s.length()));

        } else if (s.indexOf("+'") > 0) {

            return Double.parseDouble(s.substring(0, (s.indexOf("+") - 1))) + Double.parseDouble(s.substring((s.indexOf("+") + 1), s.length()));

        }  else if (s.indexOf("*'") > 0) {

            return Double.parseDouble(s.substring(0, (s.indexOf("*") - 1))) * Double.parseDouble(s.substring((s.indexOf("*") + 1), s.length()));

        } else if (s.indexOf("/'") > 0) {

            return Double.parseDouble(s.substring(0, (s.indexOf("/") - 1))) / Double.parseDouble(s.substring((s.indexOf("/") + 1), s.length()));

        } else if (s.indexOf("%'") > 0) {

            return Double.parseDouble(s.substring(0, (s.indexOf("%") - 1))) % Double.parseDouble(s.substring((s.indexOf("%") + 1), s.length()));

        } else {

            return (Double.parseDouble(s));
        }
    }
}
