package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Blog.com.models.entity.Admins;
import Blog.com.models.entity.BlogPosts;
import Blog.com.services.BlogPostsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogEditController {

	@Autowired
	private BlogPostsService blogPostsService;

	@Autowired
	private HttpSession session;

	/**
	 * ブログ編集画面を表示するメソッド。 指定されたブログIDのブログ記事を取得し、編集画面に表示します。
	 * 管理者がログインしていない場合はログイン画面にリダイレクトします。
	 *
	 * @param blogId 編集するブログ記事のID
	 * @param model  モデルオブジェクト
	 * @return 編集画面のテンプレート名またはリダイレクト先
	 */
	@GetMapping("/blog/edit/{blogId}")
	public String getBlogEditPage(@PathVariable int blogId, Model model) {
		// セッションからログインしている管理者の情報を取得
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");

		// 管理者がログインしていない場合はログイン画面にリダイレクト
		if (admin == null) {
			return "redirect:/login";
		} else {
			// 編集するブログ記事の情報を取得
			BlogPosts blogPosts = blogPostsService.blogEditCheck(blogId);

			// ブログ記事が存在しない場合はブログ一覧画面にリダイレクト
			if (blogPosts == null) {
				return "redirect:/admin/blog_list";
			} else {
				// ブログ記事が存在する場合は、編集画面に必要な情報をモデルに追加
				model.addAttribute("username", admin.getUsername());
				model.addAttribute("blogPosts", blogPosts);
				return "admin_blog_edit";
			}
		}
	}
}
