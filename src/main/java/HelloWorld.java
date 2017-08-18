import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloWorld {
    public static void main(String args[]){
        final Logger log = Logger.getLogger(HelloWorld.class);
        log.info("App started");
        try{
            ResourceBundle bundle = ResourceBundle.getBundle("Strings");

            DateTime dt = new DateTime();
            int hour = dt.getHourOfDay();
            log.info(String.format("Hour of day: %d", hour));
            String message = null;
            if(hour>=6 && hour<9){
                message =  new String(bundle.getString("GoodMorning").getBytes("ISO-8859-1"), "UTF-8");
            }
            else if(hour>=9 && hour<19){
                message =  new String(bundle.getString("GoodDay").getBytes("ISO-8859-1"), "UTF-8");
            }
            else if(hour>=19 && hour<23){
                message =  new String(bundle.getString("GoodEvening").getBytes("ISO-8859-1"), "UTF-8");
            }
            else if(hour>=23 || hour<6){
                message =  new String(bundle.getString("GoodNight").getBytes("ISO-8859-1"), "UTF-8");
            }

            message = String.format("%s, %s",message, new String(bundle.getString("World").getBytes("ISO-8859-1"), "UTF-8"));
            log.info(String.format("Localized message: %s", message));
            System.out.println(message);

        }
        catch(Exception e){
            log.error(e.getMessage(), e);
        }
        log.info("App completed");
    }
}
