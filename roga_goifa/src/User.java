import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private String password;
    private boolean loggedIn;
    private LocalDateTime lastLoginDate;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.loggedIn = false;
        this.lastLoginDate = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loggedIn=" + loggedIn +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
