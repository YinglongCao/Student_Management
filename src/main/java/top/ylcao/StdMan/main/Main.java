package top.ylcao.StdMan.main;

import top.ylcao.StdMan.sql.OperationMysql;
import top.ylcao.StdMan.view.LoginInter;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        OperationMysql opMysql = new OperationMysql("127.0.0.1", 3306, "stdman", "root", "123456");

        LoginInter loginInter = new LoginInter(opMysql);




    }

}
