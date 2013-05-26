package controllers;

import controllers.filters.UADetector;
import org.markdown4j.Markdown4jProcessor;
import org.rythmengine.play.Cache4;
import org.rythmengine.utils.S;
import play.Play;
import play.i18n.Lang;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.With;

import java.io.File;
import java.io.IOException;

@With(UADetector.class)
public class Doc extends Controller {

    private static String root = "/doc";
    private static String defLang = "en";
    private static String img = "img";
    private static Markdown4jProcessor markDown = new Markdown4jProcessor(); 

    //private static Set<String> invalidLangs = new HashSet<String>();

    private static String docDir() {
        String lang = Lang.get();
        String dir = root + "/";
        if (null == lang)  {
            //else if (invalidLangs.contains(lang)) return docDirWithDefLang();
            dir = docDirWithDefLang();
        } else {
            dir = root + "/" + lang + "/";
        }
        return dir;
    }

    private static String docDirWithDefLang() {
        String s = defLang;
        //if (invalidLangs.contains(s)) return docDirWithoutLang();
        return root + "/" + s + "/";
    }

    private static String docDirWithoutLang() {
        return root + "/";
    }

    private static String imgDir() {
        return docDir() + img + "/";
    }

    private static String imgDirWithDefLang() {
        return docDirWithDefLang() + img + "/";
    }

    private static String imgDirWithoutLang() {
        return docDirWithoutLang() + img + "/";
    }

    @Cache4(langSensitive = true)
    public static void load(String page, String path1, String path2) throws Exception {
        if (page.endsWith(".md")) page = page.substring(0, page.length() - 3);
        // Just a little validation to make sure the path is not forged
        if (page == null) {
            notFound();
        }

        if (!S.empty(path2)) page = path2 + "/" + page;
        if (!S.empty(path1)) page = path1 + "/" + page;

        File f = new File(Play.applicationPath, docDir() + page + ".md");
        if (!f.exists()) {
            // try defLang
            //invalidLangs.add(Lang.get());
            f = new File(Play.applicationPath, docDirWithDefLang() + page + ".md");
            if (!f.exists()) {
                //invalidLangs.add(defLang);
                f = new File(Play.applicationPath, docDirWithoutLang() + page + ".md");
                if (!f.exists()) {
                    notFound("Markdown page for " + page + " not found");
                }
            }
        }

        //Reader pageReader = new FileReader(f);
        //String html = Markdown.transformMarkdown(pageReader);
        String html = markDown.process(f);
        String fiddleWebSite = Play.configuration.getProperty("fiddle.website", "http://localhost:9000");
        render(page, html, fiddleWebSite);
    }

    public static void image(String imageName, String ext) throws Exception {
        // Just a little validation to make sure the path is not forged
        if (imageName == null || imageName.indexOf('/') > 0
                || imageName.indexOf('\\') > 0 || imageName.indexOf('.') > 0)
            throw new IOException("Invalid path:" + imageName);
        if (ext == null || ext.indexOf('/') > 0 || ext.indexOf('\\') > 0
                || ext.indexOf('.') > 0)
            throw new IOException("Invalid path:" + ext);

        File image = new File(Play.applicationPath, imgDir() + imageName
                + '.' + ext);

        if (!image.exists()) {
            // try defLang
            //invalidLangs.add(Lang.get());
            image = new File(Play.applicationPath, imgDirWithDefLang() + imageName + "." + ext);
            if (!image.exists()) {
                //invalidLangs.add(defLang);
                image = new File(Play.applicationPath, imgDirWithoutLang() + imageName + "." + ext);
                if (!image.exists()) {
                    notFound();
                }
            }
        }
        renderBinary(image);
    }
    
    public static void wxc(String y, String m, String d, String nid) {
        WS.HttpResponse r = WS.url(String.format("http://www.wenxuecity.com/news/%s/%s/%s/%s.html", y, m, d, nid)).get();
        response.setContentTypeIfNotSet(r.getContentType());
        renderHtml(r.getString());
    }

//    /**
//     * Force to check if language folder version is ready
//     */
//    @Util
//    public static void refreshLangs() {
//        //invalidLangs.clear();
//    }
//    
//    @OnApplicationStart
//    public static class Cleaner extends Job {
//        @Override
//        public void doJob() throws Exception {
//            refreshLangs();
//        }
//    }
//
}
