package src.Comandos;

public abstract class Terminal {

        // atributos
        protected static String dirAtual = System.getProperty("user.dir");

        protected static String[] comandos = {"pwd", "ls", "cd", "cat", "touch", "mkdir", "rm", "exit", "rm"};

        // métodos
        public abstract void exibicao();
        public abstract void pwd();
        public abstract void cd();
        public abstract void ls();
        public abstract void cat(String arquivo);


}
