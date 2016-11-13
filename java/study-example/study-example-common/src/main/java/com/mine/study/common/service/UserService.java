package com.mine.study.common.service;

import java.util.List;

import com.mine.study.common.model.UserAndAddrVO;
import com.mine.study.common.model.autocode.TUser;
import com.mine.study.common.model.autocode.TUserExample;

public interface UserService
{
    /**
     * @Description 获取用户信息列表
     * @author bm
     * @date 2016年11月13日 上午10:12:07
     * @param example
     * @return
     * @lastModifier
     */
    public List<TUser> listUser(TUserExample example);
    /**
     * @Description 获取单个用户信息
     * @author bm
     * @date 2016年11月13日 上午10:13:41
     * @param example
     * @return
     * @lastModifier
     */
    public TUser getUser(TUserExample example);
    /**
     * @Description 判断用户是否存在
     * @author bm
     * @date 2016年11月13日 上午10:14:17
     * @param example
     * @return
     * @lastModifier
     */
    public boolean isExistsUser(TUserExample example);
    /**
     * @Description 保存用户信息
     * @author bm
     * @date 2016年11月13日 上午10:12:38
     * @param user
     * @return
     * @lastModifier
     */
    public String saveUser(TUser user);
    /**
     * @Description 保存用户信息和地址,tx:纯粹为了测试aop事务
     * @author bm
     * @date 2016年11月13日 上午10:12:48
     * @param user
     * @param addr
     * @return
     * @lastModifier
     */
    public String saveUserAndAddress(UserAndAddrVO userAndAddr);
}
