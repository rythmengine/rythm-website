package controllers;

import com.greenlaw110.rythm.play.Cache4;
import play.Play;
import play.i18n.Lang;
import play.mvc.Controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Site extends Controller {
    @Cache4
    public static void index() {
        render();
    }
}
