package com.clover.springboot.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.clover.springboot.mapper.UserMapper;
import com.clover.springboot.model.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void insertTest() {
		UserInfo user = new UserInfo();
		user.setAddr("河南郑州");
		user.setId("5");
		user.setPwd("1234567890");
		user.setPwdRandom("123");
		user.setName("clover");
		user.setSex("1");
		user.setLoginTime("2018-03-21");
		user.setCreateTime("2018-01-01");

		userMapper.insert(user);
	}
}
