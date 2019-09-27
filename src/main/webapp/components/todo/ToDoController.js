angular.module('toDoApp', [])
.controller("ToDO", function($scope, $http, $rootScope){
	$scope.todo = {toDoTitle: ''};
	$scope.onToDo = function(){
		console.log(this.todo);
	}
});