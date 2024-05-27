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

	// ログイン画面を表示するメソッド。
	@GetMapping("/admin/login")
	public String login() {
		return "login";
	}

	// ログイン処理を行うメソッド。 フォームから送信されたユーザー名とパスワードを使用して認証を行います。
	// 認証に成功した場合は、管理者情報をセッションに保存し、ブログ一覧画面にリダイレクトします。 認証に失敗した場合は、再度ログイン画面を表示します。

	@PostMapping("/admin/login/process")
	public String adminLoginProcess(@RequestParam String username, @RequestParam String password) {
		// loginCheckメソッドを呼び出してその結果をadminという変数に格納
		Admins admin = adminsServices.loginCheck(username, password);

		// 認証に失敗した場合はログイン画面を再表示
		if (admin == null) {
			return "login";
		} else {
			// 認証に成功した場合は、セッションにログイン情報を保存し、ブログ一覧画面にリダイレクト
			session.setAttribute("loginAdminInfo", admin);
			return "redirect:/admin/blog_list";
		}
	}
}
