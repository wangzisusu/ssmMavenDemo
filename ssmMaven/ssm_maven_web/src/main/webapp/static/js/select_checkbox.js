
// 单选
function selectOne() {
    //
}

// 全选/全不选
function selectAll() {
    var idsAll = document.getElementsByName("ids");
    for (var i=0; i<idsAll.length; i++) {
        if (idsAll[i].checked) {
            for (var x=0; x<idsAll.length; x++) {
                idsAll[x].checked = false;
            }
            return;
        }
    }
    for (var y=0; y<idsAll.length; y++) {
        idsAll[y].checked = true;
    }
}

// 反选
function selectRes() {
    var idsAll = document.getElementsByName("ids");
    for (var i=0; i<idsAll.length; i++) {
        idsAll[i].checked = idsAll[i].checked !== true;
    }
}
