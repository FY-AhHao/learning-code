package com.fy.codeDesign.demo06;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/27
 */
public class BetUser {

    private String username;
    private int weight;

    public BetUser() {
    }

    public BetUser(String username, int weight) {
        this.username = username;
        this.weight = weight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BetUser{" +
                "username='" + username + '\'' +
                ", weight=" + weight +
                '}';
    }
}
