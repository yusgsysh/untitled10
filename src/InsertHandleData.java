import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHandleData implements ActionListener {
    String[][] a;
    Query query;
    JTable table;
    int m;

    InsertHandleData() {
        query = new Query();
    }

    public void setArray(String[][] a) {
        this.a = a;
    }

    public void actionPerformed(ActionEvent e) {
        Connection con;
        PreparedStatement sql;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "a" +
                    "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8", "root", "123");
            String SQL =
                    "INSERT INTO 药 VALUES(?,?,?,?,?,?,?,?,?)";
            sql = con.prepareStatement(SQL);
            sql.setString(1, a[0][0].trim());
            sql.setString(2, a[0][1].trim());
            sql.setString(3, a[0][2].trim());
            sql.setString(4, a[0][3].trim());
            sql.setString(5, a[0][4].trim());
            sql.setString(6, a[0][5].trim());
            sql.setString(7, a[0][6].trim());
            sql.setString(8, a[0][7].trim());
            sql.setString(9, a[0][8].trim());
            m = sql.executeUpdate();
            JOptionPane.showMessageDialog
                    (null, "插入信息成功", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < 9; i++) {
                table.setValueAt("", 0, i);
            }
            con.close();
        } catch (SQLException exp) {
            JOptionPane.showMessageDialog
                    (null, "" + exp, "消息对话框", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void update(JTable table) {
        this.table = table;
    }
}
