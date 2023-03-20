package com.examplespringcrudmongodb.controller;

import com.examplespringcrudmongodb.exception.InvalidTitleException;
import com.examplespringcrudmongodb.model.Blog;
import com.examplespringcrudmongodb.service.IBlogService;
import com.examplespringcrudmongodb.validation.ValidateBlog;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.examplespringcrudmongodb.constant.ServiceConstants.INVALID_TITLE_EXCEPTION;

@RestController
@CrossOrigin
public class BlogController {

    @Autowired
    private IBlogService blogService;

    private final Gson GSON = new Gson();

    @GetMapping("/all")
    public List<Blog> getAllBlogs(){
        return blogService.findAll();
    }

    @GetMapping("/title/{title}")
    public List<Blog> getBlogsByTitle(@PathVariable String title){
        return blogService.findByTitle(title);
    }

    @GetMapping("/id/{id}")
    public Blog getBlogsById(@PathVariable String id){
        return blogService.findById(id);
    }

    @PostMapping(value = "/create",  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> create(@RequestBody Blog blog) throws InvalidTitleException {
        ValidateBlog.validate(blog);
        blog.setBlogId(UUID.randomUUID().toString());
        return new ResponseEntity<>(GSON.toJson(blogService.create(blog)), HttpStatus.OK);
    }

    @PutMapping("/update")
    public Blog update(@RequestBody Blog blog){
        return blogService.update(blog);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable String id){
        blogService.delete(id);
    }

}
