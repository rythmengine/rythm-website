package templates;

import com.greenlaw110.rythm.play.FastTagBridge;
import com.greenlaw110.rythm.template.TemplateBase;
import groovy.lang.Closure;
import org.apache.commons.lang3.ObjectUtils;
import play.templates.FastTags;
import play.templates.GroovyTemplate;
import play.templates.TagContext;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 21/04/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
@FastTags.Namespace("ft")
public class MyFastTags extends FastTags {
    public static void _foo(Map<?, ?> args, Closure body, PrintWriter out, GroovyTemplate.ExecutableTemplate template, int fromLine) {
        out.println("Inside fasttags:foo(), timestamp:" + System.currentTimeMillis());
        if (null != body) body.call();
    }

    /**
     * See https://groups.google.com/forum/#!topic/play-framework/EkdizxWeosY/discussion
     */
    public static void _variant(Map<?, ?> args, Closure body, PrintWriter out, GroovyTemplate.ExecutableTemplate template, int fromLine) {
        String _name = args.get("arg") == null ? args.get("name").toString() : args.get("arg").toString();
        if (ObjectUtils.equals(_name, TagContext.parent().data.get("variant")) && null != body) {
            body.call();
        }
    }
    public static void _test(Map<?, ?> args, Closure body, PrintWriter out, GroovyTemplate.ExecutableTemplate template, int fromLine) {
        int i = new Random().nextInt(100);
        TagContext.current().data.put("variant", (i % 2 == 0) ? "nameA" : "nameB");
        if (null != body) body.call();
    }
}
