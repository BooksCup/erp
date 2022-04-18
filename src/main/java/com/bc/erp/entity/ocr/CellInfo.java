package com.bc.erp.entity.ocr;

/**
 * 单元格信息
 *
 * @author zhou
 */
public class CellInfo {

    private Integer tableCellId;
    private String word;
    private Integer xsc;
    private Integer xec;
    private Integer ysc;
    private Integer yec;
    private String pos;

    public Integer getTableCellId() {
        return tableCellId;
    }

    public void setTableCellId(Integer tableCellId) {
        this.tableCellId = tableCellId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getXsc() {
        return xsc;
    }

    public void setXsc(Integer xsc) {
        this.xsc = xsc;
    }

    public Integer getXec() {
        return xec;
    }

    public void setXec(Integer xec) {
        this.xec = xec;
    }

    public Integer getYsc() {
        return ysc;
    }

    public void setYsc(Integer ysc) {
        this.ysc = ysc;
    }

    public Integer getYec() {
        return yec;
    }

    public void setYec(Integer yec) {
        this.yec = yec;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

}