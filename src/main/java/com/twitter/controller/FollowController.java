package com.twitter.controller;

import com.twitter.controller.model.FollowSubscription;
import com.twitter.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

    private PostService postService;

    public FollowController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value = "Follow another user to see his post.")
    @PostMapping("/follow")
    public ResponseEntity followUser(@RequestBody final FollowSubscription followSubscription) {
        postService.followUser(followSubscription);
        return ResponseEntity.ok().build();
    }
}
