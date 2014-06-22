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
    })
    .controller('DateAndTimeCtrl', function($scope){
        $scope.format = 'M/d/yy h:mm:ss a';
    })
    .directive('myCurrentTime', function($timeout, dateFilter){
        function link(scope, element, attrs){
            var format, timeoId;

            function updateTime(){
                element.text(dateFilter(new Date(), format));
            }

            scope.$watch(attrs.myCurrentTime, function(value){
                format = value;
                updateTime()
            });

            function scheduleUpdate() {
                timeoutId = $timeout(function() {
                    updateTime();
                    scheduleUpdate();
                }, 1000);
            }

            element.on('$destory', function() {
                $timeout.cancel(timeoutId);
            });

            scheduleUpdate();
        }

        return {
            link: link
        };
    })
    .controller('transcludeCtrl', function($scope){
        $scope.name = 'Tobias';
    })
    .directive('myDialog', function(){
        return {
            restrict: 'EA',
            transclude: true,
            templateUrl: '../templates/my-dialog.html',
            link: function(scope, element){
                scope.name = 'Jeff';
            }
        };
    })
    .controller('myDialogCloseCtrl', function($scope, $timeout){
        $scope.name = 'Tobias';
        $scope.hideDialog = function() {
            $scope.dialogIsHidden = true;
            $timeout(function(){
                $scope.dialogIsHidden = false;
            }, 2000);
        };
    })
    .directive('myDraggable', function($document) {
        return function(scope, element, attr){
            var startX=0, startY=0, x=0, y=0;

            element.css({
                position: 'relative',
                border: '1px solid red',
                backgroundColor: 'lightgrep',
                cursor: 'pointer'
            });

            element.on('mousedown', function(event){
                event.preventDefault();
                startX = event.pageX - x;
                startY = event.pageY - y;
                $document.on('mousemove', mousemove);
                $document.on('mouseup', mouseup);
            });

            function mousemove(event){
                y = event.pageY - startY;
                x = event.pageX - startX;
                element.css({
                    top: y + 'px',
                    left: x + 'px'
                });
            }

            function mouseup(event) {
                $document.unbind('mousemove', mousemove);
                $document.unbind('mouseup', mouseup);
            }
        }
    })
    .directive('myTabs', function(){
        return {
            restrict: 'EA',
            transclude: true,
            scope: {},
            controller: function($scope) {
                var panes = $scope.panes =[];

                $scope.select = function(pane) {
                    angular.forEach(panes, function(pane) {
                        pane.selected = false;
                    });
                    pane.selected = true;
                };

                this.addPane = function(pane){
                    if (panes.length == 0) {
                        $scope.select(pane);
                    }
                    panes.push(pane);
                };
            },
            templateUrl: '../tempaltes/my-tabs.html'
        };
    })
    .directive('myPane', function(){
        return {
            restrict: 'EA',
            require: '^myTabs',
            transclude: true,
            scope: {
                title: '@'
            },
            link: function(scope, element, attrs, tabsCtrl) {
                tabsCtrl.addPane(scope);
            },
            templateUrl: '../templates/my-pane.html'
        };
    });