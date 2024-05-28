package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Blog.com.models.entity.Admins;
import Blog.com.services.BlogPostsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogPostDeleteController {
	@Autowired
	private BlogPostsService blogPostsService;

	@Autowired
	private HttpSession session;

	@PostMapping("/blog/delete/{blogId}")
	public String BlogPostDelete(@PathVariable int blogId) {
		// セッションからログインしている人の情報をadminという変数に格納
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");

		if (admin == null) {
			// ログインしていない場合、ログインページにリダイレクト
			return "redirect:/login";
		} else {
			try {
				// ブログ記事削除
				blogPostsService.deletePost(blogId);
				return "redirect:/admin/blog_list";
			} catch (Exception e) {
				// 削除途中でエラーが発生したら、編集画面に戻しエラーメッセージもつける
				return "redirect:/admin/blog_edit" + blogId;
			}
		}
	}
}
