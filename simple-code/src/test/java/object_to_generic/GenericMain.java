package object_to_generic;

import object_to_generic.dao.impl.ChannelDaoImpl;
import object_to_generic.dao.impl.CityDaoImpl;
import object_to_generic.dao.impl.IChannelDao;
import object_to_generic.dao.impl.ICityDao;
import object_to_generic.model.City;

public class GenericMain {
	public static void main(String[] args) {
		
		ICityDao  cityDao= new CityDaoImpl();
		
		cityDao.load();
		cityDao.load();
		
		
		IChannelDao channelDao=new ChannelDaoImpl();
		
		
		channelDao.load();
		cityDao.load();
		channelDao.load();
		
		System.out.println(" 11over game");
	}

}
