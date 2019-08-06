// 为应用程序（app）定义一个性别转换器：sexConverter
app.filter('sexConverter', function () {

    return function (sexNum) {
        if (sexNum === 1) {
            return "男";
        } else {
            return "女";
        }
    }
    
});