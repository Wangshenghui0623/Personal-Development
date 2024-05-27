package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profiles {
	// プロフィールIDの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;

	// 管理者IDの設定
	private int adminId;

	// フルネームの設定
	private String fullName;

	// 自己紹介文の設定
	private String bio;

	// プロフィール画像の設定
	private String profilePicture;

	// 作成日時の設定
	private Timestamp createdAt;

	// 更新日時の設定
	private Timestamp updatedAt;

	// 空のコンストラクタ
	public Profiles() {
	}

	/**
	 * プロフィールのコンストラクタ。
	 *
	 * @param profileId      プロフィールID
	 * @param adminId        管理者ID
	 * @param fullName       フルネーム
	 * @param bio            自己紹介文
	 * @param profilePicture プロフィール画像
	 * @param createdAt      作成日時
	 * @param updatedAt      更新日時
	 */
	public Profiles(int profileId, int adminId, String fullName, String bio, String profilePicture, Timestamp createdAt,
			Timestamp updatedAt) {
		this.profileId = profileId;
		this.adminId = adminId;
		this.fullName = fullName;
		this.bio = bio;
		this.profilePicture = profilePicture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// ゲッターとセッター

	/**
	 * プロフィールIDを取得する。
	 * 
	 * @return プロフィールID
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * プロフィールIDを設定する。
	 * 
	 * @param profileId プロフィールID
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

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
	 * フルネームを取得する。
	 * 
	 * @return フルネーム
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * フルネームを設定する。
	 * 
	 * @param fullName フルネーム
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 自己紹介文を取得する。
	 * 
	 * @return 自己紹介文
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * 自己紹介文を設定する。
	 * 
	 * @param bio 自己紹介文
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * プロフィール画像を取得する。
	 * 
	 * @return プロフィール画像
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * プロフィール画像を設定する。
	 * 
	 * @param profilePicture プロフィール画像
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * 作成日時を取得する。
	 * 
	 * @return 作成日時
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	/**
	 * 作成日時を設定する。
	 * 
	 * @param createdAt 作成日時
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * 更新日時を取得する。
	 * 
	 * @return 更新日時
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * 更新日時を設定する。
	 * 
	 * @param updatedAt 更新日時
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
