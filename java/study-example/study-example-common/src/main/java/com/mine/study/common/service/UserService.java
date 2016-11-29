package com.mine.study.common.service;

import java.util.List;

import com.mine.study.common.model.BindUserVO;
import com.mine.study.common.model.autocode.TUser;
import com.mine.study.common.model.autocode.TUserExample;
import com.mine.study.whole.util.exception.SysException;

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
     * @Description 通过第三方id获取用户id
     * @author bm
     * @date 2016年11月26日 下午6:27:48
     * @param appId
     * @return
     * @lastModifier
     */
    public String queryThirdUserId(String appId) throws SysException;
    /**
     * @Description 第三方绑定
     * @author bm
     * @date 2016年11月28日 下午3:57:13
     * @param user
     * @return
     * @throws SysException
     * @lastModifier
     */
    public String thirdBind(BindUserVO user) throws SysException;
}
