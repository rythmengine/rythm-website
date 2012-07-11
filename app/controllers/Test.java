package controllers;

import com.greenlaw110.rythm.Rythm;
import models.demo.Foo;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 16/05/12
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test extends Controller {

    public static void index() {
        render();
    }

    public static void i29() {
        String[] sa = {"ABC", "XYZ"};
        List<String> names = Arrays.asList(sa);
        Validation.addError("foo","bar");
        render(names);
    }

    public static void i30() {
        int[] vals = {1, 2, 3};
        render(vals);
    }

    public static void i32() {
        Foo foo = new Foo();
        render(foo);
    }

    public static void i40() {
        render();
    }

    public static void i44() {
        render();
    }

    public static void groovy() {
        Foo foo = new Foo();
        render(foo);
    }

    public static void p_i12() {
        Foo foo = new Foo("Hello");
        render(foo);
    }

    public static void p_i16() {
        render();
    }

    public static void p_i24() {
        render();
    }

    public static void p_i30() {
        render();
    }

    public static void i48() {
        String name = "foo";
        render(name);
    }

    public static void i50() {
        render();
    }

    public static void i52() {
        render();
    }

    public static void i53() {
        render();
    }

    public static void i54() {
        render();
    }

    public static void i55() {
        render();
    }

    public static void i56() {
        render();
    }

    public static void i58() {
        render();
    }

    public static void p_i34() {
        render();
    }

    public static void i61() {
        long ts = 50;
        render(ts);
    }

    public static void showMessage() {
        render();
    }
}
