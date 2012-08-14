package models.demo;

import com.greenlaw110.rythm.Rythm;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 17/05/12
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Foo {
    public String bar;
    public Foo() {
        bar = UUID.randomUUID().toString();
    }
    public Long bee() {
        return System.currentTimeMillis();
    }
    public int rint() {
        return new Random().nextInt();
    }
    public Date date() {
        return new Date();
    }
    public Date nullDate() {
        return null;
    }

    public String name;
    public String getName() {
        return "foo_" + name;
    }

    public Foo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Rythm.toString(this);
    }
}
