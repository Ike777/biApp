package org.Ike.Api.icon.model;

import java.util.Date;

public class MapIcon {
    /**
     *
     */
    private Integer id;

    /**
     * 标物名称
     */
    private String iconName;

    /**
     * 标物类型Code 候选项： 学校 商场 医院 产业园 重点企业 物业 交通站点
     */
    private String iconSt;

    /**
     * 物业类型Code 候选项： 住宅、商业、办公、公寓
     */
    private String realEstateSt;

    /**
     * 公寓类型Code 候选项： 普通住宅，洋房，别墅
     */
    private String apartmentSt;

    /**
     * 是否土地 0 否 1 是
     */
    private Integer isEstate;

    /**
     * yyyy-MM-dd 成立时间 手填
     */
    private Date createDate;

    /**
     * 系统创建时间
     */
    private Date sysCreateDate;

    /**
     * 记录的版本 乐观锁
     */
    private Integer version;

    /**
     * 1 已逻辑删除 0 启用中
     */
    private Integer disabled;

    /**
     *
     */
    private Integer pointId;

    /**
     *
     */
    private Integer regionId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }



    public String getIconSt() {
        return iconSt;
    }

    public void setIconSt(String iconSt) {
        this.iconSt = iconSt == null ? null : iconSt.trim();
    }



    public String getRealEstateSt() {
        return realEstateSt;
    }

    public void setRealEstateSt(String realEstateSt) {
        this.realEstateSt = realEstateSt == null ? null : realEstateSt.trim();
    }



    public String getApartmentSt() {
        return apartmentSt;
    }

    public void setApartmentSt(String apartmentSt) {
        this.apartmentSt = apartmentSt == null ? null : apartmentSt.trim();
    }



    public Integer getIsEstate() {
        return isEstate;
    }

    public void setIsEstate(Integer isEstate) {
        this.isEstate = isEstate;
    }



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    public Date getSysCreateDate() {
        return sysCreateDate;
    }

    public void setSysCreateDate(Date sysCreateDate) {
        this.sysCreateDate = sysCreateDate;
    }



    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }



    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }



    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }



    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}