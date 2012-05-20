package controllers;

import models.demo.Foo;
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

    public static void groovy() {
        Foo foo = new Foo();
        render(foo);
    }

    public static void p_i12() {
        Foo foo = new Foo("Hello");
        render(foo);
    }
}
