package com.phc.das.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phc.das.entity.User;
import com.phc.das.services.SearchService;

import lombok.Data;

@RestController
@RequestMapping("api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    @RequestMapping(value = "/options", params = "input", method = RequestMethod.GET)
    public ResponseEntity<List<SearchResultObject>> getUsers(@RequestParam String input) {
        System.out.println(input);
        return new ResponseEntity<>(searchService.searchCustomer(input).stream().map(this::convert)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    private SearchResultObject convert(User user) {
        SearchResultObject result = new SearchResultObject();
        result.setId(user.getId());
        result.setStringName(user.getFirstName() + " " + user.getLastName());
        return result;
    }

    @Data
    public static class SearchResultObject {
        private Long id;
        private String stringName;
        private String stringExtrafield;
    }
    // @RequestMapping(value = "/options", params = "search", method = RequestMethod.GET)
    // public ResponseEntity<List<String>> getUsers(@RequestParam String search) {
    // System.out.println(search);
    // return new ResponseEntity<>(userService.getAllUser().stream().map(User::getFirstName)
    // .collect(Collectors.toList()), HttpStatus.OK);
    // }
}

