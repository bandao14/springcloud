package com.zl.model;

import java.io.*;

public class SerializableTest {


    public static void main(String[] args) throws Exception{
        SerializableUser();
        //User user=TheSerializableUser();
        //System.out.println(user.toString());
    }

    public static  void SerializableUser() throws FileNotFoundException, IOException {
        User user=new User();
        user.setId(1);
        user.setName("张三");
        user.setSex("男");
        ObjectOutputStream os=new ObjectOutputStream(
                new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\1.txt")));
        os.writeObject(user);
        System.out.println("User序列化成功");
        os.close();

    }

    public static User TheSerializableUser() throws FileNotFoundException,IOException,ClassNotFoundException{
        ObjectInputStream os=new ObjectInputStream(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\1.txt")));
        User user=(User) os.readObject();
        System.out.println("User反序列化成功");
        os.close();
        return user;

    }
}
