package com.my.ssm.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.my.ssm.pojo.User;
import com.my.ssm.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springdao.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testSelectByPrimaryKey() {
		
		User user = userService.selectByPrimaryKey(4);
		System.out.println(user);
		
	}

	@Test
	public void testSelectList() {
		List<User> users = userService.selectList();
		
	}

	@Test
	public void testInsert() {
		
	}

	@Test
	public void testUpdateByPrimaryKey() {
		
	}

	@Test
	public void testDeleteByPrimaryKey() {
	}
	

}
