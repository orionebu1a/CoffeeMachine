package com.test.testTask.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class test implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final TextBox typeField = new TextBox();
        final TextBox gradeField = new TextBox();
        final TextBox cupField = new TextBox();
        final TextBox sugarField = new TextBox();
        final Button makeCoffeeButton = new Button("Make Coffee");

        RootPanel.get("makeCoffeeButtonContainer").add(makeCoffeeButton);
        RootPanel.get("typeFieldContainer").add(typeField);
        RootPanel.get("gradeFieldContainer").add(gradeField);
        RootPanel.get("cupFieldContainer").add(cupField);
        RootPanel.get("sugarFieldContainer").add(sugarField);

//        class makeHandler implements ClickHandler {
//            @Override
//            public void onClick(ClickEvent event) {
//                sendCoffeeRequestToServer();
//            }
//            private void sendCoffeeRequestToServer() {
//                coffeeService.makeCoffee(typeField.getText(),
//                        gradeField.getText(),
//                        cupField.getText(),
//                        Integer.parseInt(sugarField.getText())), new AsyncCallback<String>() {
//                            public void onFailure(Throwable caught) {
//
//                            }
//
//                            @Override
//                            public void onSuccess(String s) {
//
//                            }
//                        });
//            }
//        }
    }
}
