package tr.edu.yildiz.ce.se.base.util;

import java.util.Objects;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError();
    }

    public static boolean isBlank(String s) {
        return Objects.isNull(s) || s.isBlank();
    }
    
}
