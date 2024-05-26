package com.storefinder.StoreLocator.controller;

//import jakarta.servlet.http.HttpServletResponse;
import com.storefinder.StoreLocator.model.Store;
import com.storefinder.StoreLocator.repository.SearchRepository;
import com.storefinder.StoreLocator.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    SearchRepository searchRepository;

    //enabling the swagger to test endpoints
    @ApiIgnore
    //refining the endpoints to only what we need
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    //to fetch all the posts
    @GetMapping("/stores")
    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    //to fetch filtered posts
    @GetMapping("/stores/{text}")
    public List<Store> search(@PathVariable String text){
        return searchRepository.findByText(text);
    }

    //to post data
    @PostMapping("/allpost")
    public Store addPost(@RequestBody Store stores ){
        return storeRepository.save(stores);
    }



}
