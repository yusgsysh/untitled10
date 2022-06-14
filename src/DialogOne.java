import javax.swing.*;

public class DialogOne extends JDialog {
    JTable table;
    String[] ziduan;
    String[][] record;

    DialogOne() {
        setTitle("ÏÔÊ¾¼ÇÂ¼");
        setBounds(100, 200, 1200, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setZiduan(String[] ziduan) {
        this.ziduan = ziduan;
    }

    public void setRecord(String[][] record) {
        this.record = record;
    }

    public void init() {
        table = new JTable(record, ziduan);
        add(new JScrollPane(table));
    }
}
