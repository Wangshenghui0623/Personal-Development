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

	public List<BlogPosts> selectAllAdminBlogList(int adminId) {
		return blogPostsDao.findByAdminId(adminId);
	}

	public void saveBlogPost(String title, String content, String imagePath, int adminId) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		BlogPosts blogPost = new BlogPosts(adminId, title, content, imagePath, currentTimestamp, currentTimestamp);
		blogPostsDao.save(blogPost);
	}

	public BlogPosts blogEditCheck(int blogId) {
		return blogPostsDao.findById(blogId).orElse(null);
	}
}
