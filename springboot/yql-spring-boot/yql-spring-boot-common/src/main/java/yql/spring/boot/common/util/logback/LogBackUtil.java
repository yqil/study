package yql.spring.boot.common.util.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackUtil {
	
	private static Logger log = LoggerFactory.getLogger(Object.class);

	public static Logger getLogger(){
		return log;
	}
}
