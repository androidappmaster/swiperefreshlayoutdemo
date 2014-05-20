package es.appmaster.swiperefreshlayoutdemo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * String utils class
 *
 * @author manolovn
 */
public class StringUtils {

    /**
     * Generate count strings
     *
     * @param count
     * @return
     */
    public static List<String> generateStrings(int count) {
        List<String> items = new ArrayList<String>();
        for ( int i = 0 ; i <= count ; i++ ) {
            items.add("Appmaster " + i);
        }
        return items;
    }

}
