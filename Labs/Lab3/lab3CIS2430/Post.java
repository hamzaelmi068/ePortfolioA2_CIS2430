package Labs.Lab3.lab3CIS2430;

public class Post {
    protected int id;
    protected String title;
    protected String createdBy;

    public Post(int id, String title, String createdBy) {
        this.id = id;
        this.title = title;
        this.createdBy = createdBy;
    }

    /* mutator methods below, for post super class , Post */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Post #ID: " + id + ", Created By: " + createdBy + ", Title: " + title;
    }

}
