package lab2CIS2430;
import java.util.ArrayList;

// Hamza Elmi - 1305966.
// Post Class for our discussion board
public class Post{
    private String titleOfPost;
    private String contentOfPost;
    private User user;


    // constructor for Post class
    public Post(String titleOfPost, String contentOfPost, User user){
        this.titleOfPost = titleOfPost;
        this.contentOfPost = contentOfPost;
        this.user = user;
    }

    // getter methods (accessor) to retrieve data from our Post class private instances
    public String getTitle(){
        return titleOfPost;
    }

    public String getContent(){
        return contentOfPost;
    }

    public User getUser(){
        return user;
    }

    @Override
    public String toString(){
        return ("Created By:" + user.getFullName() + "(@<" + user.getUserName() + ">)" + "\ntitleOfPost: " + titleOfPost + "\n" + contentOfPost);
    }

    @Override
    public boolean equals(Object obj){
        // check if object compared with itself
        if (this == obj){
            return true;
        }
        
        // 2. Check if the object is null or not an instance of Post
        if (obj == null || getClass() != obj.getClass()) {
            return false; 
        }

        // 3. cast object to post and compare fields
        Post otherPost = (Post) obj;
        return this.titleOfPost.equals(otherPost.titleOfPost)&&
               this.contentOfPost.equals(otherPost.contentOfPost) &&
               this.user.equals(otherPost.user); 
    }

}