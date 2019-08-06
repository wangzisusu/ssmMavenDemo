// 为应用程序（app）定义一个控制器：userController
app.controller('userController', function ($scope, $rootScope, userService) {
    //$controller('baseController',{$scope:$scope});

    // 用户登录
    $scope.login = function (user) {
        userService.loginS(user).success(function (responseData) {
            alert(responseData.mssg);
            if (responseData.sign) {
                location.href = "/static/student/list.html";
            } else {
                location.href = "/static/user/login.html";
            }
        })
    };

    // 注册用户
    $scope.register = function (user) {
        userService.registerS(user).success(function (responseData) {
            alert(responseData.mssg);
            if (responseData.sign) {
                location.href = "/static/user/login.html";
            } else {
                alert("请重新注册用户");
                location.href = "/static/user/register.html";
            }
        })
    }

});