// 为应用程序（app）定义一个控制器：studentController
app.controller('studentController', function ($scope, $rootScope, $controller, studentService) {
    $controller('baseController',{$scope:$scope});

    // 查询所有学生记录
    $scope.findAll = function () {
        studentService.findAllS().success(function (responseData) {
            $scope.studentList = responseData;
        });
    };

    // 添加学生信息
    $scope.add = function (newStudent) {
        studentService.addS(newStudent).success(function (responseData) {
            alert(responseData.mssg);
            location.href = "/static/student/list.html";
        });
    };

    // 删除学生信息（批量删除和单个删除共享此方法）
    $scope.delete = function (ids) {
        studentService.delS(ids).success(function (responseData) {
            alert(responseData.mssg);
            location.href = "/static/student/list.html";
        })
    };


    // 根据ID查询学生信息
    // 【注意】AngularJS接收到服务器响应的数据后，如果是JSON格式会自动转换成JS对象，
    //         这里我需要将JS对象转换成JSON字符串，然后保存在sessionStorage中。
    $scope.findOne = function (id) {
        studentService.findOneS(id).success(function (responseData) {
            var studentStr = JSON.stringify(responseData);
            //alert(studentStr);
            sessionStorage.setItem("studentStr", studentStr);
            location.href = "/static/student/change.html";
        })
    };
    // 从sessionStorage中取出JSON字符串并再次转换成JS对象，然后赋值给AngularJS对象：oldStudent
    $scope.getStudent = function () {
        var studentStr = sessionStorage.getItem("studentStr");
        $rootScope.oldStudent = JSON.parse(studentStr);
        //alert($rootScope.oldStudent.name);
    };
    // 修改学生信息
    $scope.change = function (oldStudent) {
        studentService.changeS(oldStudent).success(function (responseData) {
            alert(responseData.mssg);
            location.href = "/static/student/list.html";
        });
    };

});