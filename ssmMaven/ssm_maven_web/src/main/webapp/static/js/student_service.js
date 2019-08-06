// 为应用程序（app）定义一个服务：studentService
app.service("studentService", function ($http, $rootScope) {

    // 查询所有学生记录
    this.findAllS = function () {
        return $http.get("/student/findAll");
    };

    // 添加学生信息
    this.addS = function (newStudent) {
        return $http.post("/student/add", newStudent);
    };

    // 删除学生信息
    this.delS = function (ids) {
        return $http.get("/student/del?ids=" + ids);
    };


    // 根据ID查询学生信息
    this.findOneS = function (id) {
        return $http.get("/student/findOne?id=" + id);
    };
    // 修改学生信息
    this.changeS = function (oldStudent) {
        return $http.post("/student/change", oldStudent);
    }

});