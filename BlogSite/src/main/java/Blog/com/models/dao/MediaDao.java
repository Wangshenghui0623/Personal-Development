package Blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Blog.com.models.entity.Media;

@Repository
public interface MediaDao extends JpaRepository<Media, Integer> {

	// 保存処理と更新処理
	Media save(Media mediaId);

	// SELECT * FROM mediaId
	// 用途：メディアを管理するときに使用
	List<Media> findAll();

	// SELECT * FROM media_id WHERE = ?
	// 用途：メディアを区別するときに使用
	Media findByMediaId(int mediaId);

	// SELECT * FROM post_id WHERE = ?
	// 用途：ポストを区別するときに使用
	Media findByPostId(int postId);

}
