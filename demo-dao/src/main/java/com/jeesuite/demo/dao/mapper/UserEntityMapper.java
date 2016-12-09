package com.jeesuite.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.jeesuite.demo.dao.entity.UserEntity;
import com.jeesuite.mybatis.plugin.cache.annotation.Cache;

import tk.mybatis.mapper.common.BaseMapper;

public interface UserEntityMapper extends BaseMapper<UserEntity> {
	
	@Cache
	public UserEntity findByMobile(@Param("mobile") String mobile);
	
	@Cache
	List<String> findByType(@Param("type") int type);
	
	@Cache
	@Select("SELECT count(*) FROM users where type=#{type}")
	@ResultMap("BaseResultMap")
    int countByType(@Param("type") int type);
}