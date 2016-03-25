package cn.itcast.mybatis.po;

import java.util.List;

/**
 * 
 * @author:小南风 2016年3月25日
 *
 */
public class UserQueryVo {
	
	//传入多个id
	private List<Integer> ids;
	
	
	//在这里包装所需要的查询条件
	
	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//可以包装其它的查询条件，订单、商品
	//....
	

}
