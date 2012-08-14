package models.demo;

import com.greenlaw110.rythm.Rythm;
import com.greenlaw110.rythm.toString.NoExpose;
import com.greenlaw110.rythm.toString.ToStringOption;
import com.greenlaw110.rythm.toString.ToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Transient;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 16/07/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    private String firstName;
    public String lastName;

    @Transient
    public String hash = UUID.randomUUID().toString();

    public transient int dice = 100;

    public static int version = 5;

    public Account(String fn, String ln, String password) {
        firstName = fn;
        lastName = ln;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fn) {
        firstName = fn;
    }

    @NoExpose
    private String password;

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return Rythm.toString(this);
    }

    public String toStringWithTransient() {
        return Rythm.toString(this, ToStringOption.defaultOption.setAppendTransient(true), null);
    }

    public String toStringSimpleStyle() {
        return Rythm.toString(this, ToStringOption.defaultOption, ToStringStyle.SIMPLE_STYLE);
    }

    public String toStringMultiLineStyle() {
        return Rythm.toString(this, ToStringOption.defaultOption, ToStringStyle.MULTI_LINE_STYLE);
    }

    public static void main(String[] args) {
        Account a = new Account("Rythm", "Java", "abiudsew");
        String s = null;
        for (int i = 0; i < 10; ++i) {
            s = ReflectionToStringBuilder.reflectionToString(a, null, true);
        }
        System.out.println(s);
        ToStringOption op = ToStringOption.defaultOption.setAppendTransient(true);
        for (int i = 0; i < 10; ++i) {
            s = Rythm.toString(a, op, null);
        }
        System.out.println(s);
        for (int i = 0; i < 10; ++i) {
            s = Rythm.toString("lastName=@_.lastName,firstName=@_.getFirstName(),dice=@_.dice,hash=@_.hash,password=@_.getPassword()", a);
        }
        System.out.println(s);
        long l = System.currentTimeMillis();
        int max = 100000;
        for (int i = 0; i < max; ++i) {
            a = new Account("Rythm", "Java", "abiudsew");
            ReflectionToStringBuilder.reflectionToString(a, null, true);
        }
        long commons = System.currentTimeMillis() - l;
        l = System.currentTimeMillis();
        for (int i = 0; i < max; ++i) {
            a = new Account("Rythm", "Java", "abiudsew");
            Rythm.toString(a, op, null);
        }
        long rythm = System.currentTimeMillis() - l;
        l = System.currentTimeMillis();
        for (int i = 0; i < max; ++i) {
            a = new Account("Rythm", "Java", "abiudsew");
            Rythm.toString("lastName=@_.lastName,firstName=@_.getFirstName(),dice=@_.dice,hash=@_.hash,password=@_.getPassword()", a);
        }
        long rythm2 = System.currentTimeMillis() - l;
        System.out.println(String.format("rythm: %s; commons: %s; rythm2: %s", rythm, commons, rythm2));
    }
}
