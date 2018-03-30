//列表column
var regionColumns = [{
    radio: true
}, {
    field: 'regionName',
    title: '区域名称'
}, {
    field: 'regionCode',
    title: '区域码'
}, {
    field: 'price',
    title: '单价/元'
}, {
    field: 'topPrice',
    title: '最高价/元'
}];

var iconColumns = [{
    checkbox: true
}, {
    field: 'iconName',
    title: '标物名称'
}, {
    field: 'iconSt',
    title: '标物类型',
    formatter: function (text) {
        return switchIconSt(text);
    }
}, {
    field: 'realEstateSt',
    title: '物业类型',
    formatter: function (text) {
        return switchRealSt(text);
    }
}, {
    field: 'apartmentSt',
    title: '公寓类型',
    formatter: function (text) {
        return switchApartSt(text);
    }
}];
