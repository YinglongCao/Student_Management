package top.ylcao.StdMan.view;

import top.ylcao.StdMan.handler.AdminPanelHandler;
import top.ylcao.StdMan.sql.OperationMysql;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;


public class AdminPanelInter extends JFrame {

    private OperationMysql operationMysql;

    SpringLayout springLayout = new SpringLayout();
    JPanel adminPanel = new JPanel(springLayout);

    // 标题===============================
    JLabel title = new JLabel("管理员面板", JLabel.CENTER);
    // 添加学生============================
    JLabel addStudentLabel = new JLabel("修改/添加学生");
    JTextField addStudentIDField = new JTextField("学号");
    JTextField addStudentNameField = new JTextField("姓名");
    JTextField addStudentSexField = new JTextField("性别");
    JTextField addStudentIDNumberField = new JTextField("身份证号");
    JTextField addStudentGradeField = new JTextField("年级");
    JTextField addStudentClassField = new JTextField("班级");
    JButton addConfirmButton = new JButton("添加");
    // 删除学生============================
    JLabel deleteStudentLabel = new JLabel("查询/删除学生");
    JTextField deleteStudentNameField = new JTextField("姓名");
    JButton deleteConfirmButton = new JButton("删除");
    JButton viewAllStudentTableButton = new JButton("查看所有学生");
    // ===================================
    JButton aboutButton = new JButton("关于");
    JButton editeButton = new JButton("修改");
    JButton searchButton = new JButton("查询");

    public AdminPanelInter(OperationMysql operationMysql) throws SQLException {
        super("学生管理系统 管理员面板");
        this.operationMysql = operationMysql;
        AdminPanelHandler adminPanelHandler = new AdminPanelHandler(this, operationMysql);

        Container contentPane = getContentPane();

        // 初始化布局
        initAdminPanelLayout();
        // 添加组件
        adminPanel.add(title);
        adminPanel.add(addStudentLabel);
        adminPanel.add(addStudentIDField);
        adminPanel.add(addStudentNameField);
        adminPanel.add(addStudentSexField);
        adminPanel.add(addStudentIDNumberField);
        adminPanel.add(addStudentGradeField);
        adminPanel.add(addStudentClassField);
        adminPanel.add(addConfirmButton);
        adminPanel.add(deleteStudentLabel);
        adminPanel.add(deleteStudentNameField);
        adminPanel.add(deleteConfirmButton);
        adminPanel.add(viewAllStudentTableButton);
        adminPanel.add(aboutButton);
        adminPanel.add(editeButton);
        adminPanel.add(searchButton);

        // 绑定事件监听器
        addConfirmButton.addActionListener(adminPanelHandler);
        deleteConfirmButton.addActionListener(adminPanelHandler);
        viewAllStudentTableButton.addActionListener(adminPanelHandler);
        aboutButton.addActionListener(adminPanelHandler);
        editeButton.addActionListener(adminPanelHandler);
        searchButton.addActionListener(adminPanelHandler);


        contentPane.add(adminPanel);
        setVisible(true);
    }



    private void initAdminPanelLayout() {

        // 标题
        title.setFont(new Font("微软雅黑", Font.PLAIN, 20));

        Font MSYaHei = new Font("微软雅黑", Font.PLAIN, 15);
        Dimension addAndDeleteFieldDimension = new Dimension(140, 20);

        // 添加学生标签
        addStudentLabel.setFont(MSYaHei);
        // 添加学生输入框
        addStudentIDField.setFont(MSYaHei);
        addStudentIDField.setPreferredSize(addAndDeleteFieldDimension);
        // 添加学生名字输入框
        addStudentNameField.setFont(MSYaHei);
        addStudentNameField.setPreferredSize(addAndDeleteFieldDimension);
        // 添加学生性别输入框
        addStudentSexField.setFont(MSYaHei);
        addStudentSexField.setPreferredSize(addAndDeleteFieldDimension);
        // 添加学生身份证号输入框
        addStudentIDNumberField.setFont(MSYaHei);
        addStudentIDNumberField.setPreferredSize(new Dimension(180, 20));
        // 添加学生年级输入框
        addStudentGradeField.setFont(MSYaHei);
        addStudentGradeField.setPreferredSize(addAndDeleteFieldDimension);
        // 添加学生班级输入框
        addStudentClassField.setFont(MSYaHei);
        addStudentClassField.setPreferredSize(addAndDeleteFieldDimension);
        // 添加学生确认按钮
        addConfirmButton.setFont(MSYaHei);

        // 删除学生标签
        deleteStudentLabel.setFont(MSYaHei);
        // 删除学生输入框
        deleteStudentNameField.setFont(MSYaHei);
        deleteStudentNameField.setPreferredSize(addAndDeleteFieldDimension);
        // 删除确认按钮
        deleteConfirmButton.setFont(MSYaHei);
        // 查看所有学生按钮
        viewAllStudentTableButton.setFont(MSYaHei);
        // 关于按钮
        aboutButton.setFont(MSYaHei);
        editeButton.setFont(MSYaHei);
        searchButton.setFont(MSYaHei);

        // 标题
        springLayout.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, adminPanel);
        springLayout.putConstraint(SpringLayout.WEST, title, 20, SpringLayout.WEST, adminPanel);
        // 添加学生标题
        springLayout.putConstraint(SpringLayout.WEST, addStudentLabel, 0, SpringLayout.WEST, title);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentLabel, 5, SpringLayout.SOUTH, title);
        // 添加学生ID输入框
        springLayout.putConstraint(SpringLayout.WEST, addStudentIDField, -5, SpringLayout.WEST, addStudentLabel);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentIDField, 5, SpringLayout.SOUTH, addStudentLabel);
        // 添加学生名字输入框
        springLayout.putConstraint(SpringLayout.WEST, addStudentNameField, 0, SpringLayout.WEST, addStudentIDField);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentNameField, 5, SpringLayout.SOUTH, addStudentIDField);
        // 添加学生性别输入框
        springLayout.putConstraint(SpringLayout.WEST, addStudentSexField, 0, SpringLayout.WEST, addStudentNameField);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentSexField, 5, SpringLayout.SOUTH, addStudentNameField);
        // 添加学生身份证号输入框
        springLayout.putConstraint(SpringLayout.WEST, addStudentIDNumberField, 0, SpringLayout.WEST, addStudentSexField);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentIDNumberField, 5, SpringLayout.SOUTH, addStudentSexField);
        // 添加学生年级输入框
        springLayout.putConstraint(SpringLayout.WEST, addStudentGradeField, 0, SpringLayout.WEST, addStudentIDNumberField);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentGradeField, 5, SpringLayout.SOUTH, addStudentIDNumberField);
        // 添加学生班级输入框
        springLayout.putConstraint(SpringLayout.WEST, addStudentClassField, 0, SpringLayout.WEST, addStudentGradeField);
        springLayout.putConstraint(SpringLayout.NORTH, addStudentClassField, 5, SpringLayout.SOUTH, addStudentGradeField);
        // 添加学生确认按钮
        springLayout.putConstraint(SpringLayout.EAST, addConfirmButton, 0, SpringLayout.EAST, addStudentClassField);
        springLayout.putConstraint(SpringLayout.NORTH, addConfirmButton, 5, SpringLayout.SOUTH, addStudentClassField);

        // 删除学生标签
        springLayout.putConstraint(SpringLayout.EAST, deleteStudentLabel, -(Spring.width(deleteStudentNameField).getValue() - Spring.width(deleteStudentLabel).getValue() + 5), SpringLayout.EAST, adminPanel);
        springLayout.putConstraint(SpringLayout.NORTH, deleteStudentLabel, 0, SpringLayout.NORTH, addStudentLabel);
        // 删除学生输入框
        springLayout.putConstraint(SpringLayout.WEST, deleteStudentNameField, -5, SpringLayout.WEST, deleteStudentLabel);
        springLayout.putConstraint(SpringLayout.NORTH, deleteStudentNameField, 5, SpringLayout.SOUTH, deleteStudentLabel);
        // 删除确认按钮
        springLayout.putConstraint(SpringLayout.EAST, deleteConfirmButton, 0, SpringLayout.EAST, deleteStudentNameField);
        springLayout.putConstraint(SpringLayout.NORTH, deleteConfirmButton, 5, SpringLayout.SOUTH, deleteStudentNameField);

        // 关于按钮
        springLayout.putConstraint(SpringLayout.WEST, aboutButton, -5, SpringLayout.WEST, deleteStudentLabel);
        springLayout.putConstraint(SpringLayout.SOUTH, aboutButton, 0, SpringLayout.SOUTH, addConfirmButton);
        // 查看学生界面按钮
        springLayout.putConstraint(SpringLayout.WEST, viewAllStudentTableButton, 0, SpringLayout.WEST, aboutButton);
        springLayout.putConstraint(SpringLayout.SOUTH, viewAllStudentTableButton, -5, SpringLayout.NORTH, aboutButton);

        springLayout.putConstraint(SpringLayout.WEST, editeButton, -1, SpringLayout.WEST, addStudentClassField);
        springLayout.putConstraint(SpringLayout.NORTH, editeButton, 5, SpringLayout.SOUTH, addStudentClassField);

        springLayout.putConstraint(SpringLayout.WEST, searchButton, -5, SpringLayout.WEST, deleteStudentNameField);
        springLayout.putConstraint(SpringLayout.NORTH, searchButton, 5, SpringLayout.SOUTH, deleteStudentNameField);


        // 自定义图标
        setIconImage(new ImageIcon(Objects.requireNonNull(LoginInter.class.getClassLoader().getResource("icon.png"))).getImage());
        // 设置尺寸
        setSize(340, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public JTextField getAddStudentIDField() {
        return addStudentIDField;
    }

    public JTextField getAddStudentNameField() {
        return addStudentNameField;
    }

    public JTextField getAddStudentSexField() {
        return addStudentSexField;
    }

    public JTextField getAddStudentIDNumberField() {
        return addStudentIDNumberField;
    }

    public JTextField getAddStudentGradeField() {
        return addStudentGradeField;
    }

    public JTextField getAddStudentClassField() {
        return addStudentClassField;
    }

    public JTextField getDeleteStudentNameField() {
        return deleteStudentNameField;
    }
}
