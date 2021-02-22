package com.gosang.service.impl;

import com.gosang.entity.TempFile;
import com.gosang.service.TempFileService;
import com.gosang.utils.FtpUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TempFileServiceImpl
 * @Description (TempFile)表服务实现类
 * @author gosang
 * @date 2020-03-10 11:22:11
 * @Version 1.0
 **/
@Service("tempFileService")
public class TempFileServiceImpl extends BaseService implements TempFileService {

    /**
     * @Description 添加TempFile
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param tempFile 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(TempFile tempFile) {
        if(tempFileMapper.insert(tempFile) == 1){
            return true;
        }
        return false;
    }

    /**
     * @Description 删除TempFile
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param fileId 主键
     * @return 是否成功
     */
    @Async
    @Override
    public void deleteById(Integer fileId) {
        try {
            TimeUnit.HOURS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TempFile tempFile = queryById(fileId);
        if (FtpUtil.deleteFile("/"+tempFile.getFilePath(),tempFile.getFileName())) {
            FtpUtil.deleteFolder("/"+tempFile.getFilePath());
            tempFileMapper.deleteById(fileId);
        }
    }

    /**
     * @Description 查询单条数据
     * @author gosang
     * @date 2020-03-10 11:22:11
     * @param fileId 主键
     * @return 实例对象
     */
    @Override
    public TempFile queryById(Integer fileId) {
        return tempFileMapper.queryById(fileId);
    }
}