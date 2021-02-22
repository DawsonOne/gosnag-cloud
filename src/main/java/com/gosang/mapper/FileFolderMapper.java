package com.gosang.mapper;

import com.gosang.entity.FileFolder;
import com.gosang.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName: FileFolderMapper
 * @Description: 与文件夹相关的数据库操作
 * @author: gosang
 * @date 2020/1/26 21:55
 * @Version: 1.0
 **/
@Mapper
public interface FileFolderMapper {

    /**
     * @Description 增加文件夹
     * @Author gosang
     * @Date 15:18 2020/2/26
     * @Param [fileFolder]
     * @return java.lang.Integer
     **/
    Integer addFileFolder(FileFolder fileFolder);

    /**
     * @Description 获得仓库的文件夹数量
     * @Author gosang
     * @Date 21:56 2020/2/10
     * @Param [fileStoreId]
     * @return java.lang.Integer
     **/
    Integer getFileFolderCountByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author gosang
     * @Date 23:49 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.FileFolder>
     **/
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId);


    /**
     * @Description 根据文件夹的id获取文件夹
     * @Author gosang
     * @Date 15:18 2020/2/26
     * @Param [fileFolderId]
     * @return com.gosang.entity.FileFolder
     **/
    FileFolder getFileFolderById(Integer fileFolderId);

    /**
     * @Description 根据父文件夹的id获取文件夹
     * @Author gosang
     * @Date 15:18 2020/2/26
     * @Param  * @param null
     * @return
     **/
    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据文件夹的id删除文件夹
     * @Author gosang
     * @Date 15:18 2020/2/26
     * @Param [fileFolderId]
     * @return java.lang.Integer
     **/
    Integer deleteFileFolderById(Integer fileFolderId);

    /**
     * @Description 根据文件夹的id修改文件夹信息
     * @Author gosang
     * @Date 15:19 2020/2/26
     * @Param [fileFolder]
     * @return java.lang.Integer
     **/
    Integer updateFileFolderById(FileFolder fileFolder);
}