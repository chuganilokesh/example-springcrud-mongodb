package com.examplespringcrudmongodb.service;

import com.examplespringcrudmongodb.TestAbstracts;
import com.examplespringcrudmongodb.model.Blog;
import com.examplespringcrudmongodb.dao.BlogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTests extends TestAbstracts {

    @Mock
    private BlogRepository blogRepository;


    @InjectMocks
    private BlogService blogService;



    @Test
    public void testCreateBlog() {
        Blog blog =  dummyBlog();

        given(blogRepository.save(blog)).willReturn(blog);

        Blog blogResult = blogService.create(blog);

        assertEquals(blogResult, blog);
    }
}
