(function () {
    'use strict';
    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$window', '$http', '$scope'];
    function HomeController($window, $http, $scope) {
        var vm = this;
        vm.user = null;
        vm.todo = {toDoTitle: ''};
        vm.todoItems = [];
        
    	$scope.onToDo = function(){
    		$http({
                url: '/todo',
                method: "POST",
                data: vm.todo
            }).then(function (response) {
            	if(response.status == 200){
            		vm.todoItems.push((response.data));
            		$('.close').click();
            	}
            }, function (error) {
                console.log(error);
            });
    	}
    	var gIndex;
    	$scope.done = function(v, index){
    		gIndex = index;
    		$http({
                url: '/delete/'+v,
                method: "GET"
            }).then(function (res) {
            	if(res.status == 200){
            		vm.todoItems.splice(gIndex, 1);
            	}
            }, function (error) {
                console.log(error);
            });
    	}

        initController();
        initToDo();

        function initController() {
            $http({
                url: '/user',
                method: "GET"
            }).then(function (res) {
                vm.user = res.data.name;
            }, function (error) {
                console.log(error);
            });
        };
        
        function initToDo() {
            $http({
                url: '/show-todo',
                method: "GET"
            }).then(function (res) {
            	//console.log(res);
            	if(res.status == 200 && res.data.length > 0){
            		vm.todoItems = ((res.data));
            		console.log(vm.todoItems)
            	}
            }, function (error) {
                console.log(error);
            });
        };

        $scope.logout = function () {
            $window.sessionStorage.setItem('userData', '');
            $http.defaults.headers.common['Authorization'] = 'Basic';
        }
    }
})();