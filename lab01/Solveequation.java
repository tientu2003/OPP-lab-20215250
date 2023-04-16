import javax.swing.JOptionPane;
import java.lang.Math;

public class Solveequation{
    public static void main (String[] args){
        int i;
        String n;
        do{ 
            //Choose the function
            n = JOptionPane.showInputDialog(null, 
    "1.First-degree equation with one variable\n2.The system of first-degree with two variables\n3.The second-degree equation with one variable\n4.exit","Please choose function:"
                ,JOptionPane.INFORMATION_MESSAGE);
            i  = Integer.parseInt(n);
            

            if (i == 1){ // ax + b = 0
                String n1,n2;
                n1 = JOptionPane.showInputDialog(null,"a = ","Input ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(n1); // input a
                
                while (a == 0){  // check a != 0
                n1 = JOptionPane.showInputDialog(null,
                "please re-input a = ","Error: a = 0",
                JOptionPane.INFORMATION_MESSAGE);
                a = Double.parseDouble(n1);
                }

                n2 = JOptionPane.showInputDialog(null,"b = ","Input ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(n2); // input b

                JOptionPane.showMessageDialog(null,"x = " + -b/a, // solution
                "The solution:", JOptionPane.INFORMATION_MESSAGE);

            }else if (i == 2){
                String[] C = {"a11","a12","b1","a21","a22","b2"};
                String A[] = new String[6];
                double B[] = new double[6];
                int j = 0;

                while(j < 3){ // input a11*x1 + a12*x2 = b1
                A[j] = JOptionPane.showInputDialog(null, C[j] + " = ","Input a11*x1 + a12*x2 = b1",JOptionPane.INFORMATION_MESSAGE);
                B[j] = Double.parseDouble(A[j]);
                j++;
                }

                 while(j  < 6){ // input a21*x1 + a22*x2 = b2
                A[j] = JOptionPane.showInputDialog(null, C[j] + " = ","Input a21*x1 + a22*x2 = b2",JOptionPane.INFORMATION_MESSAGE);
                B[j] = Double.parseDouble(A[j]);
                j++;
                }

                double D[] = new double[3];
                
                D[0] = B[0]*B[4] - B[3]*B[1];
                D[1] = B[2]*B[4] - B[5]*B[1];
                D[2] = B[0]*B[5] - B[3]*B[2];

                if(D[0] != 0)
                {
                    JOptionPane.showMessageDialog(null,"x1 = " + D[1]/D[0] + "\nx2 = " + D[2]/D[0], //  has solution
                "The system equation has solution:", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    if (D[1] == 0 && D[2] == 0) JOptionPane.showMessageDialog(null, // infinite solutions
                    "System equation has infiniely many solutions", "Result",
                    JOptionPane.INFORMATION_MESSAGE);               
                    
                    else JOptionPane.showMessageDialog(null,    // no solution
                    "System equation has no solution", "Result",
                    JOptionPane.INFORMATION_MESSAGE);               
                }

            }else if (i == 3){
                String n1,n2,n3;
                
                n1 = JOptionPane.showInputDialog(null,"a = ", 
                "Input ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(n1);
                
                while (a == 0){  // check a != 0
                n1 = JOptionPane.showInputDialog(null,
                "please re-input a = ","Error: a = 0",
                JOptionPane.INFORMATION_MESSAGE);
                a = Double.parseDouble(n1);
                }

                n2 = JOptionPane.showInputDialog(null,"b = ", 
                "Input ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(n2);
                
                n3 = JOptionPane.showInputDialog(null,"c = ", 
                "Input ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
                double c = Double.parseDouble(n3);

                double delta = b*b - 4*a*c;

                if (delta > 0)
                {   double x1 = (-b + Math.sqrt(delta))/(2*a);
                    double x2 = (-b - Math.sqrt(delta))/(2*a);

                    JOptionPane.showMessageDialog(null, "The equation has two solutions:\nx1 = " + x1 +
                    "\nx2 = " + x2,"The solution",JOptionPane.INFORMATION_MESSAGE);

                }else if (delta == 0)
                {   
                    JOptionPane.showMessageDialog(null, "The equation has one solutions:\nx = " + -b/(2*a)
                    ,"The solution",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "The equation has no solutions\n" 
                    ,"The solution",JOptionPane.INFORMATION_MESSAGE);
                }
            }else if (i == 4){
                break;
            }
        
        }while(i != 4);
    }
}
