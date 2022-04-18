package com.bc.erp.mapper;

import com.bc.erp.entity.ocr.OcrLog;

/**
 * 文字识别日志
 *
 * @author zhou
 */
public interface OcrLogMapper {

    /**
     * 新增文字识别日志
     *
     * @param ocrLog 文字识别日志
     */
    void addOcrLog(OcrLog ocrLog);

}