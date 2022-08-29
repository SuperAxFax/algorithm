package array;

public class digital {
    /**
     * 创建数码表
     */
    public static final char[] chs = new char[36];
     static {
        for (int i = 0; i < 10; i++) {
            chs[i] = (char)('0' + i);
        }
        for (int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i-10));
        }
    }
}
