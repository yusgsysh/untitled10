import javax.swing.*;

public class ByBirth extends JPanel {
    JTextField inputYear;
    JButton button;
    ByBirthHandleData handle;

    ByBirth() {
        inputYear = new JTextField(10);
        button = new JButton("ȷ��");
        add(new JLabel("������Ӧ֢��"));
        add(inputYear);
        add(button);
        handle = new ByBirthHandleData();
        handle.setJTextField(inputYear);
        button.addActionListener(handle);
    }
}
