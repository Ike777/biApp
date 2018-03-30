var ctx = '/biApp/';

function switchRegionSt(code) {
    switch (code) {
        case "START":
            return "起步";
            break;
        case "GROWTH":
            return "成长";
            break;
        case "MATURE":
            return "成熟";
            break;
        default :
            return "";
    }
}

function switchIconSt(code) {
    switch (code) {
        case "SCHOOL":
            return "学校";
            break;
        case "MALL":
            return "商场";
            break;
        case "HOSPITAL":
            return "医院";
            break;
        case "INDUSTRIAL_PARK":
            return "产业园";
            break;
        case "COMPANY":
            return "企业";
            break;
        case "PROPERTY":
            return "物业";
            break;
        case "TRAFFIC_STATION":
            return "交通站点";
            break;
        default :
            return "";
    }
}

function switchRealSt(code) {
    switch (code) {
        case "RESIDENTIAL":
            return "住宅";
            break;
        case "BUSINESS":
            return "商业";
            break;
        case "OFFICE":
            return "办公";
            break;
        case "APARTMENT":
            return "公寓";
            break;
        default :
            return "";
    }
}

function switchApartSt(code) {
    switch (code) {
        case "AVERAGE_HOUSE":
            return "普通住宅";
            break;
        case "HOUSES":
            return "洋房";
            break;
        case "VILLA":
            return "别墅";
            break;
        default :
            return "";
    }
}