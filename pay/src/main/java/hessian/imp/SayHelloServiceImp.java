package hessian.imp;

import hessian.SayHelloService;
import org.springframework.stereotype.Service;

/**
 * Created by AllenWish on 2017-12-19.
 */
@Service("sayHelloService")
public class SayHelloServiceImp implements SayHelloService {
    @Override
    public String say(String json) {
        System.out.println(json);
        return "{\"name\":\"helloWorld\"}";
    }
}
