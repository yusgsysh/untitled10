import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ByPriceHandleData implements ActionListener {
    JTextField minPrice;
    JTextField maxPrice;
    Query query;

    ByPriceHandleData() {
        query = new Query();
    }

    public void setJTextField(JTextField... text) {
        minPrice = text[0];
        maxPrice = text[1];
    }

    public void actionPerformed(ActionEvent e) {
        String min = minPrice.getText();//得到姓名
        String max = maxPrice.getText();
        query.setDatabaseName("a");
        query.setSQL("select * from 药 where 价格 between '" + min + "' and '" + max + "'");
        query.startQuery();
        String[] ziduan = query.getColumnName();
        String[][] record = query.getRecord();
        DialogOne dialog = new DialogOne();
        dialog.setZiduan(ziduan);
        dialog.setRecord(record);
        dialog.init();
        dialog.setVisible(true);
    }
}
