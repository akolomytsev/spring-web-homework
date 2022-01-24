package com.geekbrains.springwebhomework.endpoints;

import com.geekbrains.springwebhomework.services.CategoryService;
import com.geekbrains.springwebhomework.soap.categories.GetCategoryByTitleRequest;
import com.geekbrains.springwebhomework.soap.categories.GetCategoryByTitleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class CategoryEndpoint {
    private static final String NAMESPACE_URI = "http://www.com/geekbrains/springwebhomework/categories";
    private final CategoryService categoryService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetCategoryByTitleResponse getGroupByTitle(@RequestPayload GetCategoryByTitleRequest request) {
        GetCategoryByTitleResponse response = new GetCategoryByTitleResponse();
        //response.setCategory(categoryService.getByTitle(request.getTitle()));
        return response;
    }
}
