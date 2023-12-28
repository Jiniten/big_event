package org.example.service;

import org.example.pojo.User;

// 服务层，包含应用程序的业务逻辑。接收控制器层的请求，协调业务逻辑的执行，可能涉及多个数据访问层的调用。通常不直接与数据库交互，而是调用数据访问层（如Mapper）来执行数据库操作。
public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String username);
    // 注册
    void register(String username, String password);

    // 更新
    void update(User user);

    // 更新头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
