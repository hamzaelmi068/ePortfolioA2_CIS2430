package Labs.Lab3.lab3CIS2430;

import java.util.ArrayList;
import java.util.Arrays;

public class PollPost extends Post {
    private ArrayList<String> options;
    private ArrayList<Integer> votes;

    public PollPost(int id, String title, String createdBy, String optionsString) {
        super(id, title, createdBy);
        this.options = new ArrayList<>(Arrays.asList(optionsString.split(";")));
        this.votes = new ArrayList<>(this.options.size());
        for (int j = 0; j < this.options.size(); j++) {
            votes.add(0);
        }
    }

    public void displayOptions() {
        System.out.println("\n***Poll options below***\n");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i) + " (Votes: " + votes.get(i) + ")");
        }
    }

    public boolean vote(int choice) {
        if (choice > 0 && choice <= options.size()) {
            votes.set(choice - 1, votes.get(choice - 1) + 1);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Post #" + id + "\n" +
                "Created By: " + createdBy + "\n" +
                "Title: " + title + "\n");
        for (int i = 0; i < options.size(); i++) {
            String[] optionParts = options.get(i).split(":");
            sb.append(optionParts[0]).append(": ").append(votes.get(i)).append("\n");
        }
        return sb.toString();
    }
}
