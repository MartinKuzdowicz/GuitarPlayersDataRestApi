GpdApiApp.controller('AlbumsController', function($scope, $http) {

	$http.get('/albums').success(function(data) {
		$scope.albums = data;
	});

});
