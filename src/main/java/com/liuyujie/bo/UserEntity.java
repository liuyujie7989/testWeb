package com.liuyujie.bo;

/**
 * @author liuyishou
 * @date 2020/5/15
 */
public class UserEntity {

    private String userId;
    private String userName;

    public UserEntity(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserEntity() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
