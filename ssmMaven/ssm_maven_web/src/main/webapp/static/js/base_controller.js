// 为应用程序（app）定义一个基础控制器：baseController
app.controller('baseController', function ($scope, $rootScope, $interval) {

    // 刷新ids数组中已选中的id元素
    $rootScope.refreshIds = function () {
        $rootScope.ids = [];
        var idsAll = document.getElementsByName("ids");
        for (var i=0; i<idsAll.length; i++) {
            if (idsAll[i].checked) {
                $rootScope.ids.push(idsAll[i].value);
                console.log($rootScope.ids);
            }
        }
    };

    // 单选
    $rootScope.selectOne = function () {
        $rootScope.refreshIds();
    };

    // 全选/全不选
    $rootScope.selectAll = function () {
        var idsAll = document.getElementsByName("ids");
        for (var i=0; i<idsAll.length; i++) {
            if (idsAll[i].checked) {
                for (var x=0; x<idsAll.length; x++) {
                    idsAll[x].checked = false;
                }
                $rootScope.refreshIds();
                return;
            }
        }
        for (var y=0; y<idsAll.length; y++) {
            idsAll[y].checked = true;
        }
        $rootScope.refreshIds();
    };

    // 反选
    $rootScope.selectRes = function () {
        var idsAll = document.getElementsByName("ids");
        for (var i=0; i<idsAll.length; i++) {
            idsAll[i].checked = idsAll[i].checked !== true;
        }
        $rootScope.refreshIds();
    };

    // 动态显示当前系统时间
    $rootScope.sysTime = new Date().toLocaleString();
    $interval(function () {
        $rootScope.sysTime = new Date().toLocaleString();
    }, 1000);

    // 轮播显示我的站点
    var mySites = [
        {name:"我的站点：", url:"https://www.cnsdhh.com"},
        {name:"我的博客：", url:"https://blog.cnsdhh.com"},
        {name:"码云主页：", url:"https://gitee.com/cnsdhh"}
        ];
    var i = 0;
    $rootScope.mySite = mySites[i];
    $interval(function () {
        i++;
        if (i >= mySites.length) { i = 0; }
        $rootScope.mySite = mySites[i];
    }, 2000);

});