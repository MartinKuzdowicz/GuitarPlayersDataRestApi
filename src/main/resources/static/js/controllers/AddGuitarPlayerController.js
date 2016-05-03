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
		$scope.guitars = data;
	});

	$scope.addGuitarPlayer = function() {
		console.log('addGuitarPlayer()');
		$http.post('/guitar-players', $scope.guitarPlayerForm);
	}

});