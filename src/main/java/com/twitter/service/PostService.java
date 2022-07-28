package com.twitter.service;

import com.twitter.controller.model.FollowSubscription;
import com.twitter.controller.model.PostMessage;
import com.twitter.model.Post;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private List<Post> postList = new ArrayList<>();
    private Map<String, Set<String>> followsMap = new HashMap<>();

    public void createPost(final PostMessage message) {
        Post post = new Post();
        BeanUtils.copyProperties(message, post);
        post.setPostDate(new Date());
        createUser(message.getUsername());
        postList.add(post);
    }

    public List<Post> getUserPosts(final String username) {
        return postList
                .stream()
                .filter(post -> post.getUsername().equals(username))
                .sorted(Comparator.comparing(Post::getPostDate).reversed())
                .collect(Collectors.toList());
    }

    public List<Post> getFollowersPosts(final String username) {
        return postList
                .stream()
                .filter(post -> followsMap.getOrDefault(username, new HashSet<>()).contains(post.getUsername()))
                .sorted(Comparator.comparing(Post::getPostDate).reversed())
                .collect(Collectors.toList());
    }

    public void followUser(final FollowSubscription followSubscription) {
        followsMap.putIfAbsent(followSubscription.getFollowerUsername(), new HashSet<>());
        followsMap.get(followSubscription.getFollowerUsername()).add(followSubscription.getUsername());
    }

    private void createUser(final String username) {
        followsMap.putIfAbsent(username, new HashSet<>());
    }
}
