package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profiles {
//profile_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;

	// admin_idの設定
	private int adminId;

	// full_nameの設定
	private String fullName;

	// bioの設定
	private String bio;

	// profile_pictureの設定
	private String profilePicture;

	// created_atの設定
	private Timestamp createdAt;

	// updated_atの設定
	private Timestamp updatedAt;

	// 空のコンストラクタ
	public Profiles() {
	}

	// コンストラクタ
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
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}
