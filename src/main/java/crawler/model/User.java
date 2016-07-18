package crawler.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/15.
 */
public class User implements Serializable {
    private String name;
    private String avatarHref;
    private Set<String> relatedUsers = new HashSet<String>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarHref() {
        return avatarHref;
    }

    public void setAvatarHref(String avatarHref) {
        this.avatarHref = avatarHref;
    }


    public Set<String> getRelatedUsers() {
        return relatedUsers;
    }

    public void setRelatedUsers(Set<String> relatedUsers) {
        this.relatedUsers = relatedUsers;
    }
}
