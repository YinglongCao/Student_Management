package top.ylcao.StdMan.view;


import top.ylcao.StdMan.handler.LoginHandler;
import top.ylcao.StdMan.sql.OperationMysql;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoginInter extends JFrame {

    SpringLayout springLayout = new SpringLayout();
    JPanel loginPanel = new JPanel(springLayout);

    JLabel title = new JLabel("学生管理系统", JLabel.CENTER);
    JLabel subTitle = new JLabel("by 20计科曹应龙");
    JLabel accountLabel = new JLabel("账号");
    JTextField accountText = new JTextField();
    JLabel passwordLabel = new JLabel("密码");
    JPasswordField passwordText = new JPasswordField();
    JButton resetButton = new JButton("清空");
    JButton loginButton = new JButton("登陆");

    LoginHandler loginHandler;


    public LoginInter(OperationMysql operationMysql){
        super("学生管理系统");
        loginHandler = new LoginHandler(this, operationMysql);

        Container contentPane = getContentPane();
        // 布局
        loginLayout();
        // 添加组件
        loginPanel.add(subTitle);
        loginPanel.add(accountLabel);
        loginPanel.add(accountText);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordText);

        // 绑定事件监听器
        resetButton.addActionListener(loginHandler);
        loginPanel.add(resetButton);

        // 监听
        loginButton.addKeyListener(loginHandler);
        loginButton.addActionListener(loginHandler);
        // 设置login按钮为默认按钮
        getRootPane().setDefaultButton(loginButton);
        loginPanel.add(loginButton);

        contentPane.add(title, BorderLayout.NORTH);
        contentPane.add(loginPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void loginLayout() {

        title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        subTitle.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        Font MSYaHei = new Font("微软雅黑", Font.PLAIN, 15);
        accountLabel.setFont(MSYaHei);
        accountText.setPreferredSize(new Dimension(200, 30));
        accountText.setFont(MSYaHei);
        passwordLabel.setFont(MSYaHei);
        passwordText.setPreferredSize(new Dimension(200, 30));
        passwordText.setFont(MSYaHei);
        loginButton.setFont(MSYaHei);


        // 设置小标题在大标题下面，也就是loginPanel最上面，并水平居中
        springLayout.putConstraint(SpringLayout.NORTH, subTitle, 0, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, subTitle, -(Spring.width(subTitle).getValue() / 2), SpringLayout.HORIZONTAL_CENTER, loginPanel);

        // 设置账号标签到指定位置
        springLayout.putConstraint(SpringLayout.NORTH, accountLabel, 40, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, accountLabel, -(Spring.sum(Spring.sum(Spring.width(accountLabel), Spring.width(accountText)), Spring.constant(20)).getValue() / 2), SpringLayout.HORIZONTAL_CENTER, loginPanel);
        // 设置账号文本框
        springLayout.putConstraint(SpringLayout.WEST, accountText, 20, SpringLayout.EAST, accountLabel);
        springLayout.putConstraint(SpringLayout.BASELINE, accountText, 0, SpringLayout.BASELINE, accountLabel);


        // 设置密码标签框
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 25, SpringLayout.SOUTH, accountLabel);
        springLayout.putConstraint(SpringLayout.EAST, passwordLabel, 0, SpringLayout.EAST, accountLabel);
        // 设置密码文本框
        springLayout.putConstraint(SpringLayout.BASELINE, passwordText, 0, SpringLayout.BASELINE, passwordLabel);
        springLayout.putConstraint(SpringLayout.WEST, passwordText, 0, SpringLayout.WEST, accountText);


        // 设置关于按钮
        springLayout.putConstraint(SpringLayout.NORTH, resetButton, 20, SpringLayout.SOUTH, passwordLabel);
        springLayout.putConstraint(SpringLayout.BASELINE, loginButton, 0, SpringLayout.BASELINE, resetButton);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, 40, SpringLayout.EAST, resetButton);
        springLayout.putConstraint(SpringLayout.WEST, resetButton, -(Spring.sum(Spring.sum(Spring.width(resetButton), Spring.width(loginButton)), Spring.constant(40)).getValue() / 2), SpringLayout.HORIZONTAL_CENTER, loginPanel);



        // 如果是MacOS则设置Dock栏图标
//        if (System.getProperty("os.name").startsWith("Mac OS")) {
//            Application.getApplication().setDockIconImage(new ImageIcon(Objects.requireNonNull(LoginInter.class.getClassLoader().getResource("dockIcon.png"))).getImage());
//        }
        // 自定义图标
        setIconImage(new ImageIcon(Objects.requireNonNull(LoginInter.class.getClassLoader().getResource("icon.png"))).getImage());
        // 设置尺寸
        setSize(380, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

    }



    public JTextField getAccountText() {
        return accountText;
    }

    public JPasswordField getPasswordText() {
        return passwordText;
    }
}
