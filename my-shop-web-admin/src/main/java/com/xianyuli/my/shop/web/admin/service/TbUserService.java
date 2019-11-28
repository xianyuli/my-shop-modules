package com.xianyuli.my.shop.web.admin.service;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.domain.TbUser;

import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.service
 * @ClassName: TbUserService
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:52
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TbUserService {

    PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser);

    int count(TbUser tbUser);

    BaseResult save(TbUser tbUser);

    void delete(long id);

    TbUser getById(long id);

    void update(TbUser tbUser);

    List<TbUser> getByUsername(String username);

    TbUser login(String email, String password);

    int deleteMutil(String[] ids);

}
