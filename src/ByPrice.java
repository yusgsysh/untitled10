import javax.swing.*;

public class ByPrice extends JPanel {
    JTextField price1;
    JTextField price2;
    JButton button;
    ByPriceHandleData handle;

    ByPrice() {
        price1 = new JTextField(5);
        price2 = new JTextField(5);
        button = new JButton("ȷ��");
        add(new JLabel("����۸�����:"));
        add(price1);
        add(new JLabel("��"));
        add(price2);
        add(button);
        handle = new ByPriceHandleData();
        handle.setJTextField(price1, price2);
        button.addActionListener(handle);
    }
}
