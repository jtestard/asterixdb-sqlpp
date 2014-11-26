/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.parser;

/**
 * @author julestestard
 *
 */
public abstract class AbstractParser {

    public static final String removeQuotesAndEscapes(String s) {
        char q = s.charAt(0); // simple or double quote
        String stripped = s.substring(1, s.length() - 1);
        int pos = stripped.indexOf('\\');
        if (pos < 0) {
            return stripped;
        }
        StringBuilder res = new StringBuilder();
        int start = 0;
        while (pos >= 0) {
            res.append(stripped.substring(start, pos));
            char c = stripped.charAt(pos + 1);
            switch (c) {
                case '/':
                case '\\':
                    res.append(c);
                    break;
                case 'b':
                    res.append('\b');
                    break;
                case 'f':
                    res.append('\f');
                    break;
                case 'n':
                    res.append('\n');
                    break;
                case 'r':
                    res.append('\r');
                    break;
                case 't':
                    res.append('\t');
                    break;
                case '\'':
                case '"':
                    if (c == q) {
                        res.append(c);
                        break;
                    }
                default:
                    throw new IllegalStateException("'\\" + c + "' should have been caught by the lexer");
            }
            start = pos + 2;
            pos = stripped.indexOf('\\', start);
        }
        res.append(stripped.substring(start));
        return res.toString();
    }

}
