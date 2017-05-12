package com.jinqiao.b2c.project.common.manager.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */
public class OptionList implements Serializable {

    private List<CellText> cargoSourceTypeCode;
    private List<CellText> sexTypeCode;
    private List<CellText> refuseReason;
    private List<CellText> returnGoodStatus;
    private List<CellText> couponType;//优惠券类型


    public List<CellText> getCargoSourceTypeCode() {
        return cargoSourceTypeCode;
    }

    public void setCargoSourceTypeCode(List<CellText> cargoSourceTypeCode) {
        this.cargoSourceTypeCode = cargoSourceTypeCode;
    }

    public List<CellText> getSexTypeCode() {
        return sexTypeCode;
    }

    public void setSexTypeCode(List<CellText> sexTypeCode) {
        this.sexTypeCode = sexTypeCode;
    }

    public List<CellText> getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(List<CellText> refuseReason) {
        this.refuseReason = refuseReason;
    }

    public List<CellText> getReturnGoodStatus() {
        return returnGoodStatus;
    }

    public void setReturnGoodStatus(List<CellText> returnGoodStatus) {
        this.returnGoodStatus = returnGoodStatus;
    }

    public List<CellText> getCouponType() {
        return couponType;
    }

    public void setCouponType(List<CellText> couponType) {
        this.couponType = couponType;
    }
}
