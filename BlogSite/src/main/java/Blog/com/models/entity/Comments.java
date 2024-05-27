package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {
	// コメントIDの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;

	// 投稿IDの設定
	private int postId;

	// コメント者の名前の設定
	private String commenterName;

	// コメントテキストの設定
	private String commentText;

	// 作成日時の設定
	private Timestamp createdAt;

	// 空のコンストラクタ
	public Comments() {
	}

	// コメントのコンストラクタ。

	public Comments(int commentId, int postId, String commenterName, String commentText, Timestamp createdAt) {
		this.commentId = commentId;
		this.postId = postId;
		this.commenterName = commenterName;
		this.commentText = commentText;
		this.createdAt = createdAt;
	}

	// ゲッターとセッター

	// コメントIDを取得する。

	public int getCommentId() {
		return commentId;
	}

	// コメントIDを設定する。

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	// 投稿IDを取得する。

	public int getPostId() {
		return postId;
	}

	// 投稿IDを設定する。

	public void setPostId(int postId) {
		this.postId = postId;
	}

	// コメント者の名前を取得する。

	public String getCommenterName() {
		return commenterName;
	}

	// コメント者の名前を設定する。

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	// コメントテキストを取得する。
	public String getCommentText() {
		return commentText;
	}

	// コメントテキストを設定する。

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	// 作成日時を取得する。

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	// 作成日時を設定する。

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
