package com.my.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.ssm.pojo.User;
import com.my.ssm.service.UserService;

@Controller
@RequestMapping("/user") // User模块
public class UserController {

	// 注入Service层
	@Autowired
	private UserService userService;

	// User模块的list
	/*
	 * 参数：引入一个 Model模型，用于数据的传输
	 */
	@RequestMapping("/list")
	public String list(Model m) {
		List<User> users = userService.selectList();

		// 共享数据
		m.addAttribute("users", users);

		// 不允许外部访问
		// 转跳到userList.jsp中去
		return "userList";
	}

	@RequestMapping("delete")
	public String delete(Integer userId) {

		userService.deleteByPrimaryKey(userId);

		/*
		 * 不能用forward来转跳页面 因为用forward的话，出现访问删除页面的时候会有显示列表页面的内容
		 * 所以要用redirect,当执行完删除页面的功能之后，会重新跳回list页面中
		 */
		// return "forward:/user/list.do";
		return "redirect:/user/list.do";
	}

}
