package com.bintime.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Arthur on 10.10.2016.
 */
public class CommonsUtil {

    /**
     * Returns not-null synchronized copy of the source list
     *
     * @param source
     * @return
     */
    public static <T>List<T> getSafeList(List<T> source) {
        return Collections.synchronizedList(Optional.ofNullable(source).orElse(Collections.emptyList()));
    }
}
