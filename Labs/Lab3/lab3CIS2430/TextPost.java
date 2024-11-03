package Labs.Lab3.lab3CIS2430;

public class TextPost extends Post {
    private String body;

    public TextPost(int id, String title, String createdBy, String body) {
        super(id, title, createdBy); // call to super class constrcutor
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post #" + id + "\n" +
                "Created By:" + createdBy + "\n" +
                "Title:" + title + "\n" +
                body;
    }

}
