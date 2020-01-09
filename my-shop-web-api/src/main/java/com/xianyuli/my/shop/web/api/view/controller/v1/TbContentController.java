package com.xianyuli.my.shop.web.api.view.controller.v1;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.web.api.dto.TbContentDTO;
import com.xianyuli.my.shop.web.api.service.TbContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TbContentController
 * @Description: java类作用描述
 * @Author: LW
 */
@RestController
@RequestMapping("/content/v1")
public class TbContentController {

    @Autowired
    TbContentService tbContentService;

    @GetMapping("{categoryid}")
    public BaseResult findByCategoryId(@PathVariable("categoryid") long categoryId) {
        List<TbContent> tbContents = tbContentService.findByCategoryId(categoryId);
        List<TbContentDTO> list = new ArrayList<>();
        for (TbContent tbContent : tbContents) {
            TbContentDTO dto = new TbContentDTO();
            BeanUtils.copyProperties(tbContent, dto);
            list.add(dto);
        }
        return BaseResult.success("成功", list);
    }


}
