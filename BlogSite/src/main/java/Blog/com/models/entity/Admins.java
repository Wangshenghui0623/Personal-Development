package Blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admins {
    // admin_idの設定
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    // username
    private String username;

    // password
    private String password;

    // email
    private String email;

    // 空のコンストラクタ
    public Admins() {
    }

    // コンストラクタ
    public Admins(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // ゲッターとセッター
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
