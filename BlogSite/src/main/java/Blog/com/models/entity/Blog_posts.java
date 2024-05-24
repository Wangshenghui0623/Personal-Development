package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog_posts {
//post_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	// admin_idの設定
	private int adminId;

	// titleの設定
	private String title;

	// contentの設定
	private String content;

	// created_at
	private Timestamp createdAt;

	// updated_at
	private Timestamp updatedAt;

	// 空のコンストラクタ
	public Blog_posts() {
	}

	// コンストラクタ
	public Blog_posts(int adminId, String title, String content, Timestamp createdAt, Timestamp updatedAt) {
		this.adminId = adminId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// ゲッターとセッター
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
