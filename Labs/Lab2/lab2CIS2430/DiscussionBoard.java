package lab2CIS2430;
// or package.DiscussionBoard.Post.User

// Hamza Elmi - 1305966.

import java.util.Scanner;
import java.util.ArrayList;

// due october 8th
/* Sample Menu
    (1) Create new user
    (2) Create new post 
    (3) View all posts
    (4) View all posts with a given username
    (5) View all posts with a given keyword - tokenize
    (6) End Program*/

public class DiscussionBoard {
    // using two array lists
    private ArrayList<User> users;
    private ArrayList<Post> posts;

    // constructor
    public DiscussionBoard() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    // main method for our discussion board
    public static void main(String[] args) {
        DiscussionBoard board = new DiscussionBoard();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Sample Menu");
            System.out.println("(1) Create new user");
            System.out.println("(2) Create new post");
            System.out.println("(3) View all posts");
            System.out.println("(4) View all posts with a given username");
            System.out.println("(5) View all posts with a given keyword");
            System.out.println("(6) End Program");
            System.out.println("Enter your choice: ");
            // user enters choice below
            choice = scanner.nextInt();

            // consume new line
            scanner.nextLine();

            switch (choice) {
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
                    board.viewAllPostsGivenUserName(scanner);
                    break;
                case 5:
                    board.viewAllPostsGivenKeyword(scanner);
                    break;
                case 6:
                    System.out.println("End program");
                    break;
                default:
                    System.out.println("Invalid choice please try again");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    /* Option 1 */
    public void createUser(Scanner scanner) {
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
                System.out.println("That username already exists, please try again");
            }

        }
        User auser = new User(fullName, userName); // print debugging object
        System.out.println(auser.toString()); // not searching for username properly, its swapped - *fixed*

        users.add(auser); // adding asuer objeb to users arraylist
        System.out.println("User created Successfully\n");
    }

    /* Option 2 */
    public void createPost(Scanner scanner) {
        System.out.println("Enter your username: ");
        String userName = scanner.nextLine().trim().toLowerCase(); // convert input to lowercase

        User user = null;
        for (User u : users) { // goes through every user in arraylist
            System.out.println("Checking user: " + u.getUserName()); // debugging output
            if (u.getUserName().toLowerCase().equals(userName)) { // converting stored username to lowercase before
                                                                  // comparing to userName the person entered
                user = u;
                break;
            }
        }

        if (user == null) {
            // if the user is empty or null, we print the message below
            System.out.println("The User is not registered. Please register first.");
            return;
        }

        // prompt for title and content
        System.out.println("Enter the title: ");
        String title = scanner.nextLine();
        System.out.println("Enter the content: ");
        String content = scanner.nextLine();

        // create a new object for the post and add it to the related ArrayList
        posts.add(new Post(title, content, user));
        System.out.println("***Post created sucessfully***");

    }

    /* Option 3 */
    private void viewAllPosts() {
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    /* Option 4 */
    private void viewAllPostsGivenUserName(Scanner scanner) {
        System.out.println("Enter the username your searching for: ");
        String givenUserName = scanner.nextLine().trim();

        // Looping through the array of posts
        for (Post post : posts) {
            // checking if username of the posts match the given username we scanned above
            if (post.getUser().getUserName().equals(givenUserName)) {
                // printing post if username matches
                System.out.println(post);
            }
        }
    }

    /* Option 5 */
    private void viewAllPostsGivenKeyword(Scanner scanner) {
        System.out.println("Enter the keyword you're searching for: ");
        String keywordUser = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        // need to loop through the post array, and split the title and post content
        // into words
        for (Post post : posts) {
            String[] titleWords = post.getTitle().toLowerCase().split("\\s+");
            String[] contentWords = post.getContent().toLowerCase().split("\\s+");

            // assuming the keyword isnt found
            boolean keywordFound = false;
            for (String word : titleWords) {
                if (word.equals(keywordUser)) {
                    // if the word we split is equal to user input for keyword, its been found
                    keywordFound = true;
                    break;
                }
            }
            // if the keyword is found, we loop through the content words we split
            if (!keywordFound) {
                for (String word : contentWords) {
                    // if the word is equal to the keyword
                    if (word.equals(keywordUser)) {
                        found = true;
                        break;
                    }
                }
            }

            if (keywordFound) {
                System.out.println("Title: " + post.getTitle());
                System.out.println("Content: " + post.getContent());
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry,there isnt any post with that keyword, try again!\n ");
        }
    }
}
