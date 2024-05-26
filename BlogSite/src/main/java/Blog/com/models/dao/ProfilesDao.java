package Blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Blog.com.models.entity.Profiles;

@Repository
public interface ProfilesDao extends JpaRepository<Profiles, Integer> {

	// 保存処理と更新処理 interとupdate
	Profiles save(Profiles profileId);

	// SELECT * FROM profileId
	// 用途：個人資料を管理するときに使用
	List<Profiles> findAll();

	// SELECT * FROM adminId
	// 用途：管理者（作成者）を区別するときに使用
	Profiles findByAdminId(int adminId);

	// SELECT * FROM fullName
	// 用途：名前を管理するときに使用
	Profiles findByFullName(char fullName);
}
