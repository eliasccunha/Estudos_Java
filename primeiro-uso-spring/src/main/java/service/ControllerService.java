package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ControllerService {
    @Autowired
    private ControllerService helloWorldService;

    @GetMapping
    public String helloWorld(String name){

        return helloWorldService.helloWorld("Elias");
    }
}
