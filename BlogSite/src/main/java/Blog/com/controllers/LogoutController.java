package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	@Autowired
	private HttpSession session;

	// ログアウト処理
	@GetMapping("/admin/logout")
	public String adminLogout() {
		// セッションの無効化
		session.invalidate();
		return "login.html";
	}

}
