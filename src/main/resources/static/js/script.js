var monModule = angular.module("monModule", []);

/** controleur de récupération d'un utilisateur connecté **/
monModule.controller("GetLogedCtrl", function($http, $scope){
	
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

/****** controleur d'ajout d'un utilisateur **************/

monModule.controller("AjouterUserCtrl", function($http, $scope){
	$scope.user = {};
	$scope.users = null;
	$scope.errors = null;
	
	$scope.saveUser = function(){
		
		$http.post("users", $scope.user)
			.success(function(data){
				if(!data.errors){
					$scope.user = data;
					alert('Succès !');
					$scope.errors = null;
				} else {
					$scope.errors = data;
					//alert('pas ok');
				}
			});
	};
	
	$scope.listeUser= function(){
		$http.get("users").success(function(data){
			$scope.users = data;
		});
	};
	$scope.listeUser();
});

monModule.controller("AjouterRoleToUserCtrl", function($http, $scope){
	$scope.roleToUser = {};
	$scope.roles = null;
	$scope.errors = null;
	
	$scope.saveRoleToUser = function(){
		$http.post("addRoleToUser", $scope.roleToUser)
			.success(function(data){
				if(!data.errors){
					$scope.roleToUser = data;
					alert("Succès !");
					$scope.errors = null;
				}else{
					$scope.errors = data;
					alert("pas ok !")
				}
			});
	};
	
	$scope.listeRole = function(){
		$http.get("listeRoles").success(function(data){
			$scope.roles = data;
		});
	};
	
	$scope.listeRole();
});

/** controleur d'ajout et d'affichage des ressource **/
monModule.controller("AjouterRessourceCtrl", function($http, $scope){
	
	$scope.ressource = {};
	$scope.ressources = null;
	$scope.errors = null;
	$scope.typeRessources = null;
	
	$scope.saveRessource = function(){
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
	};
	
	$scope.listeRessource = function(){
		$http.get("ressources").success(function(data){
			$scope.ressources = data;
		});
	};
	$scope.listeRessource();
	
	$scope.selectType = function(){
		alert("ok")
	}
	//$scope.selectType();
});

/******Controleur d'ajout et affichage du type de ressource ***/
monModule.controller("AjouterTypeRessourceCtrl", function($http, $scope){
	
	$scope.typeRessource = {};
	$scope.typeRessources = null;
	$scope.errors = null;
	
	$scope.saveTypeRessource = function(){
		$http.post("typeRessources", $scope.typeRessource)
			.success(function(data){
				if(!data.errors){
					$scope.typeRessource = data;
					alert('Succès !');
					$scope.errors = null;
					$scope.listeTypeRessource();
				} else {
					$scope.errors = data;
				}
			});
	};
	
	$scope.listeTypeRessource = function(){
		$http.get("typeRessources").success(function(data){
			$scope.typeRessources = data;
		});
	};
	
	$scope.listeTypeRessource();
	
	
});
/********************* fin *******************************/

/** Controleur d'ajout et d'affichage de faculté **/
monModule.controller("AjouterFaculteCtrl", function($http, $scope){
	
	$scope.faculte = {};
	$scope.facultes = null;
	$scope.errors = null;
	
	$scope.saveFaculte = function(){
		$http.post("facultes", $scope.faculte)
			.success(function(data){
				
				if(!data.errors){
					$scope.faculte = data;
					alert('Succès ! ');
					$scope.listeFaculte();
					$scope.errors = null;
				} else {
					$scope.errors = data;
					
				}
			});
	};
	
	$scope.listeFaculte = function(){
		$http.get("facultes").success(function(data){
			$scope.facultes = data;
			
		});
	}
	
	$scope.listeFaculte();
});

/************************ fin *************************/

/** Controleur d'ajout de filière et affichage */
monModule.controller("AjouterFiliereCtrl", function($http, $scope){
	
	$scope.filiere = {};
	$scope.filieres = null;
	$scope.errors = null;
	
	$scope.saveFiliere = function(){
		
		$http.post("filieres", $scope.filiere)
			.success(function(data){
				
				if(!data.errors){
					$scope.filiere = data;
					alert('Succès ! ');
					//$scope.listeFiliere();
					$scope.errors = null;
				} else {
					$scope.errors = data;
					//alert('pas ok')
				}
			});
	};
	
	$scope.listeFiliere = function(){
		$http.get("filieres").success(function(data){
			$scope.filieres = data;
			
		});
	}
	
	$scope.listeFiliere();
});

/************************ fin *************************/

/** Controleur d'ajout de classe et affichage */
monModule.controller("AjouterClasseCtrl", function($http, $scope){
	
	$scope.classe = {};
	$scope.classes = null;
	$scope.errors = null;
	
	$scope.saveClasse = function(){
		$http.post("classes", $scope.classe)
			.success(function(data){
				if(!data.errors){
					$scope.classe = data;
					alert('Succès ! ');
					$scope.listeClasse();
					$scope.errors = null;
				} else {
					$scope.errors = data;
					//alert('pas ok')
				}
			});
	};
	
	$scope.listeClasse = function(){
		$http.get("classes").success(function(data){
			$scope.classes = data;
			
		});
	}
	
	$scope.listeClasse();
});

/************************ fin *************************/

/** Controleur d'ajout d'une UE et affichage */
monModule.controller("AjouterUECtrl", function($http, $scope){
	
	$scope.ue = {};
	$scope.ues = null;
	$scope.errors = null;
	
	$scope.saveUE = function(){
		
		$http.post("ues", $scope.ue)
			.success(function(data){
				if(!data.errors){
					$scope.ue = data;
					alert('Succès ! ');
					$scope.listeUE();
					$scope.errors = null;
				} else {
					$scope.errors = data;
					//alert('pas ok')
				}
			});
	};
	
	$scope.listeUE = function(){
		$http.get("ues").success(function(data){
			$scope.ues = data;
			
		});
	}
	
	$scope.listeUE();
});

/************************ fin *************************/

monModule.controller("TypeReservationCtrl", function($http, $scope){
	
	$scope.type_reservations = null;
	
	$scope.liste_reservation = function(){
		
		$http.get("typeReservations").success(function(data){
			$scope.type_reservations = data;
		});
	};
	
	$scope.liste_reservation();
});

/*** Controleur de creation d'un emploi de temps ***/
monModule.controller("AjouterReservationCtrl", function($http, $scope){
	
	$scope.reservation = {};
	$scope.reservations = null;
	//$scope.errors = null;
	
	$scope.saveReservation = function(){
		
		$http.post("reservations", $scope.reservation)
			.success(function(data){
				alert(data.heure_fin)
				if(!data.errors){ 
					if(data.heure_deb >= data.heure_fin){
						alert("Intervalle de temps erroné !!! [ "+ data.heure_deb +" , "+data.heure_fin + "]");
					}else{
						$scope.reservation = data;
						alert('La ressource '+ data.ressource + ' a été reservé(e) pour le '+
								data.jour + ' de '+ data.heure_deb + ' à '+data.heure_fin);
						$http.post("historiques", $scope.historique).success(function(data){
							$scope.historique = data;
						});
					}
					
					$scope.listeReservation();
					//$scope.errors = null;
				} else {
					$scope.errors = data;
					alert('pas ok')
				}
			});
	};
	
	$scope.listeReservation = function(){
		$http.get("reservations").success(function(data){
			$scope.reservations = data;
			
		});
	}
	
	var x = $scope.listeReservation();
	
});

/*********************** fin ***********************/


monModule.controller("HeureCouranteCtrl", function($http, $scope){
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
		$scope.annee1 = d.getFullYear() - 1;
		$scope.annee2 = d.getFullYear();
		$scope.jour = jours[d.getDay() - 1];
		$scope.mois = mois[d.getMonth()];
		$scope.dateCourante = $scope.jour+' '+d.getDate()+' '+$scope.mois+' '+d.getFullYear()
		//alert($scope.dateCourante);
		
		
	}
	
	$ajusterDateCourante();
	
});

/** Controleur de créatin d'emploi de temps pour les examens  ***********/


monModule.controller("AjouterReservationExamenCtrl", function($http, $scope){
	
	$scope.reservation = {};
	$scope.reservations = null;
	$scope.errors = null;
	
	$scope.saveReservationExamen = function(){
		$http.post("reservationExamens", $scope.reservation)
			.success(function(data){
				if(!data.errors){
					$scope.reservation = data;
					alert("Succès !");
					$scope.errors = null;
				} else {
					$scope.errors = data;
				}
			});
	}
	
	$scope.listeReservationExamen = function(){
		$http.get("reservationExamens").success(function(data){
			$scope.reservations = data;
		});
	}
});
/************************** fin ***************************/