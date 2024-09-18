
import java.util.Scanner;

/* Create a program that allows users to post messages to a discussion
board. The discussion board can be represented as an array of 10
Strings. If a user tries to make a new post when the discussion board is
full, display an error message and reject the new post
 Users should also be prompted for their name when posting and it
should be prepended to their post as along with the phrase “ says: ”
o e.g. “Brayden says: The quick brown fox jumps over the lazy
dog”

 The program should use a command loop that repeatedly asks the user
to select an option and perform the related function until the user
chooses the end the program
 When printing all posts from a user, the user should be prompted for a
name and all messages starting with that name should be printed. The
search should be case insensitive
 For both search functions the user should be prompted for a word and
all messages containing that word should be printed
 The vowels to look for should be: a, e, i, o, u*/
public class DiscussionBoard {

    public static void main(String[] args) {
        // This scanner will be used for our discussion board menu below
        Scanner scanner = new Scanner(System.in); // this scanner is used for input

        // discussion board represented as an array of 10 strings
        String[] posts = new String[10];
        // need to keep track of the posts, so it doesnt exceed 10
        int postCount = 0;
        int userChoice;

        // do while loop with the menu, and we exit it if an invalid choice is made
        do {
            System.out.println("\n(1) Post a new message");
            System.out.println("(2) Print all Posts");
            System.out.println("(3) Print all posts in reverse order");
            System.out.println("(4) Print number of posts entered so far");
            System.out.println("(5) Print all posts from a user");
            System.out.println("(6) Print the number of vowels across all posts");
            System.out.println("(7) Perform a search of posts containing a given word (case sensitive)");
            System.out.println("(8) Perform a search of posts containing a given word (case insensitive)");
            System.out.println("(9) End Program");

            System.out.print("Enter your choice from the menu: ");
            // this will scan the users choice for our menu
            userChoice = scanner.nextInt();

            // need to consume new line
            scanner.nextLine();
            // based off whatver the user chooses (1-9), it will enter my switch case below
            switch (userChoice) {
                case 1:
                    // posts a new message below, but the posts cant be full
                    if (postCount < posts.length) {

                        // Prompt User for name
                        System.out.println("What is your name?");
                        String getName = scanner.nextLine(); // eg: Hamza

                        System.out.println("Enter your message: ");
                        String message = scanner.nextLine();
                        posts[postCount] = getName + " says:" + message;
                        postCount++;
                    } else {
                        System.out.println("Sorry, the discussion board is full");
                    }
                    break;
                case 2:
                    for (String post : posts) {
                        if (post != null) {
                            System.out.println(post);
                        }
                    }
                    break;

                case 3:
                    for (int i = posts.length - 1; i >= 0; i--) {
                        if (posts[i] != null) {
                            System.out.println(posts[i]);
                        }
                    }
                    break;

                case 4:
                    // to print the amount of posts we have so far, we can use our postCount we initialized above
                    System.out.println("Number of posts so far: Hello, there are " + postCount + " posts currently in our discussion board");
                    break;

                case 5:
                    System.out.println("Please enter the name you'd like to search for: ");
                    // name input from user below, using scanner from earlier
                    String nameSearch = scanner.nextLine();
                    for (String post : posts) {
                        // if the post isnt empty and the string starts with the name, then we found our user
                        if (post != null && post.startsWith(nameSearch + " says:")) {
                            System.out.println(post);
                        }
                    }
                    break;

                case 6:
                    int countVowel = 0;
                    for (String post : posts) {
                        if (post != null) {
                            // the vowels were looking for are all lowercase, so we need to convert our messages to .toLowerCase()
                            String postLowerCase = post.toLowerCase();
                            for (char vowel : "aeiou".toCharArray()) {
                                if (postLowerCase.contains(String.valueOf(vowel))) {
                                    int originalLength = postLowerCase.length();
                                    int newLength = postLowerCase.replace(String.valueOf(vowel), "").length();
                                    countVowel += originalLength - newLength;
                                }
                            }
                        }
                    }
                    System.out.println("Total number of vowels across all posts: " + countVowel);
                    break;

                case 7:
                    System.out.println("Enter the word that you are searching for (case sensitive: )");
                    String wordSearch = scanner.nextLine();
                    for (String post : posts) {
                        // contains method checks if the string contains the needle as a substring
                        if (post != null && post.contains(wordSearch)) {
                            System.out.println(post);
                        }
                    }
                    break;

                case 8:
                    System.out.println("Enter the word that you are searching for (case insensitive):");
                    String wordSearchInsensitive = scanner.nextLine();
                    for (String post : posts) {
                        if (post != null && post.toLowerCase().contains(wordSearchInsensitive)) {
                            System.out.println(post);
                        }
                    }
                    break;
                case 9:
                    System.out.println("End of the Program");
                    break;

                default:
                    System.out.println("please enter a valid choice");
            }

        } while (userChoice != 9);

        // finally, good practice to close our scanner, so we close it below
        scanner.close();
    }
}
