package src.GerenciaArquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorArquivos {

        public static void leArquivo(String arquivo){
                File arq = new File(arquivo);

                if(!arq.exists()){
                        System.out.println("arquivo passado não encontrado\n");
                        return;
                }

                try(BufferedReader bf = new BufferedReader(new FileReader(arquivo))){
                        String linha;

                        while((linha = bf.readLine()) != null){
                                System.out.println(linha);
                        }

                } catch (IOException e){
                        System.out.println("erro ao ler o arquivo: " + e.getMessage());
                        System.out.println();
                }
        }

        public static void criaArquivo(String arquivo){
                File arq = new File(arquivo);

                if(arq.exists()){
                        System.out.println("arquivo já existe\n");
                        return;
                }

                try{
                        if(arq.createNewFile()){
                                System.out.println("arquivo criado\n");
                        }

                } catch (IOException e){
                        System.out.println("erro ao criar o arquivo: " + e.getMessage());
                }
        }


}
