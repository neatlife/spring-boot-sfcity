package com.github.neatlife.util;

import java.nio.charset.StandardCharsets;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:25
 */
public class SignUtil {
    /**
     * 签名方法
     * 参数：content：要发送的JSON结构字符串
     * 返回值：签名信息字符串
     * 注意：签名计算结果可以到此页面进行验证：http://sftc.jsonce.com/sign/
     */
    public static String sign(String appId, String appSecret, String content) {
        // 假设原始内容JSON为 {"hello":"kitty"}
        // content : "{\"hello\":\"kitty\"}"

        String toSign = content + "&" + appId + "&" + appSecret;
        // toSign : "{\"hello\":\"kitty\"}&1234567890&0123456789abcdef0123456789abcdef";

        String md5Result = md5(toSign.getBytes(StandardCharsets.UTF_8));
        // md5Result : "ef3435b1480e553480e19e3e162fb0be"

        // signResult : "ZWYzNDM1YjE0ODBlNTUzNDgwZTE5ZTNlMTYyZmIwYmU="

        return base64Encode(md5Result.getBytes(StandardCharsets.UTF_8));
    }

    private static String toHex(byte[] bytes) {
        final char[] hexDigits = "0123456789abcdef".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (byte aByte : bytes) {
            ret.append(hexDigits[(aByte >> 4) & 0x0f]);
            ret.append(hexDigits[aByte & 0x0f]);
        }
        return ret.toString();
    }

    private static String md5(byte[] toSignBytes) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(toSignBytes);
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String base64Encode(byte[] md5ResultBytes) {
        java.util.Base64.Encoder be = java.util.Base64.getEncoder();
        return be.encodeToString(md5ResultBytes);
    }
}
