package lib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Libraries {
	
	private static final Logger logger = LoggerFactory.getLogger(Libraries.class);

	public static void main(String[] args) {
		
		logger.debug("ciao sono un messaggio");
		logger.info("ciao sono un messaggio");
		logger.error("ciao sono un messaggio");

	}

}
