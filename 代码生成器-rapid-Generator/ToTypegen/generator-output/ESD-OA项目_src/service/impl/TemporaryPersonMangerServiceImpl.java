package cn.com.oa.birthdaybless_test.service.impl;
/**
 * 
 * 曹文平欢迎你使用本模板
 *
 */
import cn.com.oa.birthdaybless_test.model.TemporaryPersonManger;
import cn.com.oa.birthdaybless_test.dao.TemporaryPersonMangerDao;
import cn.com.oa.birthdaybless_test.service.TemporaryPersonMangerService;


import cn.com.oa.common.service.impl.BaseServiceImpl;
import javax.annotation.Resource;  //注解
import org.springframework.stereotype.Service;  //注解


@Service("temporaryPersonMangerSerivce")
public class TemporaryPersonMangerServiceImpl extends BaseServiceImpl<TemporaryPersonManger> implements TemporaryPersonMangerService {
	
		private TemporaryPersonMangerDao  dao;		
		
		@Resource
		public void setTemporaryPersonMangerDao( TemporaryPersonMangerDao dao) {		
			super.setDAO(dao); //注入父类
			this.dao = dao;
		}	
		
}


