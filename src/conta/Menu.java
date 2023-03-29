package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		System.out.println("\n Criar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Marina dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
			
		
		
		
		while (true) {
			
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND
					          +"----------------------------------------------");//texto será roxo e fundo preto
			System.out.println("                                              ");
			System.out.println("               Banco da Gen                   ");
			System.out.println("                                              ");
			System.out.println("----------------------------------------------");
			System.out.println("                                              ");
			System.out.println("         1- Criar Conta                       ");
			System.out.println("         2- Listar todas as contas            ");
			System.out.println("         3- Buscar Conta por Número           ");
			System.out.println("         4- Atualizar Dados da Conta          ");
			System.out.println("         5- Apagar Conta                      ");
			System.out.println("         6- Sacar                             ");
			System.out.println("         7- Depositar                         ");
			System.out.println("         8- Transferir valores entre Contas   ");
			System.out.println("         9- Sair                              ");
			System.out.println("                                              ");
			System.out.println("----------------------------------------------");
			System.out.println("Entre com a opção desejada                    ");
			System.out.println("                                              "+ Cores.TEXT_RESET);//Ao finalizar cores voltam ao normal
			
			try {
				opcao = leia.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("\n Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"\n Banco da Gen - O seu futuro começa aqui!!");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			
			case 1:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Criar Conta                                   \n\n");
				
				System.out.println("Digite o Número da Agência:                   ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular:                     ");
				leia.skip("\\R?"); //ignora a entrada q corresponde ao padrão especificado, ignorando os delimitadores(está ignorando a quebra de linha, para que o comando nextLine leia palavras compostas)
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP):        ");
					tipo = leia.nextInt();
					
				}while(tipo < 1 && tipo >2);
				
				   System.out.println("Digite o Saldo da Conta (R$):                 ");
				   saldo = leia.nextFloat();
				   
				   switch(tipo) {
				   
				   case 1 -> {
					   System.out.println("Digite o Limite de Crédito (R$):              ");
					   limite = leia.nextFloat();
					   contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, limite));
				   }
				   case 2 -> {
					   System.out.println("Digite o dia do Aniversario da Conta:           ");
					   aniversario = leia.nextInt();
					   contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				   }
				   }
				   keyPress();
				   break;
				
			case 2:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Listar todas as Contas \n\n");
				contas.listarTodas();
				keyPress();
				break;
				
			case 3:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Consultar dados da Conta - por número \n\n");
				
				keyPress();
				break;
				
			case 4:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Atualizar dados da Conta \n\n");
				
				keyPress();
				break;
				
			case 5:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Apagar a Conta \n\n");
				
				keyPress();
				break;
				
			case 6:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Saque \n\n");
				
				keyPress();
				break;
				
			case 7:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Depósito \n\n");
				
				keyPress();
				break;
				
			case 8:
				
				System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"Transferencia entre Contas \n\n");
				
				keyPress();
				break;
				
				default:
					
					System.out.println(Cores.TEXT_RED_BOLD+Cores.ANSI_WHITE_BACKGROUND+"\n Opção Inválida!! \n");
					
					keyPress();
					break;
					
			}
			
			
			
 
		}

	}
	public static void keyPress() {
		
		try {
			
			System.out.println(Cores.TEXT_RESET + "\n Pressione enter para Continuar...");
			System.in.read();
			
		}catch(IOException e) {
			
			System.out.println("Você pressionou um tecla diferente de enter!!");
			
		}
	}

}
