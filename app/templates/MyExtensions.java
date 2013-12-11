package templates;

import play.templates.JavaExtensions;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 24/05/12
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyExtensions extends JavaExtensions {
    public static String ccyAmount(Number number, String currencySymbol) {
        String format = "'"+currencySymbol + "'#####.##";
        return new DecimalFormat(format).format(number);
    }
}
