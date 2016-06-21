package mx.unam.login;

public class RecursiveParserIMP extends RecursiveParserDMO
{
    public double evaluateIntern(String s) throws ParserException
    {
        int index;

        if (s.isEmpty())
        {
            throw new ParserException("Empty string");
        }

        if (s.charAt(0) == '-' || s.charAt(0) == '+')
        {
            s = '0' + s;
        }

        if ((index = find(s, '+')) >= 0)
        {
            return (evaluateIntern(s.substring(0, index)) + evaluateIntern(s.substring(index+1, s.length())));

        } else if ((index = find(s, '-')) >= 0) {

            return (evaluateIntern(s.substring(0, index)) - evaluateIntern(s.substring(index+1, s.length())));

        }  else if ((index = find(s, '*')) >= 0) {

            return (evaluateIntern(s.substring(0, index)) * evaluateIntern(s.substring(index+1, s.length())));

        } else if ((index = find(s, '/')) >= 0) {

            return (evaluateIntern(s.substring(0, index)) / evaluateIntern(s.substring(index+1, s.length())));

        } else if ((index = find(s, '%')) >= 0) {

            return (evaluateIntern(s.substring(0, index)) % evaluateIntern(s.substring(index+1, s.length())));
        }

        if (s.charAt(0) == '(')
        {
            if (s.charAt(s.length()-1) == ')')
                return (evaluate(s.substring(1, s.length()-1)));
            else
                throw new ParserException("Invalid brackets: " + s);
        }

        try
        {
            return Double.parseDouble(s);

        } catch (NumberFormatException ex) {

            throw new ParserException("String to number parsing exception: " + s);
        }
    }
}
