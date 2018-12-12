package com.simon.subwaydating.engine.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.UnsupportedCharsetException;
import java.util.*;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/10/24 16:23
 * @File : HttpClientUtil
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String CHARSET_UTF8 = "UTF-8";

    private static RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000)
            .build();

    private HttpClientUtil() {

    }

    public static String sendGetRequest(String url) throws HttpUtilException {
        return execute(new HttpGet(url));
    }

    public static String sendPostRequest(String url) throws HttpUtilException {
        return execute(new HttpPost(url), new HashMap<>());
    }

    /**
     * Request Content-Type: application/x-www-form-urlencoded
     * @param url
     * @param params
     * @return
     * @throws HttpUtilException
     */
    public static String sendPostRequest(String url, Map<String, String> params) throws HttpUtilException {
        HttpPost httpPost = new HttpPost(url);
        return execute(httpPost, params);
    }

    /**
     * Request Content-Type: application/x-www-form-urlencoded
     * @param url
     * @param params
     * @return
     * @throws HttpUtilException
     */
    public static String sendGetRequest(String url, Map<String, String> params) throws HttpUtilException {
        HttpGet httpGet = new HttpGet();
        try {
            URIBuilder builder = new URIBuilder(url);
            if (null != params && !params.isEmpty()) {
                for (String key : params.keySet()) {
                    builder.addParameter(key, URLEncoder.encode(params.get(key), CHARSET_UTF8));
                }
            }
            httpGet.setURI(builder.build());
        } catch (URISyntaxException e) {
            logger.error("doGet(map)", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("doGet(map)", e);
        }
        return execute(httpGet);
    }

    /**
     * Request Content-Type: application/json
     * @param url
     * @param json
     * @return
     * @throws HttpUtilException
     */
    public static String sendPostRequest(String url, String json) throws HttpUtilException {
        HttpPost httpPost = new HttpPost(url);
        return execute(httpPost, json);
    }

    /**
     * Request Content-Type: text/plain
     * @param url
     * @param text
     * @return
     * @throws HttpUtilException
     */
    public static String sendPlainPostRequest(String url, String text) throws HttpUtilException {
        HttpPost httpPost = new HttpPost(url);
        return plainExecute(httpPost, text);
    }

    private static String execute(HttpGet httpGet) throws HttpUtilException {
        httpGet.setConfig(requestConfig);
        return doExecute(httpGet);
    }

    private static String execute(HttpPost httpPost, Map<String, String> params) throws HttpUtilException {
        httpPost.setConfig(requestConfig);
        if (null != params && !params.isEmpty()) {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            Set<Map.Entry<String, String>> set = params.entrySet();
            for(Map.Entry<String, String> entry : set) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET_UTF8));
            } catch (UnsupportedEncodingException e) {
                logger.error("execute(MAP)", e);
                throw new HttpUtilException(e);
            }
        }
        return doExecute(httpPost);
    }

    private static String execute(HttpPost httpPost, String json) throws HttpUtilException {
        if (StringUtils.isEmpty(json)) {
            return "";
        }
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        try {
            httpPost.setEntity(new StringEntity(json,CHARSET_UTF8));
        } catch (UnsupportedCharsetException e) {
            logger.error("execute(JSON)", e);
            throw new HttpUtilException(e);
        }
        return doExecute(httpPost);
    }

    private static String plainExecute(HttpPost httpPost, String text) throws HttpUtilException {
        if (StringUtils.isEmpty(text)) {
            return "";
        }
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type", "text/plain; charset=utf-8");
        try {
            httpPost.setEntity(new StringEntity(text,CHARSET_UTF8));
        } catch (UnsupportedCharsetException e) {
            logger.error("execute(text)", e);
            throw new HttpUtilException(e);
        }
        return doExecute(httpPost);
    }

    private static String doExecute(HttpUriRequest httpUriRequest) throws HttpUtilException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(httpResponse.getEntity(), CHARSET_UTF8);
        } catch (IOException e) {
            logger.error("doExecute() -> ", e);
            throw new HttpUtilException(e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    logger.error("doExecute() -> ", e);
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    logger.error("doExecute() -> ", e);
                }
            }
        }
    }

    public static class HttpUtilException extends Exception {
        private HttpUtilException(Exception e) {
            super(e);
        }
    }



}
