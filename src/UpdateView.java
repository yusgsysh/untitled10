import javax.swing.*;
import java.awt.*;

public class UpdateView extends JPanel {
    JTextField inputID;
    JTable table;
    String[] head = {"ҩƷ����", "�ɷ�", "��Ӧ֢", "�÷�����", "������Ӧ", "����", "ע������", "�۸�"};
    String[][] a = {{" ", " ", " ", " ", " ", " ", " ", " "}};
    JButton buttonLook, buttonUpdate;
    UpdateHandleData handle;

    UpdateView() {
        setLayout(null);
        inputID = new JTextField(10);
        table = new JTable(a, head);
        table.setRowHeight(80);
        table.setFont(new Font("����", Font.BOLD, 16));
        buttonLook = new JButton("�鿴��¼");
        buttonUpdate = new JButton("���¼�¼");
        JLabel tishiOne = new JLabel("����Ҫ���µĺ�:");
        add(tishiOne);
        add(inputID);
        add(buttonLook);
        JLabel tishiTwo = new JLabel("�����µ�ֵ:");
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
        handle = new UpdateHandleData();  //���ݵĴ�����
        handle.setArray(a);
        handle.setJTextField(inputID);
        handle.setJButton(buttonLook, buttonUpdate);
        buttonLook.addActionListener(handle);
        buttonUpdate.addActionListener(handle);
        handle.update(table);
    }
}
