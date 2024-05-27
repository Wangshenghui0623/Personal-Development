package Blog.com.models.entity;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BlogPosts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	private int adminId;
	private String title;
	private String content;
	private String imagePath;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public BlogPosts() {
	}

	public BlogPosts(int adminId, String title, String content, String imagePath, Timestamp createdAt,
			Timestamp updatedAt) {
		this.adminId = adminId;
		this.title = title;
		this.content = content;
		this.imagePath = imagePath;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
