import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Userregistry registry = new Userregistry();
        Scanner reader = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Register user");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Check if user exists");
            System.out.println("5. Delete user");
            System.out.println("6. Show total users");
            System.out.println("7. Display all users (alphabetical)");
            System.out.println("8. Display all users (with details)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = reader.nextInt();
            reader.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Login: ");
                    String regLogin = reader.nextLine();
                    System.out.print("Password: ");
                    String regPass = reader.nextLine();
                    registry.registerUser(regLogin, regPass);        
                    break;
                case 2:
                    System.out.print("Login: ");
                    String logLogin = reader.nextLine();
                    System.out.print("Password: ");
                    String logPass = reader.nextLine();
                    registry.loginUser(logLogin, logPass);
                    break;
                case 3:
                    System.out.print("User ID to logout: ");
                    int logoutId = reader.nextInt();
                    registry.logoutUser(logoutId);
                    break;
                case 4:
                    System.out.print("Login to check: ");
                    String checkLogin = reader.nextLine();
                    boolean exists = registry.isUserRegistered(checkLogin);
                    System.out.println(exists ? checkLogin + " is registered" : checkLogin + " not found");
                    break;
                case 5:
                    System.out.print("User ID to delete: ");
                    int removeId = reader.nextInt();
                    registry.removeUser(removeId);
                    break;
                case 6:
                    registry.printTotalUniqueUsers();
                    break;
                case 7:
                    registry.displayAllUsers();
                    break;
                    case 8:
                    registry.printAllUsers();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        reader.close();
    }
}
