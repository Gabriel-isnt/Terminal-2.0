package src.GerenciaArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

                        return;
                }

                return;
        }

        public static boolean criaArquivo(String arquivo){

                File arq = new File(arquivo);

                if(arq.exists()){
                        System.out.println("arquivo já existe\n");
                        return true;
                }

                try{
                        if(arq.createNewFile()){
                                System.out.println("arquivo criado\n");
                        }

                } catch (IOException e){
                        System.out.println("erro ao criar o arquivo: " + e.getMessage());
                        return false;
                }

                return true;
        }

        public static boolean escreveArquivo(String arquivo, String texto, String addFim){

                // validando o arquivo
                if(arquivo == null || arquivo.isEmpty()){
                        System.out.println("nenhum arquivo passado\n");
                        return false;
                }

                File arq = new File(arquivo);

                if(!arq.exists()){

                        if(!criaArquivo(arquivo)){
                                return false;
                        }

                        arq = new File(arquivo);
                }

                // validando o addfim
                boolean append;

                if(addFim == null || addFim.isEmpty()){
                        append = false;

                } else append = !addFim.equals("false");  // genial isso aqui


                // trantando a função agora

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(arq, append))){

                        if(append){
                                bw.write("\n");
                        }

                        bw.write(texto);

                } catch (IOException e){
                        System.out.println("não foi possível escrever no arquivo: " + e.getMessage());
                        return false;
                }

                return true;
        }


}
