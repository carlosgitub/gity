/**
 * @ngdoc service
 * @name app.catalogService
 * @description
 * # Servicio de persistencia con la entidad Usuario
 * Service in the angularSeedApp.
 */

/**
 * Created by santiago.yacelga on 31/03/2017.
 */

app.service('servicio-usuario', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.obtenerEstados = function () {
        var deferred = $q.defer();
        try {
            Usuario.obtenerEstados(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };

        return deferred.promise;
    };

    this.obtenerHorarios = function () {
        var deferred = $q.defer();
        try {
            Usuario.obtenerHorarios(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };


    this.obtenerOficinasSucursales = function () {
        var deferred = $q.defer();
        try {
            Usuario.obtenerOficinasSucursales(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

}]);