// 为应用程序（app）定义一个服务：userService
app.service("userService", function ($http, $rootScope) {

    // 用户登录
    this.loginS = function (user) {
        return $http.post("/user/login", user);
    };

    // 注册用户
    this.registerS = function (user) {
        return $http.post("/user/register", user);
    }

});