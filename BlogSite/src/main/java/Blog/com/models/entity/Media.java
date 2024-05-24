package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Media {
//media_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mediaId;

	// post_idの設定
	private int postId;

	// file_pathの設定
	private String filePath;

	// created_atの設定
	private Timestamp createdAt;

	// 空のコンストラクタ
	public Media() {
	}

	// コンストラクタ
	public Media(int mediaId, int postId, String filePath, Timestamp createdAt) {
		this.mediaId = mediaId;
		this.postId = postId;
		this.filePath = filePath;
		this.createdAt = createdAt;
	}

	// ゲッターとセッター
	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}
