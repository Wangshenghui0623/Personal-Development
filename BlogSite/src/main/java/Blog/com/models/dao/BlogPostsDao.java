package Blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Blog.com.models.entity.BlogPosts;

@Repository
public interface BlogPostsDao extends JpaRepository<BlogPosts, Integer> {

	// 保存処理と更新処理
	BlogPosts save(BlogPosts blogPost);

	// SELECT * FROM postId
	// 用途：ブログポストを管理するときに使用
	List<BlogPosts> findAll();

	// SELECT * FROM postId WHERE title = ?
	// 用途：ポストを区別するときに使用
	BlogPosts findByTitle(String title);

	// SELECT * FROM blog_posts WHERE postId = ?
	// 用途：ポスト編集するとき区別として使用
	BlogPosts findByPostId(int postId);

	// SELECT * FROM blog_posts WHERE adminId = ?
	// 用途：ポストの管理者（作成者）を区別する時に使用
	List<BlogPosts> findByAdminId(int adminId);

	// 用途:削除使用します。
	void deleteByPostId(int postId);
}
