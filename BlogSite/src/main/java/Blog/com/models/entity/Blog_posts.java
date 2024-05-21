package Blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog_posts {
//admin_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	// admin_idの設定
	private int adminId;

	// titleの設定
	private char title;

	// contentの設定
	private char content;

	// created_at
	private int createdAt;

	// updated_at
	private int updatedAt;

	// 空のコンストラクタ
	public Blog_posts() {
	}

	// コンストラクタ
	public Blog_posts(int adminId, char title, char content, int createdAt, int updatedAt) {
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

	public char getTitle() {
		return title;
	}

	public void setTitle(char title) {
		this.title = title;
	}

	public char getContent() {
		return content;
	}

	public void setContent(char content) {
		this.content = content;
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
