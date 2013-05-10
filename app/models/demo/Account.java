package models.demo;

import org.rythmengine.Rythm;
import org.rythmengine.toString.NoExpose;
import org.rythmengine.toString.ToStringOption;
import org.rythmengine.toString.ToStringStyle;

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
        return Rythm.toString(this, ToStringOption.DEFAULT_OPTION.setAppendTransient(true), null);
    }

    public String toStringSimpleStyle() {
        return Rythm.toString(this, ToStringOption.DEFAULT_OPTION, ToStringStyle.SIMPLE_STYLE);
    }

    public String toStringMultiLineStyle() {
        return Rythm.toString(this, ToStringOption.DEFAULT_OPTION, ToStringStyle.MULTI_LINE_STYLE);
    }

}
