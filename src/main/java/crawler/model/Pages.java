package crawler.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class Pages {
    private static volatile List<Page> pageList = new ArrayList<Page>();

    public static List<Page> getPageList() {
        return pageList;
    }

}
