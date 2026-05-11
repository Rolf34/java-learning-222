import java.time.LocalDateTime;
import java.util.HashSet;

public class Userregistry {
    private HashSet<User> users = new HashSet<>();
    private int nextId = 1;

    // Registers a new user
    public void registerUser(String login, String password) {
        User newUser = new User(nextId, login, password);
        if (users.contains(newUser)) {
            System.out.println("User " + login + " already exists");
        } else {
            users.add(newUser);
            nextId++;
            System.out.println("User " + login + " successfully registered");
        }
    }

    // Authenticates a user by login and password
    public void loginUser(String login, String password) {
        for (User user : users) {
            if (user.getName().equals(login)) {
                if (user.getPassword().equals(password)) {
                    user.setLoggedIn(true);
                    user.setLastLoginDate(LocalDateTime.now());
                    System.out.println("User " + login + " logged in successfully");
                } else {
                    System.out.println("Cannot authenticate user");
                }
                return;
            }
        }
        System.out.println("Cannot authenticate user");
    }

    // Logs out a user by ID
    public void logoutUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                if (user.isLoggedIn()) {
                    user.setLoggedIn(false);
                    System.out.println("User " + user.getName() + " logged out");
                } else {
                    System.out.println("User " + user.getName() + " is not logged in");
                }
                return;
            }
        }
        System.out.println("User with id=" + userId + " not found");
    }

    // Checks if a user is registered
    public boolean isUserRegistered(String login) {
        for (User user : users) {
            if (user.getName().equals(login)) {
                return true;
            }
        }
        return false;
    }

    // Removes a user by ID
    public void removeUser(int id) {
        User toRemove = null;
        for (User user : users) {
            if (user.getId() == id) {
                toRemove = user;
                break;
            }
        }
        if (toRemove != null) {
            users.remove(toRemove);
            System.out.println("User " + toRemove.getName() + " deleted");
        } else {
            System.out.println("User with id=" + id + " not found");
        }
    }

    // Prints total unique users
    public void printTotalUniqueUsers() {
        System.out.println("Total unique users: " + users.size());
    }

    // Displays all users in alphabetical order
    public void displayAllUsers() {
        System.out.println("\n=== All Users (Alphabetically) ===");
        if (users.isEmpty()) {
            System.out.println("List is empty");
        } else {
            users.stream()
                 .map(User::getName)
                 .sorted()
                 .forEach(System.out::println);
        }
        System.out.println("====================================");
    }

    // Displays all users with details (ID, name, status)
    public void printAllUsers() {
        System.out.println("\n=== All Users (with Details) ===");
        if (users.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        System.out.println("==================================");
    }
}