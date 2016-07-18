package crawler.processor;

import crawler.model.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class SimplePageProcessor implements PageProcessor {
    private List<Page> pageList;
    SimplePageProcessor(List<Page> pageList){
        this.pageList = pageList;
    }
    public void process(Page page) {

    }
}
