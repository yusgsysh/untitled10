import javax.swing.*;
import java.awt.*;

public class InsertView extends JPanel {
    JTable table;
    String[] head = {"���", "ҩƷ����", "�ɷ�", "��Ӧ֢", "�÷�����", "������Ӧ", "����", "ע������", "�۸�"};
    String[][] a = {{" ", " ", " ", " ", " ", " ", " ", " ", " "}};
    JButton button;
    InsertHandleData handle;

    InsertView() {
        setLayout(null);
        table = new JTable(a, head);
        table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());
        table.setFont(new Font("����", Font.BOLD, 16));
        table.setRowHeight(195);
        button = new JButton("�����¼");
        JScrollPane js = new JScrollPane(table);
        add(js);
        add(button);
        js.setBounds(10, 10, 970, 220);
        button.setBounds(0, 240, 120, 30);
        handle = new InsertHandleData();  //���ݵĴ�����
        handle.setArray(a);
        button.addActionListener(handle);
        handle.update(table);
    }
}
