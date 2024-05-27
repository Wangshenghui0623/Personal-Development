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

	/**
	 * コメントのコンストラクタ。
	 *
	 * @param commentId     コメントID
	 * @param postId        投稿ID
	 * @param commenterName コメント者の名前
	 * @param commentText   コメントテキスト
	 * @param createdAt     作成日時
	 */
	public Comments(int commentId, int postId, String commenterName, String commentText, Timestamp createdAt) {
		this.commentId = commentId;
		this.postId = postId;
		this.commenterName = commenterName;
		this.commentText = commentText;
		this.createdAt = createdAt;
	}

	// ゲッターとセッター

	/**
	 * コメントIDを取得する。
	 * 
	 * @return コメントID
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * コメントIDを設定する。
	 * 
	 * @param commentId コメントID
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * 投稿IDを取得する。
	 * 
	 * @return 投稿ID
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * 投稿IDを設定する。
	 * 
	 * @param postId 投稿ID
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * コメント者の名前を取得する。
	 * 
	 * @return コメント者の名前
	 */
	public String getCommenterName() {
		return commenterName;
	}

	/**
	 * コメント者の名前を設定する。
	 * 
	 * @param commenterName コメント者の名前
	 */
	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	/**
	 * コメントテキストを取得する。
	 * 
	 * @return コメントテキスト
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * コメントテキストを設定する。
	 * 
	 * @param commentText コメントテキスト
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
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
}
