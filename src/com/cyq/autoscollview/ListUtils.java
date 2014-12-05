package com.cyq.autoscollview;

import java.util.List;

/**
 * List Utils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2011-7-22
 */
public class ListUtils {

    /** default join separator **/
    public static final String DEFAULT_JOIN_SEPARATOR = ",";

    private ListUtils() {
        throw new AssertionError();
    }

    /**
     * get size of list
     * 
     * <pre>
     * getSize(null)   =   0;
     * getSize({})     =   0;
     * getSize({1})    =   1;
     * </pre>
     * 
     * @param <V>
     * @param sourceList
     * @return if list is null or empty, return 0, else return {@link List#size()}.
     */
    public static <V> int getSize(List<V> sourceList) {
        return sourceList == null ? 0 : sourceList.size();
    }

    /**
     * is null or its size is 0
     * 
     * <pre>
     * isEmpty(null)   =   true;
     * isEmpty({})     =   true;
     * isEmpty({1})    =   false;a
     * </pre>
     * 
     * @param <V>
     * @param sourceList
     * @return if list is null or its size is 0, return true, else return false.
     */
    public static <V> boolean isEmpty(List<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }


}
