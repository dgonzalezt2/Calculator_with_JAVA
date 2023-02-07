public class Analizador 
{
    public static int evaluar(Arbol expr){
        int resp=0;

        if (expr == null){
            resp = 0;
        } else if (expr instanceof Terminal)
        {
            Terminal unNum = (Terminal) expr;
            resp = unNum.getValor(); 
        } else 
        {  //es un NoTerminal
            NoTerminal unOper = (NoTerminal) expr;

            switch (unOper.getOper()){
                case SUMA:
                resp = evaluar(unOper.getIzq()) +
                evaluar(unOper.getDer());
                break;
                case RESTA:
                resp = evaluar(unOper.getIzq()) -
                evaluar(unOper.getDer());
                break;
                case MULT:
                resp = evaluar(unOper.getIzq()) *
                evaluar(unOper.getDer());
                break;
                case DIV:
                resp = evaluar(unOper.getIzq()) /
                evaluar(unOper.getDer());
                break;
                
            }
        }
        return resp;
    }

    public static StringBuffer mostrar(Arbol expr)
    {
        StringBuffer sb = new StringBuffer();
        if (expr == null)
        {
            sb.append("no hay expresion");
        } else if (expr instanceof Terminal)
        {
            Terminal unNum = (Terminal)expr;
            sb.append(unNum.getValor());
        } else {  //es no terminal
            NoTerminal unOper = (NoTerminal)expr;
            sb.append('(')
            .append(mostrar(unOper.getIzq()))
            .append(unOper.getOper())
            .append(mostrar(unOper.getDer()))
            .append(')');
        }
        return sb;
    }

    public static void mostrarEvalucion(Arbol expr){
        System.out.println(mostrar(expr) +  " = " + evaluar(expr));
    }

}