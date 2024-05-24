package Blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Blog.com.models.entity.Comments;

@Repository
public interface CommentsDao extends JpaRepository<Comments, Integer> {

	// 保存処理と更新処理
	Comments save(Comments commentId);
	
	// SELECT * FROM commentId
	// 用途：コメントを管理するときに使用
	List<Comments> findAll();

	// SELECT * FROM comment_id WHERE = ?
	// 用途：コメントを区別するときに使用
	Comments findByCommentId(int commentId);

	// SELECT * FROM post_id WHERE = ?
	// 用途：ポストを区別するときに使用
	Comments findByPostId(int postId);

	// SELECT * FROM commenter_name WHERE = ?
	// 用途：コメント者を区別するときに使用
	List<Comments> findByCommenterName(char commenterName);

}
