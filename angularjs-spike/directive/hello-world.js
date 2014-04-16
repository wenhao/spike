angular.module('directive-spike', [])
	.directive('helloWorld', function() {
		return {
			scope: true,
			restrict: 'AE',
			replace: 'true',
			template: '<p style="background-color:{{color}}">Hello World!!',
			link: function(scope, elem, attrs) {
				elem.bind('click', function() {
					//elem.css('background-color', 'white');
					scope.$apply(function() {
						scope.color = "white";
					});
				});
				elem.bind('mouseover', function() {
					elem.css('cursor', 'pointer');
				})
			}	
		};

	});