package Blog.com.models.entity;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogposts") // テーブルを指定する
public class BlogPosts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId; // ブログ記事のID

	private int adminId; // 管理者のID
	private String title; // ブログ記事のタイトル
	private String content; // ブログ記事の内容
	private String imagePath; // 画像のパス
	private Timestamp createdAt; // 作成日時
	private Timestamp updatedAt; // 更新日時

	// デフォルトコンストラクタ
	public BlogPosts() {
	}

	// パラメータ付きコンストラクタ
	public BlogPosts(int adminId, String title, String content, String imagePath, Timestamp createdAt,
			Timestamp updatedAt) {
		this.adminId = adminId;
		this.title = title;
		this.content = content;
		this.imagePath = imagePath;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// postId の getter と setter
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	// adminId の getter と setter
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	// title の getter と setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// content の getter と setter
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// imagePath の getter と setter
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	// createdAt の getter と setter
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	// updatedAt の getter と setter
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
