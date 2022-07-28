package com.twitter.controller;

import com.twitter.controller.model.PostMessage;
import com.twitter.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BoardController {

    private PostService postService;

    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value = "Get user post.")
    @GetMapping("/user/post")
    public ResponseEntity getUserPosts(@RequestParam final String username){
        return ResponseEntity.ok(postService.getUserPosts(username));
    }

    @ApiOperation(value = "Get post for main board.")
    @GetMapping("/board/post")
    public ResponseEntity getFollowersPosts(@RequestParam final String username){
        return ResponseEntity.ok(postService.getFollowersPosts(username));
    }

    @ApiOperation(value = "Create a post for followers.")
    @PostMapping("/post")
    public ResponseEntity createPost(@Valid @RequestBody final PostMessage message) {
        postService.createPost(message);
        return ResponseEntity.ok().build();
    }

}
