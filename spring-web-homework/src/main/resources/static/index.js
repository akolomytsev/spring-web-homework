angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function () {
    console.log($scope.productsPriceBetween);
        $http({
        url: contextPath + '/products',
        method: 'GET',
        params: {
        title_part: $scope.filter ? $scope.filter.title_part : null,
        min_price: $scope.filter ? $scope.filter.min_price : null,
        max_price: $scope.filter ? $scope.filter.max_price : null,
        }
        }).then(function (response){
        console.log(response.data);
        $scope.ProductsList = response.data.content;
        });
    };

    $scope.deleteProduct = function (productId) {
    $http.delete(contextPath + '/products' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

//    $scope.changeNumber = function (productId, delta) {
//        $http({
//            url: contextPath + '/products/change_number',
//            method: 'GET',
//            params: {
//                productId: productId,
//                delta: delta
//            }
//        }).then(function (response) {
//            $scope.loadProducts();
//        });
//    }

     $scope.createProductJson = function () {
            console.log($scope.newProductJson);
            $http.post(contextPath + '/products', $scope.newProductJson)
                .then(function (response) {
                    $scope.loadProducts();
                });
        }

//        $scope.filteringByPrice = function () {
//                console.log($scope.productsPriceBetween);
//                $http({
//                    url: contextPath + '/products/price_between',
//                    method: 'GET',
//                    params: {
//                        max: $scope.productsPriceBetween.max,
//                        min: $scope.productsPriceBetween.min
//                    }
//                }).then(function (response) {
//                console.log(response.data);
//                    $scope.ProductsList = response.data;
//                });
//            }

    $scope.loadProducts();
});