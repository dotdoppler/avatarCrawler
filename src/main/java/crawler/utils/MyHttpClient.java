package crawler.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by Administrator on 2016/7/15.
 */
public class MyHttpClient {
   private CloseableHttpClient httpClient ;
   private HttpGet getDocument;
   private HttpGet getImg;
   private HttpEntity httpEntity;

   public MyHttpClient(String url){
      httpClient = HttpClients.createDefault();
      getDocument = new HttpGet(url){
         {
            setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            setHeader("Accept-Encoding","gzip, deflate, sdch");
            setHeader("Accept-Language","zh-CN,zh;q=0.8");
            setHeader("Host","my.csdn.net");
            setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 " +
                    "(KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36");
         }
      };
      getImg = new HttpGet(url){
         {
            setHeader("Host","avatar.csdn.net");
            setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 " +
                    "(KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36");
            setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            setHeader("Accept-Language","zh-CN,zh;q=0.8");
            setHeader("Accept-Encoding","gzip, deflate, sdch");
         }
      };
   }
   public void sendRequest(HttpGet get) throws IOException {
      this.httpEntity = httpClient.execute(get).getEntity();
   }
   public String getResponseDocument() throws IOException {
      StringWriter writer = new StringWriter();
      sendRequest(getDocument);
      IOUtils.copy(httpEntity.getContent(),writer,"UTF-8");
      return writer.toString();
   }
   public InputStream getIS() throws IOException {
      sendRequest(getImg);
      return httpEntity.getContent();
   }

}
