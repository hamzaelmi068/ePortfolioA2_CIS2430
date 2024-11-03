package Labs.Lab3.lab3CIS2430;

public class User {
    private String userName;
    private String fullName;

    // constructor
    public User(String fullName, String userName) {
        this.userName = userName.toLowerCase();
        this.fullName = fullName;
    }

    // getter methods (accessor)
    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName + " (Username:" + userName + ")"; // toString provides a string representation of the object
    }

    @Override
    public boolean equals(Object obj) {
        // 1. check if the obj is compared with itself
        if (this == obj) {
            return true;
        }

        // 2. check if object is null or not an instance of user
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 3. cast object to user and compare
        User otherUser = (User) obj;
        return this.userName.equals(otherUser.userName) && this.fullName.equals(otherUser.fullName);
    }
}