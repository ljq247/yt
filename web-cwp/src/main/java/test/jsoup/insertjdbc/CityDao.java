package test.jsoup.insertjdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import test.jsoup.insertjdbc.model.City;


public class CityDao {
	
private JdbcTemplate jdbcT;
    
    public void setJdbcT(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }

    public  List findALL() {
        String sql = "select * from t_city";
        return jdbcT.queryForList(sql);
    }
    public  void insert(City c){
    	
    	jdbcT.update("insert into t_city( c_name,e_name,create_time ,contry_id)  VALUES(?,?,?,?)",
    			new Object[]{c.getcName(),c.geteName(),c.getCreateTime(),c.getContry_id()});
    	
    }
    public City findCityByid(int i){
    	
    	 Map<String, Object>  mc= jdbcT.queryForMap("select * from t_city where id="+i);
    	 
    	 City city=new City();
    	 city.setId(  ( Integer) mc.get("id"));
    	 city.setcName((String) mc.get("c_name"));
    	 city.seteName( (String) mc.get("e_name"));
    	 city.setCreateTime(   (Date) mc.get( "create_time" ));
    	  Object o= mc.get("p_id") ;
    	  city.setContry_id( (Integer) mc.get("c_id"));
    	 return city;
    	 
    }
    
    public List<City> findALLDepts() {
        List<City> depts = new ArrayList<City>();;
        String sql = "select * from ";
        List list = jdbcT.queryForList(sql); 
        Iterator iterator = list.iterator();
        City city = null;
        while (iterator.hasNext()) {
            Map map4dept = (Map) iterator.next();
            city = new City();     
            //…Ë÷√ Ù–‘
            //city.setId(id);(((BigDecimal) map4dept.get("DEPTNO")).intValue());
//            city.setDName((String)map4dept.get("DNAME"));
//            city.setLoc((String)map4dept.get("LOC"));        
//            depts.add(dept);
        }
        return depts;
    }    
    public void delete(int bid){
//        String sql = "delete from DeptInfo where bid =?";
//        return jdbcT.update(sql, new Object[]{bid});
 
    }
}
