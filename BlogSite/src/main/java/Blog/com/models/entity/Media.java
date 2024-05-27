package Blog.com.models.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Media {
	// メディアIDの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mediaId;

	// 投稿IDの設定
	private int postId;

	// ファイルパスの設定
	private String filePath;

	// 作成日時の設定
	private Timestamp createdAt;

	// 空のコンストラクタ
	public Media() {
	}

	/**
	 * メディアのコンストラクタ。
	 *
	 * @param mediaId   メディアID
	 * @param postId    投稿ID
	 * @param filePath  ファイルパス
	 * @param createdAt 作成日時
	 */
	public Media(int mediaId, int postId, String filePath, Timestamp createdAt) {
		this.mediaId = mediaId;
		this.postId = postId;
		this.filePath = filePath;
		this.createdAt = createdAt;
	}

	// ゲッターとセッター

	/**
	 * メディアIDを取得する。
	 * 
	 * @return メディアID
	 */
	public int getMediaId() {
		return mediaId;
	}

	/**
	 * メディアIDを設定する。
	 * 
	 * @param mediaId メディアID
	 */
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
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
	 * ファイルパスを取得する。
	 * 
	 * @return ファイルパス
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * ファイルパスを設定する。
	 * 
	 * @param filePath ファイルパス
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
