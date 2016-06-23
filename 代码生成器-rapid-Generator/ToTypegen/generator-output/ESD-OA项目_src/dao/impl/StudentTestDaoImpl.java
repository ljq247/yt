package cn.com.oa.birthdaybless_test.dao.impl;
/*******************************************************************************
曹文平欢迎你使用次模板
 *******************************************************************************/
import cn.com.oa.birthdaybless_test.model.StudentTest;
import cn.com.oa.birthdaybless_test.dao.StudentTestDao;

import cn.com.oa.common.dao.impl.BaseDAOHibernate;
import java.util.List;


public class StudentTestDaoImpl extends BaseDAOHibernate< StudentTest> implements  StudentTestDao {

	@Override
	protected Class getEntityClass() {
		
		return  StudentTest.class;
	}
}