import javax.swing.*;

public class ByName extends JPanel {
    JTextField inputName;
    JButton button;
    ByNameHandleData handle;

    ByName() {
        inputName = new JTextField(12);
        button = new JButton("确定");
        add(new JLabel("输入药品名:"));
        add(inputName);
        add(button);
        handle = new ByNameHandleData();  //负责按姓名去处理数据的处理者
        handle.setJTextField(inputName);
        button.addActionListener(handle);
    }
}
