package src.com.accountmaker.springboot;

import com.accountmaker.springboot.service.TemporaryMailService;
import org.joda.time.LocalDateTime;
import org.joda.time.Seconds;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test1 {


    @Test @Ignore
    public void test1() {
        Random random = new Random();
        System.out.println(String.valueOf(random.nextInt() % 28 + 1));
    }
    @Test @Ignore
    public void test2() {
        Integer x = ThreadLocalRandom.current().nextInt(1, 28 + 1);
        System.out.println(String.valueOf(x));
    }
    @Test @Ignore
    public void test3() {//e5bretrhytry@tempinbox.com
    }

    @Test @Ignore
    public void test4() throws IOException, InterruptedException{
        //Create new button
        ///html/body/div[1]/div/div[2]/div[2]/h2/span[2]/button

        //ID = expire_block


        Document doc = Jsoup.connect("https://www.crazymailing.com/").get();

        System.out.println(doc.title());
        System.out.println(doc.getElementById("email_addr"));
        for (int i = 0; i < 10; i++) {
            System.out.println(doc.getElementById("expire_time") + " : " + doc.getElementById("expire_word"));
            Thread.sleep(30000);
        }

    }

    @Test @Ignore
    public void test5() throws IOException, InterruptedException{

        //ts.getTemporaryMail();
        //Create new button
        ///html/body/div[1]/div/div[2]/div[2]/h2/span[2]/button

        //ID = expire_block


//        Document doc = Jsoup.connect("http://tempinbox.com").get();
//        System.out.println(doc.title());
//        System.out.println(doc.getElementById("email_addr"));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(doc.getElementById("expire_time") + " : " + doc.getElementById("expire_word"));
//            Thread.sleep(30000);
//        }

    }



}
