package org.example.models;

import org.sql2o.Sql2o;

public class DB {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-107-22-238-112.compute-1.amazonaws.com:5432/ddskj5i4o8vi2j", "dahrgtvvqdnrwd", "f42a32c9cc36ddc03ac643ebeb3e23f659c1acd4498e58bfce7f37f7ee91b81e");


}
