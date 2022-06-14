import javax.swing.*;
import java.awt.*;

public class InsertView extends JPanel {
    JTable table;
    String[] head = {"编号", "药品名称", "成分", "适应症", "用法用量", "不良反应", "禁忌", "注意事项", "价格"};
    String[][] a = {{" ", " ", " ", " ", " ", " ", " ", " ", " "}};
    JButton button;
    InsertHandleData handle;

    InsertView() {
        setLayout(null);
        table = new JTable(a, head);
        table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());
        table.setFont(new Font("宋体", Font.BOLD, 16));
        table.setRowHeight(195);
        button = new JButton("插入记录");
        JScrollPane js = new JScrollPane(table);
        add(js);
        add(button);
        js.setBounds(10, 10, 970, 220);
        button.setBounds(0, 240, 120, 30);
        handle = new InsertHandleData();  //数据的处理者
        handle.setArray(a);
        button.addActionListener(handle);
        handle.update(table);
    }
}
