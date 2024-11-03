package Labs.Lab3.lab3CIS2430;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

// Hamza Elmi - 1305966
// compile: javac Labs/Lab3/lab3CIS2430/*.java , then java Labs/Lab3/lab3CIS2430/*.java

// due october 28-29 2024
/*Sample Menu
(1) Create new user
(2) Create new post
(3) View all posts
(4) Vote in poll
(5) View all posts with a given username
(6) View all posts with a given keyword
(7) Save Discussion Board
(8) End Program */

public class DiscussionBoard {
    private ArrayList<Post> posts;
    private ArrayList<User> users;

    private int nextPostId; // for generating unique IDs

    // constructor
    public DiscussionBoard() {
        posts = new ArrayList<>();
        users = new ArrayList<>();
        nextPostId = 1;
    }

    public static void main(String[] args) {
        DiscussionBoard board = new DiscussionBoard();
        Scanner scanner = new Scanner(System.in);
        String filename = null;

        if (args.length > 0) {
            filename = "./boards" + args[0] + ".dboard";
            board.loadDiscussionBoard(filename);
        } else {
            System.out.println("No file specified, starting with a blank discussion board.");
        }

        int menuChoice;

        do {
            System.out.println("Sample Menu");
            System.out.println("(1) Create new user");
            System.out.println("(2) Create new post");
            System.out.println("(3) View all posts");
            System.out.println("(4) Vote in poll");
            System.out.println("(5) View all posts with a given username");
            System.out.println("(6) View all posts with a given keyword");
            System.out.println("(7) Save Discussion Board");
            System.out.println("(8) End Program");
            System.out.println("Enter your choice: ");

            // user enters menu choice below
            menuChoice = scanner.nextInt();

            // concusme new line
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    board.createUser(scanner);
                    break;
                case 2:
                    board.createPost(scanner);
                    break;
                case 3:
                    board.viewAllPosts();
                    break;
                case 4:
                    board.votePoll(scanner);
                    break;
                case 5:
                    board.viewAllPostsGivenUserName(scanner);
                    break;
                case 6:
                    board.viewAllPostsGivenKeyword(scanner);
                    break;
                case 7:
                    if (filename == null) {
                        System.out.println("Enter the filename: ");
                        String saveFilename = scanner.nextLine();
                        filename = "./boards/" + saveFilename + ".dboard";
                    }
                    board.saveDiscussionBoard(filename);
                    System.out.println("Discussion board saved to " + filename);
                    break;
                case 8:
                    System.out.println("End program");
                    break;
                default:
                    System.out.println("Invalid choice please try again");
                    break;

            }

        } while (menuChoice != 8);

        // closing the scanner
        scanner.close();
    }

    // Option 1
    public void createUser(Scanner scanner) {
        // method stub here
        System.out.println("Enter your fullname: ");
        String fullName = scanner.nextLine().toLowerCase();
        // username is optional, and must be one word, so use .trim method
        System.out.print("Enter your Username (optional): ");
        String userName = scanner.nextLine().trim().toLowerCase();

        if (userName.isEmpty()) {
            userName = fullName.split(" ")[0].toLowerCase(); // if the userName is empty, we have to default to
                                                             // firstname, first word must be lowercase
        }

        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                System.out.println("That username already exists, please try again.");
            }
        }
        User auser = new User(fullName, userName);
        System.out.println(auser.toString());

        users.add(auser);
        System.out.println("User created Successfully.\n");

    }

    // Option 2
    public void createPost(Scanner scanner) {
        // prompt for post type, poll or text ?
        System.out.println("Enter the post type: ('poll' or 'text'): ");
        String postType = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter your username: ");
        String userName = scanner.nextLine().trim().toLowerCase(); // convert input to lowercase
        System.out.println("Enter the post title: ");
        String title = scanner.nextLine().trim();

        if (postType.equals("text")) {
            System.out.println("Enter the text post body: ");
            String body = scanner.nextLine().trim();
            // Create a new TextPost object with the given details
            TextPost post = new TextPost(nextPostId++, title, userName, body);
            // Add the new TextPost object to the posts list
            posts.add(post);
        } else if (postType.equals("poll")) {
            // prompt user to enter poll options, scan for options, create object, add to
            System.out.println("Enter the Poll options, separated by semicolons: ");
            String options = scanner.nextLine().trim();
            // creating new pollpost object with the given details
            PollPost post = new PollPost(nextPostId++, title, userName, options);
            // adding new pollpost object to posts list
            posts.add(post);
        } else {
            System.out.println("Invalid post type.");
        }
        System.out.println("Post created successfuly.");
    }

    public void viewAllPosts() {
        // method stub here
        for (Post post : posts) {
            System.out.println(post.toString()); // calling the tostring methods, they follow the format in the
                                                 // instructionw
        }
    }

    public void votePoll(Scanner scanner) {
        // prompting user of the id to post
        System.out.println("Enter the ID of the post to vote: ");
        int voteID = scanner.nextInt();
        // consume new line
        scanner.nextLine();
        for (Post post : posts) {
            if (post.getId() == (voteID)) {
                if (post instanceof PollPost) {
                    PollPost pollPost = (PollPost) post;
                    pollPost.displayOptions();
                    System.out.println("Enter your choice: ");
                    int choice = scanner.nextInt();
                    if (pollPost.vote(choice)) {
                        System.out.println("Vote has been recorded.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } else {
                    System.out.println("This is not a poll post.");
                }
                return;
            }
        }
        System.out.println("Post ID not found.");
    }

    // option 5
    public void viewAllPostsGivenUserName(Scanner scanner) {
        /*
         * When viewing posts, a PollPost should display each option with the vote count
         * together on a separate line
         */
        // prompt for username
        System.out.println("Enter the username: ");
        // username input from user
        String userNameSearch = scanner.nextLine().trim().toLowerCase();
        // Iterate through the list of posts
        for (Post post : posts) {
            // Check if the post's creator matches the input username
            if (post.getCreatedBy().equals(userNameSearch)) {
                // print the post
                System.out.println(post);
            }
        }
    }

    // option 6
    public void viewAllPostsGivenKeyword(Scanner scanner) {
        // prompting for desired keyword
        System.out.println("Enter the keyword: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        // looping through array of posts
        for (Post post : posts) {
            if (post.getTitle().toLowerCase().contains(keyword)) {
                System.out.println(post);
            } else {
                System.out.println("Oops, There isnt a post with that keyword. Try again.\n");
            }

        }
    }

    public void saveDiscussionBoard(String filename) {
        // opening file if neccesary
        File file = new File(filename);
        file.getParentFile().mkdirs(); // making sure parent directory exists

        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (Post post : posts) {
                String postString = post.toString() + "\n";
                fos.write(postString.getBytes()); // write bytes to file to file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadDiscussionBoard(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse the line to create Post objects
                // Assume format: "type,id,title,username,options/body"
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[1]);
                String title = parts[2];
                String createdBy = parts[3];
                if (parts[0].equals("text")) {
                    String body = parts[4];
                    posts.add(new TextPost(id, title, createdBy, body));
                } else if (parts[0].equals("poll")) {
                    String options = parts[4];
                    posts.add(new PollPost(id, title, createdBy, options));
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found or cannot be opened, starting with a blank discussion board.");
        }
    }
}