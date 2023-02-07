import java.util.Scanner;

public class Calculadora 
{   
    int resul=0;
    public void scanner(String expression)
    {
        boolean status= true;
        String[] ary = expression.split(" ");
        int Token=0;
        for(int i=0;i<ary.length-1;i++)
        {
            if(isNumeric(ary[i]))
            {
                resul = Integer.parseInt(ary[i]);
            }
            else 
            {
                Token = tokendetc(ary[i]);
                if(Token==0)
                {
                    Arbol expr1 = new NoTerminal(Operador.SUMA,new Terminal(resul), new Terminal(Integer.parseInt(ary[i+1])));
                    resul = Analizador.evaluar(expr1);
                    i++;
                }
                else if(Token==1)
                {
                    Arbol expr1 = new NoTerminal(Operador.RESTA,new Terminal(resul), new Terminal(Integer.parseInt(ary[i+1])));
                    resul = Analizador.evaluar(expr1);
                    i++;
                }
                else if(Token==2)
                {
                    Arbol expr1 = new NoTerminal(Operador.MULT,new Terminal(resul), new Terminal(Integer.parseInt(ary[i+1])));
                    resul = Analizador.evaluar(expr1);
                    i++;
                }
                else if(Token==3)
                {
                    Arbol expr1 = new NoTerminal(Operador.DIV,new Terminal(resul), new Terminal(Integer.parseInt(ary[i+1])));
                    resul = Analizador.evaluar(expr1);
                    i++;
                }
                
                else
                {
                    System.out.println("Termino no implementado");
                    status = false;
                    break;
                }
            }
        }
        if(status)
        {
            System.out.println("\n El resultado de la expresion es -> "+resul);
        }
    }

    public int tokendetc(String token)
    {
        if(token.equalsIgnoreCase("+"))
        {
            return 0;
        }
        else if(token.equalsIgnoreCase("-"))
        {
            return 1;
        }
        else if(token.equalsIgnoreCase("*"))
        {
            return 2;
        }
        else if(token.equalsIgnoreCase("/"))
        {
            return 3;
        }
        else return 10;        
    }

    public static boolean isNumeric(String str) 
    { 
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
}