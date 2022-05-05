package top.ylcao.StdMan.swingLearning;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Vector;

public class JTableTest extends JFrame {


    public JTableTest() {
        super("测试JTable");


        Vector<String> columns = new Vector<>();
        columns.addElement("编号");
        columns.addElement("姓名");
        columns.addElement("学号");
        columns.addElement("成绩");

        Vector<Vector<Object>> data = new Vector<>();

        Vector<Object> rowVector1 = new Vector<>();
        rowVector1.addElement("1");
        rowVector1.addElement("张三");
        rowVector1.addElement("B20200101101");
        rowVector1.addElement("100");

        Vector<Object> rowVector2 = new Vector<>();
        rowVector2.addElement("2");
        rowVector2.addElement("李四");
        rowVector2.addElement("B20200101102");
        rowVector2.addElement("99");

        Vector<Object> rowVector3 = new Vector<>();
        rowVector3.addElement("3");
        rowVector3.addElement("王五");
        rowVector3.addElement("B20200101103");
        rowVector3.addElement("98");

        data.addElement(rowVector1);
        data.addElement(rowVector2);
        data.addElement(rowVector3);


        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setDataVector(data, columns);
        // JTable和table关联，只需要更新model
        JTable jTable = new JTable(tableModel);

        Container contentPane = getContentPane();
        JScrollPane jScrollPane = new JScrollPane((jTable));
        JTableHeader tableHeader = jTable.getTableHeader();
        tableHeader.setFont(new Font(null, Font.BOLD, 16));
        // 设置多行选择
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        contentPane.add(jScrollPane);


        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }


}
