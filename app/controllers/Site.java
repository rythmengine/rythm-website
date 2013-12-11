package controllers;

import org.rythmengine.play.Cache4;
import play.mvc.Controller;

public class Site extends Controller {
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
