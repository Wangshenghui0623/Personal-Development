package Blog.com.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog.com.models.dao.Blog_postsDao;
import Blog.com.models.entity.Blog_posts;

@Service
public class BlogPostsService {
	@Autowired
	private Blog_postsDao blogPostsDao;

	public List<Blog_posts> selectAllAdminBlogList(int adminId) {
		return blogPostsDao.findByAdminId(adminId);
	}

	public void saveBlogPost(String title, String content, String imagePath, int adminId) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		Blog_posts blogPost = new Blog_posts(adminId, title, content, imagePath, currentTimestamp, currentTimestamp);
		blogPostsDao.save(blogPost);
	}

	public Blog_posts blogEditCheck(int blogId) {
		return blogPostsDao.findById(blogId).orElse(null);
	}
}
