package com.furkan.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstContoller {


//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello from my first controller";
//    }

    @PostMapping("/post")
    public String post(
          @RequestBody String message
    ){
        return "Request accepted and message is : " + message;
    }
    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ){
        return "Request accepted and order is : " + order.toString()  ;
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ){
        return "Request accepted and order is : " + order.toString()  ;
    }

    //normal class ile record arasındaki fark record çok daha minimal diyebiliriz
    //Örneğin normal bir class oluşturduğumuz zaman private final oluşturur
    //ardından constructor ve getter setter ekleriz ama record tarafında bunlar
    //gerek yok sadece record adı ve parametre gibi parantez içinde tanımlamak
    //yeterli olacaktır.
    //Her record otomatik olarak finaldir
    //Record kalıtım desteklemez, başka bir sınıftan türetilemez ya da başka bir
    //record'ı genişletemez.

    //http://localhost:8080/hello/furkan
     @GetMapping("/hello/{user-name}")
    public String pathVar(
           @PathVariable("user-name") String userName
    ) {
        return "my value = " + userName;
    }

    //http://localhost:8080/hello?param_name=paramvalue&param_name_2=value_2
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastname

    ) {
        return "my value = " + userName + "  " + userLastname;
    }


}
