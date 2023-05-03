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
 *javadoc - -encoding Utf-8 -d apidoc DuMain.java
 *
 * */

//import com.mysql.cj.*;
//import com.mysql.jdbc.*;
// import com.intellij.database.*;
// import com.intellij.database.dialects.*;
import Geovin.DAL.*;
import Geovin.Model.*;
import Geovin.Model.OutValue;
import Geovin.Common.*;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DuMain {



    private static Connection con;
    //private static Properties duproperties;
    private static Properties  pp = null;
    private static InputStream fis = null;
    private static String url = "";
    private static String  driverName="";
    private static String user="";
    private static String password ="";

    public static void main(String[] args) {

        try {
            // DuMysqlCon c = new DuMysqlCon();
            // c.getConnection();
            OutValue value = new OutValue();


            ArrayList<DuField> duFields= DuGetField.getFields("BookKind");
            int c=0;
            for(DuField duField:duFields)
            {
                c++;
                System.out.println("NO:"+c+":"+duField.getName()+":"+duField.getType());
            }
           /*
            DuDAL dal = new DuDAL();

            BookKind info = new BookKind();
            info.setBookKindParent(1);
            info.setBookKindName("社会科学");
            info.setBookKindID(2);
           int upint=dal.UpdateSQL(info);
           System.out.println("update:"+upint+"\t\n");

            BookKind addinfo=new BookKind();
            addinfo.setBookKindName("美国小说");
            addinfo.setBookKindParent(2);
            int isint= dal.InsertSQL(addinfo);
            System.out.println("Insert:"+isint+"\t\n");


            info = dal.selectId(2);
            info=dal.SelectSQLId(2);
           if(info!=null) {
                System.out.println("查询一条记录：2===" + info.getBookKindID() + ":" + info.getBookKindName() + "\t\n");
            }
            */
           // ArrayList<BookKind> list=dal.selectAll();
            BookKindDAL bookKindDAL=new BookKindDAL();
            ArrayList<BookKind> list=bookKindDAL.SelectSProcBookKindAll();
            for(BookKind bk:list)
            {
               System.out.println("\t\n"+bk.getBookKindID()+"\t"+bk.getBookKindName()+"\t"+bk.getBookKindParent()+"" +
                        "");
            }
            //java 数据类型 与sql.Types类型的转换
            ArrayList<OutObject> outObjects=new ArrayList<OutObject>();
            OutObject outObject=null;
             int i=0;
            outObject=new OutObject();
            outObject.setObject(i);
            outObject.setOutInt(1);
            outObjects.add(outObject);

             String s="geovindu";
            outObject=new OutObject();
            outObject.setObject(s);
            outObject.setOutInt(2);
            outObjects.add(outObject);

             long l=234343;
            outObject=new OutObject();
            outObject.setObject(l);
            outObject.setOutInt(3);
            outObjects.add(outObject);
             short ss=1111;
            outObject=new OutObject();
            outObject.setObject(ss);
            outObject.setOutInt(4);
            outObjects.add(outObject);
             byte b=22;
            outObject=new OutObject();
            outObject.setObject(b);
            outObject.setOutInt(5);
            outObjects.add(outObject);
            double db=23.2;
            outObject=new OutObject();
            outObject.setObject(db);
            outObject.setOutInt(6);
            outObjects.add(outObject);
             float ff=23.5f;
            outObject=new OutObject();
            outObject.setObject(ff);
            outObject.setOutInt(7);
            outObjects.add(outObject);

             char ch='y';
            outObject=new OutObject();
            outObject.setObject(ch);
            outObject.setOutInt(8);
            outObjects.add(outObject);

             boolean bl=false;
            outObject=new OutObject();
            outObject.setObject(bl);
            outObject.setOutInt(9);
            outObjects.add(outObject);
            DuGetField duGetField=new DuGetField();


            for(OutObject object:outObjects)
            {
              System.out.println( "DataType:"+ DuGetField.getType(object.getObject())+"  id:"+object.getOutInt());
            }
           /*
           * DataType:Integer  id:1
DataType:String  id:2
DataType:Long  id:3
DataType:Short  id:4
DataType:Byte  id:5
DataType:Double  id:6
DataType:Float  id:7
DataType:Character  id:8
DataType:Boolean  id:9
           * */

            /*
           java.sql.Types 数据类型
           Types.INTEGER;
            Types.NVARCHAR;
            Types.BIT;
            Types.ARRAY;
            Types.BIGINT;
            Types.BINARY;
            Types.BLOB;
            Types.BOOLEAN;
            Types.CHAR;
            Types.CLOB;
            Types.DATALINK;
            Types.DATE;
            Types.DECIMAL;
            Types.DISTINCT;
            Types.DOUBLE;
            Types.FLOAT;
            Types.LONGNVARCHAR;
            Types.JAVA_OBJECT;
            Types.LONGVARBINARY;
            Types.NCHAR;
            Types.NULL;
            Types.NCLOB;
            Types.NUMERIC;
            Types.OTHER;
            Types.REAL;
            Types.REF;
            Types.REF_CURSOR;
            Types.ROWID;
            Types.SMALLINT;
            Types.SQLXML;
            Types.STRUCT;
            Types.TIME;
            Types.TIME_WITH_TIMEZONE;
            Types.TIMESTAMP;
            Types.TINYINT;
            Types.VARBINARY;
            Types.VARCHAR;
             */


            //info.setBookKindName("社会科学");
            //info.setBookKindName("自然科学");
            // info.setBookKindID(4);
            // info.setBookKindName("geovindu文学");
            // info.setBookKindParent(2);
            // int ok= dal.proc(info);
            //int ok=dal.procInsert(info,value);
            //edit
            //int ok=dal.procUpdate(info);
            //int ok=dal.procDel(4);

            // if(ok>0) {
            // System.out.println("ok:"+ok+",out:"+value.getIntValue());
            // }
            //else {
            //  System.out.println("no");
            // }
            DuDAL duDAL=new DuDAL();
            ArrayList<TablesMetadata> tablesMetadatas=new ArrayList<TablesMetadata>();
            tablesMetadatas=duDAL.selectTablesMetadata();
            for(TablesMetadata tablesMetadata:tablesMetadatas)
            {
                System.out.println(tablesMetadata.getTableName()+":"+tablesMetadata.getRemarks()+"\t\n");
            }

           // ArrayList<ColumnsMetadata> columnsMetadatas=new ArrayList<ColumnsMetadata>();
           // columnsMetadatas=duDAL.selectColumnsMetadata("BookKindList");
           // for(ColumnsMetadata columnsMetadata:columnsMetadatas)
           // {
               // System.out.println(columnsMetadata.getColumnName()+":"+columnsMetadata.getDataType()+"\t\n");
           // }

            ArrayList<SchemasMetadata> schemasMetadatas=new ArrayList<SchemasMetadata>();
            schemasMetadatas=duDAL.selectSchemasMetadata();
            for(SchemasMetadata schemasMetadata:schemasMetadatas)
            {
              System.out.println(schemasMetadata.getTableSchem()+":"+schemasMetadata.getTableCatalog()+"\t\n");
             }

            DuCon cn = new DuCon();
            cn.getConnection();

         /*
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
            */




        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }

}
