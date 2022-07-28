package com.twitter.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowSubscription implements Serializable {
    private String followerUsername;
    private String username;
}
