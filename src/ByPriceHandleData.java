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
        String min = minPrice.getText();//�õ�����
        String max = maxPrice.getText();
        query.setDatabaseName("a");
        query.setSQL("select * from ҩ where �۸� between '" + min + "' and '" + max + "'");
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
