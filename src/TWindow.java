import javax.swing.*;
import java.awt.*;

public class TWindow extends JFrame {
    JTabbedPane p;
    ByName byName;
    ByBirth byBirth;
    ByPrice byPrice;
    InsertView insertView;
    UpdateView updateView;

    public TWindow() {
        super("ҩƷ��Ϣ����ϵͳ");
        setBounds(100, 100, 1000, 400);
        setVisible(true);
        p = new JTabbedPane();
        byName = new ByName();
        byBirth = new ByBirth();
        byPrice = new ByPrice();
        insertView = new InsertView();
        updateView = new UpdateView();
        p.add("��ҩƷ������ѯ", byName);
        p.add("����Ӧ֢��ѯ", byBirth);
        p.add("���۸��ѯ", byPrice);
        p.add("��������", insertView);
        p.add("��������", updateView);
        p.validate();
        add(p, BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
