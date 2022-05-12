package org.example.models;

import org.sql2o.Sql2o;

public class DB {


    public static Sql2o sql2o = new Sql2o("jdbc:postgres://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d7fba7ufgrglei", "laukiljlputcqf", "a2c1922e9fb5ab66be74fa17737423cc6fb6f6919f7a5bbe9bf19df3386de452");

}