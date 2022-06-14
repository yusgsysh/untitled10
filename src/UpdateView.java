import javax.swing.*;
import java.awt.*;

public class UpdateView extends JPanel {
    JTextField inputID;
    JTable table;
    String[] head = {"药品名称", "成分", "适应症", "用法用量", "不良反应", "禁忌", "注意事项", "价格"};
    String[][] a = {{" ", " ", " ", " ", " ", " ", " ", " "}};
    JButton buttonLook, buttonUpdate;
    UpdateHandleData handle;

    UpdateView() {
        setLayout(null);
        inputID = new JTextField(10);
        table = new JTable(a, head);
        table.setRowHeight(80);
        table.setFont(new Font("宋体", Font.BOLD, 16));
        buttonLook = new JButton("查看记录");
        buttonUpdate = new JButton("更新记录");
        JLabel tishiOne = new JLabel("输入要更新的号:");
        add(tishiOne);
        add(inputID);
        add(buttonLook);
        JLabel tishiTwo = new JLabel("输入新的值:");
        add(tishiTwo);
        JScrollPane js = new JScrollPane(table);
        add(js);
        add(buttonUpdate);
        tishiOne.setBounds(10, 10, 160, 30);
        inputID.setBounds(172, 10, 100, 30);
        buttonLook.setBounds(275, 10, 150, 30);
        tishiTwo.setBounds(10, 60, 200, 50);
        js.setBounds(10, 110, 800, 150);
        buttonUpdate.setBounds(10, 270, 100, 40);
        handle = new UpdateHandleData();  //数据的处理者
        handle.setArray(a);
        handle.setJTextField(inputID);
        handle.setJButton(buttonLook, buttonUpdate);
        buttonLook.addActionListener(handle);
        buttonUpdate.addActionListener(handle);
        handle.update(table);
    }
}
