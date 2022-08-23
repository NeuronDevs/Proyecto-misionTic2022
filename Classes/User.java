import java.util.ArrayList;
import java.util.Date;

enum Enum_RoleName {
    Admin,
    Operario
}

public class User {
    private long id;
    private String email;
    private Profile profile;
    private Enum_RoleName role;
    private Enterprise enterprise;
    private ArrayList<Transactions> transactions = new ArrayList<Transactions>();
    private Date createdAt;

    public User(long id, String email, Profile profile, Enum_RoleName role, Enterprise enterprise,
            ArrayList<Transactions> transactions, Date createdAt) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.createdAt = createdAt;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
