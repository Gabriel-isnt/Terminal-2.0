package src.GerenciadorComandos;

public class Gerenciador {

        public static String[] trataEntrada(String entrada){

                entrada = entrada.trim();

                String addFim = "false";

                if(entrada.isEmpty()){
                        return new String[]{null, null, null, addFim};
                }

                String comando = null;
                String texto   = null;
                String arquivo = null;


                // tratando sobre o comando
                int parte1 = entrada.indexOf((" "));

                if(parte1 == -1) {
                        return new String[]{entrada, null, null, addFim};
                }

                comando = entrada.substring(0, parte1);

                String textoArquivo = entrada.substring(parte1 + 1).trim();

                // tratando sobre o texto
                int parte2 = textoArquivo.indexOf(">");

                if(parte2 == -1){
                        texto = textoArquivo;
                        return new String[]{comando, texto, null, addFim};
                }

                // vendo se tem >> ou só >
                if(textoArquivo.charAt(parte2 + 1) == '>'){
                        addFim = "true";
                }

                // tratando sobre o arquivo
                texto = textoArquivo.substring(0, parte2).trim();

                arquivo = textoArquivo.substring(parte2 + 1).trim();

                return new String[]{comando, texto, arquivo, addFim};
        }


}
