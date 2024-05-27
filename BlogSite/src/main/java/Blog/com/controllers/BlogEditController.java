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

    // 編集画面の表示
    @GetMapping("/blog/edit/{blogId}")
    public String getBlogEditPage(@PathVariable int blogId, Model model) {
        // セッションからログインしている人の情報をadminという変数に格納
        Admins admin = (Admins) session.getAttribute("loginAdminInfo");
        // もしadmin==null ログイン画面にリダイレクトする
        if (admin == null) {
            return "redirect:/login";
        } else {
            // 編集画面に表示させる情報を変数に格納 blogPosts
            BlogPosts blogPosts = blogPostsService.blogEditCheck(blogId);
            // もし、blogPosts==nullだったら、ブログ一覧画面ページいリダイレクトする
            // そうでない場合、編集画面に編集する内容を渡す
            // 編集画面を表示
            if (blogPosts == null) {
                return "admin_blog_list.html";
            } else {
                model.addAttribute("username", admin.getUsername());
                model.addAttribute("blogPosts", blogPosts);
                return "admin_blog_edit.html";
            }
        }
    }
}
