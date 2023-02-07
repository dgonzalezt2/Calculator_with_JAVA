public class NoTerminal extends Arbol 
{
        //atributos
        private Operador oper;
        private Arbol izq;
        private Arbol der;

        //metodos
        public NoTerminal (Operador oper, Arbol izq, Arbol der){
                this.oper = oper;
                this.izq = izq;
                this.der = der;
        }

        public Arbol getIzq(){
                return this.izq;
        }
        
        public Arbol getDer(){
                return this.der;
        }

        public Operador getOper(){
                return this.oper;
        }
}