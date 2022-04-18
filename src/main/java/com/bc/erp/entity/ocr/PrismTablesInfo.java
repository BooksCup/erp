package com.bc.erp.entity.ocr;

import java.util.List;

/**
 * 表格数组
 *
 * @author zhou
 */
public class PrismTablesInfo {
    private Integer tableId;
    private Integer xCellSize;
    private Integer yCellSize;

    private List<CellInfo> cellInfos;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getxCellSize() {
        return xCellSize;
    }

    public void setxCellSize(Integer xCellSize) {
        this.xCellSize = xCellSize;
    }

    public Integer getyCellSize() {
        return yCellSize;
    }

    public void setyCellSize(Integer yCellSize) {
        this.yCellSize = yCellSize;
    }

    public List<CellInfo> getCellInfos() {
        return cellInfos;
    }

    public void setCellInfos(List<CellInfo> cellInfos) {
        this.cellInfos = cellInfos;
    }

}