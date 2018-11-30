package com.ruoyi.content.mapper;

import com.ruoyi.content.domain.MusicUser;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户 数据层
 * 
 * @author hylu
 * @date 2018-11-30
 */
public interface MusicUserMapper 
{
	/**
	 * 新增用户
	 *
	 * @param musicUser 用户信息
	 * @return 结果
	 */
	public int insertMusicUser(MusicUser musicUser);

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public MusicUser selectMusicUserById(Long id);
	
	/**
     * 查询用户列表
     * 
     * @param musicUser 用户信息
     * @return 用户集合
     */
	public List<MusicUser> selectMusicUserList(MusicUser musicUser);
	
	/**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
	public int deleteMusicUserById(Long id);
	
	/**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMusicUserByIds(String[] ids);

	ArrayList<String> selectSeedMusicUserId(@Param("startId") String startId, @Param("stepNum")int stepNum);

	int updateMusicUserUsed(String[] ids);
}