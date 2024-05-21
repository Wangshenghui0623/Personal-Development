package Blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
//admin_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	// username
	private char username;

	// password
	private char password;

	// email
	private char email;

	// created_at
	private int createdAt;

	// updated_at
	private int updatedAt;

	// 空のコンストラクタ
	public Admin() {
	}

	// コンストラクタ
	public Admin(char username, char password, char email, int createdAt, int updatedAt) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;

	}

	// ゲッターとセッター
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public char getUsername() {
		return username;
	}

	public void setUsername(char username) {
		this.username = username;
	}

	public char getPassword() {
		return password;
	}

	public void setPassword(char password) {
		this.password = password;
	}

	public char getEmail() {
		return email;
	}

	public void setEmail(char email) {
		this.email = email;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

}
