package composicao_exercicio_fixacao.model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import composicao_exercicio_fixacao.model.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus orderStatus;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {}
	
	public Order(Date moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
/* A manipulação da lista somente pelos métodos addItem e removeItem.
	public List<OrderItem> getItems() {
		return items;
	}*/

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem order: items) {
			sum += order.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + orderStatus +"\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: \n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f",total()));
		return sb.toString();
	}
	
	
}
