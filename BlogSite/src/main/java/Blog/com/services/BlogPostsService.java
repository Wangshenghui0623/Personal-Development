package Blog.com.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog.com.models.dao.BlogPostsDao;
import Blog.com.models.entity.BlogPosts;

@Service
public class BlogPostsService {
	@Autowired
	private BlogPostsDao blogPostsDao;

	// 指定された管理者IDに関連する全てのブログ記事を取得するメソッド。
	public List<BlogPosts> selectAllAdminBlogList(int adminId) {
		return blogPostsDao.findByAdminId(adminId);
	}

	// 新しいブログ記事を保存するメソッド。
	public void saveBlogPost(String title, String content, String imagePath, int adminId) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		BlogPosts blogPost = new BlogPosts(adminId, title, content, imagePath, currentTimestamp, currentTimestamp);
		blogPostsDao.save(blogPost);
	}

	// 指定されたブログ記事IDに対応するブログ記事を取得するメソッド。
	// 指定されたIDに対応するブログ記事、存在しない場合はnull
	public BlogPosts blogEditCheck(int blogId) {
		return blogPostsDao.findById(blogId).orElse(null);
	}

	// ブログ記事を更新する
	public void updateBlogPost(int postId, String title, String content) throws Exception {
		BlogPosts blogPost = blogPostsDao.findById(postId).orElse(null);
		if (blogPost == null) {
			throw new Exception("ブログ記事が見つかりません");
		}
		blogPost.setTitle(title);
		blogPost.setContent(content);
		blogPost.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		blogPostsDao.save(blogPost);
	}

	public void incrementReaderCount(int postId) {
		BlogPosts blogPost = blogPostsDao.findById(postId).orElse(null);
		if (blogPost != null) {
			blogPost.setReaderCount(blogPost.getReaderCount() + 1);
			blogPostsDao.save(blogPost);
		}
	}

	// 記事削除する方法
	public void deletePost(int postId) {
		blogPostsDao.deleteById(postId);
	}

}
