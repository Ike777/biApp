package com.system.response;

import com.system.D;

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

    private String iconStr;

    private String realEstateStr;

    private String apartmentStr;

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

    public String getIconStr() {
        if (D.SCHOOL.equals(iconSt)) {
            return "学校";
        } else if (D.MALL.equals(iconSt)) {
            return "商场";
        } else if (D.HOSPITAL.equals(iconSt)) {
            return "医院";
        } else if (D.INDUSTRIAL_PARK.equals(iconSt)) {
            return "产业园";
        } else if (D.COMPANY.equals(iconSt)) {
            return "企业";
        } else if (D.PROPERTY.equals(iconSt)) {
            return "物业";
        } else if (D.TRAFFIC_STATION.equals(iconSt)) {
            return "交通站点";
        } else {
            return iconStr;
        }
    }

    public void setIconStr(String iconStr) {
        this.iconStr = iconStr;
    }

    public String getRealEstateStr() {
        if (D.RESIDENTIAL.equals(realEstateSt)) {
            return "住宅";
        } else if (D.BUSINESS.equals(realEstateSt)) {
            return "商业";
        } else if (D.OFFICE.equals(realEstateSt)) {
            return "办公";
        } else if (D.APARTMENT.equals(realEstateSt)) {
            return "公寓";
        } else {
            return realEstateSt;
        }
    }

    public void setRealEstateStr(String realEstateStr) {
        this.realEstateStr = realEstateStr;
    }

    public String getApartmentStr() {
        if (D.AVERAGE_HOUSE.equals(apartmentSt)) {
            return "普通住宅";
        } else if (D.HOUSES.equals(apartmentSt)) {
            return "洋房";
        } else if (D.VILLA.equals(apartmentSt)) {
            return "别墅";
        } else {
            return apartmentSt;
        }
    }

    public void setApartmentStr(String apartmentStr) {
        this.apartmentStr = apartmentStr;
    }
}
