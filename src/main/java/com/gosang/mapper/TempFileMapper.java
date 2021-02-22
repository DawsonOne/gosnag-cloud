package com.gosang.mapper;

import com.gosang.entity.TempFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @InterfaceName TempFileMapper
* @Description (TempFile)表数据库访问层
* @author gosang
* @date 2020-03-10 11:22:11
* @Version 1.0
**/
@Mapper
public interface TempFileMapper {
    /**
     * @Description 添加TempFile
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param tempFile 实例对象
     * @return 影响行数
     */
    int insert(TempFile tempFile);

    /**
     * @Description 查询单条数据
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param fileId 主键
     * @return 实例对象
     */
    TempFile queryById(Integer fileId);

    /**
     * @Description 删除TempFile
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param fileId 主键
     * @return 影响行数
     */
    int deleteById(Integer fileId);
}