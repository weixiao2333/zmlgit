package zju.ccnt.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class saveImage {
    public static void saveImg(String base64,String filename){
        /**
         * 1.获取到后面到核心数据
         */
        String base64Data =  base64.split(",")[1];
        /**
         * 2.解码成字节数组
         */
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(base64Data);
        /**
         * 3.字节流转文件
         */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/Users/weixiao2333/Desktop/pic/concept/"+filename+".png");
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
