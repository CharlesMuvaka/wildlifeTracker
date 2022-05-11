package org.example.models;

import org.sql2o.Sql2o;

public class DB {


    public static Sql2o sql2o = new Sql2o("jdbc:postgres://ec2-54-172-175-251.compute-1.amazonaws.com:5432/d3kc0tt6krr3l5", "ukzfsftgxkuwmv", "4a5be043f769d7a2987b27da04b36bbba3538f92a7216daff81acadce6dfc218");

}