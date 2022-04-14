//package com.geekbrains.spring.web.cart;
//
//
//import com.geekbrains.spring.web.api.carts.CartItemDto;
//import com.geekbrains.spring.web.api.core.ProductDto;
//import com.geekbrains.spring.web.cart.integrations.ProductsServiceIntegration;
//import com.geekbrains.spring.web.cart.models.Cart;
//import com.geekbrains.spring.web.cart.models.CartItem;
//import com.geekbrains.spring.web.cart.services.CartService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.web.client.RestTemplate;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest(classes = SpringWebCartsApplication.class)
//public class CartServerTest {
//
//    @Autowired
//    private CartService cartService;
//
//    @MockBean
//    private RestTemplate restTemplate;
//
//    @MockBean
//    private CartItemDto cartItemDto;
//
//    @MockBean
//    private CartItem cartItem;
//
//    @MockBean
//    private ProductsServiceIntegration productsServiceIntegration;
//
//    @MockBean
//    private ProductDto productDto;
//
//
//
//    @BeforeEach
//    public void initCart() {
//        cartService.clearCart("userCartTest");
//        BigDecimal x = new BigDecimal(200);
//
//    }
//
//    @Test
//    public void addToCartTest(){
//        ProductDto productDto = new ProductDto(1L, "Лыжа", "200.00");
//
//        Mockito.doReturn(Optional.of(productDto)).when(productsServiceIntegration).findById(1L);
//        cartService.addToCart("userCartTest", 1L);
//        cartService.addToCart("userCartTest", 1L);
//        cartService.addToCart("userCartTest", 1L);
//        Assertions.assertEquals(1, cartService.getCurrentCart("userCartTest").getItems().size());
//
//    }
//
//    @Test
//    public void mergeTest() {
//        CartItem cartItem0 = new CartItem(1L, "Лыжа", 15, 200, 3000);
//        CartItem cartItem1 = new CartItem(2L, "Лыжа", 15, 200, 3000);
//        CartItem cartItem2 = new CartItem(3L, "Лыжа", 15, 200, 3000);
//        CartItem cartItem3 = new CartItem(4L, "Лыжа", 15, 200, 3000);
//
//        List<CartItem> cartItemList0 = new ArrayList<>();
//        cartItemList0.add(cartItem0);
//        cartItemList0.add(cartItem1);
//
//        Cart guestCart1 = new Cart();
//        guestCart1.setItems(cartItemList0);
//        cartService.clearCart("guestCartTest");
//        cartService.updateCart("guestCartTest", guestCart1);
//
//        List<CartItem> cartItemList1 = new ArrayList<>();
//        cartItemList1.add(cartItem2);
//        cartItemList1.add(cartItem3);
//
//        Cart userCart1 = new Cart();
//        userCart1.setItems(cartItemList1);
//        cartService.clearCart("userCartTest");
//        cartService.updateCart("userCartTest", userCart1);
//
//        cartService.merge("userCartTest", "guestCartTest");
//
//        Assertions.assertEquals(4, cartService.getCurrentCart("userCartTest").getItems().size());
//        Assertions.assertEquals(12000, cartService.getCurrentCart("userCartTest").getTotalPrice());
//    }
//
//    @Test
//    public void getCurrentCartTest(){
//        ProductDto productDto = new ProductDto(1L, "Лыжа", 200);
//
//        Mockito.doReturn(Optional.of(productDto)).when(productsServiceIntegration).findById(1L);
//        cartService.addToCart("userCartTest", 1L);
//        Assertions.assertEquals(200, cartService.getCurrentCart("userCartTest").getTotalPrice());
//    }
//
//    @Test
//    public void removeItemFromCartTest(){
//        ProductDto productDto = new ProductDto(1L, "Лыжа", 200);
//        ProductDto productDto2 = new ProductDto(2L, "Лыжа", 200);
//        ProductDto productDto3 = new ProductDto(3L, "Лыжа", 200);
//
//        Mockito.doReturn(Optional.of(productDto)).when(productsServiceIntegration).findById(1L);
//        Mockito.doReturn(Optional.of(productDto2)).when(productsServiceIntegration).findById(2L);
//        Mockito.doReturn(Optional.of(productDto3)).when(productsServiceIntegration).findById(3L);
//        cartService.addToCart("userCartTest", 1L);
//        cartService.addToCart("userCartTest", 1L);
//        cartService.addToCart("userCartTest", 2L);
//        cartService.addToCart("userCartTest", 3L);
//        Assertions.assertEquals(3, cartService.getCurrentCart("userCartTest").getItems().size());
//        cartService.removeItemFromCart("userCartTest", 1L);
//        Assertions.assertEquals(2, cartService.getCurrentCart("userCartTest").getItems().size());
//    }
//
//    @Test
//    public void decrementItemTest(){
//        ProductDto productDto = new ProductDto(1L, "Лыжа", 200);
//        Mockito.doReturn(Optional.of(productDto)).when(productsServiceIntegration).findById(1L);
//        cartService.addToCart("userCartTest", 1L);
//        cartService.addToCart("userCartTest", 1L);
//        Assertions.assertEquals(400, cartService.getCurrentCart("userCartTest").getTotalPrice());
//        cartService.decrementItem("userCartTest", 1L);
//        Assertions.assertEquals(200, cartService.getCurrentCart("userCartTest").getTotalPrice());
//    }
//
//    @Test
//    public void clearCartTest(){
//        cartService.clearCart("userCartTest");
//        Assertions.assertEquals(0, cartService.getCurrentCart("userCartTest").getItems().size());
//    }
//
//
//
//
//
//
//
//}
