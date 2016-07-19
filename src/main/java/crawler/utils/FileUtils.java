package crawler.utils;

import crawler.global.GlobalConstans;

import java.io.*;

/**
 * Created by doppler on 2016/7/19.
 */
public class FileUtils {

    public static void checkDownloadDir(String dir) throws IOException {
        File file = new File(dir);
        if (!file.exists())
            file.mkdir();
    }

    public static void saveFile(InputStream inputStream,String avatarName) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(GlobalConstans.DIR_DOWNLOAD +
                File.separator + avatarName + GlobalConstans.IMG_SUFFIX ));


        byte[] buffer = new byte[1024];
        int len = bis.read(buffer);
        while ( len != -1) {
            bos.write(buffer, 0, len);
            len = bis.read(buffer);
        }
        bos.close();
        bis.close();
    }
    public static void main(String[] args) throws IOException {
        checkDownloadDir(GlobalConstans.DIR_DOWNLOAD);
    }
}
