package controllers;

import com.greenlaw110.rythm.play.Cache4;
import play.mvc.Controller;

public class Site extends Controller {
    @Cache4(langSensitive = true)
    public static void index() {
        render();
    }
}
