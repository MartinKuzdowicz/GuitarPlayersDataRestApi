GpdApiApp.controller('AddGuitarPlayerController', function($scope, $http) {

	$scope.guitarPlayerForm = {
		name : '',
		lastname : '',
		age : 0,
		heIsAlive : true,
		nationality : '',
		dateOfBirth : '',
		guitarId : ''
	};

	$http.get('/guitars').success(function(data) {
		$scope.guitars = data.guitars;
	});

	$scope.addGuitarPlayer = function() {
		console.log('addGuitarPlayer()');
		$http.post('/guitar-players', $scope.guitarPlayerForm).success(function(gp){
			$scope.addedGuitarPlayer = gp;
		});
	}

});