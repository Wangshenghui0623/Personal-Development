package Blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Blog.com.models.entity.Blog_posts;

@Repository
public interface Blog_postsDao extends JpaRepository<Blog_posts, Integer> {

	// 保存処理と更新処理
	Blog_posts save(Blog_posts blogPost);

	// SELECT * FROM postId
	// 用途：ブログポストを管理するときに使用
	List<Blog_posts> findAll();
	
	//SELECT * FROM postId WHERE title = ?
	//用途：ポストを区別するときに使用
	Blog_posts findByTitle(String title);
	
	//SELECT * FROM blog_posts WHERE postId = ?
	//用途：ポスト編集するとき区別として使用
	Blog_posts findByPostId(int postId);
	
	//SELECT * FROM blog_posts WHERE adminId = ?
	//用途：ポストの管理者（作成者）を区別する時に使用
	List<Blog_posts> findByAdminId(int adminId);
}
