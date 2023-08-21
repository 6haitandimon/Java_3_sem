package bsu.rfct.course2.group6.boreyko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

    enum radioButtonsType{
        MEMORY,
        FORMULA
    }

    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;

    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    
    private Double[] memCell = new Double[3];

    private JTextField textFieldResult;
    private JLabel labelForMemory = new JLabel("0.0", 10);

    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons2 = new ButtonGroup();
    

    private int formulaId = 1;
    private int memoryId = 0;

    public Double calculate1(Double x, Double y, Double z) {
        return Math.sin(Math.log(y) + Math.sin(Math.PI * Math.pow(y, 2))) * Math.pow(Math.pow(x, 2) + Math.sin(z) + Math.exp(Math.cos(z)), 0.25);
    }
//Double a = Math.sin(Math.log(y) + Math.sin(Math.PI*Math.pow(y, 2))) * Math.pow(Math.pow(x, 2) + Math.sin(z) + Math.exp(Math.cos(z)), 0.25);
    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(Math.pow(Math.cos(Math.E), x) + Math.pow(Math.log(1 + y), 2) + Math.sqrt(Math.exp(Math.cos(x)) + Math.pow(Math.signum(Math.PI * z), 2)) + Math.sqrt(1 / x) + Math.cos(y * y), Math.sin(z));
    }

    private JRadioButton addRadioButton(String buttonName, final int Id, radioButtonsType Type) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if(Type == radioButtonsType.FORMULA)
                    MainFrame.this.formulaId = Id;
                else if(Type == radioButtonsType.MEMORY){
                    MainFrame.this.memoryId = Id;
                    labelForMemory.setText(Double.toString(memCell[Id]));
                }

                
            }
        });

        if(Type == radioButtonsType.FORMULA)
            radioButtons.add(button);
        else if(Type == radioButtonsType.MEMORY)
            radioButtons2.add(button);
        
        return button;
    }

    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        
        for(int i = 0; i < 3; i++)
            memCell[i] = 0.0;

        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране 
        setLocation((kit.getScreenSize().width - WIDTH)/2,
        (kit.getScreenSize().height - HEIGHT)/2);
        Box hboxFormulaType = Box.createHorizontalBox();
        hboxFormulaType.add(Box.createHorizontalGlue()); 
        
        hboxFormulaType.add(addRadioButton("Формула 1", 1, radioButtonsType.FORMULA)); 
        hboxFormulaType.add(addRadioButton("Формула 2", 2, radioButtonsType.FORMULA)); 
        radioButtons.setSelected(
        radioButtons.getElements().nextElement().getModel(), true); 
        hboxFormulaType.add(Box.createHorizontalGlue()); 
        hboxFormulaType.setBorder(
        BorderFactory.createLineBorder(Color.YELLOW));
        // Создать область с полями ввода для X и Y
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10); 
        textFieldX.setMaximumSize(textFieldX.getPreferredSize()); 
        
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10); 
        textFieldY.setMaximumSize(textFieldY.getPreferredSize()); 
        
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10); 
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        
        Box hboxVariables = Box.createHorizontalBox(); 
        hboxVariables.setBorder(
        
        BorderFactory.createLineBorder(Color.RED)); 
        hboxVariables.add(Box.createHorizontalGlue()); 
        hboxVariables.add(labelForX); 
        hboxVariables.add(Box.createHorizontalStrut(10)); 
        hboxVariables.add(textFieldX); 
        hboxVariables.add(Box.createHorizontalStrut(100)); 
        hboxVariables.add(labelForY); 
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY); 
        hboxVariables.add(Box.createHorizontalStrut(100)); 
        hboxVariables.add(labelForZ); 
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ); 
        hboxVariables.add(Box.createHorizontalGlue());
                    
        //Память
        Box hBoxMem = Box.createVerticalBox();
        hBoxMem.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

        Box hBoxMemRadioButton = Box.createHorizontalBox();
        hBoxMemRadioButton.add(Box.createHorizontalGlue());

        hBoxMemRadioButton.add(addRadioButton("Ячейка 1", 0, radioButtonsType.MEMORY)); 
        hBoxMemRadioButton.add(addRadioButton("Ячейка 2", 1, radioButtonsType.MEMORY)); 
        hBoxMemRadioButton.add(addRadioButton("Ячейка 3", 2, radioButtonsType.MEMORY));
        
        hBoxMemRadioButton.add(Box.createHorizontalGlue());
        
        radioButtons2.setSelected(
        radioButtons2.getElements().nextElement().getModel(), true); 
       

        Box hBoxMemButton = Box.createHorizontalBox();

        JButton buttonMemClear = new JButton("MC"); 
        buttonMemClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) { 
                memCell[memoryId] = 0.0;
                labelForMemory.setText("0.0");
            } 
        });

        JButton buttonMemAdd = new JButton("M+"); 
        buttonMemAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) { 
                memCell[memoryId] += Double.parseDouble(textFieldResult.getText());
                labelForMemory.setText(Double.toString(memCell[memoryId]));
            } 
        });

        hBoxMemButton.add(Box.createHorizontalGlue());
        hBoxMemButton.add(buttonMemClear);
        hBoxMemButton.add(buttonMemAdd);
        hBoxMemButton.add(labelForMemory);
        hBoxMemButton.add(Box.createHorizontalGlue());


        hBoxMem.add(hBoxMemRadioButton);
        hBoxMem.add(hBoxMemButton);
        
        

        // Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:"); 
        //labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10); 
        textFieldResult.setMaximumSize(
        textFieldResult.getPreferredSize());

        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue()); 
        hboxResult.add(labelForResult); 
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());

        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
        // Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить"); 
        buttonCalc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) { 
            try {
                Double x = Double.parseDouble(textFieldX.getText()); 
                Double y = Double.parseDouble(textFieldY.getText()); 
                Double z = Double.parseDouble(textFieldZ.getText()); 
                Double result;
                if (formulaId == 1)
                    result = calculate1(x, y, z);
                else
                    result = calculate2(x, y, z);
                if(Double.isNaN(result))
                    throw(new ArithmeticException()); 
                textFieldResult.setText(result.toString());
            } catch (NumberFormatException ex) { 
                JOptionPane.showMessageDialog(MainFrame.this,"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(MainFrame.this,"Нарушена область определения", "Ошибка области определения", JOptionPane.WARNING_MESSAGE);
            }
        }
    });
    JButton buttonReset = new JButton("Очистить поля"); 
    buttonReset.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) { 
            textFieldX.setText("0"); 
            textFieldY.setText("0");
            textFieldZ.setText("0");
            textFieldResult.setText("0");
        } 
    });
        Box hboxButtons = Box.createHorizontalBox(); 
        hboxButtons.add(Box.createHorizontalGlue()); 
        hboxButtons.add(buttonCalc); 
        hboxButtons.add(Box.createHorizontalStrut(30)); 
        hboxButtons.add(buttonReset); 
        hboxButtons.add(Box.createHorizontalGlue()); 
        hboxButtons.setBorder(
        BorderFactory.createLineBorder(Color.GREEN));
        // Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox(); contentBox.add(Box.createVerticalGlue()); 
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hBoxMem);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons); 
        contentBox.add(Box.createVerticalGlue()); 
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
}
