package Blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Blog.com.models.entity.Admins;
import Blog.com.services.BlogPostsService;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class BlogRegisterController {

	private static final Logger LOGGER = Logger.getLogger(BlogRegisterController.class.getName());

	@Autowired
	private BlogPostsService blogPostsService;

	@Autowired
	private HttpSession session;

	@GetMapping("/blog/register")
	public String getBlogRegisterPage(Model model) {
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");
		if (admin == null) {
			return "redirect:/login";
		} else {
			model.addAttribute("username", admin.getUsername());
			return "admin_blog_register";
		}
	}

	@PostMapping("/blog/register/process")
	public String blogRegisterProcess(@RequestParam String title, @RequestParam String time,
			@RequestParam String content, @RequestParam MultipartFile image, Model model) {
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");

		if (admin == null) {
			return "redirect:/login";
		} else {
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
					+ image.getOriginalFilename();

			try {
				Path uploadPath = Paths.get("src/main/resources/static/blog-image/" + fileName);
				if (!Files.exists(uploadPath.getParent())) {
					Files.createDirectories(uploadPath.getParent());
				}
				Files.copy(image.getInputStream(), uploadPath);
				LOGGER.info("File uploaded successfully: " + fileName);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "File upload error", e);
				model.addAttribute("errorMessage", "ファイルのアップロード中にエラーが発生しました。");
				return "admin_blog_register";
			}

			try {
				blogPostsService.saveBlogPost(title, content, fileName, admin.getAdminId());
				LOGGER.info("Blog post saved successfully");
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Blog post save error", e);
				model.addAttribute("errorMessage", "ブログの保存中にエラーが発生しました。");
				return "admin_blog_register";
			}

			// Correct view name
			return "admin_blog_list";
		}
	}
}
