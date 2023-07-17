package com.hF.quoteSender;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Properties;

public class QuoteSender {


    public static String getQuote() throws IOException {

        final String URL = "https://www.zerochan.net/Watanabe+Akari";

        Document doc = Jsoup.connect(URL).get();
//        hCL kVc L4E MIw
        Elements quotes = doc.getElementsByTag("img");

        Element quote = quotes.get(13);

//        Elements elsRight = new Elements();
//        for (Element el : quotes) {
//
//            if (el.hasText()) {
//                elsRight.add(el);
//            }
//        }
//
//        Element photo = elsRight.get(0);
//
//        return photo.attr("src");

        for(int i = 8; i< quotes.size(); i++){
            Element quotePho = quotes.get(i);
            System.out.println(quotePho.attr("src"));

        }
        return quote.attr("src");

    }


    public static void main(String[] args) throws IOException, MessagingException, InterruptedException {

        String quote = getQuote();

        MailSender mailSender = new MailSender();

        mailSender.send(quote, "hiklesd@gmail.com", "QUOTE FROM hF");


    }
}

