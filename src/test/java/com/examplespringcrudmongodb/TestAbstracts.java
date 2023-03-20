package com.examplespringcrudmongodb;

import com.examplespringcrudmongodb.model.Blog;

import static com.examplespringcrudmongodb.constant.TestConstants.DUMMY_CONTENT;
import static com.examplespringcrudmongodb.constant.TestConstants.DUMMY_TITLE;

public abstract class TestAbstracts {

    protected Blog dummyBlog() {
        Blog blog =  new Blog();

        blog.setContent(DUMMY_CONTENT);
        blog.setTitle(DUMMY_TITLE);

        return blog;
    }
}
