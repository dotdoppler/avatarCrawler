package crawler.model;

/**
 * Created by Administrator on 2016/7/15.
 */
public class Page {
    private String rowDocument;

    public Page(String content){
        this.rowDocument = content;
    }

    public String getRowDocument() {
        return rowDocument;
    }

    public void setRowDocument(String rowDocument) {
        this.rowDocument = rowDocument;
    }
}
