package Blog.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogSiteApplication {

	/**
	 * アプリケーションのエントリーポイント。 Spring Bootアプリケーションを起動します。
	 *
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(BlogSiteApplication.class, args);
	}
}
