var ctx = '/biApp/';

var SysService = new Object();

var isTest = 1;
if (isTest) {
    SysService.urls = {
        testUrl: 'auth/demo2.do',
        loginUrl: 'auth/login.do',
        getRolesUrl: 'auth/getRoles.do',
        submitRegionUrl: 'region/createRegion.do',
        initMapRegionsUrl: 'mockData/initShowMap.json'

    };
} else {
    SysService.urls = {
        testUrl: 'auth/demo2.do',
        loginUrl: 'auth/login.do',
        getRolesUrl: 'auth/getRoles.do',
        submitRegionUrl: 'region/createRegion.do',
        initMapRegionsUrl: ''

    };
}

SysService.doPost = function (data, url, cb) {
    $.ajax({
        type: 'POST',
        url: ctx + url,
        data: JSON.stringify(data),
        //data: data,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.success) {
                cb(res.t);
                return res;
            } else {
                alert(res.message);
            }
        },
        error: function (res) {
            console.log(res)
        }
    });
};