var myApp = angular.module("myApp", []);

/** controleur de récupération d'un utilisateur connecté **/
myApp.controller("GetLogedCtrl", function($http, $scope){
	
	$scope.user = {};
	$scope.success = null;
	$scope.errors = null;
	
	$scope.getUser = function(){
		
		$http.get("getLogedUser")
			.success(function(data){
				if(!data.errors){
					$scope.user = data;
					$scope.success = " connecté ";
				}
				
			});
	};
	
	$scope.getUser();
});
/**************** fin ********************/

/** controleur d'ajout et d'affichage des ressource **/
myApp.controller("AjouterRessourceCtrl", function($http, $scope){
	
	$scope.ressource = {};
	$scope.ressources = null;
	$scope.errors = null;
	
	$scope.saveRessource(function(){
		$http.post("ressources", $scope.ressource)
			.success(function(data){
				
				if(!data.errors){
					$scope.ressource = data;
					alert('Succès !');
					$scope.errors = null;
					$scope.listeRessource();
				} else {
					$scope.errors = data;
				}
			});
	});
	
	$scope.listeRessource = function(){
		$http.get("ressources").success(function(data){
			$scope.ressources = data;
		});
	};
	
	$scope.listeRessource();
	
	
});


myApp.controller("AjouterTypeRessourceCtrl", function($http, $scope){
	
	$scope.typeRessource = {};
	$scope.typeRessources = null;
	$scope.errors = null;
	
	$scope.saveTypeRessource(function(){
		$http.post("typeRessources", $scope.typeRessource)
			.success(function(data){
				
				if(!data.errors){
					$scope.typeRessource = data;
					alert('Succèss !');
					$scope.listeTypeRessource();
					$scope.errors = null;
				} else {
					$scope.errors = data;
				}
			});
	});
	
	$scope.listeTypeRessource = function(){
		$http.get("typeRessource").success(function(data){
			$scope.typeRessource = data;
		});
	};
	$scope.listeTypeRessource();
});