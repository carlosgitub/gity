'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.login = function() {
        // console.log("8888");



        $scope.oficinaSucursal = {};
        $scope.oficinaSucursal.oficina="001";
        $scope.oficinaSucursal.nombre="002";
        $scope.oficinaSucursal.sucursal="003";
        $scope.oficinaSucursal.sucursalNombre="005";

        var usuario = {

        };

        usuario.id="1";
        usuario.nombre="TEST";
        usuario.apellido="00001";

//        UsuarioPerfil.obtenerOficinasSucursales($scope.oficinaSucursal, callbackObtenerOficinasSucursales);

       // UsuarioPerfil.obtenerOficinasSucursales(usuario, callbackObtenerOficinasSucursales);


        $state.go('app.dashboard-v2');

    };

    var callbackObtenerOficinasSucursales = function (data) {
        console.log(data);
    }
}])
;