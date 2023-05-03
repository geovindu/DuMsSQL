/*
 * 版权所有 2021 涂聚文有限公司
 * 许可信息查看：
 * 描述：
 *
 * 历史版本： JDK 1.8.02
 * 2021-12-12 创建者 geovindu
 * 2021-12-15 添加 Lambda
 * 2021-12-15 修改：date
 * 接口类 mysql-connector-java-8.0.27.jar.
 * 数据库：MySQL Server 8.0
 * 2021-12-15 修改者：Geovin Du
 * 生成API帮助文档的指令：
 *javadoc - -encoding Utf-8 -d apidoc DuCon.java
 *
 * */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.*;
import com.mysql.jdbc.*;
import java.io.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.*;


public class DuCon {


    Connection con;
    //private static Properties duproperties;
    private static Properties  pp = null;
    private static InputStream fis = null;
    private static String url = "";
    private static String  driverName="";
    private static String user="";
    private static String password ="";

    public Connection getConnection() {

       // duproperties =new Properties();//创建资源对象
        pp = new Properties();
        try {
            fis=DuCon.class.getClassLoader().getResourceAsStream("dbinfo.properties");
            pp.load(fis);

            url = pp.getProperty("url");
            driverName = pp.getProperty("driverName");
            user = pp.getProperty("user");
            password = pp.getProperty("password");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //properties.load(new InputStreamReader(DuCon.class.getClassLoader().getResourceAsStream("dbinfo.properties"),"UTF-8"));

        try
        {

            Class.forName(driverName);
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


}
