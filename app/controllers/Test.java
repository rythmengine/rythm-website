package controllers;

import com.greenlaw110.rythm.Rythm;
import models.demo.Foo;
import play.cache.Cache;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.ArrayList;
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

    public static void i66() {
        render();
    }


    public static void p_i38() {
        render();
    }

    public static void i67() {
        render();
    }


    public static void p_i41() {
        String s = Rythm.toString("@Test.p_i41.ok()", new Test());
        render(s);
    }

    public static void i68() {
        List<String> ls = new ArrayList<String>();
        ls.add("x");
        ls.add("y");
        String s = Rythm.render("hello @who", "world");
        render(ls);
    }

    public static void p_i48(String p1, String p2) {
        render(p1, p2);
    }

    public static void showMessage() {
        render();
    }

    public static void i74() {
        render();
    }


    public static class P35 {
        public String foo = "foo";
    }

    public static void p_i35() {
        Cache.add("foo", new P35());
        render();
    }

    public static void i77() {
        render();
    }

    public static void i78() {
        render();
    }

    public static void p_i50(String a, String b) {
        render();
    }

    public static void ix() {
        render();
    }

    public static void i94() {
        render();
    }

    public static void i95() {
        Foo foo = new Foo("bar");
        render(foo);
    }

    public static void p_i59() {
        render();
    }

}
