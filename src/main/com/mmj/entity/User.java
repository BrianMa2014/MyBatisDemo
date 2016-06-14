package main.com.mmj.entity;

import java.util.List;

/**
 * Created by MaMingJiang on 2016/6/12.
 */
public class User {
    private int id;
    private String name;
    private String dept;
    private String phone;
    private String website;
    private List<Post> posts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString(){
        System.out.println("id:"+this.id+"," +
                "name:"+this.name+"," +
                "dept:"+dept+"," +
                "phone:"+phone+"," +
                "website:"+website);
        return "";
    }
}
