package top.ylcao.StdMan.view;

import top.ylcao.StdMan.sql.OperationMysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class AllStudentsTable extends JFrame {

    private Vector<String> studentTableHeader;
    private ArrayList<HashMap<String, String>> allStudentInfo;
    Vector<Vector<String>> allStudentVector;

    public AllStudentsTable(OperationMysql operationMysql) throws SQLException {
        super("学生管理系统 所有学生");
        this.allStudentInfo = operationMysql.getAllStudents();
        initAllStudentsTable();
    }

    private void initAllStudentsTable() {
        // 初始化学生表头
        this.studentTableHeader = new Vector<>();
        studentTableHeader.addElement("学号");
        studentTableHeader.addElement("姓名");
        studentTableHeader.addElement("性别");
        studentTableHeader.addElement("身份证号");
        studentTableHeader.addElement("年级");
        studentTableHeader.addElement("班级");

        // 初始化所有学生Vector
        this.allStudentVector = new Vector<Vector<String>>();
        String index = null;
        for (int r = 0; r < allStudentInfo.size(); r++) {
            allStudentVector.addElement(new Vector<String>());
            for (int c = 0; c < allStudentInfo.get(r).size(); c++) {
                switch (c) {
                    case 0:
                        index = "ID";
                        break;
                    case 1:
                        index = "name";
                        break;
                    case 2:
                        index = "sex";
                        break;
                    case 3:
                        index = "IDNumber";
                        break;
                    case 4:
                        index = "grade";
                        break;
                    case 5:
                        index = "class";
                        break;
                }
                allStudentVector.get(r).addElement(allStudentInfo.get(r).get(index));
            }
        }

        // 新建默认表模板
        DefaultTableModel tableModel = new DefaultTableModel();
        // 将所有学生Vector和表头Vector设置到表模版
        tableModel.setDataVector(allStudentVector, studentTableHeader);
        // JTable和table关联，只需要更新model
        JTable jTable = new JTable(tableModel);
        // 新建内容面板
        Container contentPane = getContentPane();
        // 创建滑动面板
        JScrollPane jScrollPane = new JScrollPane((jTable));
        // 获取表头
        JTableHeader tableHeader = jTable.getTableHeader();
        // 设置表头字体
        tableHeader.setFont(new Font(null, Font.BOLD, 16));
        // 设置多行选择
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // 添加滑动面板到内容面板
        contentPane.add(jScrollPane);

        // 设置是否显示网格
        jTable.setShowGrid(true);
        // 水平方向网格线是否显示
        jTable.setShowHorizontalLines(true);
        // 竖直方向网格线是否显示
        jTable.setShowVerticalLines(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }


}
