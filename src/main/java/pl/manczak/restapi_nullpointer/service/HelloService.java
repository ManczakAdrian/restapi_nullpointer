package pl.manczak.restapi_nullpointer.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)// scope po wstrzyknięciu za każdym razem wywołuje nową instancję wstrzykniętego beana
public class HelloService {

    public String hello(){
        return "Hello World";
    }
}
