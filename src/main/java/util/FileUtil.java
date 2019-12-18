package util;

import com.cry.forum.model.Article;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtil {
    public static void main(String[] args) {
        String s = "http://www.javascriptvue.com/f/u-20190908214720076-1938730684.jpg";
        System.out.println(s.substring(s.lastIndexOf("/")));
    }

    public static String codeFileName(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf("."));
        if (StringUtils.isEmpty(ext) || !("jpg".equals(ext) || "png".equals(ext))) {
            ext = ".jpg";
        }
        fileName = "u-" + CryStringUtil.genStringByTime() + ext;
        return fileName;
    }

    public static void replaceImgTag(Article article, String uploadPath, String downloadPath) {
        String str = article.getContent();
        if (str == null) {
            return;
        }
        String tag = "img";
        String tagAttrib = "src";
        String regxpForTag = "<\\s*" + tag + "\\s+([^>]*)\\s*";
        String regxpForTagAttrib = tagAttrib + "=\\s*\"([^\"]+)\"";
        Pattern patternForTag = Pattern.compile(regxpForTag, Pattern.CASE_INSENSITIVE);
        Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib, Pattern.CASE_INSENSITIVE);
        Matcher matcherForTag = patternForTag.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result = matcherForTag.find();
        String imageShort = article.getImageShort();
        int imageShortIndex = article.getImageShortIndex();
        int index = 0;
        while (result) {
            index++;
            StringBuffer sbreplace = new StringBuffer("<" + tag + " ");
            Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));

            if (matcherForAttrib.find()) {
                String attributeStr = matcherForAttrib.group(1);
                if (attributeStr.indexOf("www.javascriptvue.com") > 0) {
                    result = matcherForTag.find();
                    if (imageShortIndex == index) {
                        imageShort = attributeStr.substring(attributeStr.lastIndexOf("/"));
                    }
                    continue;
                }
                String fileName = codeFileName(attributeStr);
                try {
                    downLoadFromUrl(attributeStr, fileName, uploadPath);
                } catch (IOException e) {
                    e.printStackTrace();
                    result = matcherForTag.find();
                    continue;
                }
                if (imageShortIndex == index) {
                    imageShort = fileName;
                }

                matcherForAttrib.appendReplacement(sbreplace, "src=" + downloadPath + fileName );
            }
            matcherForTag.appendReplacement(sb, sbreplace.toString());
            result = matcherForTag.find();
        }
        matcherForTag.appendTail(sb);
        article.setImageShort(imageShort);
        article.setContent(sb.toString());
    }

    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        conn.setRequestProperty("lfwywxqyh_token", "testToken");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }


        System.out.println("info:" + url + " download success");

    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


}
