package top.ylcao.StdMan.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import top.ylcao.StdMan.main.Log;


public class OperationMysql {

    private Connection connection; // 声明Connection私有对象
    private Statement sql; // 声明Statement对象


    public OperationMysql(String IP, int port, String database, String username, String password) throws SQLException { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.jdbc.Driver");
            new Log().pLog(Log.OPERATION, "数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            // 通过访问数据库的URL获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql:"
                    + String.format("//%s:%d/%s", IP, port, database), username, password);
            new Log().pLog(Log.OPERATION, "数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.connection = connection;
        this.sql = connection.createStatement();
    }


    public HashMap<String, String> searchStudentWithName(String studentName) {
        try {
            // 从students表中查询学生姓名
            ResultSet sqlResult = this.sql.executeQuery(String.format("select * from students where name = '%s'", studentName));// 执行SQL语句
            return packStudentSearchResult(sqlResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public HashMap<String, String> searchStudentWithID(String id) {
        try {
            // 从students表中查询学生姓名
            ResultSet sqlResult = this.sql.executeQuery(String.format("select * from students where ID = '%s'", id));
            return packStudentSearchResult(sqlResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void test(String username) throws SQLException {
        // 从students表中查询学生姓名
        ResultSet sqlResult = this.sql.executeQuery(String.format("select * from users where user = '%s'", username));
        while (sqlResult.next()) {
            System.out.println(sqlResult.getString("user"));
            System.out.println(sqlResult.getString("pwd"));
        }

    }


    private HashMap<String, String> packStudentSearchResult(ResultSet sqlResult) throws SQLException {
        HashMap<String, String> searchResult = new HashMap<String, String>();
        while (sqlResult.next()) { // 如果当前语句不是最后一条则进入循环
            setOneStudentInfo(sqlResult, searchResult);
        }
        return searchResult;
    }


    public boolean loginSystem(String username, String password) throws SQLException {
        try {
            // 从students表中查询管理员用户名
            ResultSet loginSqlResult = this.sql.executeQuery(String.format("select * from admins where username = '%s'", username));
            while (loginSqlResult.next()) {
                // 如果当前语句不是最后一条则进入循环
                // 判断密码是否一致
                if (!password.equals(loginSqlResult.getString("password"))) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<HashMap<String, String>> getAllStudents() throws SQLException {
        // 所有学生的ArrayList
        ArrayList<HashMap<String, String>> allStudentInfo = new ArrayList<HashMap<String, String>>();
        // 搜索students表里所有内容
        ResultSet allStudentSqlResult = this.sql.executeQuery("select * from students");
        while (allStudentSqlResult.next()) { // 如果当前语句不是最后一条则进入循环
            // 每一行的学生信息
            HashMap<String, String> oneOfAllStudent = new HashMap<String, String>();
            // 设置学生信息
            setOneStudentInfo(allStudentSqlResult, oneOfAllStudent);
            // 将每个学生的HashMap添加到总的ArrayList中
            allStudentInfo.add(oneOfAllStudent);
            // 打印日志
            new Log().pLog(Log.OPERATION, "查询数据库:" + oneOfAllStudent.toString());
        }
        // 返回ArrayList
        return allStudentInfo;
    }

    private void setOneStudentInfo(ResultSet studentSql, HashMap<String, String> StudentInfo) throws SQLException {
        StudentInfo.put("ID", studentSql.getString("ID"));
        StudentInfo.put("name", studentSql.getString("name"));
        StudentInfo.put("sex", studentSql.getString("sex"));
        StudentInfo.put("IDNumber", studentSql.getString("IDNumber"));
        StudentInfo.put("grade", studentSql.getString("grade"));
        StudentInfo.put("class", studentSql.getString("class"));
    }


}