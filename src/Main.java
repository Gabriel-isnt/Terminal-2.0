package src;

import java.util.Scanner;
import java.util.concurrent.TransferQueue;

import src.GerenciadorComandos.Gerenciador;
import src.Comandos.Windows;
import src.Comandos.Terminal;

public class Main {
        public static void main(String[] args){

                // inicializações
                Scanner sc = new Scanner(System.in);

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


                                case "pwd":
                                        tm.pwd();
                                        break;
                                case "ls":
                                        tm.ls();
                                        break;

                                default:
                                        System.out.println("comando não reconhecido\n");
                        }

                } while(true);


        }

}
