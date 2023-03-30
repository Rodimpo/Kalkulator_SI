import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator implements ActionListener {
    private JFrame frame;
    private JPanel paneliox,main;

    private Wyswietlacz display;
    private Klawiatura keyboard;

    private Jednostka jednostka;
    private Czas czas1, czas2;
    private Dlugosc dlugosc1, dlugosc2;
    private Masa masa1, masa2;
    private Temperatura temperatura1, temperatura2;

    private String przedrostek1, przedrostek2;
    private double x;


    public Calculator()
    {
        frame = new JFrame("Dobry żart, chrupek wart");
        frame.setSize(600,300);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        jednostka = new Jednostka();
        jednostka.setBagno(this);

        dlugosc1 = new Dlugosc();
        dlugosc1.setBagno(this);
        dlugosc1.frame.setVisible(false);

        masa1 = new Masa();
        masa1.setBagno(this);
        masa1.frame.setVisible(false);

        czas1 = new Czas();
        czas1.setBagno(this);
        czas1.frame.setVisible(false);

        temperatura1 = new Temperatura();
        temperatura1.setBagno(this);
        temperatura1.frame.setVisible(false);

        dlugosc2 = new Dlugosc();
        dlugosc2.setBagno(this);
        dlugosc2.frame.setVisible(false);

        masa2 = new Masa();
        masa2.setBagno(this);
        masa2.frame.setVisible(false);

        czas2 = new Czas();
        czas2.setBagno(this);
        czas2.frame.setVisible(false);

        temperatura2 = new Temperatura();
        temperatura2.setBagno(this);
        temperatura2.frame.setVisible(false);

        //frame.setResizable(false);


        display = new Wyswietlacz();
        //display.frame.setBounds(1,20,500,100);
        display.frame.setVisible(true);

        keyboard = new Klawiatura();
        //keyboard.frame.setBounds(50,250,250,300);
        keyboard.frame.setVisible(true);
        keyboard.setBagno(this);

        main = new JPanel(new FlowLayout());
        main.add(keyboard.frame);
        main.add(jednostka.frame);

        paneliox = new JPanel(new FlowLayout());

        frame.add(display.frame,BorderLayout.NORTH);
        frame.add(main,BorderLayout.CENTER);
        paneliox.add(dlugosc1.frame);
        paneliox.add(masa1.frame);
        paneliox.add(czas1.frame);
        paneliox.add(temperatura1.frame);
        paneliox.add(dlugosc2.frame);
        paneliox.add(masa2.frame);
        paneliox.add(czas2.frame);
        paneliox.add(temperatura2.frame);
        frame.add(paneliox, BorderLayout.SOUTH);
        frame.setVisible(true);


        przedrostek1 = "";
        przedrostek2 = "";

    }

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource() == keyboard.numberButtons[i])
            {
                display.setLiczba(keyboard.getValue());
            }
        }
        if(e.getSource() == keyboard.dot)
        {
            display.setLiczba(keyboard.getValue());
        }
        if(e.getSource() == keyboard.backspace)
        {
            display.setLiczba(keyboard.getValue());
        }
        if(e.getSource() == jednostka.heheButton)
        {
            addComponent(jednostka.getWartosc());
        }

        if(e.getSource() == dlugosc1.heheButton)
        {
            display.setPrzedrostek(dlugosc1.getWartosc());
            przedrostek1 = display.getPrzedrostek();
        }
        if(e.getSource() == dlugosc2.heheButton)
        {
            display.setPrzedrostek(dlugosc2.getWartosc());
            przedrostek2 = display.getPrzedrostek();
            obliczProszeDlugosc();
        }

        if(e.getSource() == masa1.heheButton)
        {
            display.setPrzedrostek(masa1.getWartosc());
            przedrostek1 = display.getPrzedrostek();
        }
        if(e.getSource() == masa2.heheButton)
        {
            display.setPrzedrostek(masa2.getWartosc());
            przedrostek2 = display.getPrzedrostek();
            obliczProszeMase();
        }

        if(e.getSource() == czas1.heheButton)
        {
            display.setPrzedrostek(czas1.getWartosc());
            przedrostek1 = display.getPrzedrostek();
        }
        if(e.getSource() == czas2.heheButton)
        {
            display.setPrzedrostek(czas2.getWartosc());
            przedrostek2 = display.getPrzedrostek();
            obliczProszeCzas();
        }

        if(e.getSource() == temperatura1.heheButton)
        {
            display.setPrzedrostek(temperatura1.getWartosc());
            przedrostek1 = display.getPrzedrostek();
        }
        if(e.getSource() == temperatura2.heheButton)
        {
            display.setPrzedrostek(temperatura2.getWartosc());
            przedrostek2 = display.getPrzedrostek();
            obliczProszeTemperature();
        }
    }
    public void addComponent(String ebe)
    {
        if(ebe.equals("m"))
        {
            dlugosc1.frame.setVisible(true);
            masa1.frame.setVisible(false);
            czas1.frame.setVisible(false);
            temperatura1.frame.setVisible(false);

            dlugosc2.frame.setVisible(true);
            masa2.frame.setVisible(false);
            czas2.frame.setVisible(false);
            temperatura2.frame.setVisible(false);

        }
        if(ebe.equals("kg"))
        {
            dlugosc1.frame.setVisible(false);
            masa1.frame.setVisible(true);
            czas1.frame.setVisible(false);
            temperatura1.frame.setVisible(false);

            dlugosc2.frame.setVisible(false);
            masa2.frame.setVisible(true);
            czas2.frame.setVisible(false);
            temperatura2.frame.setVisible(false);
        }
        if(ebe == "s")
        {
            dlugosc1.frame.setVisible(false);
            masa1.frame.setVisible(false);
            czas1.frame.setVisible(true);
            temperatura1.frame.setVisible(false);

            dlugosc2.frame.setVisible(false);
            masa2.frame.setVisible(false);
            czas2.frame.setVisible(true);
            temperatura2.frame.setVisible(false);
        }
        if(ebe.equals("K"))
        {
            dlugosc1.frame.setVisible(false);
            masa1.frame.setVisible(false);
            czas1.frame.setVisible(false);
            temperatura1.frame.setVisible(true);

            dlugosc2.frame.setVisible(false);
            masa2.frame.setVisible(false);
            czas2.frame.setVisible(false);
            temperatura2.frame.setVisible(true);
        }
        display.setJednostka(" "+ebe+" ");
    }

    public void obliczProszeDlugosc()
    {
        if(przedrostek1.equals("mm"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x/1000;
            if(przedrostek2.equals("mm"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("cm"))
            {
                x = x*100;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dm"))
            {
                x = x*10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("cm"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x/100;
            if(przedrostek2.equals("mm"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("cm"))
            {
                x = x*100;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dm"))
            {
                x = x*10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("dm"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x/10;
            if(przedrostek2.equals("mm"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("cm"))
            {
                x = x*100;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dm"))
            {
                x = x*10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("m"))
        {
            x = Double.parseDouble(display.getLiczba());
            if(przedrostek2.equals("mm"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("cm"))
            {
                x = x*100;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dm"))
            {
                x = x*10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("km"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x/1000;
            if(przedrostek2.equals("mm"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("cm"))
            {
                x = x*100;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dm"))
            {
                x = x*10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
        }
    }

    public void obliczProszeMase()
    {
        if(przedrostek1.equals("mg"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x/1000;
            if(przedrostek2.equals("mg"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("g"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dag"))
            {
                x = x/10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("kg"))
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("t"))
            {
                x = x/1000000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("g"))
        {
            x = Double.parseDouble(display.getLiczba());
            if(przedrostek2.equals("mg"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("g"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dag"))
            {
                x = x/10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("kg"))
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("t"))
            {
                x = x/1000000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("dag"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x*10;
            if(przedrostek2.equals("mg"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("g"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("dag"))
            {
                x = x/10;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("kg"))
            {
                x = x/1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("t"))
            {
                x = x/1000000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("kg"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x / 1000;
            if (przedrostek2.equals("mg")) {
                x = x * 1000;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("g")) {
                x = x;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("dag")) {
                x = x / 10;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("kg")) {
                x = x / 1000;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("t")) {
                x = x / 1000000;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("t"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x / 1000000;
            if (przedrostek2.equals("mg")) {
                x = x * 1000;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("g")) {
                x = x;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("dag")) {
                x = x / 10;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("kg")) {
                x = x / 1000;
                display.setLiczba(String.valueOf(x));
            } else if (przedrostek2.equals("t")) {
                x = x / 1000000;
                display.setLiczba(String.valueOf(x));
            }
        }
    }

    public void obliczProszeCzas()
    {
        if(przedrostek1.equals("ms"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x/1000;
            if(przedrostek2.equals("ms"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("s"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x/60;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("h"))
            {
                x = x/3600;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("s"))
        {
            x = Double.parseDouble(display.getLiczba());
            if(przedrostek2.equals("ms"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("s"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x/60;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("h"))
            {
                x = x/3600;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("m"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x*60;
            if(przedrostek2.equals("ms"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("s"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x/60;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("h"))
            {
                x = x/3600;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("h"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x*3600;
            if(przedrostek2.equals("ms"))
            {
                x = x*1000;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("s"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("m"))
            {
                x = x/60;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("h"))
            {
                x = x/3600;
                display.setLiczba(String.valueOf(x));
            }
        }
    }

    public void obliczProszeTemperature()
    {
        if(przedrostek1.equals("K"))
        {
            x = Double.parseDouble(display.getLiczba());
            if(przedrostek2.equals("F"))
            {
                x = x*1.8 - 459.67;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("K"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("C"))
            {
                x = x - 273.15;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("F"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = (x + 459.67) * (5/9);
            if(przedrostek2.equals("F"))
            {
                x = x*1.8 - 459.67;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("K"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("C"))
            {
                x = x - 273.15;
                display.setLiczba(String.valueOf(x));
            }
        }
        if(przedrostek1.equals("C"))
        {
            x = Double.parseDouble(display.getLiczba());
            x = x + 273.15 ;
            if(przedrostek2.equals("F"))
            {
                x = x*1.8 - 459.67;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("K"))
            {
                x = x;
                display.setLiczba(String.valueOf(x));
            }
            else if(przedrostek2.equals("C"))
            {
                x = x - 273.15;
                display.setLiczba(String.valueOf(x));
            }
        }
    }
}