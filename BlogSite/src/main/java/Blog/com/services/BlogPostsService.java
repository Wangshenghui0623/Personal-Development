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

	/**
	 * 指定された管理者IDに関連する全てのブログ記事を取得するメソッド。
	 *
	 * @param adminId 管理者ID
	 * @return 指定された管理者に関連するブログ記事のリスト
	 */
	public List<BlogPosts> selectAllAdminBlogList(int adminId) {
		return blogPostsDao.findByAdminId(adminId);
	}

	/**
	 * 新しいブログ記事を保存するメソッド。
	 *
	 * @param title     ブログ記事のタイトル
	 * @param content   ブログ記事の内容
	 * @param imagePath 画像のパス
	 * @param adminId   管理者ID
	 */
	public void saveBlogPost(String title, String content, String imagePath, int adminId) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		BlogPosts blogPost = new BlogPosts(adminId, title, content, imagePath, currentTimestamp, currentTimestamp);
		blogPostsDao.save(blogPost);
	}

	/**
	 * 指定されたブログ記事IDに対応するブログ記事を取得するメソッド。
	 *
	 * @param blogId ブログ記事ID
	 * @return 指定されたIDに対応するブログ記事、存在しない場合はnull
	 */
	public BlogPosts blogEditCheck(int blogId) {
		return blogPostsDao.findById(blogId).orElse(null);
	}
}
