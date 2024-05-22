import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);

        int controladora = 0;

        while (controladora != 8) {
            System.out.println("""
                    ****************** Conversor de Moedas ******************
                                        
                    1 - Dólar(USD) => Peso Argentino(ARS)
                    2 - Peso Argentino(ARS) => Dólar(USD)
                    3 - Dólar(USD) => Real(BRL)
                    4 - Real(BRL) => Dólar(USD)
                    5 - Dólar(USD) => Peso Colombiano(COP)
                    6 - Peso Colombiano(COP) => Dólar(USD)
                    7 - Personalizado
                    8 - Sair
                                        
                    Escolha uma opção para converter:
                    """);

            controladora = leitura.nextInt();
            double valor;

            Conversor converter = new Conversor();
            Dados novoDado[] = new Dados[7];

            switch (controladora) {
                case 1:
                    System.out.println("""
                            **************** Dólar para Peso Argentino **************
                            Digite a quantidade em Dólar que você deseja converter
                            para Peso Argentino:
                            """);

                    valor = leitura.nextDouble();
                    novoDado[0] = converter.converterMoeda("USD", "ARS", valor);
                    String resultadoFormatado1 = String.format("%.2f", novoDado[0].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[0].base_code() + " equivale a " + resultadoFormatado1 + " " + novoDado[0].target_code());

                    break;

                case 2:
                    System.out.println("""
                            **************** Peso Argentino para Dólar **************
                            Digite a quantidade em Peso Argentino que você deseja
                            converter para Dólar:
                            """);

                    valor = leitura.nextDouble();
                    novoDado[1] = converter.converterMoeda("ARS", "USD", valor);
                    String resultadoFormatado2 = String.format("%.2f", novoDado[1].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[1].base_code() + " equivale a " + resultadoFormatado2 + " " + novoDado[1].target_code());
                    break;

                case 3:
                    System.out.println("""
                            ********************* Dólar para Real *******************
                            Digite a quantidade em Dólar que você deseja converter
                            para Real:
                            """);

                    valor = leitura.nextDouble();
                    novoDado[2] = converter.converterMoeda("USD", "BRL", valor);
                    String resultadoFormatado3 = String.format("%.2f", novoDado[2].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[2].base_code() + " equivale a " + resultadoFormatado3 + " " + novoDado[2].target_code());

                    break;

                case 4:
                    System.out.println("""
                            ********************* Real para Dólar *******************
                            Digite a quantidade em Real que você deseja converter
                            para Dólar:
                            """);

                    valor = leitura.nextDouble();
                    novoDado[3] = converter.converterMoeda("BRL", "USD", valor);
                    String resultadoFormatado4 = String.format("%.2f", novoDado[3].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[3].base_code() + " equivale a " + resultadoFormatado4 + " " + novoDado[3].target_code());
                    break;

                case 5:
                    System.out.println("""
                            *************** Dólar para Peso Colombiano **************
                            Digite a quantidade em Dólar que você deseja
                            converter para Peso Colombiano:
                            """);

                    valor = leitura.nextDouble();
                    novoDado[4] = converter.converterMoeda("USD", "COP", valor);
                    String resultadoFormatado5 = String.format("%.2f", novoDado[4].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[4].base_code() + " equivale a " + resultadoFormatado5 + " " + novoDado[4].target_code());
                    break;

                case 6:
                    System.out.println("""
                            *************** Peso Colombiano para Dólar **************
                            Digite a quantidade em Peso Colombiano que você deseja
                            converter para Dólar:
                            """);

                    valor = leitura.nextDouble();
                    novoDado[5] = converter.converterMoeda("COP", "USD", valor);
                    String resultadoFormatado6 = String.format("%.2f", novoDado[5].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[5].base_code() + " equivale a " + resultadoFormatado6 + " " + novoDado[5].target_code());
                    break;

                case 7:
                    System.out.println("""
                            ********************** Personalizado ********************
                            Obs: Só serão aceitos nomes no padrão internacional 
                            abreviado(BRL, ARS, USD, COP, LYD, SSP, VES)
                            
                            Digite  a moeda para a qual você quer converter:
                            """);
                    String moedaRef = leitura.next().toUpperCase();

                    System.out.println("Digite a moeda convertida");
                    String moedaConver = leitura.next().toUpperCase();

                    System.out.println("Você escolheu converter de " + moedaRef + " para " + moedaConver + ". Digite o valor que deseja converter: ");
                    valor = leitura.nextDouble();

                    novoDado[6] = converter.converterMoeda(moedaRef, moedaConver, valor);
                    String resultadoFormatado7 = String.format("%.2f", novoDado[6].conversion_result());
                    System.out.println("************************ Resultado **********************");
                    System.out.println(valor + " " + novoDado[6].base_code() + " equivale a " + resultadoFormatado7 + " " + novoDado[6].target_code());
                    break;

                case 8:
                    System.out.println("""
                            *********************************************************
                            *********************** Você saiu! **********************
                            *********************************************************
                            """);
                    break;
                default:
                    System.out.println("""
                            *********************************************************
                            ********************* Opção Invalida ********************
                            *********************************************************
                            """);
                    break;
            }
        }
    }
}
