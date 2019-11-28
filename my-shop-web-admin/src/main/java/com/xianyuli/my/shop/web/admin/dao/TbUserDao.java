package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.dao
 * @ClassName: TbUserDao
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:44
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Repository
public interface TbUserDao {

    /**
     * 新增
     *
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 删除
     *
     * @param id
     */
    void delete(long id);

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return
     */
    TbUser getById(long id);

    /**
     * 更新
     *
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 根据姓名查询
     *
     * @param username
     * @return
     */
    List<TbUser> getByUsername(String username);

    /**
     * 根据邮箱查询
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteMutil(String[] ids);

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @return
     */
    List<TbUser> page(@Param("start") int start, @Param("length") int length, @Param("user") TbUser tbUser);

    /**
     * 分页查询的统计
     *
     * @return
     */
    Integer count( @Param("user") TbUser tbUser);

}
