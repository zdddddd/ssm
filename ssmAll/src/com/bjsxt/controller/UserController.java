package com.bjsxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveUser(User user) {
		int userId = this.userService.saveUser(user);
		return "redirect:/success.jsp?userId=" + userId;
	}
	
	@RequestMapping(value="{userId}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public User getUser(@PathVariable("userId") int userId) {
		User user = this.userService.getUser(userId);
		return user;
	}
	
//	@RequestMapping(value="{page}/{rows}")
//	public String getPaginatedUsers(@PathVariable("page") int page, @PathVariable("rows") int rows, Model model) {
//		
//		return "user_list";
//	}
	
	@RequestMapping(value="list")
	public String getPaginatedUsers(
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value="rows", required=false, defaultValue="10") int rows,
			Model model) {
		List<User> users = this.userService.getPaginatedUsers(page, rows);
		int pageSum = this.userService.getPageSum(rows);
		
		model.addAttribute("userList", users);
		model.addAttribute("pageSum", pageSum);
		model.addAttribute("currentPage", page);
		
		return "user_list";
	}
	
	@RequestMapping(value="{page}", method=RequestMethod.PUT)
	public String modifyUser(User user, @PathVariable("page") int page) {
		this.userService.modifyUser(user);
		return "redirect:/user/list?page=" + page;
	}
	
	/**
	 * save
	 * 		http://localhost:8080/ssmAll/user    POST请求
	 * update
	 * 		http://localhost:8080/ssmAll/user	 PUT请求
	 * 查询
	 * 		http://localhost:8080/ssmAll/user/10098  GET请求
	 * 删除
	 * 		http://localhost:8080/ssmAll/user/10098  DELETE请求
	 * 分页查询
	 * 		http://localhost:8080/ssmAll/user/3/5	GET请求
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="{userId}", method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public Map<String, Object> removeUser(@PathVariable("userId") int userId) {
		this.userService.removeUser(userId);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 200);
		result.put("msg", "删除成功");
		
		return result;
	}
	
}
