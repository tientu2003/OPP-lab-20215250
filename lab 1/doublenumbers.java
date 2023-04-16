// Exercise 2.2.5
import javax.swing.JOptionPane;

public class Doublenumbers {
    public static void main (String[] args) {
        String strn1, strn2;
        
        strn1 = JOptionPane.showInputDialog(null, 
                "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double n1 = Double.parseDouble(strn1);
        
        strn2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double n2 = Double.parseDouble(strn2);
        System.out.printf(" The first number: %.2f\n The second number: %.2f\n",n1,n2);
        double sum = n1 + n2;
        System.out.printf(" The sum: %.2f\n",sum);

        double dif = n1 - n2;
        System.out.printf(" The difference: %.2f\n",dif);
        double pro = n1*n2;
        System.out.printf(" The product: %.2f\n",pro);
        if (n2 == 0)
        {
            System.out.println(" The divisor equal 0. please check again\n");
        }else 
        {
            double quo = n1/n2;
            System.out.printf(" The quotient: %.2f\n",quo);
        }
    System.exit(0);
    }

}