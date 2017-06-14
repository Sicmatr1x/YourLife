package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private GridPane gridPane;

    /**
     * 输入出生日期
     */
    @FXML
    private TextField bornTextField;
    /**
     * 输入今天日期
     */
    @FXML
    private TextField todayTextField;
    /**
     * 输入高亮显示时间段1的开始日期
     */
    @FXML
    private TextField begTextField1;
    /**
     * 输入高亮显示时间段1的结束日期
     */
    @FXML
    private TextField endTextField1;
    /**
     * 输入高亮显示时间段2的开始日期
     */
    @FXML
    private TextField begTextField2;
    /**
     * 输入高亮显示时间段2的结束日期
     */
    @FXML
    private TextField endTextField2;
    /**
     * 输入高亮显示时间段3的开始日期
     */
    @FXML
    private TextField begTextField3;
    /**
     * 输入高亮显示时间段3的结束日期
     */
    @FXML
    private TextField endTextField3;
    /**
     * 输入高亮显示时间段4的开始日期
     */
    @FXML
    private TextField begTextField4;
    /**
     * 输入高亮显示时间段4的结束日期
     */
    @FXML
    private TextField endTextField4;
    /**
     * 输入高亮显示时间段5的开始日期
     */
    @FXML
    private TextField begTextField5;
    /**
     * 输入高亮显示时间段5的结束日期
     */
    @FXML
    private TextField endTextField5;



    /**
     * 按钮矩阵
     */
    private List<Button> btList = new ArrayList<>();
    /**
     * 已经活了多少个月
     */
    private int mounthNum = 0;

    private int i;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 初始化按钮矩阵
        for(i = 0; i < 900; i++){
            // 使每个按钮宽度一样
            String btTest = "";
            if(i+1 < 10){
                btTest += "00" + (i+1);
            }else if(i+1 < 100){
                btTest += "0" + (i+1);
            }else{
                btTest += (i+1);
            }
            Button t = new Button(btTest);
//            t.setStyle("-fx-background-insets: 0;");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c1 = Calendar.getInstance();
                c1.setTime(sdf.parse(this.bornTextField.getText()));
                int begYear = c1.get(Calendar.YEAR);
                int begMounth = c1.get(Calendar.MONTH) + 1;
                begMounth += i % 12;
                if(begMounth > 12){
                    begYear++;
                    begMounth %= 12;
                }
                begYear += i / 12;
                MenuItem mi = new MenuItem(begYear + "-" + begMounth);
                ContextMenu cm = new ContextMenu(mi);
                t.setContextMenu(cm);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            t.setOnAction(e -> {
                System.out.println("setOnAction:" + i);
            });

            this.btList.add(t);
            this.gridPane.add(t, i%30, i/30 + 1);
        }
        System.out.println("this.btList=" + this.btList.size());
    }

    /**
     * 计算已经活了多少个月并给相应的按钮上色
     */
    @FXML
    private void startCompute(){
        try {
            // 计算活了多少个月
            mounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.todayTextField.getText());
            System.out.println("mounthNum=" + mounthNum);
            // 为已活的月上色
            for(int i = 0; i < mounthNum; i++){
                this.btList.get(i).setStyle("-fx-background-color: #32CD32;-fx-text-fill: #FFFFFF");
                // 若为生日月
                if(i % 12 == 0){
                    this.btList.get(i).setStyle("-fx-background-color: #B22222;-fx-text-fill: #FFFFFF");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 给制定的时间段上色
     */
    @FXML
    private void drawHightLight1(){
        if(this.mounthNum == 0){ // 若没有计算已活月份数
            return;
        }
        try {
            // 计算出生到时间段开始日期月份数
            int begMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.begTextField1.getText());
            int endMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.endTextField1.getText());
            System.out.println("(" + begMounthNum + "," + endMounthNum + ")");
            for(int i = begMounthNum; i < endMounthNum; i++){
                this.btList.get(i).setStyle("-fx-background-color: #3A5FCD;-fx-text-fill: #FFFFFF");
            }
            // TODO
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给制定的时间段上色
     */
    @FXML
    private void drawHightLight2(){
        if(this.mounthNum == 0){ // 若没有计算已活月份数
            return;
        }
        try {
            // 计算出生到时间段开始日期月份数
            int begMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.begTextField2.getText());
            int endMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.endTextField2.getText());
            System.out.println("(" + begMounthNum + "," + endMounthNum + ")");
            for(int i = begMounthNum; i < endMounthNum; i++){
                this.btList.get(i).setStyle("-fx-background-color: #912CEE;-fx-text-fill: #FFFFFF");
            }
            // TODO
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给制定的时间段上色
     */
    @FXML
    private void drawHightLight3(){
        if(this.mounthNum == 0){ // 若没有计算已活月份数
            return;
        }
        try {
            // 计算出生到时间段开始日期月份数
            int begMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.begTextField3.getText());
            int endMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.endTextField3.getText());
            System.out.println("(" + begMounthNum + "," + endMounthNum + ")");
            for(int i = begMounthNum; i < endMounthNum; i++){
                this.btList.get(i).setStyle("-fx-background-color: #FF7F24;-fx-text-fill: #FFFFFF");
            }
            // TODO
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给制定的时间段上色
     */
    @FXML
    private void drawHightLight4(){
        if(this.mounthNum == 0){ // 若没有计算已活月份数
            return;
        }
        try {
            // 计算出生到时间段开始日期月份数
            int begMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.begTextField4.getText());
            int endMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.endTextField4.getText());
            System.out.println("(" + begMounthNum + "," + endMounthNum + ")");
            for(int i = begMounthNum; i < endMounthNum; i++){
                this.btList.get(i).setStyle("-fx-background-color: #EEEE00;-fx-text-fill: #FFFFFF");
            }
            // TODO
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给制定的时间段上色
     */
    @FXML
    private void drawHightLight5(){
        if(this.mounthNum == 0){ // 若没有计算已活月份数
            return;
        }
        try {
            // 计算出生到时间段开始日期月份数
            int begMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.begTextField5.getText());
            int endMounthNum = Controller.getMonthSpace(this.bornTextField.getText(), this.endTextField5.getText());
            System.out.println("(" + begMounthNum + "," + endMounthNum + ")");
            for(int i = begMounthNum; i < endMounthNum; i++){
                this.btList.get(i).setStyle("-fx-background-color: #8B5A00;-fx-text-fill: #FFFFFF");
            }
            // TODO
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算2个日期之间相差月份数
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
//        result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);
        result = (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12 + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }
}
