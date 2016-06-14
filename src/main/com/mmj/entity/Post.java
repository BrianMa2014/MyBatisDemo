package main.com.mmj.entity;

import org.joda.time.DateTime;

/**
 * Created by MaMingJiang on 2016/6/14.
 */
public class Post {
    private int id;
    private User user;
    private String title;
    private String content;
    private DateTime create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString(){
        System.out.println("post id:"+id+",title:"+title+",content:"+content);
        return null;
    }
}
