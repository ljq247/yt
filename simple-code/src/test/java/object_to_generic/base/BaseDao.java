package object_to_generic.base;

import java.lang.reflect.Type;

public  class BaseDao<T> {

	private Class entityClass = null;

	private Class getEntityClass() {

		if (entityClass != null)
			return entityClass;

		
		Class thisclass = this.getClass();

		Type t = thisclass.getGenericSuperclass();  //获取带有泛型父类
		String cname_all = t.toString();
		int bigin = cname_all.indexOf('<');
		int end = cname_all.indexOf('>');
		String cname = cname_all.substring(bigin + 1, end);
		try {
			entityClass = Class.forName(cname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getEntityClass函数被调用:生成类模板是:" + entityClass);

		return entityClass;
	}

	public void save(T t) {
	}

	public T load() {
		System.out.println(getEntityClass());
		return null;
	}

}
