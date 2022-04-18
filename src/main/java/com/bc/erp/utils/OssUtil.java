package com.bc.erp.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * OSS工具类
 *
 * @author zhou
 */
@Component
public class OssUtil {

    private static final Logger logger = LoggerFactory.getLogger(OssUtil.class);

    @Value("${aliyun.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.access-secret}")
    private String accessSecret;

    @Value("${aliyun.end-point}")
    private String endPoint;

    @Value("${aliyun.bucket-name}")
    private String bucketName;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param key  文件名
     * @return 上传成功的标签
     */
    public String uploadFile(MultipartFile file, String key) {
        String eTag = "";
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessSecret);
        try {
            InputStream is = new ByteArrayInputStream(file.getBytes());
            // 上传图片
            PutObjectResult result = client.putObject(bucketName, key, is);
            eTag = result.getETag();
        } catch (Exception e) {
            logger.error("OSS错误=>", e);
        } finally {
            // 关闭OSS服务,一定要关闭
            client.shutdown();
        }
        return eTag;
    }

    /**
     * 上传文件
     *
     * @param bytes 字节数组
     * @param key   文件名
     * @return 上传成功的标签
     */
    public String uploadFile(byte[] bytes, String key) {
        String eTag = "";
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessSecret);
        try {
            InputStream is = new ByteArrayInputStream(bytes);
            // 上传图片
            PutObjectResult result = client.putObject(bucketName, key, is);
            eTag = result.getETag();
        } catch (Exception e) {
            logger.error("OSS错误=>", e);
        } finally {
            // 关闭OSS服务,一定要关闭
            client.shutdown();
        }
        return eTag;
    }

}
