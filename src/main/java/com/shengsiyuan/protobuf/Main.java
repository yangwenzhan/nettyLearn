package com.shengsiyuan.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
//        PersonProtobuf.Persion.Build persionBuilder=PersonProtobuf.Person.newBuilder();
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("zhang三").setAge(22).setAddress("北国").build();
        byte [] student2ByteArrage =student.toByteArray();


        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArrage);
        System.out.println(student2.getAddress());
        System.out.println(student2.getAge());
        System.out.println(student2.getName());
        System.out.println(student2.toString());
        System.out.println(student2.hasName());

    }
}
