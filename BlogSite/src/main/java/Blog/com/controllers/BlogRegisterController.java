package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Blog.com.models.entity.Admins;
import Blog.com.services.BlogPostsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogRegisterController {

	@Autowired
	private BlogPostsService blogpostsService;
	
	@Autowired
	private HttpSession session;
	
	//ブログの画面の表示
	@GetMapping("/blog/register")
	public String getBlogRegisterPage(Model model) {
		//セッションからログインしている人の情報をadminという変数に格納
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");
		//もしadmin==null ログイン画面にダイレクトする
		//そうでない場合は、ログインしている人の名前を画面に渡す
		//ブログ登録のhtmlを表示させる
		if(admin == null) {
			return "login.html";
		}else {
			model.addAttribute("username", admin.getUsername());
			return "admin_blog_register.html";
		}

	}
	
}
