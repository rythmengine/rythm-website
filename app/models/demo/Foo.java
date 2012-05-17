package models.demo;

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
}
