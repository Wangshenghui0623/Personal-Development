package Blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admins {
	// 管理者IDの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	// ユーザー名の設定
	private String username;

	// パスワードの設定
	private String password;

	// メールアドレスの設定
	private String email;

	// 空のコンストラクタ
	public Admins() {
	}

	// 管理者のコンストラクタ。

	public Admins(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	// ゲッターとセッター

	// 管理者IDを取得する。

	public int getAdminId() {
		return adminId;
	}

	// 管理者IDを設定する。

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	// ユーザー名を取得する。

	public String getUsername() {
		return username;
	}

	// ユーザー名を設定する。

	public void setUsername(String username) {
		this.username = username;
	}

	// パスワードを取得する。

	public String getPassword() {
		return password;
	}

	// パスワードを設定する。

	public void setPassword(String password) {
		this.password = password;
	}

	// メールアドレスを取得する。

	public String getEmail() {
		return email;
	}

	// メールアドレスを設定する。

	public void setEmail(String email) {
		this.email = email;
	}
}
