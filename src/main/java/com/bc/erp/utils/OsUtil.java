package com.bc.erp.utils;

/**
 * 操作系统工具类
 *
 * @author zhou
 */
public class OsUtil {

    private static final String OS_NAME_WIN = "Windows";
    private static final String OS_NAME_SUN = "SunOS";
    private static final String OS_NAME_SOLARIS = "Solaris";
    private static final String OS_NAME_MAC = "MAC";
    private static final String OS_NAME_FREEBSD = "FreeBSD";
    private static final String OS_NAME_LINUX = "Linux";

    public enum OsType {
        /**
         * 操作系统类型
         */
        OS_TYPE_LINUX, OS_TYPE_WIN, OS_TYPE_SOLARIS, OS_TYPE_MAC, OS_TYPE_FREEBSD, OS_TYPE_OTHER
    }

    static private OsType getOsType() {
        String osName = System.getProperty("os.name");
        if (osName.startsWith(OS_NAME_WIN)) {
            return OsType.OS_TYPE_WIN;
        } else if (osName.contains(OS_NAME_SUN) || osName.contains(OS_NAME_SOLARIS)) {
            return OsType.OS_TYPE_SOLARIS;
        } else if (osName.contains(OS_NAME_MAC)) {
            return OsType.OS_TYPE_MAC;
        } else if (osName.contains(OS_NAME_FREEBSD)) {
            return OsType.OS_TYPE_FREEBSD;
        } else if (osName.startsWith(OS_NAME_LINUX)) {
            return OsType.OS_TYPE_LINUX;
        } else {
            // Some other form of Unix
            return OsType.OS_TYPE_OTHER;
        }
    }

    public static final OsType OS_TYPE = getOsType();
    public static final boolean WINDOWS = (OS_TYPE == OsType.OS_TYPE_WIN);
    public static final boolean SOLARIS = (OS_TYPE == OsType.OS_TYPE_SOLARIS);
    public static final boolean MAC = (OS_TYPE == OsType.OS_TYPE_MAC);
    public static final boolean FREEBSD = (OS_TYPE == OsType.OS_TYPE_FREEBSD);
    public static final boolean LINUX = (OS_TYPE == OsType.OS_TYPE_LINUX);
    public static final boolean OTHER = (OS_TYPE == OsType.OS_TYPE_OTHER);

}
