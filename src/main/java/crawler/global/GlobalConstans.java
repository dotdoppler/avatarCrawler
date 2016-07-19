package crawler.global;

import java.io.File;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface GlobalConstans {
    String BASE_TARGET_URL = "http://my.csdn.net/";
    String REX_MATCH_AVATAR_DIV = "<dl class=\"person-photo\">\\s*\\n\\s*<dt><a href=\"javascript:;\"><img src=\".*?\"";
    String REX_MATCH_AVATAR_URL = "[a-zA-z]+://[^\\s]*g";
    String REX_MATCH_USERNAME = "username='.*?'";


    String DIR_DOWNLOAD = "D:" + File.separator +"avatarDownload";
    String IMG_SUFFIX = ".jpg";
}
