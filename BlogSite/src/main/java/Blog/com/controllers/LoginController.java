package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Blog.com.models.entity.Admins;
import Blog.com.services.AdminsServices;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private AdminsServices adminsServices;

	// Sessionが使えるように宣言
	@Autowired
	private HttpSession session;

	// ログイン画面の表示
	@GetMapping("/admin/login")
	public String getAdminLoginPage() {
		return "login.html";
	}

	// ログイン処理
	@PostMapping("/admin/login/process")
	public String adminLoginProcess(@RequestParam String username, @RequestParam String password) {
		// loginCheckメソッドを呼び出してその結果をadminsという変数に格納
		Admins admin = adminsServices.loginCheck(username, password);
		// もし、admins == nullログイン画面にとどまります。
		// そうでない場合、sessionにログイン情報に保存
		// ブログ一覧画面にリダイレクトする/blog/list

		if (admin == null) {
			return "login.html";
		} else {
			session.setAttribute("loginAdminInfo", admin);
			return "admin_blog_list.html";
		}

	}
}
