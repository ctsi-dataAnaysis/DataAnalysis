package business.dao;

import business.entitys.FileDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tianyi Xia on 2018/03/28.
 * 负责file_information表的连接和操作
 */
@Transactional
@Repository
public interface DeleteRepository extends JpaRepository<FileDelete, Integer> {
    FileDelete findByUsername(String username);
    FileDelete findByFilename(String filename);
    FileDelete findById(Integer id);
//    public FileUpload findByFiletype(String filetype);
//    public FileUpload findByUpload_time(String upload_time);
//    public FileUpload findByUsername(String username);
}
