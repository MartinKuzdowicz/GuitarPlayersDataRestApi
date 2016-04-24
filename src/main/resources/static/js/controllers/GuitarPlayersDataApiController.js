GpdApiApp.controller('GuitarPlayersDataApiController', function($scope, $http) {

	$scope.guitarPlayerForm = {
		name : '',
		lastname : '',
		age : 0,
		heIsAlive : true,
		nationality : '',
		dateOfBirth: '',
		guitarId: ''
	};

	$scope.GetAllGuitarPlayers = function() {
		console.log('GetAllGuitarPlayers()');
		$http.get('/guitar-players').success(function(data) {
			$scope.guitarPlayers = data;
		});
	};

	$scope.ShowAllSongs = function() {
		console.log('ShowAllSongs()');
		$http.get('/compositions').success(function(data) {
			$scope.songs = data;
		});
	};

	$scope.ShowAllAlbums = function() {
		console.log('ShowAllAlbums()');
		$http.get('/albums').success(function(data) {
			$scope.albums = data;
		});
	};

	$scope.AddGuitarPlayer = function() {
		console.log('ShowAllAlbums()');
	};

	$scope.addGuitarPlayer = function() {
		console.log('addGuitarPlayer()');
		$http.post('/guitar-players', $scope.guitarPlayerForm);
	}

	showAllGuitars($scope, $http);

});

function showAllGuitars($scope, $http) {
	console.log('showAllGuitars()');
	$http.get('/guitars').success(function(data) {
		$scope.guitars = data;
	});
}
