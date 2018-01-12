package com.system.response;

import java.util.Date;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/8
 * Version    : 1.0
 * </pre>
 */
public class MapIconResponse {
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
        this.iconName = iconName;
    }

    public String getIconSt() {
        return iconSt;
    }

    public void setIconSt(String iconSt) {
        this.iconSt = iconSt;
    }

    public String getRealEstateSt() {
        return realEstateSt;
    }

    public void setRealEstateSt(String realEstateSt) {
        this.realEstateSt = realEstateSt;
    }

    public String getApartmentSt() {
        return apartmentSt;
    }

    public void setApartmentSt(String apartmentSt) {
        this.apartmentSt = apartmentSt;
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
}
