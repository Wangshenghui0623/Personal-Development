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

	// ブログ登録画面を表示するメソッド。 ユーザーがログインしているか確認し、ログインしていない場合はログインページにリダイレクトします。
	// ログインしている場合は、登録画面にユーザー名を表示します。

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

	// ブログ登録処理を行うメソッド。 フォームから送信されたデータを受け取り、ブログ記事を保存します。
	// ファイルのアップロードおよびブログ記事の保存中にエラーが発生した場合は、エラーメッセージを表示します。
	@PostMapping("/blog/register/process")
	public String blogRegisterProcess(@RequestParam String title, @RequestParam String time,
			@RequestParam String content, @RequestParam MultipartFile image, Model model) {
		Admins admin = (Admins) session.getAttribute("loginAdminInfo");

		// もし、同じファイルの名前がなかったら保存
		// ブログ一覧画面にダイレクトする
		// そうでない場合、ブログ登録画面にとどまります。
		if (admin == null) {
			return "redirect:/login";
		} else {
			// ファイル名を現在の日付と時間で一緒に生成
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
					+ image.getOriginalFilename();

			try {
				// ファイルの保存パスを指定
				Path uploadPath = Paths.get("src/main/resources/static/blog-image/" + fileName);
				// 保存ディレクトリが存在しない場合は作成
				if (!Files.exists(uploadPath.getParent())) {
					Files.createDirectories(uploadPath.getParent());
				}
				// ファイルを指定したパスに保存
				Files.copy(image.getInputStream(), uploadPath);
				LOGGER.info("File uploaded successfully: " + fileName);
			} catch (IOException e) {
				// ファイルアップロード中にエラーが発生した場合の処理
				LOGGER.log(Level.SEVERE, "File upload error", e);
				model.addAttribute("errorMessage", "ファイルのアップロード中にエラーが発生しました。");
				return "admin_blog_register";
			}

			try {
				// ブログ記事を保存
				blogPostsService.saveBlogPost(title, content, fileName, admin.getAdminId());
				LOGGER.info("Blog post saved successfully");
			} catch (Exception e) {
				// ブログ記事保存中にエラーが発生した場合の処理
				LOGGER.log(Level.SEVERE, "Blog post save error", e);
				model.addAttribute("errorMessage", "ブログの保存中にエラーが発生しました。");
				return "admin_blog_register";
			}

			// ブログ一覧画面に遷移
			// 遷移するのは最初のブログ一覧画面（// return "admin_blog_list";）ではなく、更新した後のブログ一覧画面です。
			//
			return "redirect:/admin/blog_list";

		}
	}
}
