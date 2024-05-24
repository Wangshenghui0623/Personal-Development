package Blog.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Blog.com.models.entity.Admins;

@Repository
public interface AdminsDao extends JpaRepository<Admins, Integer> {

	// 保存処理と更新処理 interとupdate
	Admins save(Admins adminId);

	// SELECT * FROM admins WHERE username = ?
	// 用途：管理者の登録処理をするときに、同じユーザー名があったらば登録させないようにする
	// 1行だけしかレコードは取得できない
	Admins findByUsername(String username);

	// SEKECT * FROM admins WHERE username = ? AND password
	// 用途：ログイン処理に使用。入力したユーザー名とパスワードが一致してるときだけデータを取得する
	Admins findByUsernameAndPassword(String username, String password);
}
