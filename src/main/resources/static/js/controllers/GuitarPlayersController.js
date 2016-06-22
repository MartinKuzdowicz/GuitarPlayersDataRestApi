GpdApiApp.controller('GuitarPlayersController', function($scope, $http) {

	$http.get('/guitar-players').success(function(data) {
		console.log(data);
		$scope.guitarPlayers = data.guitarPlayers;
	});


	$http.get('/albums').success(function(data) {
		console.log(data);
		$scope.albums = data;
	});

});
