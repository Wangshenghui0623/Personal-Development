package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Blog.com.services.AdminsServices;

@Controller
public class AdminRegisterController {

	@Autowired
	private AdminsServices adminService;

	// 登録画面の表示
	@GetMapping("/admin/register")
	public String aminRegister() {
		return "admin_register";
	}

	// 登録処理
	@PostMapping("/admin/register/process")
	public String adminRegisterProcrss(@RequestParam String username, @RequestParam String password,
			@RequestParam String email) {
		// もし、createAdminがtrue login.htmlに遷移
		// そうでない場合、admin_register.htmlにとどまります。
		if (adminService.createAdmin(username, email, password)) {
			return "login.html";
		} else {
			return "admin_register.html";
		}
	}
}
