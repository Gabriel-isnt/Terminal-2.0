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
                help.put("cat <Arquivo>", "mostra o conteúdo de dentro de um arquivo de texto");
                help.put("touch <Arquivo>", "cria um arquivo vazio para escrita");
                help.put("echo <texto> >/>> <arquivo>", "escreve/sobrescreve em um arquivo de escrita existente");

                Scanner sc  = new Scanner(System.in);
                Terminal tm = new Windows();

                String comandoPassado;
                String[] partesComando;

                String comando;
                String texto;
                String arquivo;
                String addFim;

                // código em sí
                do{
                        tm.exibicao();
                        comandoPassado = sc.nextLine();

                        partesComando = Gerenciador.trataEntrada(comandoPassado);

                        comando = partesComando[0];
                        texto   = partesComando[1];
                        arquivo = partesComando[2];
                        addFim  = partesComando[3];

                        if(comando == null || comando.isEmpty()){
                                System.out.println("comando não reconhecido\n");
                                continue;
                        }

                        if(comando.equals("exit")){
                                break;
                        }

                        switch(comando){
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
                                case "echo":
                                        tm.echo(arquivo, texto, addFim);
                                        break;
                               default:
                                        System.out.println("comando não reconhecido\n");
                        }

                } while(true);


        }

        public static void ajuda(){

                for(Map.Entry<String, String> entry : help.entrySet()){
                        System.out.printf("%-30s: %s\n", entry.getKey(), entry.getValue());
                }

                System.out.println();
        }

}
