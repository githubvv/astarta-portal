package astarta.web.config.bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {

    private static final Logger logger = LoggerFactory.getLogger(ExposedResourceMessageBundleSource.class);

    public Map<String,String> getMessages(String filename){
    	Properties props = getProperties(filename).getProperties();
    	logger.info("Locale is got. File name is " + filename);
    	return getMessagesMap(props);
    }
    
    private Map<String,String> getMessagesMap(Properties properties){
        Map<String,String> messagesMap = new HashMap<String,String>();
        for(Map.Entry<Object,Object> entry: properties.entrySet()){
            if(entry.getKey() != null && entry.getValue() != null) {
                messagesMap.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return messagesMap;
    }
       
}