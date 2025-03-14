package src;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

import src.GerenciadorComandos.Gerenciador;
import src.Comandos.Windows;
import src.Comandos.Terminal;

public class Main {

        private static final Map<String, String> help = new HashMap<>();

        public static void main(String[] args){

                // inicializações
                help.put("pwd", "Mostra o diretório atual que o usuário está");
                help.put("ls", "mostra diretórios e arquivos dentro do diretório atual do usuário");
                help.put("exit", "encerra o programa");
                help.put("cat", "mostra o conteúdo de dentro de um arquivo de texto");
                help.put("touch", "cria um arquivo vazio para escrita");

                Scanner sc  = new Scanner(System.in);
                Terminal tm = new Windows();

                String comandoPassado;
                String[] partesComando;

                // código em sí

                do{
                        tm.exibicao();
                        comandoPassado = sc.nextLine();

                        partesComando = Gerenciador.trataEntrada(comandoPassado);

                        if(partesComando[0].equals("exit")){
                                break;
                        }

                        switch(partesComando[0]){
                                case "help":
                                        ajuda();
                                        break;
                                case "pwd":
                                        tm.pwd();
                                        break;
                                case "ls":
                                        tm.ls();
                                        break;
                                case "cat":
                                        tm.cat(partesComando[1]);
                                        break;
                                case "touch":
                                        tm.touch(partesComando[1]);
                                        break;
                               default:
                                        System.out.println("comando não reconhecido\n");
                        }

                } while(true);


        }

        public static void ajuda(){
                for(Map.Entry<String, String> entry : help.entrySet()){
                        System.out.printf("%-10s: %s\n", entry.getKey(), entry.getValue());
                }

                System.out.println();
        }

}
