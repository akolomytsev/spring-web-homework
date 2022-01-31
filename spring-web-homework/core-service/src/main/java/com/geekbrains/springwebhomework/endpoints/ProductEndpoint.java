package com.geekbrains.springwebhomework.endpoints;

import com.geekbrains.springwebhomework.soap.products.GetAllProductsRequest;
import com.geekbrains.springwebhomework.soap.products.GetAllProductsResponse;
import com.geekbrains.springwebhomework.soap.products.GetProductByTitleRequest;
import com.geekbrains.springwebhomework.soap.products.GetProductByTitleResponse;
import com.geekbrains.springwebhomework.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.com/geekbrains/springwebhomework/products";
    private final ProductsService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByTitleRequest")
    @ResponsePayload
    public GetProductByTitleResponse getProductByTitleResponse(@RequestPayload GetProductByTitleRequest request) {
        GetProductByTitleResponse response = new GetProductByTitleResponse();
        response.setProduct1(productService.getByTitle(request.getTitle()));
        return response;

    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productService.getAllProducts().forEach(response.getProducts()::add);
        return response;
    }
/*
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.com/geekbrains/springwebhomework/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getProductByTitleRequest>
                    <f:title>Apple</f:title>
                </f:getProductByTitleRequest>
            </soapenv:Body>
        </soapenv:Envelope>
*/

/*
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.com/geekbrains/springwebhomework/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
*/
}
