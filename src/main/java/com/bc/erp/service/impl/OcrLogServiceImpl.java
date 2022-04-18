package com.bc.erp.service.impl;

import com.bc.erp.entity.ocr.OcrLog;
import com.bc.erp.mapper.OcrLogMapper;
import com.bc.erp.service.OcrLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文字识别日志
 *
 * @author zhou
 */
@Service("ocrLogService")
public class OcrLogServiceImpl implements OcrLogService {

    @Resource
    OcrLogMapper ocrLogMapper;

    /**
     * 新增文字识别日志
     *
     * @param ocrLog 文字识别日志
     */
    public void addOcrLog(OcrLog ocrLog) {
        ocrLogMapper.addOcrLog(ocrLog);
    }

}