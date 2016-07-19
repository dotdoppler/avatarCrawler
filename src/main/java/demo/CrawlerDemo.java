package demo;

import crawler.global.GlobalConstans;
import crawler.utils.MyHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/15.
 */
public class CrawlerDemo {
    public static void main(String[] args) throws IOException {
        MyHttpClient myHttpClient = new MyHttpClient(GlobalConstans.BASE_TARGET_URL + "isea533");
        String content = myHttpClient.getResponseDocument();
        Document document =Jsoup.parse(content);
        String nickName = document.getElementsByClass("person-nick-name").tagName("span").text();
        System.out.println(nickName);
        String realAvatarHref = document.getElementsByClass("person-photo").select("img[src$=.jpg]").attr("src");
        System.out.println(realAvatarHref);
        Elements relations = document.getElementsByClass("focus");
        for (Element f :relations) {
            Elements imgsHref = f.getElementsByTag("div").get(2).getElementsByTag("a");
            for (Element e : imgsHref)
                System.out.println(e.getElementsByTag("img").get(0).attr("username"));
        }
    }
}
