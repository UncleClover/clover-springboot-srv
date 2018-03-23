package com.clover.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.clover.springboot.model.UserInfo;

/**
 * mybatis 接口
 * 
 * @author zhangdq
 * @time 2018年3月16日 下午5:04:31
 * @Email qiang900714@126.com
 */
@Mapper
public interface UserMapper {
	/**
	 * 新增接口
	 * 
	 * @author zhangdq
	 * @time 2018年3月16日 下午5:04:46
	 * @Email qiang900714@126.com
	 * @param user
	 */
	public void insert(UserInfo user);

	/**
	 * oracle新增用户测试
	 * 
	 * @author zhangdq
	 * @time 2018年3月23日 上午11:25:22
	 * @Email qiang900714@126.com
	 * @param user
	 */
	public void addUser(UserInfo user);
}
