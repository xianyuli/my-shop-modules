package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import com.xianyuli.my.shop.commoms.utils.RegexpUtils;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.dao.TbUserDao;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.service.impl
 * @ClassName: TbuserServiceImpl
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:55
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    TbUserDao tbUserDao;

    @Override
    public PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser) {
        PageInfo<TbUser> result = new PageInfo<>();
        List<TbUser> list = tbUserDao.page(start, length, tbUser);
        int count = count(tbUser);
        result.setDraw(draw);
        result.setRecordsTotal(count);
        result.setRecordsFiltered(count);
        result.setData(list);
        result.setError("");
        return result;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);
        if (baseResult.getStatus() == ConstantUtils.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null) {
                //密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            } else {//更新用户
                tbUserDao.update(tbUser);
            }
            baseResult.setMsg("保存成功");
        }

        return baseResult;

    }

    @Override
    public void delete(long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> getByUsername(String username) {
        return tbUserDao.getByUsername(username);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            String pwd = tbUser.getPassword();
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (pwd.equals(md5Password)) {
                return tbUser;
            }
        }

        return null;
    }

    @Override
    public int deleteMutil(String[] ids) {
        return tbUserDao.deleteMutil(ids);
    }

    /**
     * 功能描述: 用户有效性验证<br>
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/11/11 0011 16:55
     */
    private BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = baseResult.fail("邮箱不能为空，请重新输入。");
        } else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = baseResult.fail("邮箱格式不正确");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = baseResult.fail("密码不能为空，请重新输入。");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = baseResult.fail("姓名不能为空，请重新输入。");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = baseResult.fail("手机不能为空，请重新输入。");
        } else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = baseResult.fail("手机格式不正确");
        } else if (tbUser.getId() == null) {
            //用户信息唯一性验证
            List<TbUser> list = getByUsername(tbUser.getUsername());
            if (list != null && list.size() > 0) {
                baseResult = baseResult.fail("用户名" + tbUser.getUsername() + "已存在");
            }
        }

        return baseResult;

    }


}
