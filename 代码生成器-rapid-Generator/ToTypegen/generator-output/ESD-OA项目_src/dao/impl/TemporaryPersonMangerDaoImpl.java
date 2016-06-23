package cn.com.oa.birthdaybless_test.dao.impl;
/*******************************************************************************
曹文平欢迎你使用次模板
 *******************************************************************************/
import cn.com.oa.birthdaybless_test.model.TemporaryPersonManger;
import cn.com.oa.birthdaybless_test.dao.TemporaryPersonMangerDao;

import cn.com.oa.common.dao.impl.BaseDAOHibernate;
import java.util.List;


public class TemporaryPersonMangerDaoImpl extends BaseDAOHibernate< TemporaryPersonManger> implements  TemporaryPersonMangerDao {

	@Override
	protected Class getEntityClass() {
		
		return  TemporaryPersonManger.class;
	}
}