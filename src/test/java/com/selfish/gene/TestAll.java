package com.selfish.gene;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/3/8.
 */
public class TestAll {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void A() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime parse = LocalDateTime.parse("11 4 07:48:34 2016", DateTimeFormatter.ofPattern("MM d HH:mm:ss yyyy"));
        long epochMilli = parse.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(epochMilli);

        Date date = new Date(epochMilli);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    @Test
    public void B() throws Exception {
        String s = "July 5 08:34:24 2016";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d HH:mm:ss yyyy");
        LocalDateTime l = LocalDateTime.parse(s, formatter);
        System.out.println(l.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    public void C() throws Exception {

    }
}