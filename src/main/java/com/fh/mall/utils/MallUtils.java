package com.fh.mall.utils;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Description: 上传图片时用于得到服务器的URI
 * Author: HueFu
 * Date: 2020-8-22 22:12
 */
public class MallUtils {

    public static URI getHost(URI uri){
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(),null, null, null);
        } catch (URISyntaxException e) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
