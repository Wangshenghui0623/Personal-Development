package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Blog.com.models.entity.Admins;
import Blog.com.models.entity.BlogPosts;
import Blog.com.services.BlogPostsService;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class BlogListController {
	@Autowired
	private HttpSession session;

	@Autowired
	private BlogPostsService blogpostsService;

	@GetMapping("/admin/blog_list")
	public String getBlogList(Model model) {
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");
		if (admin == null) {
			return "login.html";
		} else {
			List<BlogPosts> blogPostsList = blogpostsService.selectAllAdminBlogList(admin.getAdminId());
			model.addAttribute("username", admin.getUsername());
			model.addAttribute("blogPostsList", blogPostsList);
			// 追加記事の表示
			System.out.println("Admin: " + admin);
			System.out.println("BlogPosts List Size: " + blogPostsList.size());
			for (BlogPosts post : blogPostsList) {
				System.out.println("Post: " + post.getTitle());
			}
			return "admin_blog_list";
		}
	}

}
