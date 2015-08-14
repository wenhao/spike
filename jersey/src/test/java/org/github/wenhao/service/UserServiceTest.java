package org.github.wenhao.service;


import static org.assertj.core.api.StrictAssertions.assertThat;

import org.github.wenhao.model.User;
import org.junit.Test;

public class UserServiceTest
{
    @Test
    public void should_be_able_to_get_user()
    {
        // given
        UserService userService = new UserService();

        // when
        User user = userService.get("101");

        // then
        assertThat(user).isEqualToComparingFieldByField(new User("jack", 30));
    }
}