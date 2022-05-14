package com.aynu.service.impl;


import com.aynu.dao.TbDocDao;
import com.aynu.entity.TbDoc;
import com.aynu.service.TbDocService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TbDocServiceImpl extends ServiceImpl<TbDocDao, TbDoc> implements TbDocService {


    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private ExecutorService threadPool = Executors.newFixedThreadPool(CPU_COUNT);

    @Autowired
    private TbDocDao tbDocDao;

    //根据id查询子目录及内容
    @Override
    public List<TbDoc> findById(Integer id) {
        List<TbDoc> tbDocList = new ArrayList<>();
        tbDocList.add(tbDocDao.selectById(id));
        int idx = 0;
        //基于BFS的思想，查询当前内容的子内容，加到队列，依次进行查询
        while(idx < tbDocList.size()){
            TbDoc tbDoc = tbDocList.get(idx);
            //文件夹继续查询，文件无子目录不查询
            if(tbDoc.getType() == 0){
                List<TbDoc> kidList = tbDocDao.selectByPid(tbDoc.getId());
                if(kidList != null) tbDocList.addAll(kidList);
            }
            idx ++;
        }
        return tbDocList;
    }

    @Override
    public void copy(Integer kid, Integer parent) {
        TbDoc tbDoc = tbDocDao.selectById(kid);
        tbDoc.setId(null);
        tbDoc.setPid(parent);
        tbDocDao.add(tbDoc);
        dfs(tbDocDao.selectByPid(kid),tbDoc.getId());
    }

    //递归插入，一次插入一层
    public void dfs(Vector<TbDoc> tbList, int parent){
        for (TbDoc tbDoc : tbList) {
            threadPool.execute(()->{
                int oldId = tbDoc.getId();
                tbDoc.setId(null);
                tbDoc.setPid(parent);
                tbDocDao.add(tbDoc);
                //文件夹继续复制；文件无子目录，不进行复制
                if(tbDoc.getType() == 0){
                    dfs(tbDocDao.selectByPid(oldId),tbDoc.getId());
                }
            });
        }
    }

}
