package service;


import com.twitter.controller.model.FollowSubscription;
import com.twitter.controller.model.PostMessage;
import com.twitter.model.Post;
import com.twitter.service.PostService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class PostServiceTest {

    private PostService postService;

    @Before
    public void init(){
        postService = new PostService();
    }

    @Test
    public void createPostTestForOneUser(){
        postService.createPost(new PostMessage("testMessage", "testUser"));
        List<Post> posts = postService.getUserPosts("testUser");
        Assert.assertFalse(posts.isEmpty());
        Assert.assertEquals(1, posts.size());
    }

    @Test
    public void createPostTestWhenTwoUserPostMessage(){
        postService.createPost(new PostMessage("testMessage", "testUser"));
        postService.createPost(new PostMessage("testMessage2", "testUser2"));
        List<Post> posts = postService.getUserPosts("testUser");
        Assert.assertFalse(posts.isEmpty());
        Assert.assertEquals(1, posts.size());
    }

    @Test
    public void getFollowersPostsIfNoSubscription() {
        List<Post> posts = postService.getFollowersPosts("testUser");
        Assert.assertTrue(posts.isEmpty());
    }

    @Test
    public void getFollowersPostsIfIsSubscription() {
        postService.followUser(new FollowSubscription("testUser", "testUser2"));
        List<Post> posts = postService.getFollowersPosts("testUser");
        Assert.assertTrue(posts.isEmpty());
    }

}
