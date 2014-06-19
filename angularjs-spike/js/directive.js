angular.module('myDirective', [])
    .controller('Ctrl', function($scope){
        $scope.customer = {
            name: 'Naomi',
            address: '1600 Amphitheatre'
        };
    })
    .controller('IgnoCtrl', function($scope){
        $scope.customer = {
            name: 'Igno',
            address: '112220 Cheng Du'
        };
    })
    .directive('myCustomer', function() {
        return {
            restrict: 'EA',
            templateUrl: './templates/my-customer.html'
        };
    })
    .directive('myCustm', function(){
        return {
            restrict: 'EA',
            templateUrl: './templates/my-custm.html'
        };
    })
    .directive('attrCustomer', function(){
        return {
            restrict: 'EA',
            scope: {
                customer: '=info'
            },
            templateUrl: './templates/my-customer.html'
        };
    });