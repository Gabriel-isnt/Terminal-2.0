package src.Comandos;

import java.io.File;
import java.io.BufferedReader;
import java.io.Reader;

public class Windows extends Terminal{

        @Override
        public void exibicao(){
                System.out.print(System.getProperty("user.dir") + "> ");
        }

        @Override
        public void pwd() {
                System.out.println(Windows.dirAtual);
                System.out.println();
        }

        @Override
        public void cd(){

        }

        @Override
        public void ls(){

                File diretorio = new File(System.getProperty("user.dir"));
                File[] arquivos = diretorio.listFiles();

                if(arquivos == null){
                        System.out.println("diretório vazio");
                        return;
                }

                for(File a : arquivos){
                        if(a.isDirectory()){
                                System.out.println("<DIR> " + a.getName());
                        } else {
                                System.out.printf("\t  %s\n", a.getName());
                        }

                }

                System.out.println();
        }

        @Override
        public void cat(String arquivo){

        }

}
