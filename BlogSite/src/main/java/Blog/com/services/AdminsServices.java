package Blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog.com.models.dao.AdminsDao;
import Blog.com.models.entity.Admins;

@Service
public class AdminsServices {
	@Autowired
	private AdminsDao adminsDao;

	/**
	 * 管理者アカウントを作成するメソッド。 ユーザー名が既に存在しない場合に新しい管理者アカウントを作成します。
	 *
	 * @param username ユーザー名
	 * @param password パスワード
	 * @param email    メールアドレス
	 * @return アカウント作成に成功した場合はtrue、失敗した場合はfalse
	 */
	public boolean createAdmin(String username, String password, String email) {
		// ユーザー名で検索し、存在しない場合は新しい管理者アカウントを作成
		if (adminsDao.findByUsername(username) == null) {
			adminsDao.save(new Admins(username, email, password));
			return true;
		} else {
			// ユーザー名が既に存在する場合はfalseを返す
			return false;
		}
	}

	/**
	 * ログイン処理を行うメソッド。 指定されたユーザー名とパスワードが一致する管理者アカウントを検索します。
	 *
	 * @param username ユーザー名
	 * @param password パスワード
	 * @return 一致する管理者アカウントが存在する場合はAdminsオブジェクト、存在しない場合はnull
	 */
	public Admins loginCheck(String username, String password) {
		// ユーザー名とパスワードで検索し、一致する管理者アカウントを取得
		Admins admins = adminsDao.findByUsernameAndPassword(username, password);
		if (admins == null) {
			// 一致するアカウントが存在しない場合はnullを返す
			return null;
		} else {
			// 一致するアカウントが存在する場合はAdminsオブジェクトを返す
			return admins;
		}
	}
}
