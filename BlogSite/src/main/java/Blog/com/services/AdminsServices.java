package Blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog.com.models.dao.AdminsDao;
import Blog.com.models.entity.Admins;

@Service
public class AdminsServices {
	@Autowired
	private AdminsDao adminsDao;

	// 保存処理（登録処理）
	// もし、findByUsername==nullだったら、登録処理をします。
	// saveメールアドレスを使用して登録処理をする
	// 保存ができたらtrue
	// そうでない場合は、保存処理失敗 false

	public boolean createAdmin(String username, String password, String email) {
		if (adminsDao.findByUsername(username) == null) {
			adminsDao.save(new Admins(username, email, password));
			return true;
		} else {
			return false;
		}
	}
	// ログイン処理
	// もし、usernameとpasswordがfindByUsernameAndPasswordを使用して存在しなかった場合==nullの場合、
	// その場合、存在しないnullであることをコントローラークラスに知らせる
	// そうでない場合ログインしている人の情報をコントローラークラスに渡す

	public Admins loginCheck(String username, String password) {
		Admins admins = adminsDao.findByUsernameAndPassword(username, password);
		if (admins == null) {
			return null;
		} else {
			return admins;
		}
	}
}
