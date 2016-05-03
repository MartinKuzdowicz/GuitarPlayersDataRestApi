var GpdApiApp = angular.module('GpdApiApp', [ 'ngRoute' ]);

GpdApiApp.config(function($routeProvider) {

	$routeProvider//
	.when('/home', {
		templateUrl : 'ngViews/Home.html',
		resolve: {
			events: function(){
				console.log('/home');
			}
		}
	}).when('/add-guitar-player', {
		templateUrl : 'ngViews/AddGuitarPlayer.html'
	}).when('/albums', {
		templateUrl : 'ngViews/Albums.html'
	}).when('/guitar-players', {
		templateUrl : 'ngViews/GuitarPlayers.html'
	}).when('/songs', {
		templateUrl : 'ngViews/Songs.html'
	})

});

$(document).ready(function() {
	$('#navMenu li a').click(function() {
		$(this).parent().addClass('active').siblings().removeClass('active');
	});
});