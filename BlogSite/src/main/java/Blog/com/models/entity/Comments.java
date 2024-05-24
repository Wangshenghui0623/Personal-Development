package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {
//comment_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;

	// post_idの設定
	private int postId;

	// commenter_nameの設定
	private String commenterName;

	// comment_textの設定
	private String commentText;

	// created_atの設定
	private Timestamp createdAt;

	// 空のコンストラクタ
	public Comments() {
	}

	// コンストラクタ
	public Comments(int commentId, int postId, String commenterName, String commentText, Timestamp createdAt) {
		this.commentId = commentId;
		this.postId = postId;
		this.commenterName = commenterName;
		this.commentText = commentText;
		this.createdAt = createdAt;
	}

	// ゲッターとセッター
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}
