var myApp = angular.module('myApp', []);

myApp.controller('controllerCtrl', ['$scope', function($scope) {
    $scope.greeting = 'Hola !';
}]);

myApp.controller('doubleCtrl', ['$scope', function($scope) {
    $scope.double = function(value) {
        return value * 2;
    };
}]);

myApp.controller('spicyCtrl', ['$scope', function($scope) {
    $scope.spice = 'very';

    $scope.chiliSpicy = function() {
        $scope.spice = 'chili';
    };

    $scope.jalapenoSpicy = function() {
        $scope.spice = 'jalapeno';
    };
}]);

myApp.controller('spicyCtrl2', ["$scope", function($scope){
    $scope.spice = 'very';

    $scope.spicy = function(value) {
        $scope.spice = value;
    };
}]);

myApp.controller('mainCtrl', ["$scope", function($scope){
    $scope.timeOfDay = 'morning';
    $scope.name = 'Nikki';
}]);

myApp.controller('childCtrl', ["$scope", function($scope){
    $scope.name = 'Mattie';
}]);

myApp.controller('grandChildCtrl', ["$scope", function($scope){
    $scope.timeOfDay = 'evening';
    $scope.name = 'Gingerbreak Baby';
}]);

myApp.controller('Cntl2', ["$scope", function($scope) {
    var exprs = $scope.exprs = [];
    $scope.expr = '3*10|currency';

    $scope.addExp = function(expr){
        exprs.push(expr);
    };

    $scope.removeExp = function(index) {
        exprs.splice(index, 1);
    };
}]);

myApp.controller('Cntl1', ["$scope", function($scope){
    $scope.name = 'World';

    $scope.greet = function() {
        ($window.mockWindow || $window).alert('Hello ' + $scope.name);
    };
}]);