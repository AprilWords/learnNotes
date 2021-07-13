import sun.misc.BASE64Decoder;
import sun.nio.cs.ext.GBK;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import java.util.Enumeration;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/24
 */
public class PFXTest {
    public static void downloadByHttps() throws IOException {

        byte[] buffer = new byte[1024];
        int len;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        URL reqURL = new URL("https://801.ebanktest.com.cn:6801/image/801/im_receipt/20210709/y1G1e17111P/8010820300000000005_20210709154253.pdf" ); //创建URL对象
        HttpsURLConnection httpsConn = (HttpsURLConnection)reqURL.openConnection();
        InputStream insr = httpsConn.getInputStream();
        while( (len = insr.read(buffer))!= -1){
            os.write(buffer,0,len);
        }
        File file = new File("D://pdf.pdf");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(os.toByteArray());

    }
    public static void post() throws IOException {

        String urlParam = "http://10.255.4.98:7071/yqbank/APIReqServlet";
        URL url = new URL(urlParam);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(6*10000);
        con.setReadTimeout(6*1000);
        con.setRequestProperty("Content-Type", "text/xml;charset=GBK");
        //允许写出
        con.setDoOutput(true);
        //允许读入
        con.setDoInput(true);
        //不使用缓存
        con.setUseCaches(false);
        //con.setDoOutput(true);
        //con.setRequestProperty("Pragma:", "no-cache");
        //con.setRequestProperty("Cache-Control", "no-cache");

        OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());

        String content = "202107061508588016Z50600000000HisReceiptListQry00002305<?xml version=\"1.0\" encoding=\"GBK\" ?><BankData><Sign><SignedData>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</SignedData><PubKey></PubKey></Sign><opReq><startIntcDate>20210519</startIntcDate><endIntcDate>20210525</endIntcDate><StartSeq>1</StartSeq><accountNo>801106301421013346</accountNo></opReq></BankData>";
        String temp =  "<?xml version=\"1.0\" encoding=\"GBK\" ?><BankData><Sign><SignedData>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</SignedData><PubKey></PubKey></Sign><opReq><startIntcDate>20210506</startIntcDate><endIntcDate>20210626</endIntcDate><StartSeq>11111111111111111111111</StartSeq><accountNo>801106701421005390</accountNo></opReq></BankData>";

      /*  BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = "";
        for (line = br.readLine(); line != null; line = br.readLine()) {
            System.out.println(line);
        }*/
      String t1 = "202107081457058016Z000100000000HisReceiptListQry00002704<?xml version=\"1.0\" encoding=\"GBK\" ?><BankData><Sign><SignedData>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</SignedData><PubKey></PubKey></Sign><opReq><opname>TodayReceiptListQry</opname><cstNo>100000000320</cstNo><userNo>100380</userNo><serialNo>202107081457058016Z0001</serialNo><userId>6Z</userId><reqTime>20210708145705</reqTime><ReqParam><accountNo>801106301421008276</accountNo><StartSeq>1</StartSeq><endIntcDate>20210511</endIntcDate><startIntcDate>20200806</startIntcDate></ReqParam></opReq></BankData>";
      out.write(new String(t1.getBytes("GBK")));
        out.flush();
     /*   InputStream in = con.getInputStream();
        byte[] result = new byte[64096];
        while(in.read(result)!= -1){

        }*/
        StringBuffer buffer = new StringBuffer();

        BufferedReader br = new BufferedReader(new InputStreamReader(

                con.getInputStream(), "gbk"));

        String temps;

        while ((temps = br.readLine()) != null) {
            buffer.append(temps);

            buffer.append("\n");
            //String response = new String(result,"gbk");
            //System.out.println(response);
        }
        String result = buffer.toString().trim();
        System.out.println(result);

    }
    public static void httpSend(){
        HttpURLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;
        String urlParam = "http://10.255.4.98:7071/yqbank/APIReqServlet";
        String  dss = "https://801.ebanktest.com.cn";
        try {
            URL url = new URL(dss);
            //得到连接对象
            con = (HttpURLConnection) url.openConnection();
            //设置请求类型
            con.setRequestMethod("POST");
            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");
            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
            //得到响应码

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = con.getInputStream();
                //将响应流转换成字符串
                resultBuffer = new StringBuffer();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }



    }
    public static void TCPSend() throws IOException {
        String ip = "10.255.4.98";
        int prot = 7071;
        Socket clinet = new Socket(ip,prot);
        String content = "202107061142138016Z684300000000HisReceiptListQry00002355<?xml version=\"1.0\" encoding=\"GBK\" ?><BankData><Sign><SignedData>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</SignedData><PubKey></PubKey></Sign><opReq><startIntcDate>20210506</startIntcDate><endIntcDate>20210626</endIntcDate><StartSeq>11111111111111111111111</StartSeq><accountNo>801106701421005390</accountNo></opReq></BankData>";
        OutputStream out = clinet.getOutputStream();
        byte[] sends = content.getBytes("UTF-8");
        out.write(sends);
       InputStream in = clinet.getInputStream();
       byte[] result = new byte[4096];
       while(in.read(result)!= -1){

       }
       clinet.close();
       String response = new String(result,"utf-8");
       System.out.println(response);






    }
    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, InvalidKeyException, SignatureException {
        //httpSend();
        String ss = "https://801.ebanktest.com.cn:6801/image/801/im_receipt/20210709/y1G1e17111P/8010820300000000005_20210709154253.pdf";
      /*  String[] spiltStr = ss.split(":");
        int portIndex = spiltStr[2].indexOf("/");
        String dowloadIp = spiltStr[0]+spiltStr[1];
        String dowladPort = spiltStr[2].substring(0,portIndex);
        String downloadUlrl = spiltStr[2].substring(portIndex);*/
        downloadByHttps();


    }

}
