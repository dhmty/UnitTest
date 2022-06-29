package com.demo.unittest;

import com.demo.unittest.utils.JsonUtil;
import com.demo.unittest.utils.OBJ;
import com.demo.unittest.utils.ZIP;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
class UnitTestApplicationTests {

  @Test
  void contextLoads() throws Exception {



//    String regEmail="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    String key="{\n" +
            "   \"GRAYLOG_HOST_test\":\"10.1.5.197\",\n" +
            "   \"GRAYLOG_HOST\":\"172.16.3.66\",\n" +
            "   \"GRAYLOG_PORT\":\"12201\"\n" +
            "}";
    System.out.println(key);
    String zipTest= OBJ.zip(key);
    System.out.println("zip test: "+zipTest);
    String k1=String.valueOf(OBJ.unZip(zipTest));
    System.out.println(k1);
    JsonObject json1 = JsonUtil.gson.fromJson(k1,
            JsonObject.class);
    System.out.println(json1);
    System.out.println(json1.get("GRAYLOG_HOST_test").getAsString());
    System.out.println(json1.get("GRAYLOG_HOST").getAsString());
    System.out.println(json1.get("GRAYLOG_PORT").getAsInt());

//        System.out.println(JWTConfig.ins().key);




    // zip bên api Momo
    String data = "{\"urlGetListPaymentTransactionType_test\":\"http://testpos.bachhoaxanh.com/api/PaymentTransaction/GetListPaymentTransactionType\",\"urlGetPaymentQRCode_test\":\"http://testpos.bachhoaxanh.com/api/PaymentTransaction/GetPaymentQRCode\",\"urlQueryStatusPaymentTransaction_test\":\"http://testpos.bachhoaxanh.com/api/PaymentTransaction/QueryStatusPaymentTransaction\",\"authenKey\":\"ksdfswfrew3ttc!@4#123\"}";
    System.out.println(ZIP.zip(data));
  }

}
