angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
    $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changeNumber = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_number',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

     $scope.createProductJson = function () {
            console.log($scope.newProductJson);
            $http.post(contextPath + '/products', $scope.newProductJson)
                .then(function (response) {
                    $scope.loadProducts();
                });
        }

        $scope.filteringByPrice = function () {
                console.log($scope.productsPriceBetween);
                $http({
                    url: contextPath + '/products/price_between',
                    method: 'GET',
                    params: {
                        max: $scope.productsPriceBetween.max,
                        min: $scope.productsPriceBetween.min
                    }
                }).then(function (response) {
                console.log(response.data);
                    $scope.ProductsList = response.data;
                });
            }

    $scope.loadProducts();
});