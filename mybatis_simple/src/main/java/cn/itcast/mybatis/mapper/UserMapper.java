package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

/**
 * 
 * @author:小南风 2016年3月25日
 *
 */
public interface UserMapper {
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) ;
	
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) ;
	
	//根据id查询用户信息
	public User findUserById(int id) ;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) ;
	
	
	//根据用户名列查询用户列表
	public List<User> findUserByName(String name);
	
	//插入用户
	public void insertUser(User user);
	
	//删除用户
	public void deleteUser(int id);

}
