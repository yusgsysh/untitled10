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
        super("药品信息管理系统");
        setBounds(100, 100, 1000, 400);
        setVisible(true);
        p = new JTabbedPane();
        byName = new ByName();
        byBirth = new ByBirth();
        byPrice = new ByPrice();
        insertView = new InsertView();
        updateView = new UpdateView();
        p.add("按药品名名查询", byName);
        p.add("按适应症查询", byBirth);
        p.add("按价格查询", byPrice);
        p.add("插入数据", insertView);
        p.add("更新数据", updateView);
        p.validate();
        add(p, BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
