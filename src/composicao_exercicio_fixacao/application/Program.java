package composicao_exercicio_fixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import composicao_exercicio_fixacao.model.entities.Client;
import composicao_exercicio_fixacao.model.entities.Order;
import composicao_exercicio_fixacao.model.entities.OrderItem;
import composicao_exercicio_fixacao.model.entities.Product;
import composicao_exercicio_fixacao.model.enums.OrderStatus;



public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date moment = new Date();

		
		System.out.println("Enter cliente data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		

		// Instancia o cliente após receber as informações do cliente
		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status:");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
		
		// Instanciar o pedido
		Order order = new Order(moment, orderStatus, client);

		
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			// Instanciar o Pedido

			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
			

		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
	}

}
