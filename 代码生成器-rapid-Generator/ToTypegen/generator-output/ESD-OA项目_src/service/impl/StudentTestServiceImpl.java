package cn.com.oa.birthdaybless_test.service.impl;
/**
 * 
 * 曹文平欢迎你使用本模板
 *
 */
import cn.com.oa.birthdaybless_test.model.StudentTest;
import cn.com.oa.birthdaybless_test.dao.StudentTestDao;
import cn.com.oa.birthdaybless_test.service.StudentTestService;


import cn.com.oa.common.service.impl.BaseServiceImpl;
import javax.annotation.Resource;  //注解
import org.springframework.stereotype.Service;  //注解


@Service("studentTestSerivce")
public class StudentTestServiceImpl extends BaseServiceImpl<StudentTest> implements StudentTestService {
	
		private StudentTestDao  dao;		
		
		@Resource
		public void setStudentTestDao( StudentTestDao dao) {		
			super.setDAO(dao); //注入父类
			this.dao = dao;
		}	
		
}


