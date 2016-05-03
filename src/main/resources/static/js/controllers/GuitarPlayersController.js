GpdApiApp.controller('GuitarPlayersController', function($scope, $http) {

	$http.get('/guitar-players').success(function(data) {
		$scope.guitarPlayers = data;
	});


	$http.get('/albums').success(function(data) {
		$scope.albums = data;
	});

});
