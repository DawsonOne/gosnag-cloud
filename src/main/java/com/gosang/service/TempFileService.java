package com.gosang.service;

import com.gosang.entity.TempFile;

import java.util.List;

/**
 * @InterfaceName TempFileService
 * @Description (TempFile)表服务接口
 * @author gosang
 * @date 2020-03-10 11:22:11
 * @Version 1.0
 **/
public interface TempFileService {

    /**
     * @Description 添加TempFile
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param tempFile 实例对象
     * @return 是否成功
     */
    boolean insert(TempFile tempFile);

    /**
     * @Description 删除TempFile
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param fileId 主键
     */
    void deleteById(Integer fileId);

    /**
     * @Description 查询单条数据
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param fileId 主键
     * @return 实例对象
     */
    TempFile queryById(Integer fileId);
}