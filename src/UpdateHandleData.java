import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateHandleData implements ActionListener {
    JTextField inputID;
    JButton buttonLook, buttonUpdate;
    String[][] a;
    Query query;
    String id;
    JTable table;
    String[][] record;
    int m;

    UpdateHandleData() {
        query = new Query();
    }

    public void setArray(String[][] a) {
        this.a = a;
    }

    public void setJTextField(JTextField... text) {
        inputID = text[0];
    }

    public void setJButton(JButton... b) {
        buttonLook = b[0];
        buttonUpdate = b[1];
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonUpdate) {
            id = inputID.getText().trim();
            doGengxin();
        } else if (e.getSource() == buttonLook) {
            id = inputID.getText().trim();
            doLookRecord();
            table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());
            table.setValueAt(record[0][1], 0, 0);
            table.setValueAt(record[0][2], 0, 1);
            table.setValueAt(record[0][3], 0, 2);
            table.setValueAt(record[0][4], 0, 3);
            table.setValueAt(record[0][5], 0, 4);
            table.setValueAt(record[0][6], 0, 5);
            table.setValueAt(record[0][7], 0, 6);
            table.setValueAt(record[0][8], 0, 7);
        }
    }

    private void doGengxin() {
        Connection con;
        PreparedStatement sql;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "a" + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8", "root", "123");
            String SQL = "update ҩ set ҩƷ����=? ,�ɷ�=?,��Ӧ֢=?,�÷�����=?,������Ӧ=?,����=?,ע������=?,�۸�=? where ���='" + id + "'";
            sql = con.prepareStatement(SQL);
            for (int i = 0; i < 8; i++) {
                sql.setString(i + 1, a[0][i].trim());
            }
            m = sql.executeUpdate();
            JOptionPane.showMessageDialog
                    (null, "���³ɹ�", "��Ϣ�Ի���", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e, "��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void doLookRecord() {
        query.setDatabaseName("a");
        query.setSQL("SELECT * FROM ҩ where ���='" + id + "'");
        query.startQuery();
        record = query.getRecord();
    }

    public void update(JTable table) {
        this.table = table;
    }
}
