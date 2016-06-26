GpdApiApp.controller('SongsController', function($scope, $http) {

	$http.get('/compositions').success(function(data) {
		$scope.songs = data.compositions;
	});

});