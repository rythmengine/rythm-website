package controllers;

import org.rythmengine.play.Cache4;
import org.rythmengine.utils.S;
import play.i18n.Lang;
import play.mvc.Before;
import play.mvc.Controller;

public class Site extends Controller {

    @Before
    public static void setLang() {
        String lang = params.get("lang");
        if (S.notEmpty(lang)) {
            Lang.set(lang);
        }
    }

    @Cache4(langSensitive = true)
    public static void index() {
        render();
    }
    
    @Cache4(langSensitive = true)
    public static void community() {
        render();
    }
    
    @Cache4(langSensitive = true)
    public static void about() {
        render();
    }
}
