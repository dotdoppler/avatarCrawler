package crawler.processor;

import crawler.global.GlobalConstans;
import crawler.utils.FileUtils;
import crawler.utils.MyHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by doppler on 2016/7/19.
 */
public class AvatarDownloader {
    private  String targetURL;
    private  String avatarName;

    private MyHttpClient client;

    public void download(){
        try {
            InputStream input = client.getIS();
            FileUtils.checkDownloadDir(GlobalConstans.DIR_DOWNLOAD);
            FileUtils.saveFile(input,avatarName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public AvatarDownloader(String url,String avatarName){
        this.targetURL = url;
        this.avatarName =avatarName;
        client = new MyHttpClient(targetURL);
    }
    public String getTargetURL() {
        return targetURL;
    }

    public void setTargetURL(String targetURL) {
        this.targetURL = targetURL;
    }

    public static void main(String[] args) {
        AvatarDownloader downloader = new AvatarDownloader("http://avatar.csdn.net/1/B/A/1_opennaive.jpg","avatar_0");
        downloader.download();
    }
}
