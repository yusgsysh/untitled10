import javax.swing.*;

public class ByName extends JPanel {
    JTextField inputName;
    JButton button;
    ByNameHandleData handle;

    ByName() {
        inputName = new JTextField(12);
        button = new JButton("ȷ��");
        add(new JLabel("����ҩƷ��:"));
        add(inputName);
        add(button);
        handle = new ByNameHandleData();  //��������ȥ�������ݵĴ�����
        handle.setJTextField(inputName);
        button.addActionListener(handle);
    }
}
