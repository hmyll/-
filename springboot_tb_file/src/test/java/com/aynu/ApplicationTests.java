package com.aynu;

import com.aynu.dao.TbDocDao;
import com.aynu.entity.TbDoc;
import com.aynu.service.TbDocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private TbDocDao tbDocDao;

	@Autowired
	private TbDocService tbDocService;

	@Test
	void contextLoads() {

	}

	@Test
	void test1() {
		System.out.println(tbDocDao.selectList(null));
	}


	@Test
	void test2(){
		System.out.println(tbDocService.findById(1));
	}

	@Test
	void test3(){
		tbDocService.copy(5,2);
	}

	@Test
	void test4() {
		TbDoc tbDoc = new TbDoc();
		tbDoc.setPid(1);
		tbDoc.setName("1");
		tbDoc.setType(1);
		System.out.println(tbDocDao.add(tbDoc));
		System.out.println(tbDoc+"-----"+tbDoc.getId());
	}


}
