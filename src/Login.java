import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JFrame {
    Login() {
        super("��¼");
        setBounds(100, 100, 220, 150);
        setLayout(new FlowLayout());
        JLabel a = new JLabel("�˺�");
        JLabel b = new JLabel("����");
        JTextField e = new JTextField(15);
        JTextField f = new JTextField(15);
        JButton g = new JButton("��¼");
        JButton h = new JButton("ע��");

        add(a);
        add(e);
        add(b);
        add(f);
        add(g);
        add(h);
        g.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent bt) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "a" + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8", "root", "123");
                    String SQL = "SELECT * FROM user";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(SQL);
                    boolean flag = true;
                    while (rs.next()) {
                        if (e.getText().equals(rs.getString(1)) && f.getText().equals(rs.getString(2))) {
                            new TWindow();
                            flag = false;
                        }
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "��¼ʧ��", "��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
                    }
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "" + e, "��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        h.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent bt) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "a" + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8", "root", "123");
                    String SQL = "INSERT INTO user VALUES(?,?)";
                    PreparedStatement sql = con.prepareStatement(SQL);
                    sql.setString(1, e.getText());
                    sql.setString(2, f.getText());
                    sql.executeUpdate();
                    con.close();
                    JOptionPane.showMessageDialog(null, "ע��ɹ�", "��Ϣ�Ի���", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException exp) {
                    JOptionPane.showMessageDialog(null, "" + exp, "��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }
}