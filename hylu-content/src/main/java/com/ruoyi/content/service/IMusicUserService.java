package com.ruoyi.content.service;

import com.ruoyi.content.domain.MusicUser;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户 服务层
 * 
 * @author hylu
 * @date 2018-11-30
 */
public interface IMusicUserService 
{
	/**
	 * 新增用户
	 *
	 * @param musicUser 用户信息
	 * @return 结果
	 */
	public int insertMusicUser(MusicUser musicUser);

	/**
	 * 批量新增用户
	 *
	 * @param musicUserArr 用户信息列表
	 * @return 结果
	 */
	public int insertMusicUserBatch(ArrayList<MusicUser> musicUserArr);

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
     * 删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMusicUserByIds(String ids);

	/**
	 * 查询指定区间的种子
	 *
	 * @param startId 开始查询的id
	 * @param stepNum 区间长度
	 * @return
	 */
	public ArrayList selectSeedMusicUserId(String startId, int stepNum);

	/**
	 * 更新种子用户为已使用
	 *
	 * @param ids 需要更新的数据ID
	 * @return 结果
	 */
	public int updateMusicUserUsed(String[] ids);
	
}
