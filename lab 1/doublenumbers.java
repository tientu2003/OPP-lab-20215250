
import javax.swing.JOptionPane;

public class doublenumbers {
    public static void main (String[] args) {
        String strn1, strn2;
        
        strn1 = JOptionPane.showInputDialog(null, 
                "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double n1 = Double.parseDouble(strn1);
        
        strn2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double n2 = Double.parseDouble(strn2);
        System.out.println(" the first number: "+ n1 + 
        "\n the second number: " +n2);

        double sum = n1 + n2;
        System.out.println(" the sum: " + sum);

        double dif = n1 - n2;
        System.out.println(" the difference: " + dif);
        double pro = n1*n2;
        System.out.println(" the product: " + pro);
        if (n2 == 0)
        {
            System.out.println(" the divisor equal 0\n");
        }else 
        {
            double quo = n1/n2;
            System.out.println(" the quotient: " + quo);
        }
    System.exit(0);
    }

}