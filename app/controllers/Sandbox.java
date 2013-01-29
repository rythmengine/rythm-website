package controllers;

import com.greenlaw110.rythm.Rythm;
import play.mvc.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 23/01/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sandbox extends Controller {

    public static void index(String src) {
        String output = null;
        if (null != src) {
            try {
                output = Rythm.sandbox().render(src);
            } catch (Exception e) {
                output = e.getMessage();
            }
        } else {
            src = "<h1>Test Sandbox</h1>";
        }
        render(src, output);
    }
}
