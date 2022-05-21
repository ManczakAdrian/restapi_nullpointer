package pl.manczak.restapi_nullpointer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.manczak.restapi_nullpointer.service.HelloService;

@RestController
@RequiredArgsConstructor  // ta adnotacja pozwala na nie pisanie konstruktora
public class HelloControler {


    private final HelloService helloService;




    @GetMapping("/")
    public String hello(){
        return helloService.hello();
    }
}
