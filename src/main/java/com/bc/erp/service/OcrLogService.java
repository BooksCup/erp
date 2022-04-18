package com.bc.erp.service;

import com.bc.erp.entity.ocr.OcrLog;

/**
 * 文字识别日志
 *
 * @author zhou
 */
public interface OcrLogService {

    /**
     * 新增文字识别日志
     *
     * @param ocrLog 文字识别日志
     */
    void addOcrLog(OcrLog ocrLog);

}