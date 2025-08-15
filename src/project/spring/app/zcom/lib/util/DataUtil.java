package project.spring.app.zcom.lib.util;

import java.lang.reflect.Method;
import java.util.List;

public class DataUtil {

	public static void println(Object object) {
		if (object == null) {
			System.out.println(object.getClass().getName() + " IS NULL !!!");
		}
		
		Method[] methods = object.getClass().getMethods();
		if (methods == null) {
			System.out.println(object.getClass().getName() + " METHODS IS NULL !!!");
		}
		
		for ( int i = 0; i < methods.length; i++ ) {
			if ( "get".startsWith(methods[i].getName()) ) continue;
			
			try {
				System.out.println(methods[i].getName().substring(3) + " : " + methods[i].invoke(object, null));
			} catch ( Exception e ) {
				
			}
		}
	}
	
	public static void println(List object) {
		System.out.println(object.getClass().getName() + " METHODS IS NULL !!!");
		
		for ( int i = 0; i < object.size(); i++ ) {
			println(object.get(i));
		}
	}
	
}
