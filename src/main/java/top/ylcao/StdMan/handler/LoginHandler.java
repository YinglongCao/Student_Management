package top.ylcao.StdMan.handler;

import top.ylcao.StdMan.sql.OperationMysql;
import top.ylcao.StdMan.view.AdminPanelInter;
import top.ylcao.StdMan.view.AllStudentsTable;
import top.ylcao.StdMan.view.LoginInter;
import top.ylcao.StdMan.main.Log;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginHandler extends KeyAdapter implements ActionListener {

    private final LoginInter loginInter;
    private OperationMysql operationMysql;
    private Log log;
    private AdminPanelInter adminPanelInter;

    public LoginHandler(LoginInter loginInter, OperationMysql operationMysql) {
        this.loginInter = loginInter;
        this.operationMysql = operationMysql;
        this.log = new Log();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 强转JButton源
        JButton sourceButton = (JButton) e.getSource();
        String buttonText = sourceButton.getText();

        if (buttonText.equals("清空")) {
            // 清除两个文本框内容
            loginInter.getAccountText().setText("");
            loginInter.getPasswordText().setText("");
        } else if (buttonText.equals("登陆")) {
            try {
                loginMethod();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void loginMethod() throws SQLException {
        String username = loginInter.getAccountText().getText();
        String password = new String(loginInter.getPasswordText().getPassword());

        this.log.pLog(Log.OPERATION, "登陆:" + username + ", " + password);
        boolean isSuccessLogin = this.operationMysql.loginSystem(username, password);
        if (isSuccessLogin) {
            // 打印登录成功日志
            this.log.pLog(Log.OPERATION, "登录成功");
            // 弹出提示框
            JOptionPane.showMessageDialog(loginInter, "登陆成功!");
            // 隐藏菜单
            this.loginInter.setVisible(false);
            // 进入管理面板
            this.adminPanelInter = new AdminPanelInter(operationMysql);
            // 显示所有学生表界面
            // this.allStudentsTable = new AllStudentsTable(allStudentInfo);
        } else {
            JOptionPane.showMessageDialog(loginInter, "登陆失败...");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            try {
                loginMethod();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
