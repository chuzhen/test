package com.jiuqi.url;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
 * https处理，跳过ssl证书
 * @author lianghaojun
 *
 */
public class SSL {
    private static boolean initialled = false;
    
    /**
     * 跳过ssl证书验证
     * @throws Exception
     */
    public synchronized static void trustAllHttpsCertificates() throws Exception{
        if(initialled) return;
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
        
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. "
                        + session.getPeerHost());
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        
        initialled = true;
    }
    
    static class miTM implements javax.net.ssl.TrustManager,
        javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        
        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }
        
        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }
        
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
        
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}
