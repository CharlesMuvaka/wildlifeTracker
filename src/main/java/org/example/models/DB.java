package org.example.models;

import org.sql2o.Sql2o;

public class DB {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-44-196-223-128.compute-1.amazonaws.com:5432/d8do1n1u5vmpme", "pvcywcrhlfrkcf", "1278cb11471956fabd3d4be2f590ee1bcedf6948f4ef4252bf1c1041a23c71c8");


}
