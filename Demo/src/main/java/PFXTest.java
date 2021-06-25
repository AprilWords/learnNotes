import java.io.*;
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


    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, InvalidKeyException, SignatureException {
        String ca_password = "123123";
        String file_paht = "C:\\Users\\admin\\Desktop\\千蛟渠道开发\\齐商银行\\761c55f8cfcda8a6834775db94aae3cd_c4c2eeeef931c31c132b992ddd13d1ad_8.pfx";
        FileInputStream fPkcs12 = new FileInputStream(new File(file_paht));
        KeyStore keyStore = null ;
        KeyStore ks = KeyStore.getInstance("PKCS12");

        char[] nPassword = {'1','2','3','1','2','3'};

        ks.load(fPkcs12, nPassword);
        fPkcs12.close();
        Enumeration enuml = ks.aliases();
        String keyAlias = null;
        if (enuml.hasMoreElements()) {
            keyAlias = (String) enuml.nextElement();

        }
        PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
        // Now once we know the alias, we could get the keys.
        System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
        Certificate cert = ks.getCertificate(keyAlias);
        PublicKey pubkey = cert.getPublicKey();

        System.out.println("cert class = " + cert.getClass().getName());
        System.out.println("cert = " + cert);
        System.out.println("public key = " + pubkey);
        System.out.println("private key = " + prikey);

        // 获得证书
        X509Certificate x509Certificate = (X509Certificate)cert;

        // 构建签名
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
        signature.initSign(prikey);
        String data = "1111111";
       signature.update(data.getBytes());
        String sss = signature.sign().toString();
       System.out.println(sss);

    }

}
