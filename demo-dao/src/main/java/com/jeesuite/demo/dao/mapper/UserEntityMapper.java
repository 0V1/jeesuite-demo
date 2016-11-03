package com.jeesuite.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jeesuite.demo.dao.entity.UserEntity;
import com.jeesuite.mybatis.plugin.cache.annotation.Cache;

import tk.mybatis.mapper.common.BaseMapper;

public interface UserEntityMapper extends BaseMapper<UserEntity> {
	
	@Cache
	public UserEntity findByMobile(@Param("mobile") String mobile);
	
	@Cache(uniqueResult = false,keyPattern = "UserEntity.type:%s")
	List<String> findByType(@Param("type") int type);
	

}