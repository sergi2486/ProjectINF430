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

	$scope.ressource={};
	$scope.errors = null;
	$scope.ressources = null;
	
	
	
	$scope.saveRessource = function(){
		$http.post("ressources", $scope.ressource)
		.success(function(data){
			
			if(!data.errors){
				$scope.ressource = data
				$scope.errors = null;
				$scope.listeRessources();
				
				alert('Succès !');
			} else {
				$scope.errors = data;
				
			}
			
		});
	};
	
	$scope.listeRessources = function(){
		$http.get("ressources")
			.success(function(data){
				$scope.ressources = data;
			});
	};
	
	$scope.listeRessources();
});

/** Controlleur d'ajout et affichage d'un type de ressource ***/
myApp.controller("AjouterTypeRessourceCtrl", function($http, $scope){

	$scope.ressource={};
	$scope.errors = null;
	$scope.ressources = null;
	
	
	
	$scope.saveRessource = function(){
		$http.post("ressources", $scope.ressource)
		.success(function(data){
			
			if(!data.errors){
				$scope.ressource = data
				$scope.errors = null;
				$scope.listeRessources();
				
				alert('Succès !');
			} else {
				$scope.errors = data;
				
			}
			
		});
	};
	
	$scope.listeRessources = function(){
		$http.get("ressources")
			.success(function(data){
				$scope.ressources = data;
			});
	};
	
	$scope.listeRessources();
});



myApp.controller("heureCouranteCtrl", function($http, $scope){
	$scope.jour = null;
	$scope.mois = null;
	$scope.dateCourante = null;
	$scope.annee1 = null;
	$scope.annee2 = null;
	
	$ajusterDateCourante = function(){
		
		var  d = new Date();
		var jours = ["lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"];
		var mois = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", 
			"Juillet", "Août", "Septempbre", "Octobre", "Novembre", "Décembre"];
		$scope.annee1 = d.getFullYear();
		$scope.annee2 = d.getFullYear() + 1;
		$scope.jour = jours[d.getDay() - 1];
		$scope.mois = mois[d.getMonth()];
		$scope.dateCourante = $scope.jour+' '+d.getDate()+' '+$scope.mois+' '+d.getFullYear()
		alert($scope.dateCourante);
		
		
	}
	
});
/**************** fin ********************/

/** controleur d'affichage des ressources **/
myApp.controller("AfficherRessources", function($http, $scope){
	$scope.ressources = null;

	$scope.listeRessources = function(){
		$http.get("ressources")
			.success(function(data){
				$scope.ressources = data;
			});
	};
	
	$scope.listeRessources();
});
/**************** fin ********************/


/************* controleur d'ajout d'une faculté **********/
/* création  des ressources */
myApp.controller("AjouterFaculteCtrl", function($http, $scope){

	$scope.faculte={};
	$scope.errors = null;
	$scope.success = null;
	$scope.facultes = null;
	/*$scope.jour = null;
	$scope.mois = null;
	$scope.dateCourante = null;
	var  d = new Date();
	var jours = ["lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"];
	var mois = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", 
		"Juillet", "Août", "Septempbre", "Octobre", "Novembre", "Décembre"];
	
	$scope.jour = jours[d.getDay() - 1];
	$scope.mois = mois[d.getMonth()];
	$scope.dateCourante = $scope.jour+' '+d.getDate()+' '+$scope.mois+' '+d.getFullYear()*/
	
	$scope.saveFaculte = function(){
		$http.post("facultes", $scope.faculte)
		.success(function(data){
			if(!data.errors){
				$scope.faculte = data;
				
				$scope.errors = null;
				$scope.listeFacultes();
				alert('Succès !')
				
				//alert($scope.dateCourante);
			} else {
				$scope.errors = data;
				
			}
			
		});
	};
	
	$scope.listeFacultes = function(){
		$http.get("facultes")
			.success(function(data){
				if(!data.errors){
					$scope.facultes = data;
					
				}
			});
	};
	
	$scope.listeFacultes();

});

/******************** fin *****************/

/**************** controleur d'ajout d'une filière ****************/

myApp.controller("AjouterFiliereCtrl", function($http, $scope){
	
	$scope.filiere = {};
	$scope.filieres = null;
	$scope.success = null;
	$scope.errors = null;
	
	$scope.saveFiliere = function(){
		
		$http.post("filieres", $scope.filiere)
			.success(function(data){
				
				if(!data.errors){
					$scope.filiere = data;
					alert('Succès !');
					$scope.errors = null;
					$scope.listeFilieres();
				} else {
					$scope.errors = data;
				}
				
			});
	};
	
	$scope.listeFilieres = function(){
		
		$http.get("filieres")
			.success(function(data){
				if(!data.errors){
					alert('test')
					$scope.filieres = data;
				}
			});
	};
	
	$scope.listeFilieres();
});
		
/************************* fin ***************************/

/***************** Controleur d'ajout d'une classe ***************/
myApp.controller("AjouterClasseCtrl", function($http, $scope){
	
	$scope.classe = {};
	$scope.classes = null;
	$scope.errors = null;
	
	$scope.saveClasse = function(){
		
		$http.post("classes", $scope.classe)
			.success(function(data){
				if(!data.errors){
					$scope.classe = data;
					alert('Succès !');
					$scope.errors = null;
					$scope.listeClasse();
					
				} else {
					$scope.errors = data;
				}
				
			});
	};
	
	$scope.listeClasse = function(){
		$http.get("classes")
			.success(function(data){
				if(!data.errors){
					$scope.classes = data;
				}
			});
	};
	
	$scope.listeClasse();
});

/*********************** fin ******************************/

/***************** Controleur d'ajout d'une unité d'enseignement ***************/
myApp.controller("AjouterUECtrl", function($http, $scope){
	
	$scope.ue = {};
	$scope.ues = null;
	$scope.success = null;
	$scope.errors = null;
	
	$scope.saveUE = function(){		
		$http.post("ues", $scope.ue)
			.success(function(data){
				if(!data.errors){
					$scope.ue = data;
					alert('Succès');
					$scope.errors = null;
					$scope.listeUE();
					
				} else {
					$scope.errors = data;
					alert('pas succes');
				}
				
			});
	};
	
	$scope.listeUE = function(){
		$http.get("ues")
			.success(function(data){
				if(!data.errors){
					$scope.ues = data;
				}
			});
	};
	
	$scope.listeUE();
});

/*********************** fin ******************************/

//myApp.controller("AjouterDepartCtrl", function($http, $scope){
//	
//	$scope.depart = {};
//	$scope.departs = null;
//	$scope.success = null;
//	$scope.errors = null;
//	
//	$scope.saveDepart = function(){
//		
//		$http.post("departements", $scope.ue)
//			.success(function(data){
//				if(!data.errors){
//					$scope.depart = data;
//					$scope.success = "Le département est ajouté";
//					$scope.errors = null;
//					$scope.listeDepart();
//					
//				} else {
//					$scope.errors = data;
//					
//				}
//				
//			});
//	};
//	
//	$scope.listeDepart = function(){
//		$http.get("departements")
//			.success(function(data){
//				if(!data.errors){
//					$scope.departs = data;
//				}
//			});
//	};
//	
//	$scope.listeDepart();
//});

/*********************** fin ******************************/

/*********************** Controleur de recherche d'une ressource ***********/




//myApp.controller("RechercheRessourceCtrl", function($http, $scope){
//	$scope.ressources = null;
//	
//	$scope.chercher = function(){
//		$http.get("chercher")
//			.success(function(data){
//				$scope.ressources = data;
//			});
//	};
//	
//	$scope.chercher();
//});
/******************** fin ******************************/

myApp.controller("AjouterReservationCtrl", function($http, $scope){
	
	$scope.reservation = {};
	$scope.reservations = null;
	//$scope.success = null;
	$scope.errors = null;
	$scope.mode={value:""};
	
	$scope.saveReservation = function(){
		
		$http.post("reservations", $scope.reservation)
			.success(function(data){
				if(!data.errors){
					$scope.depart = data;
					//$scope.success = "Le réservation à bien été effectuée";
					$scope.errors = null;
					$scope.listeReservation();
					$scope.mode.value="confirmer";
					alert('ok')
				} else {
					$scope.errors = data;
					alert('pas ok')
				}
				
			});
	};
	
	$scope.listeReservation = function(){
		$http.get("reservations")
			.success(function(data){
				if(!data.errors){
					$scope.reservations = data;
				}
			});
	};
	
	$scope.listeReservation();
});
