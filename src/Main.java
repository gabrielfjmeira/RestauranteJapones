import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        //Cria arraylist de cardápio
        ArrayList<Prato> cardapio = new ArrayList<>();
        cardapio.add(new Sushi(1, "Combo sushi de salmão", "8 unidades de sushi de salmão", 23.00f, 300.00f, 50.00f));
        cardapio.add(new Sushi(2, "Combo sushi de carangueijo", "8 unidades de sushi de carangueijo", 18.00f, 323.00f, 27.00f));
        cardapio.add(new Uramaki(3, "Combo uramaki philadelphia", "8 unidades de uramaki philadelphia", 28.00f,250.00f, 50.00f, 50.00f));
        cardapio.add(new Uramaki(4, "Combo hot philadelphia", "8 unidades de uramaki hot philadelphia", 35.00f, 220.00f, 60.00f, 70.00f));
        cardapio.add(new Sashimi(5, "Combo sashimi", "8 unidades de sashimi", 40.00f, 140.00f));
        cardapio.add(new Sushi(6, "barca de sushi", "10 unidades de sushi de salmão + 10 unidades de sushi de carangueijo", 70.00f, 600.00f, 100.00f));

        //Inicializa arraylist de pedido do usuário
        ArrayList<Integer> pedido = new ArrayList<>();

        //Inicializa menu
        while (true){
            System.out.println("----- RESTAURANTE JAPONÊS ----");
            System.out.println();
            System.out.println("1 - Fazer Pedido");
            System.out.println("2 - Sair");
            System.out.println();

            try{
                System.out.println("Selecione uma Opção:");
                int opcaoSelecionada = scannerNumber();

                //verifica a opção do usuário
                switch(opcaoSelecionada) {
                    case 1:
                        //Solicita o nome do cliente
                        System.out.println("Insira seu nome:");
                        String nomeCliente = scannerTxt();

                        //imprime os pratos dos cardápios
                        for (Prato p : cardapio) {
                            System.out.println();
                            System.out.println("----- Cardápio -----");
                            System.out.println("Código: " + p.getCodigo());
                            System.out.println("Nome: " + p.getNome());
                            System.out.println("Descrição: " + p.getDescricao());
                            if (p instanceof Sushi){
                                System.out.printf("Gramas de Arroz: %.2fg\n", ((Sushi) p).getGramasArroz());
                                System.out.printf("Gramas de Carne: %.2fg\n", ((Sushi) p).getGramasCarne());
                            } else if (p instanceof Uramaki) {
                                System.out.printf("Gramas de Arroz: %.2fg\n", ((Uramaki) p).getGramasArroz());
                                System.out.printf("Gramas de Carne: %.2fg\n", ((Uramaki) p).getGramasCarne());
                                System.out.printf("Gramas de Philadelphia: %.2fg", ((Uramaki) p).getGramasPhiladelphia());
                            }else if (p instanceof Sashimi) {
                                System.out.printf("Gramas de Carne: %.2fg\n", ((Sashimi) p).getGramasCarne());
                            }
                            System.out.printf("Valor: R$%.2f\n", p.getValor());

                            System.out.println();
                        }

                        //Fica lendo os pedidos do usuário
                        while (true){

                            //Variável de Controle
                            boolean pratoAdicionado = false;

                            try{
                                //Pede para o usuário inserir o código do prato que deseja
                                System.out.println("Selecione um código de prato para adicionar no pedido - 0 para cancelar:");
                                int pratoAdd = scannerNumber();

                                if (pratoAdd != 0){
                                    for (Prato p2 : cardapio){
                                        if (p2.getCodigo() == pratoAdd){
                                            pedido.add(pratoAdd);
                                            pratoAdicionado = true;
                                        }
                                    }

                                    if (pratoAdicionado == false){
                                        System.out.println("Prato inexistente");
                                    }
                                }else{
                                    break;
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Escolha uma opção Válida");
                            }
                        }

                        //Exibe nota fiscal
                        System.out.println();
                        if (pedido.size() > 0){
                            System.out.println("Nota Fiscal(" + nomeCliente +")");
                            float total = 0;
                            while (true){
                                for (Integer i : pedido) {
                                    for (Prato p3 : cardapio){
                                        if (p3.getCodigo() == i){
                                            System.out.printf("Prato: " + p3.getCodigo() + " - Nome: " + p3.getNome() + " - Valor: R$%.2f\n", p3.getValor());
                                            total += p3.getValor();
                                        }
                                    }

                                }
                                //Imprime valor total sem taxa de serviço
                                System.out.printf("Valor sem taxa de serviço: R$%.2f", total);
                                float vt = 0;

                                while(true) {
                                    //Solicita a gorgeta do serviço
                                    System.out.println();
                                    System.out.println("Taxa de Serviço:");
                                    System.out.println("1 - 10%");
                                    System.out.println("2 - Valor Personalizado");
                                    System.out.println();
                                    try {
                                        System.out.println("Selecione um código de gorgeta:");
                                        int codGorgeja = scannerNumber();

                                        if(codGorgeja == 2){
                                            try {
                                                System.out.println("Insira seu valor personalizado:");
                                                float valorGorgeta = scannerFloat();
                                                if (valorGorgeta > 10){
                                                    float valorTotal = total + ((total * valorGorgeta)/100);
                                                    System.out.printf("Valor Taxa: R$%.2f\n", (total * valorGorgeta)/100);
                                                    System.out.printf("Valor Total: R$%.2f\n", valorTotal);
                                                    vt = valorTotal;
                                                    break;
                                                }else{
                                                    System.out.println("Insira um valor acima de 10% para a taxa");
                                                }
                                            }catch (InputMismatchException e){
                                                System.out.println("Insira um valor válido para taxa de serviço");
                                            }

                                        }else{
                                            float valorTotal = total * 1.10f;
                                            System.out.printf("Valor Taxa: R$%.2f\n", (total * 10)/100);
                                            System.out.printf("Valor Total: R$%.2f\n", valorTotal);
                                            vt = valorTotal;
                                            break;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Insira um valor válido para taxa de serviço");
                                    }
                                }

                                //Imprime o troco
                                while(true){
                                    try{
                                        System.out.println();
                                        System.out.println("Insira o valor recebido:");
                                        float valorPago = scannerFloat();
                                        if((valorPago - vt) > 0){
                                            System.out.printf("Troco: R$%.2f\n", (valorPago - vt));
                                            break;
                                        }else if ((valorPago - vt) < 0){
                                            System.out.printf("Valor não pago deve ser superior ou igual a R$%.2f", vt);
                                        }else{
                                            System.out.println("Sem troco necessário!");
                                            break;
                                        }
                                    }catch (InputMismatchException e){
                                        System.out.println("Insira um valor válido!");
                                    }
                                }
                                break;
                            }

                        }else{
                            System.out.println("Sem pedidos realizados!");
                        }

                        System.out.println("Tecle enter para continuar...");
                        String continuar = scannerNextLine();

                        menu();
                    case 2:
                        break;
                }

                break;
            }catch(InputMismatchException e){
                System.out.println("Escolha uma opção Válida");
            }
        }
    }

    public static int scannerNumber(){
        Scanner input = new Scanner(System.in);
        int resultadoInput = input.nextInt();
        return resultadoInput;
    }

    public static String scannerTxt(){
        Scanner input = new Scanner(System.in);
        String resultadoInput = input.nextLine();
        return resultadoInput;
    }

    public static float scannerFloat(){
        Scanner input = new Scanner(System.in);
        float resultadoInput = input.nextFloat();
        return resultadoInput;
    }

    public static void scannerNextLine(){
        Scanner input = new Scanner(System.in);
        String resultadoInput = input.nextLine();
    }
}
