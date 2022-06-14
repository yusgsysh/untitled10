import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JFrame {
    Login() {
        super("登录");
        setBounds(100, 100, 220, 150);
        setLayout(new FlowLayout());
        JLabel a = new JLabel("账号");
        JLabel b = new JLabel("密码");
        JTextField e = new JTextField(15);
        JTextField f = new JTextField(15);
        JButton g = new JButton("登录");
        JButton h = new JButton("注册");
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
                        JOptionPane.showMessageDialog(null, "登录失败", "消息对话框", JOptionPane.WARNING_MESSAGE);
                    }
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "" + e, "消息对话框", JOptionPane.WARNING_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "注册成功", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException exp) {
                    JOptionPane.showMessageDialog(null, "" + exp, "消息对话框", JOptionPane.WARNING_MESSAGE);
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