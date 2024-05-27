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

	/**
	 * 管理者のコンストラクタ。
	 *
	 * @param username ユーザー名
	 * @param password パスワード
	 * @param email    メールアドレス
	 */
	public Admins(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	// ゲッターとセッター

	/**
	 * 管理者IDを取得する。
	 * 
	 * @return 管理者ID
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * 管理者IDを設定する。
	 * 
	 * @param adminId 管理者ID
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * ユーザー名を取得する。
	 * 
	 * @return ユーザー名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ユーザー名を設定する。
	 * 
	 * @param username ユーザー名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * パスワードを取得する。
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する。
	 * 
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * メールアドレスを取得する。
	 * 
	 * @return メールアドレス
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * メールアドレスを設定する。
	 * 
	 * @param email メールアドレス
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
