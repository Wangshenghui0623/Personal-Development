package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Blog.com.models.entity.Admins;
import Blog.com.models.entity.Blog_posts;
import Blog.com.services.BlogPostsService;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class BlogListController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BlogPostsService blogpostsService;

	//ブログ一覧画面を表示する
	@GetMapping("/admin/blog_list")
	public String getBlogList(Model model) {
		// セッションからログインしている人の情報を取得
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");
		// もし、admin==null ログイン画面にダイレクトする
		if (admin == null) {
			return "admin/login";
		} else {
			// ログインしている人の名前の情報を画面に渡して、ブログ一覧のhtmlを表示
			List<Blog_posts> blogPostsList = blogpostsService.selectAllAdminBlogList(admin.getUsername());
			model.addAttribute("username", admin.getUsername());
			model.addAttribute("blogPostsList", blogPostsList);
			return "admin/blog_list";
		}
	}
}
