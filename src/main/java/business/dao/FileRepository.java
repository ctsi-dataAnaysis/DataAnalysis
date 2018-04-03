package business.dao;

import business.entitys.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Tianyi Xia on 2018/03/28.
 * 负责file_information表的连接和操作
 */
@Transactional
@Repository
public interface FileRepository extends JpaRepository<FileUpload, Integer> {
    public FileUpload findByUsername(String username);

//    public FileUpload findByFiletype(String filetype);
//    public FileUpload findByUpload_time(String upload_time);
//    public FileUpload findByUsername(String username);
}
