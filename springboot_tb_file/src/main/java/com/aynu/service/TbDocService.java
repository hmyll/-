package com.aynu.service;

import com.aynu.entity.TbDoc;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TbDocService extends IService<TbDoc> {

    List<TbDoc> findById(Integer id);

    void copy(Integer kid, Integer parent);
}
