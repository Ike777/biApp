function dict(id,code) {
    $.ajax({
        type: 'POST',
        url: ctx + "/sys/dictByParentCode.do",
        data: {"parentCode": code},
        dataType: 'json',
        success: function (res) {
            if (res.success) {
                var selector = $('#' + id);
                selector.empty();
                for (var i in res.t) {
                    var data = res.t[i];
                    var option = "<option value=\"" + data.code + "\">" + data.value + "</option>";
                    selector.append(option);
                }
                selector.selectpicker('refresh');
            } else {
                Mes.show(res.message);
            }
        },
        error: function (res) {
            console.log(res)
        }
    });
}