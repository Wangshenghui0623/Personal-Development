package Blog.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog.com.models.dao.Blog_postsDao;
import Blog.com.models.entity.Blog_posts;

@Service
public class BlogPostsService {
	@Autowired
	private Blog_postsDao blogPostsDao;

	//ブログ一覧のチェック
	//もしusername == null 戻り値としてnull
	//findAll内容をコントローラークラスに渡す
	public List<Blog_posts> selectAllAdminBlogList(String username) {
		if (username == null) {
			return null;
		} else {
			return blogPostsDao.findAll();
		}
	}
}
